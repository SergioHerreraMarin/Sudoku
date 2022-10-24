package com.example.sudoku;

import android.content.Context;
import android.os.Debug;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.TableLayout;

import java.util.Random;

public class SudokuModel {

    private static int[][] sudokuData = new int[9][9];
    private CharSequence[] opciones = {"0","1","2","3","4","5","6","7","8","9"};

    public int[][] getSudokuData(){
        return sudokuData;
    }

    public CharSequence[] getOpciones(){
        return this.opciones;
    }

    public int getVal(int x, int y){
        return sudokuData[x][y];
    }

    public void setVal(int x, int y, int val){

        Log.i("INFO", "Fila: " + comprovaFila(x,y, val) + ", Columna: " + comprovaColumna(x,y, val));
        if(comprovaFila(x,y, val) && comprovaColumna(x,y, val)){
            sudokuData[x][y] = val;
        }else{
            sudokuData[x][y] = 0;
        }

    }

    public boolean comprovaFila(int x, int y, int val){

        for (int i = 0; i < sudokuData[y].length; i++) {
            if(sudokuData[x][i] == val){
                return false;
            }
        }

        return true;
    }

    public boolean comprovaColumna(int x, int y, int val){

        for (int i = 0; i < sudokuData[x].length; i++) {
            if(sudokuData[i][y] == val){
                return false;
            }
        }

        return true;
    }

    public boolean comprovaQuadrant(int x, int y){
        return true;
    }

    public void creaPartida(){

        Random random = new Random();

        for(int i = 0; i < sudokuData.length; i++){
            for(int j = 0; j < sudokuData[i].length; j++){
                sudokuData[i][j] = 0;
            }
        }

        for(int i = 0; i < sudokuData.length; i++){
            for(int j = 0; j < sudokuData[i].length; j++){
                setVal(i, j, random.nextInt(9));
            }
        }

    }

}
