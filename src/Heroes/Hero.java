package Heroes;

public class Hero {

    private String hero;
    private int id;
    private int damage;
    private int health;
    private int gold;

    public Hero(String hero, int id, int damage, int health, int gold){
        this.hero = hero;
        this.id = id;
        this.damage = damage;
        this.health = health;
        this.gold = gold;
    }

    public String getHero() {
        return hero;
    }

    public void setHero(String hero) {
        this.hero = hero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}
