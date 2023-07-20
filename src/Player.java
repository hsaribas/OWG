import Heroes.Ninja;
import Heroes.Hero;
import Heroes.Warrior;
import Heroes.Wizard;
import Inventory.Inventory;

import java.util.Scanner;

public class Player {

    private String player;
    private Inventory inventory;
    private String hero;
    private int damage;
    private int health;
    private int gold;
    private int defaultHealth;
    private final Scanner scan = new Scanner(System.in);

    public Player(String player) {
        this.player = player;
        this.inventory = new Inventory();
    }

    public void selectHero() {
        Hero[] heroes = {new Warrior(), new Ninja(), new Wizard()};

        for (Hero h : heroes) {
            System.out.println("Hero: " + h.getHero() +
                               " | Id: " + h.getId() +
                               " | Damage: " + h.getDamage() +
                               " | Health: " + h.getHealth() +
                               " | Gold: " + h.getGold());
        }
        System.out.println();

        System.out.print("\tEnter the id of the hero you want to pick: ");
        int decision = scan.nextInt();

        switch (decision) {
            case 1:
                heroProperties(new Warrior());
                break;
            case 2:
                heroProperties(new Ninja());
                break;
            case 3:
                heroProperties(new Wizard());
                break;
            default:
                System.out.println("\tInvalid number! Try again.");
                selectHero();
                break;
        }
        System.out.println();
        System.out.println("\tYour pick is -> [" + this.getHero() + "]");
    }

    public void heroProperties(Hero hero) {
        this.setHero(hero.getHero());
        this.setDamage(hero.getDamage());
        this.setHealth(hero.getHealth());
        this.setGold(hero.getGold());
        this.setDefaultHealth(hero.getHealth());
    }

    public void showInfo() {
        System.out.println("Hero: " + this.getHero() +
                           " | Weapon: " + this.getInventory().getWeapon().getWeapon() +
                           " | Damage: " + this.getTotalDamage() +
                           " | Armor: " + this.getInventory().getArmor().getArmor() +
                           " | Blocking: " + this.getInventory().getArmor().getBlock() +
                           " | Health: " + this.getHealth() +
                           " | Gold: " + this.getGold() +
                           " | Materials: " + this.getInventory().getMaterialList());
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public String getHero() {
        return hero;
    }

    public void setHero(String hero) {
        this.hero = hero;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getTotalDamage() {
        return damage + inventory.getWeapon().getDamage();
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0) {
            health = 0;
        }
        this.health = health;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getDefaultHealth() {
        return defaultHealth;
    }

    public void setDefaultHealth(int defaultHealth) {
        this.defaultHealth = defaultHealth;
    }
}
