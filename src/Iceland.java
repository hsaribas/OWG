import Monsters.IceGollum;

public class Iceland extends BattleLocations {

    public Iceland(Player player) {
        super(player, "Iceland", new IceGollum(), "Ice globe", 3);
    }
}
