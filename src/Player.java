import Heroes.Archer;
import Heroes.Hero;
import Heroes.Warrior;
import Heroes.Wizard;
import Inventory.Inventory;

import java.util.Scanner;

public class Player {

    private String player;
    private String hero;
    private int damage;
    private int health;
    private int defaultHealth;
    private int gold;
    private Inventory inventory;

    private final Scanner scan = new Scanner(System.in);

    public Player(String player) {
        this.player = player;
        this.inventory = new Inventory();
    }

    public void pickHero() {
        Hero[] heroes = {new Warrior(), new Archer(), new Wizard()};
        for (Hero h : heroes) {
            System.out.println("Hero: " + h.getHero() +
                    " | Id: " + h.getId() +
                    " | Damage: " + h.getDamage() +
                    " | Health: " + h.getHealth() +
                    " | Gold: " + h.getGold());
        }
        System.out.println();

        System.out.print("Enter the id of the hero you want to pick: ");
        int decision = scan.nextInt();
        switch (decision) {
            case 1:
                heroProperty(new Warrior());
                break;
            case 2:
                heroProperty(new Archer());
                break;
            case 3:
                heroProperty(new Wizard());
                break;
            default:
                System.out.println("Please enter a valid id!");
                pickHero();
                break;
        }
        System.out.println();
        System.out.println("Your pick is -> " + this.getHero());
    }

    public void heroProperty(Hero hero) {
        this.setHero(hero.getHero());
        this.setDamage(hero.getDamage());
        this.setHealth(hero.getHealth());
        this.setGold(hero.getGold());
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0) {
            health = 0;
        }
        this.health = health;
    }

    public int getDefaultHealth() {
        return defaultHealth;
    }

    public void setDefaultHealth(int defaultHealth) {
        this.defaultHealth = defaultHealth;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
