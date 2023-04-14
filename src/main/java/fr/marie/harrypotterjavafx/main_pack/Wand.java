package fr.marie.harrypotterjavafx.main_pack;

public class Wand {
    private Core core;
    private int size;

    //Setters
    public Wand(Core core, int size){
        this.core=core;
        this.size=size;
    }

    //Getters
    public Core getCore(){
        return core;
    }
    public int getSize(){
        return size;
    }

    //Individual setters
    public void setCore(Core core){
        this.core=core;
    }
    public void setSize(int size){
        this.size=size;
    }
}
