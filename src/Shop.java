import Inventory.*;

public class Shop extends Location {

    public Shop(Player player) {
        super(player, "Shop");
    }

    @Override
    public boolean onLocation() {
        System.out.println("|| Now you are in Shop ||\n" +
                "You can buy a new weapon to boost your damage and you can buy an armor to boost your blocking.");

        boolean showMenu = true;
        while (showMenu) {
            System.out.println();
            System.out.println("0 - Exit\n1 - Weapons\n2 - Armors");
            System.out.print("Enter the number of the purchase you want to make: ");
            int choice = scan.nextInt();
            if (choice < 0 || choice > 2) {
                System.out.print("Invalid number! Please try again:");
                choice = scan.nextInt();

                switch (choice) {
                    case 0:
                        System.out.println("You left the market.");
                        showMenu = false;
                        break;
                    case 1:
                        showWeapons();
                        System.out.println();
                        break;
                    case 2:
                        showArmors();
                        System.out.println();
                        break;
                }
            }
        }
        return true;
    }

    public void showWeapons() {
        System.out.println();
        System.out.println("|| Weapons ||");

        Weapon[] weapons = {new Spear(), new Sword(), new Dagger(), new Arrow(), new MagicWand(), new SpellBook()};
        for (Weapon w : weapons) {
            System.out.println("Weapon: " + w.getWeapon() +
                    " | Id: " + w.getId() +
                    " | Damage: " + w.getDamage() +
                    " | Price: " + w.getPrice());
        }
        System.out.println("Don't forget to pick the best weapon for your hero!");
    }

    public void showArmors() {
        System.out.println();
        System.out.println("|| Armors ||");

        Armor[] armors = {new LeatherArmor(), new CopperArmor(), new SteelArmor()};
        for (Armor a : armors) {
            System.out.println("Armor: " + a.getArmor() +
                    " | Id: " + a.getId() +
                    " | Blocking: " + a.getBlocking() +
                    " | Price: " + a.getPrice());
        }
        System.out.println("Don't forget to pick the best armor for your hero!");
    }
}
