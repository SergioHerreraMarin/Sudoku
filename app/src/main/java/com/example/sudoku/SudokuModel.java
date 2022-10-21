package com.example.sudoku;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.TableLayout;

public class SudokuModel {

    private static int[][] sudokuData = new int[9][9];
    CharSequence[] nombres = {"1","2","3","4","5","6","7","8","9"};

    public int[][] getSudokuData(){
        return sudokuData;
    }

    public CharSequence[] getNombres(){
        return this.nombres;
    }


}
