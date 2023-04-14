package fr.marie.harrypotterjavafx.main_pack;

public class House {
    private String name;
    private float potionEff;
    private float spellEff;
    private float resistanceEff;
    private float precisionEff;

    public House(String name, float potionEff, float spellEff,float resistanceEff,float precisionEff){
        this.name=name;
        this.potionEff=potionEff;
        this.spellEff=spellEff;
        this.resistanceEff=resistanceEff;
        this.precisionEff=precisionEff;
    }

    // Getters
    public String getName() {return name;}

    public float getPotionEff() {return potionEff;}

    public float getSpellEff() {return spellEff;}

    public float getResistanceEff() {return resistanceEff;}

    public float getPrecisionEff() {return precisionEff;}

    // Setters
    public void setName(String name) {this.name = name;}

    public void setPotionEff(float potionEff) {this.potionEff = potionEff;}

    public void setSpellEff(float spellEff) {this.spellEff = spellEff;}

    public void setResistanceEff(float resistanceEff) {this.resistanceEff = resistanceEff;}

    public void setPrecisionEff(float precisionEff) {this.precisionEff = precisionEff;}
}
