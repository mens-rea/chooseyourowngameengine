package com.wanderast.anghimagsikan;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public TextView playerName, playerHealth, mainDialog;
    public RecyclerView listRecycler;

    private ChoiceAdapter choiceAdapter;

    private LinearLayoutManager layoutManager;

    Button nextButton;
    private ArrayList<Scenario> scenarios = new ArrayList<Scenario>();
    private Player player;

    private int scenarioCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listRecycler = findViewById(R.id.list_recycler);

        playerName = findViewById(R.id.player_name);
        playerHealth = findViewById(R.id.player_health);
        mainDialog = findViewById(R.id.scenario);

        nextButton = findViewById(R.id.next_button);

        // set up the player
        player = new Player("Tonton");
        playerName.setText("Manlalaro: " + player.name);
        playerHealth.setText("Buhay: "+ player.health +"/100");

        // initialize scene 1
        Scenario scene = new Scenario();
        scene.text = getString(R.string.scenario1);

        // adding choices to scene 1
        scene.addChoice(getString(R.string.choice1_1));
        scene.addChoice(getString(R.string.choice1_2));
        scene.addChoice(getString(R.string.choice1_3));

        // initialize scene 2
        Scenario scene2 = new Scenario();
        scene2.text = getString(R.string.scenario2);

        // addding choices to scene 2
        scene2.addChoice(getString(R.string.choice2_1));
        scene2.addChoice(getString(R.string.choice2_2));
        scene2.addChoice(getString(R.string.choice2_3));

        // initialize scene 3
        Scenario scene3 = new Scenario();
        scene3.text = "Scene 3";

        // adding choices to scene 3
        scene3.addChoice(getString(R.string.choice3_1));
        scene3.addChoice(getString(R.string.choice3_2));
        scene3.addChoice(getString(R.string.choice3_3));

        // setting the scenarios
        scenarios.add(scene);
        scenarios.add(scene2);
        scenarios.add(scene3);

        // setting up recycler view for choices ui
        choiceAdapter = new ChoiceAdapter(this, scenarios.get(scenarioCount).choices);
        layoutManager = new LinearLayoutManager(this);
        listRecycler.setLayoutManager(layoutManager);
        listRecycler.setItemAnimator(new DefaultItemAnimator());
        listRecycler.setAdapter(choiceAdapter);
        choiceAdapter.notifyDataSetChanged();

        // set initial dialog
        mainDialog.setText(scenarios.get(scenarioCount).text);
    }

    public void update(){
        // do consequence here
        scenarioCount++;

        // load new scenario
        mainDialog.setText(scenarios.get(scenarioCount).text);

        // update player stats
//        player.updatePlayer("health", -1, 10);

        // update UI
        playerHealth.setText("Buhay: "+ player.health +"/100");

        // load new choices
        choiceAdapter.setChoices(scenarios.get(scenarioCount).choices);
        choiceAdapter.notifyDataSetChanged();
    }
}
