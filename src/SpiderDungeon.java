import Monsters.Tarantula;

public class SpiderDungeon extends BattleLocations {

    public SpiderDungeon(Player player) {
        super(player, "Spider Dungeon", new Tarantula(), "Spider legs", 3);
    }
}
