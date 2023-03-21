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
        System.out.println("\tNow you are in -> [" + this.getLocation() + "]\n" +
                "\tGet ready to fight " + count + " " + this.getMonster().getMonster() + ".");

        if (fight(count)) {
            return true;
        }
        if (this.getPlayer().getHealth() <= 0) {
            System.out.println();
            System.out.println("\tYou are died...");
            return false;
        }
        return true;
    }

    public boolean fight(int count) {
        int num = count;

        for (int i = 1; i <= count; i++) {
            this.getMonster().setHealth(this.getMonster().getDefaultHealth());
            System.out.println();

            playerStats();
            System.out.println();
            monsterStats(i);
            System.out.println();

            while (this.getPlayer().getHealth() > 0 && this.getMonster().getHealth() > 0) {
                System.out.print("\tPress 'A' to attack or press 'E' to escape: ");
                String decision = scan.nextLine().toUpperCase();

                if (decision.equals("A")) {
                    this.getMonster().setHealth(this.getMonster().getHealth() - this.getPlayer().getTotalDamage());
                    System.out.println();
                    currentHealth();

                    if (this.getMonster().getHealth() > 0) {
                        int monsterDamage = this.getMonster().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if (monsterDamage < 0) {
                            monsterDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDamage);
                        System.out.println();
                        currentHealth();
                    }
                } else {
                    System.out.println();
                    System.out.println("\tYou left the battle location.");
                    return false;
                }
            }
            if (this.getPlayer().getHealth() > this.getMonster().getHealth()) {
                System.out.println();
                System.out.println("\tGreat fight!\n" +
                        "\tYou killed the monster.");
                this.getPlayer().setGold(this.getPlayer().getGold() + this.getMonster().getReward());
                System.out.println("\t" + this.getMonster().getReward() + " gold earned.");
                num--;

                if (num == 0) {
                    System.out.println();
                    this.getPlayer().getInventory().setMaterialList(this.getMaterial());
                    System.out.println("\tYou killed all creatures and gained new material -> [" + this.getMaterial() + "]");
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public void currentHealth() {
        System.out.println("[" + this.getPlayer().getPlayer() + "]'s health: " + this.getPlayer().getHealth());
        System.out.println(this.getMonster().getMonster() + "'s health: " + this.getMonster().getHealth());
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
