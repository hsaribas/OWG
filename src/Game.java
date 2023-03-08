import java.util.Scanner;

public class Game {

    public static Scanner scan = new Scanner(System.in);

    public void start(){
        System.out.print("Welcome\nPlease enter a name to your character to start the game: ");
        String playerName = scan.nextLine();
        Player player = new Player(playerName);
        System.out.println("Let's get started " + player);
    }

}
