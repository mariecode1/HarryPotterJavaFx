package fr.marie.harrypotterjavafx.main_pack;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WizardTest {

    @Test
    void defend() {
        Wand wand=new Wand(Core.PHOENIX_FEATHER,10);
        House house=new House("Gryffindor", 1,1,1.2F,1);
        Spell spell=new Spell("Wingardium Leviosa", 1, 40);
        List<Spell> knownSpells=new ArrayList<>();
        knownSpells.add(spell);
        Potion potion= new Potion("Healing Potion", 10.0f, "Increases your life points", 10.0f);
        List<Potion> potions=new ArrayList<>();
        potions.add(potion);
        Wizard wizard=new Wizard("Harry", Pet.CAT, wand, house,knownSpells,potions,100, 10);

        float resistance= wizard.defend(wizard);
        assertEquals(resistance,wizard.getHouse().getResistanceEff()*2);
    }
}