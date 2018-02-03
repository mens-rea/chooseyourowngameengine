package com.wanderast.anghimagsikan;

public class Player {
    public String name;
    public int health, intelligence, strength, agility, language, charisma, luck;

    public Player(String name){
        this.health = 100;
        this.name = name;
        intelligence = 0;
        strength = 0;
        agility = 0;
        language = 0;
        charisma = 0;
        luck = 0;
    }

    public void updatePlayer(String action, int orientation, int quantity){
        if(action.equals("health")){
            this.health = this.health + (quantity*orientation);
        }
        else if(action.equals("strength")){
            this.strength = this.strength + (quantity*orientation);
        }
        else if(action.equals("intelligence")) {
            this.intelligence = this.intelligence + (quantity * orientation);
        }
    }
}
