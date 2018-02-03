package com.wanderast.anghimagsikan;

import java.util.ArrayList;

public class Scenario {

    public String text;
    public int choiceCount;
    public int fromScenario;
    public ArrayList<Choice> choices = new ArrayList<Choice>();


    public Scenario(){

    }

    public void addChoice(String choiceText){
        Choice choice = new Choice();
        choice.text = choiceText;
        choices.add(choice);
    }
}
