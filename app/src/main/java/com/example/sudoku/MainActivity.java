package com.example.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static Spinner[][] spinnerArray = new Spinner[9][9];
    private TableLayout tableLayout;
    private SudokuModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        model = new SudokuModel();
        tableLayout = findViewById(R.id.tableLayout);
        createTable(model.getSudokuData());
        model.creaPartida();
        refrescaGUI();
    }


    private TableRow.LayoutParams newTableRowParams(){
        TableRow.LayoutParams params = new TableRow.LayoutParams();
        params.setMargins(1,1,1,1);
        params.weight = 1;
        return params;
    }


    private void createTable(int[][] data){
        for(int x = 0; x < data.length; x++){
            TableRow row = new TableRow(this.getApplicationContext());
            for(int y = 0; y < data[x].length; y++){
                Spinner spinner = new Spinner(this);
                spinner.setBackground(null);
                //spinner.setBackgroundColor(Color.LTGRAY);
                ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this,
                        android.R.layout.simple_spinner_item, model.getOpciones());
                spinner.setAdapter(adapter);
                spinner.setOnItemSelectedListener(this);
                spinner.setTag(R.id.col, y);
                spinner.setTag(R.id.fila, x);
                spinnerArray[x][y] = spinner;
                row.addView(spinner);
            }
            tableLayout.addView(row);
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        //model.setVal((int)adapterView.getTag(R.id.fila),(int)adapterView.getTag(R.id.col), (int)adapterView.getItemAtPosition(i));

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    private void refrescaGUI(){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                int value = model.getSudokuData()[i][j];
                int index = 0;
                for(int k = 0; k < model.getOpciones().length; k++){
                    if(model.getOpciones()[k].equals(String.valueOf(value))){
                        index = k;
                        break;
                    };
                }
                spinnerArray[i][j].setSelection(index);
            }
        }
    }

}



