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

    private TableLayout tableLayout;
    private SudokuModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        model = new SudokuModel();
        tableLayout = findViewById(R.id.tableLayout);
        createTable(model.getSudokuData());
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
                spinner.setBackgroundColor(Color.LTGRAY);
                ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this,
                        android.R.layout.simple_spinner_item, model.getOpciones());
                spinner.setAdapter(adapter);
                spinner.setOnItemSelectedListener(this);
                spinner.setTag(R.id.col, y);
                spinner.setTag(R.id.fila, x);
                row.addView(spinner);
            }
            tableLayout.addView(row);
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        model.setVal((int)adapterView.getTag(R.id.fila),(int)adapterView.getTag(R.id.col), (int)adapterView.getItemAtPosition(i));
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}



