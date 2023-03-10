import java.util.Scanner;

public class Game {

    public static Scanner scan = new Scanner(System.in);

    public void start(){
        System.out.print("Welcome\nPlease enter a name to your character to start the game: ");
        String playerName = scan.nextLine();
        Player player = new Player(playerName);
        System.out.println("Let's get started " + player);
    }

    public void game(){
        System.out.println("<< Regions >>\n" +
                "1 - Safe House\n" +
                "2 - Shop\n" +
                "3 - Forest\n" +
                "4 - Desert\n" +
                "5 - River\n" +
                "6 - Mountain\n" +
                "7 - Cave\n" +
                "8 - Swamp");
        System.out.print("Select the region you want to go to: ");
        int region = scan.nextInt();
    }
}
