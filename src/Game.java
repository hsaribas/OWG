import java.util.Scanner;

public class Game {

    private Player player;
    private Location location;
    public static Scanner scan = new Scanner(System.in);

    public void start() {
        System.out.print("Welcome!\n" +
                "Enter a name to your character to start the game: ");
        String playerName = scan.nextLine();
        player = new Player(playerName);

        System.out.println();
        System.out.println("Let's get started [" + player.getPlayer() + "]");

        System.out.println();
        player.selectHero();

        location = null;

        while (true) {
            System.out.println();
            player.showInfo();
            game();

            if (location == null) {
                System.out.println();
                System.out.println("See you again!");
                break;
            }

            if (!location.onLocation()) {
                System.out.println();
                System.out.println("GAME OVER!");
                break;
            }
        }
    }

    public void game() {
        System.out.println();
        System.out.println("<< Regions >>\n" +
                "1 - Safe House\n" +
                "2 - Shop\n" +
                "3 - Sahara Desert\n" +
                "4 - Spider Dungeon\n" +
                "5 - Great Mountain\n" +
                "6 - Ghost Forest\n" +
                "7 - Land of Giants\n" +
                "8 - Iceland");
        System.out.println();
        System.out.print("Where do you want to go to? Select a region: ");
        int region = scan.nextInt();

        System.out.println();
        switch (region) {
            case 0:
                location = null;
                break;
            case 1:
                location = new SafeHouse(player);
                break;
            case 2:
                location = new Shop(player);
                break;
            case 3:
                location = new SaharaDesert(player);
                break;
            case 4:
                location = new SpiderDungeon(player);
                break;
            case 5:
                location = new GreatMountain(player);
                break;
            case 6:
                location = new GhostForest(player);
                break;
            case 7:
                location = new LandOfGiants(player);
                break;
            case 8:
                location = new Iceland(player);
                break;
            default:
                System.out.println("Invalid number! Try again.");
                game();
                break;
        }
    }
}
