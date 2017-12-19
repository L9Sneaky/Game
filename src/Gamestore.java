import java.util.Scanner;

public class Gamestore {

	private Game[] games;
	private int numOfGames;
	private double totalprice;
	public static final int MAX = 100;

	public Gamestore() {
		setGames(new Game[MAX]);
		setNumOfGames(0);
		setTotalprice(0);
	}

	public Game[] getGames() {
		return games;
	}

	public void setGames(Game[] games) {
		this.games = games;
	}

	public int getNumOfGames() {
		return numOfGames;
	}

	public void setNumOfGames(int numOfGames) {
		this.numOfGames = numOfGames;
	}

	public double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}

	// _________________________________________________________________________________________________________________
	public int findGame(String name) {
		for (int i = 0; i < numOfGames; i++) {
			if (games[i].getName().equalsIgnoreCase(name)) {
				return i;
			}

		}
		return -1;
	}

	public void addGame(String name, double price) {
		if (findGame(name) == -1) {
			Game g = new Game(name, price);
			games[getNumOfGames()] = g;
			setNumOfGames(numOfGames++);
		} else
			System.out.println("game already added");
	}

	public void sell(String name) {
		if (findGame(name) != -1) {
			totalprice += games[findGame(name)].getPrice();
			for (int i = 0; i < numOfGames; i++) {
				games[findGame(name)] = games[findGame(name) - 1];
			}
			setNumOfGames(numOfGames--);
		} else
			System.out.println("game not found or sold out");

	}
	// _________________________________________________________________________________________________________________

	public static void main(String[] args) {
		Gamestore g = new Gamestore();
		Scanner s = new Scanner(System.in);
		System.out.println("how games do you want to add");
		int n =s.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println("Please enter the name and the price for game ["+i+"]");
			g.addGame(s.next(), s.nextDouble());
		}
		System.out.println("how many games do you want to sell (Must be between 0 - "+n+")");
		n = s.nextInt();
		for(int i = 0; i< n ;i++) {
			System.out.println("Please enter the name of the game you want to sell");
			g.sell(s.next());
		}
		
		System.out.println("The Total price for the sold games are "+g.getTotalprice());
	
	}
}
