package Inventory;

import java.util.ArrayList;
import java.util.List;

public class Armor {

    private String armor;
    private int id;
    private int block;
    private int price;

    public Armor(String armor, int id, int block, int price) {
        this.armor = armor;
        this.id = id;
        this.block = block;
        this.price = price;
    }

    public static Armor getArmorById(int id) {
        Armor[] armors = {new LeatherArmor(), new CopperArmor(), new SteelArmor()};

        for (Armor a : armors) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    public static List<Integer> armorIds() {
        Armor[] armors = {new LeatherArmor(), new CopperArmor(), new SteelArmor()};
        List<Integer> armorIdList = new ArrayList<>();

        for (Armor a : armors) {
            armorIdList.add(a.getId());
        }
        return armorIdList;
    }

    public String getArmor() {
        return armor;
    }

    public void setArmor(String armor) {
        this.armor = armor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
