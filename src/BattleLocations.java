import Monsters.Monster;

import java.util.Random;

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
        int count = randomMonsters();
        System.out.println("Now you are in -> [" + this.getLocation() + "]\n" +
                "Get ready to fight " + count + this.getMonster() + "!");


        return true;
    }

    public void playerStats() {
        System.out.println("<< Player " + this.getPlayer().getPlayer() + "'s Stats >>");
        System.out.println("Weapon: " + this.getPlayer().getInventory().getWeapon().getWeapon() +
                " | Damage: " + this.getPlayer().getTotalDamage() +
                " | Armor: " + this.getPlayer().getInventory().getArmor().getArmor() +
                " | Block: " + this.getPlayer().getInventory().getArmor().getBlock() +
                " | Health: " + this.getPlayer().getHealth() +
                " | Gold: " + this.getPlayer().getGold());
    }

    public void monsterStats(int i) {
        System.out.println("<< " + i + ". " + this.getMonster().getMonster() + "'s Stats >>");
        System.out.println("Damage: " + this.getMonster().getDamage() +
                " | Health: " + this.getMonster().getHealth() +
                " | Reward: " + this.getMonster().getReward());
    }

    public int randomMonsters() {
        Random r = new Random();
        return r.nextInt(this.getMonsterCount()) + 1;
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
