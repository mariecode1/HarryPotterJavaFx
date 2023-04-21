package fr.marie.harrypotterjavafx.console;

import fr.marie.harrypotterjavafx.main_pack.House;
import fr.marie.harrypotterjavafx.main_pack.SortingHat;
import fr.marie.harrypotterjavafx.main_pack.Wand;
import fr.marie.harrypotterjavafx.main_pack.Pet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void createRandomWand() {
        Main main=new Main();
        Wand wand =main.createRandomWand();
        assertNotNull(wand);
    }

    @Test
    void chooseRandomPet() {
        Main main=new Main();
        Pet pet =main.chooseRandomPet();
        assertNotNull(pet);
    }
}