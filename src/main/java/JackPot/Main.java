/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JackPot;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] BALLS = new int[48]; 
        List<Integer> luckyBalls = new ArrayList<>();
        
        // write data from 01 to 48 into the BALLS
        for(int i = 0; i < BALLS.length; i++){
            BALLS[i] = i+1;
        }
        // Fill the luckyBalls with the array of chosen balls 
        int[] chosenBalls = {33,44,47,28,32,12,30,13,10,40,17,25};
        for(int ball : chosenBalls){
            luckyBalls.add(0, ball);
        }
        JackPot jackPot = new JackPot(BALLS);
//        jackPot.displayAllBalls();
//        jackPot.displayLuckyBalls();
        jackPot.displayShuffledBalls(jackPot.shuffleBalls(chosenBalls));
    }
    
}
