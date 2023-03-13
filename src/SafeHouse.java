public class SafeHouse extends Location {

    public SafeHouse(Player player) {
        super(player, "Safe House");
    }

    @Override
    public boolean onLocation() {
        System.out.println("|| Now you are in Safe House ||\n" +
                "You can renew your health and take a rest.");

        this.getPlayer().setHealth(this.getPlayer().getDefaultHealth());

        return true;
    }
}
