package fr.marie.harrypotterjavafx.main_pack;

public enum Pet {
    OWL,
    RAT,
    CAT,
    TOAD;

    public String display() {
        if (this.name().equals("OWL") ) {
            return (this.name() + " 🦉");
        }
        else if (this.name().equals("RAT") ) {
            return (this.name() + " 🐀");
        }
        else if (this.name().equals("CAT") ) {
            return (this.name() + " 😸");
        }
        else if (this.name().equals("TOAD") ) {
            return (this.name() + " 🐸");
        }
        else {
            return "" ;
        }
    }
}
