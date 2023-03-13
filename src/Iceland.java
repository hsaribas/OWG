import Monsters.IceGolem;

public class Iceland extends BattleLocations {

    public Iceland(Player player) {
        super(player, "Iceland", new IceGolem(), "Ice globe", 3);
    }
}
