public class Shop extends Location{

    public Shop(Player player) {
        super(player, "Shop");
    }

    @Override
    public boolean onLocation() {
        System.out.println("|| Now you are in Shop ||\n" +
                "You can buy a new weapon to boost your damage and you can buy an armor to boost your blocking.");
        return true;
    }
}
