package com.example.tess.mycalculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Déclaration des variables
    TextView textViewResults;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button button0;
    Button buttonPoint;
    Button buttonEgal;
    Button buttonAddition;
    Button buttonSoustraction;
    Button buttonMultiplication;
    Button buttonDivision;
    Button buttonClear;

    private double chiffre1;
    private boolean clicOperateur = false;
    private boolean update = false;
    private String operateur = "";
    private boolean virgule = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //On récupère les éléments avec leurs ID
        textViewResults = (TextView) findViewById(R.id.textViewResults);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button0 = (Button) findViewById(R.id.button0);
        buttonPoint = (Button) findViewById(R.id.buttonPoint);
        buttonEgal = (Button) findViewById(R.id.buttonEgal);
        buttonAddition = (Button) findViewById(R.id.buttonAddition);
        buttonSoustraction = (Button) findViewById(R.id.buttonSoustraction);
        buttonMultiplication = (Button) findViewById(R.id.buttonMultiplication);
        buttonDivision = (Button) findViewById(R.id.buttonDivision);
        buttonClear = (Button) findViewById(R.id.buttonClear);

        //On attribue un évènement aux boutons
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clickChiffre("1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clickChiffre("2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clickChiffre("3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clickChiffre("4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clickChiffre("5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clickChiffre("6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clickChiffre("7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clickChiffre("8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clickChiffre("9");
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clickChiffre("0");
            }
        });

        buttonPoint.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!virgule) {
                    clickChiffre(".");
                    virgule = true;
                }
            }
        });

        buttonEgal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clickEgal();
            }
        });

        buttonAddition.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clickAddition();
            }
        });

        buttonSoustraction.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clickSoustraction();
            }
        });

        buttonMultiplication.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clickMultiplication();
            }
        });

        buttonDivision.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clickDivision();
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clickClear();
            }
        });
    }

    //Fonction exécutée quand on appuie sur un bouton "chiffre"
    private void clickChiffre(String str) {

        if(update){
            update = false;
        }else{
            //Si le champ n'est pas 0, on ajoute la valeur à la suite
            if(!textViewResults.getText().equals("0"))
                str = textViewResults.getText() + str;
        }

        //On met le nouveau contenu dans le champ
        textViewResults.setText(str);
    }

    //Fonction exécutée lorsqu'on clique sur le bouton "+"
    public void clickAddition(){

        if(clicOperateur){
            calcul();
            textViewResults.setText(String.valueOf(chiffre1));
        }else{
            chiffre1 = Double.valueOf(textViewResults.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "+";
        update = true;
        virgule = false;
    }

    //Fonction exécutée lorsqu'on clique sur le bouton "-"
    public void clickSoustraction(){
        if(clicOperateur){
            calcul();
            textViewResults.setText(String.valueOf(chiffre1));
        }else{
            chiffre1 = Double.valueOf(textViewResults.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "-";
        update = true;
        virgule = false;
    }

    //Fonction exécutée lorsqu'on clique sur le bouton "*"
    public void clickMultiplication(){
        if(clicOperateur){
            calcul();
            textViewResults.setText(String.valueOf(chiffre1));
        }else{
            chiffre1 = Double.valueOf(textViewResults.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "*";
        update = true;
        virgule = false;
    }

    //Fonction exécutée lorsqu'on clique sur le bouton "/"
    public void clickDivision(){
        if(clicOperateur){
            calcul();
            textViewResults.setText(String.valueOf(chiffre1));
        }else{
            chiffre1 = Double.valueOf(textViewResults.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "/";
        update = true;
        virgule = false;
    }

    //Fonction exécutée lorsqu'on clique sur le bouton "="
    public void clickEgal(){
        calcul();
        update = true;
        clicOperateur = false;
        virgule = false;
    }

    //Fonction exécutée lorsque l'on clique sur le bouton "Clear"
    public void clickClear(){
        clicOperateur = false;
        update = true;
        virgule = false;
        chiffre1 = 0;
        operateur = "";
        textViewResults.setText("");
    }

    //Fonction qui fait le calcul qui a été demandé par l'utilisateur
    private void calcul(){
        if(operateur.equals("+")){
            chiffre1 = chiffre1 + Double.valueOf(textViewResults.getText().toString()).doubleValue();
            textViewResults.setText(String.valueOf(chiffre1));
        }

        if(operateur.equals("-")){
            chiffre1 = chiffre1 - Double.valueOf(textViewResults.getText().toString()).doubleValue();
            textViewResults.setText(String.valueOf(chiffre1));
        }

        if(operateur.equals("*")){
            chiffre1 = chiffre1 * Double.valueOf(textViewResults.getText().toString()).doubleValue();
            textViewResults.setText(String.valueOf(chiffre1));
        }

        if(operateur.equals("/")){
            try{
                chiffre1 = chiffre1 / Double.valueOf(textViewResults.getText().toString()).doubleValue();
                textViewResults.setText(String.valueOf(chiffre1));
            }catch(ArithmeticException e){
                textViewResults.setText("0");
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
