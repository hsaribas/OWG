import Monsters.GhostTree;

public class GhostForest extends BattleLocations {

    public GhostForest(Player player) {
        super(player, "Ghost Forest", new GhostTree(), "Wood", 4);
    }
}
