import Monsters.Monster;

public abstract class BattleLocations extends Location {

    private Monster monster;
    private String material;
    private int monsterCount;


    public BattleLocations(Player player, String location, Monster monster, String material, int monsterCount) {
        super(player, location);
        this.monster = monster;
        this.material = material;
        this.monsterCount = monsterCount;
    }

    @Override
    public boolean onLocation() {
        return false;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getMonsterCount() {
        return monsterCount;
    }

    public void setMonsterCount(int monsterCount) {
        this.monsterCount = monsterCount;
    }
}
