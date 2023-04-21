package fr.marie.harrypotterjavafx.main_pack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortingHatTest {

    @Test
    void chooseHouse() {
        SortingHat sortingHat=new SortingHat();
        House house =sortingHat.chooseHouse();
        assertNotNull(house);
    }
}