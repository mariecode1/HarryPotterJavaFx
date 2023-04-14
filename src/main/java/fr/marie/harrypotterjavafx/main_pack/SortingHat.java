package fr.marie.harrypotterjavafx.main_pack;

import java.util.Random;
public class SortingHat {
    //choose a random house

    //list containing all the houses with their caracteristics
    final House[] houses = {
            new House("Gryffindor", 1,1,1.2F,1),
            new House("Slytherin",1,1.2F,1,1),
            new House("Ravenclaw",1,1,1,1.2F),
            new House ("Hufflepuff",1.2F,1,1,1)};
    private Random random;
    public SortingHat(){
        random=new Random();
    }
    public House chooseHouse(){
        int i =random.nextInt(houses.length);  //choose a random int
        return houses[i];    //return the concerned house
    }
}
