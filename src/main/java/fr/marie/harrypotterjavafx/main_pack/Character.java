package fr.marie.harrypotterjavafx.main_pack;

public abstract class Character {
    private String name;
    private float life;

    public void attack(Character c){
        // method attack
    };
    public Character(String name, float life){
        this.name=name;
        this.life=life;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getLife() {
        return life;
    }
    public void setLife(float life) {
        this.life = life;
    }
}
