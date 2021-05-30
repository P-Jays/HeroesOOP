class Player {
    private String name;
    private int health;
    private int attack;
    private int level;
    private Weapon weapon;
    private Armor armor;
    // private int maxHealth;
    

    Player(String name) {
        this.name = name;
        this.health = 100;
        this.attack = 20;
        this.level = 1;
    }

    public void display() {
        System.out.println("Name\t\t:" + this.name);
        System.out.println("Level\t\t:" + this.level);
        System.out.println("Health\t\t:" + this.health);
        System.out.println("Attack\t\t:" + this.attack);
        System.out.println("Weapon\t\t:" + this.weapon.getName());
        System.out.println("Armor\t\t:"+ this.armor.getName()+"\n");
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
        this.attack += weapon.getAttack();
    }

    public void setArmor(Armor armor){
        this.armor = armor;
        this.health += (this.level * 10) + armor.getMaxDefense();
    }

    public void attack(Player opponent){
       
        System.out.println(this.name+" is attacking"+ opponent.name +" with the damage of :" +this.attack+"\n");
    
        opponent.getDamage(this.attack);
    }

    private void getDamage(int damage) {
        this.health -= damage;

        System.out.println(this.name+" still have :"+ this.health+"\n");
    }



}

class Weapon {
    private String name;
    private int attack;

    Weapon(String name, int attack) {
        this.name = name;
        this.attack = attack;
    }

    public String getName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }
}

class Armor {
    private String name;
    private int strength;
    private int defence;

    Armor(String name, int strength, int defence) {
        this.name = name;
        this.strength = strength;
        this.defence = defence;
    }

    public String getName() {
        return this.name;
    }

    public int getStrength() {
        return this.strength;
    }

    public int getDefence() {
        return this.defence;
    }

    public int getMaxDefense() {
        return strength * 10 + this.defence;
    }

}

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        // creating player1
        Player player1 = new Player("PJ");
        Weapon weapon1 = new Weapon("Baseball Bat", 18);
        Armor armor1 = new Armor("Uniform", 5, 50);
        player1.setWeapon(weapon1);
        player1.setArmor(armor1);
        player1.display();


        // creating player2
        Player player2 = new Player("Metta");
        Weapon weapon2 = new Weapon("Bow", 30);
        Armor armor2 =  new Armor("Training Uniform", 10, 100);
        player2.setWeapon(weapon2);
        player2.setArmor(armor2);
        player2.display();


        // episode 1 
        player1.attack(player2);
        player1.display();
        player2.display();

        // episode 2 
        player2.attack(player1);
        player1.display();
        player2.display();
    }
}
