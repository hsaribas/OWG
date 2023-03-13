import Monsters.CursedBear;

public class GreatMountain extends BattleLocations {

    public GreatMountain(Player player) {
        super(player, "Great Mountain", new CursedBear(), "Bear claw", 2);
    }
}
