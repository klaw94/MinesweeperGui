/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.guimijnenveger;

/**
 *
 * @author Gebruiker
 */
public class Veld {
    int[][] bord;
    int MIJN = 9;
    

    public Veld(int numRows, int numColumns, int numBombs) {
        bord = new int[numRows][numColumns]; 
    
        for (int i = 0; i < numBombs; i ++){
            bord[(int) Math.floor(Math.random()* numRows)][(int) Math.floor(Math.random()* numColumns)] = MIJN;
            
        }
    }
    
    public boolean isBomb(int row, int column){
        if(bord[row][column] == MIJN){
            return true;
        } else{
            return false;
        }
    }   
    
    public int checkBombsAround(int row, int column){
        int amountBombs = 0;        
        for(int i = -1; i <= 1; i ++){
            for(int x = -1; x <= 1; x ++){
                if(!isInTheField(row + i, column + x)){
                    continue;
                }
                if (isBomb(row + i, column + x)){
                    amountBombs++;
                } 
            }
        }
        return amountBombs;
    }

    private boolean isInTheField(int row, int column) {
        if(row < bord.length && row >= 0 && column < bord[0].length && column >= 0){
            return true;
        } else {
            return false;
        }
    }
        
}
