package Inventory;

public class Weapon {

    private String weapon;
    private int id;
    private int damage;
    private int price;

    public Weapon(String weapon, int id, int damage, int price) {
        this.weapon = weapon;
        this.id = id;
        this.damage = damage;
        this.price = price;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
