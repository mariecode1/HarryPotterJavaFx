package fr.marie.harrypotterjavafx.main_pack;

//Mainly used in level 1, the impact of an object thrown at the enemy depends on its weight.
public class Object {
    private String name;
    private float weight;


    public Object(String name, float weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {this.weight = weight;}
}