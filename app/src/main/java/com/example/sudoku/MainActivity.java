package com.example.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private TableLayout tableLayout;
    private Context context;
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
        for(int i = 0; i < data.length; i++){
            TableRow row = new TableRow(this.getApplicationContext());
            for(int j = 0; j < data[i].length; j++){
                Spinner spinner = new Spinner(this);
                ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this,
                        android.R.layout.simple_spinner_item, model.getNombres());
                spinner.setAdapter(adapter);

                //spinner.setBackground(null);
                //spinner.setPadding(5,5,5,5);
                //spinner.setBackgroundColor(Color.BLUE);
                spinner.setTag(R.id.col, j);
                spinner.setTag(R.id.fila, i);
                spinner.setOnItemSelectedListener(this);
                row.addView(spinner, newTableRowParams());
            }
            tableLayout.addView(row);
        }
    }




    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        adapterView.getItemAtPosition(i);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}



