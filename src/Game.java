import java.util.Scanner;

public class Game {

    private Player player;
    private Location location;
    public static Scanner scan = new Scanner(System.in);
    boolean result = true;

    public void start() {
        System.out.print("\t* * * Welcome! * * *\n\n" +
                "\tEnter a name to your character to start the game: ");
        String playerName = scan.nextLine();
        player = new Player(playerName);

        System.out.println();
        System.out.println("\tLet's get started [" + player.getPlayer() + "]!");

        System.out.println();
        player.selectHero();

        location = null;

        while (result) {
            System.out.println();
            player.showInfo();
            game();

            if (location == null) {
                System.out.println();
                System.out.println("\tSee you again!");
                break;
            }
            if (!location.onLocation()) {
                System.out.println();
                System.out.println("\tGAME OVER!");
                break;
            }
        }
    }

    public void game() {
        System.out.println();
        System.out.println("|| Regions ||\n" +
                "0 - Quit Game\n" +
                "1 - Safe House\n" +
                "2 - Shop\n" +
                "3 - Sahara Desert\n" +
                "4 - Spider Dungeon\n" +
                "5 - Great Mountain\n" +
                "6 - Ghost Forest\n" +
                "7 - Land of Giants\n" +
                "8 - Iceland");
        System.out.println();
        System.out.print("\tWhere do you want to go to? Select a region: ");
        int region = scan.nextInt();

        System.out.println();
        switch (region) {
            case 0:
                location = null;
                break;
            case 1:
                location = new SafeHouse(player);
                if (this.player.getInventory().getMaterialList().size() == 6) {
                    System.out.println("\tYou have collected all the materials.\n\n" +
                            "\t* * * Congratulations! * * *\n" +
                            "\t* * * You Won The Game! * * *");
                    result = false;
                    location = null;
                }
                break;
            case 2:
                location = new Shop(player);
                break;
            case 3:
                materialCheck("Snake skin", new SaharaDesert(player));
                break;
            case 4:
                materialCheck("Spider legs", new SpiderDungeon(player));
                break;
            case 5:
                materialCheck("Bear claw", new GreatMountain(player));
                break;
            case 6:
                materialCheck("Wood", new GhostForest(player));
                break;
            case 7:
                materialCheck("Orc tooth", new LandOfGiants(player));
                break;
            case 8:
                materialCheck("Ice globe", new Iceland(player));
                break;
            default:
                System.out.println("\tInvalid number! Try again.");
                game();
                break;
        }
    }

    public void materialCheck(String material, Location regionPreference) {
        if (this.player.getInventory().getMaterialList().contains(material)) {
            System.out.println("\tYou have already crossed this area and captured the material. You cannot re-enter the zone!");
            game();
        } else {
            location = regionPreference;
        }
    }
}
