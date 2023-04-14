package fr.marie.harrypotterjavafx.main_pack;
import java.util.List;
import java.util.ArrayList;


public class ForbiddenSpell extends AbstractSpell{
    final String description;
    public ForbiddenSpell(String spellName, int levelRequired, float effectiveness,String description) {
        super(spellName, levelRequired, effectiveness);
        this.description=description;
    }
    public String getDescription() {
        return description;
    }


}
