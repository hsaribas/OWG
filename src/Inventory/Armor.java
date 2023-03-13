package Inventory;

public class Armor {

    private String armor;
    private int id;
    private int blocking;
    private int price;

    public Armor(String armor, int id, int blocking, int price) {
        this.armor = armor;
        this.id = id;
        this.blocking = blocking;
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

    public int getBlocking() {
        return blocking;
    }

    public void setBlocking(int blocking) {
        this.blocking = blocking;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
