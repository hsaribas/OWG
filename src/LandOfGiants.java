import Monsters.Orc;

public class LandOfGiants extends BattleLocations {

    public LandOfGiants(Player player) {
        super(player, "Land Of Giants", new Orc(), "Orc tooth", 2);
    }
}
