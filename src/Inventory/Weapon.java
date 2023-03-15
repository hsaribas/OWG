package Inventory;

import java.util.ArrayList;
import java.util.List;

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

    public static Weapon getWeaponById(int id) {
        Weapon[] weapons = {new Spear(), new Sword(), new Dagger(), new Arrow(), new MagicWand(), new SpellBook()};
        for (Weapon w : weapons) {
            if (w.getId() == id) {
                return w;
            }
        }
        return null;
    }

    public static List<Integer> weaponIds() {
        Weapon[] weapons = {new Spear(), new Sword(), new Dagger(), new Arrow(), new MagicWand(), new SpellBook()};
        List<Integer> weaponIdList = new ArrayList<>();
        for (Weapon w : weapons) {
            weaponIdList.add(w.getId());
        }
        return weaponIdList;
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
