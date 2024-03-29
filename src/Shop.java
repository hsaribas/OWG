import Inventory.*;

import java.util.Objects;

public class Shop extends Location {

    public Shop(Player player) {
        super(player, "Shop");
    }

    @Override
    public boolean onLocation() {
        System.out.println("\t|| Now you are in the Shop ||\n" +
                           "\tYou can buy a new weapon to boost your damage and you can buy an armor to boost your blocking.");
        boolean showMenu = true;

        while (showMenu) {
            System.out.println();
            System.out.println("0 - Exit\n" +
                               "1 - Weapons\n" +
                               "2 - Armors");
            System.out.print("\tEnter the number of the action you want to do: ");
            int choice = scan.nextInt();

            while (choice < 0 || choice > 2) {
                System.out.print("\tInvalid number! Try again: ");
                choice = scan.nextInt();
            }

            switch (choice) {
                case 0:
                    System.out.println();
                    System.out.println("\tYou left the market.");
                    showMenu = false;
                    break;
                case 1:
                    showWeapons();
                    buyWeapon();
                    break;
                case 2:
                    showArmors();
                    buyArmor();
                    break;
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
        System.out.println("\tPress '0' if you want to leave the shop.");
    }

    public void buyWeapon() {
        System.out.println();
        System.out.print("\tChoose a suitable weapon for your hero.\n" +
                         "\tEnter the id of the weapon you want to buy: ");
        int pickedWeapon = scan.nextInt();

        while (pickedWeapon < 0 || pickedWeapon > Weapon.weaponIds().size()) {
            System.out.print("\tInvalid number! Try again: ");
            pickedWeapon = scan.nextInt();
        }
        System.out.println();

        if (pickedWeapon != 0) {
            switch (pickedWeapon) {
                case 1:
                    if (!Objects.equals(this.getPlayer().getHero(), "Warrior")) {
                        System.out.println("\tOnly a 'warrior' can use this weapon.");
                        buyWeapon();
                    }
                    weaponBuyingProcess(1);
                    break;
                case 2:
                    if (!Objects.equals(this.getPlayer().getHero(), "Warrior")) {
                        System.out.println("\tOnly a 'warrior' can use this weapon.");
                        buyWeapon();
                    }
                    weaponBuyingProcess(2);
                    break;
                case 3:
                    if (!Objects.equals(this.getPlayer().getHero(), "Ninja")) {
                        System.out.println("\tOnly a 'ninja' can use this weapon.");
                        buyWeapon();
                    }
                    weaponBuyingProcess(3);
                    break;
                case 4:
                    if (!Objects.equals(this.getPlayer().getHero(), "Ninja")) {
                        System.out.println("\tOnly a 'ninja' can use this weapon.");
                        buyWeapon();
                    }
                    weaponBuyingProcess(4);
                    break;
                case 5:
                    if (!Objects.equals(this.getPlayer().getHero(), "Wizard")) {
                        System.out.println("\tOnly a 'wizard' can use this weapon.");
                        buyWeapon();
                    }
                    weaponBuyingProcess(5);
                    break;
                case 6:
                    if (!Objects.equals(this.getPlayer().getHero(), "Wizard")) {
                        System.out.println("\tOnly a 'wizard' can use this weapon.");
                        buyWeapon();
                    }
                    weaponBuyingProcess(6);
                    break;
                default:
                    System.out.println("\tInvalid number! Try again.");
                    buyWeapon();
                    break;
            }
        }
    }

    public void weaponBuyingProcess(int id) {
        Weapon selectedWeapon = Weapon.getWeaponById(id);

        if (selectedWeapon != null) {
            if (this.getPlayer().getGold() < selectedWeapon.getPrice()) {
                System.out.println("\tYou don't have enough gold to buy this weapon.");
            } else {
                this.getPlayer().setGold(this.getPlayer().getGold() - selectedWeapon.getPrice());
                this.getPlayer().getInventory().setWeapon(selectedWeapon);
                System.out.println("\tYour new weapon is -> [" + Objects.requireNonNull(Weapon.getWeaponById(id)).getWeapon() + "]");
            }
        }
    }

    public void showArmors() {
        System.out.println();
        System.out.println("|| Armors ||");
        Armor[] armors = {new LeatherArmor(), new CopperArmor(), new SteelArmor()};

        for (Armor a : armors) {
            System.out.println("Armor: " + a.getArmor() +
                               " | Id: " + a.getId() +
                               " | Blocking: " + a.getBlock() +
                               " | Price: " + a.getPrice());
        }
        System.out.println("\tPress '0' if you want to leave the shop.");
    }

    public void buyArmor() {
        System.out.println();
        System.out.print("\tChoose an armor for your hero.\n" +
                         "\tEnter the id of the armor you want to buy: ");
        int pickedArmor = scan.nextInt();

        while (pickedArmor < 0 || pickedArmor > Armor.armorIds().size()) {
            System.out.print("\tInvalid number! Try again: ");
            pickedArmor = scan.nextInt();
        }
        System.out.println();

        if (pickedArmor != 0) {
            Armor selectedArmor = Armor.getArmorById(pickedArmor);
            if (selectedArmor != null) {
                if (this.getPlayer().getGold() < selectedArmor.getPrice()) {
                    System.out.println("\tYou don't have enough gold to buy this armor.");
                } else {
                    this.getPlayer().setGold(this.getPlayer().getGold() - selectedArmor.getPrice());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("\tYour new armor is -> [" + Objects.requireNonNull(Armor.getArmorById(selectedArmor.getId())).getArmor() + "]");
                }
            }
        }
    }
}
