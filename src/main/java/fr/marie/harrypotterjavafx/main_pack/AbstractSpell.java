package fr.marie.harrypotterjavafx.main_pack;

public abstract class AbstractSpell {
    String spellName;
    int levelRequired;
    float effectiveness;
    public AbstractSpell(String spellName, int levelRequired, float effectiveness) {
        this.spellName = spellName;
        this.levelRequired = levelRequired;
        this.effectiveness = effectiveness;
    }

    public String getSpellName() {
        return spellName;
    }
    public void setSpellName() {this.spellName=spellName;}

    public int getLevelRequired() {
        return levelRequired;
    }
    public void setLevelRequired(){this.levelRequired=levelRequired;}

    public float getEffectiveness() {
        return effectiveness;
    }
    public void setEffectiveness(){this.effectiveness=effectiveness;}

}
