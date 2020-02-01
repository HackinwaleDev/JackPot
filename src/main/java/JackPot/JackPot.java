/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JackPot;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class JackPot {
    
    // instantiate the class variables
    private final int[] balls;
    private final List<Integer> ballsWithoutReplacement;
    private static final int SIZE = 35;
    private final SecureRandom random;    
    
    // create a constructor
    public JackPot(int[] allBalls){
        this.balls = allBalls;
        this.ballsWithoutReplacement = new ArrayList<>();
        random = new SecureRandom();
    }// end constructor
    
    // create setter-getter for ballsWithoutReplacement
    public void setBallsWithoutReplacement(List<Integer> bwr){
        // Something needs to be done here 
        System.out.println(bwr);
        if(ballsWithoutReplacement.size() > 0) this.ballsWithoutReplacement.clear();
        this.ballsWithoutReplacement.addAll(bwr);
        System.out.println("Inside setBalls...");
        System.out.println(this.ballsWithoutReplacement);
        
    }// end setter
    
    public List<Integer> getBallsWithoutReplacement(){
        return this.ballsWithoutReplacement;
    }// end getter
    
    // CORE FUNCTIONALITY BEGINS HERE...
    public int[] shuffleBalls(int[] arrBalls){
        // Using Fisher-Yate's algorithm
        for(int i = arrBalls.length-1; i>0; i--){
            //pick a random number btw 0-i
            int r = random.nextInt(i+1);
            int temp = arrBalls[i];
            arrBalls[i] = arrBalls[r];
            arrBalls[r] = temp;
        }
        return arrBalls;
        
    } // end method shuffleBalls (int)
    
    public List shuffleBalls(List<Integer> listBalls){
        // Using Fisher-Yate's algorithm       
        for(int i = listBalls.size()-1; i > 0; i--){
            //pick a random number btw 0 - i
            int r = random.nextInt(i+1);            
            int temp = listBalls.get(i);
            listBalls.set(i, listBalls.get(r));
            listBalls.set(r, temp);
        }
    /*    
        // Using normal shuffle alorithm
        for(int i = 0; i < listBalls.size(); i++){
            int r = random.nextInt(listBalls.size());
            int temp = listBalls.get(i);
            listBalls.set(i, listBalls.get(r));
            listBalls.set(r, temp);
        }
    */
        return listBalls;
    
    } // end method shuffleBalls (List)
      
    // Display all pre-played balls 
    public void displayAllBalls(){
        System.out.printf("%nALL BALLS IN THE LUCKYBALL GAME%n");
        // print 8 digit per row
        for(int ball : balls){
            System.out.printf("%2d\t", ball);
            if(ball%8 == 0) System.out.println();
        }
    }//end displayAllBalls
    
    // Display the balls after being shuffled
    public void displayShuffledBalls(int[] arr){
        System.out.printf("%nALL SHUFFLED BALLS IN THE LUCKYBALL GAME%n");
        // print 8 digit per row
        for(int count = 0; count < arr.length; count++){
            System.out.printf("%2d\t", arr[count]);
            if(count%8 == 0) System.out.println();
        }
        System.out.println();
        
    }// end method displayShuffledBalls

    // Display the 35 lucky balls only
    public void displayLuckyBalls(List<Integer> luckyBalls){
        // Convert luckballs list to array
        Integer[] luckyBallsArr = luckyBalls.toArray(new Integer[SIZE]);
        // represent the format in multidimenstional array
        int[][] myBalls = new int[7][];
        myBalls[0] = new int[5];
        myBalls[1] = new int[9];
        myBalls[2] = new int[3];
        myBalls[3] = new int[3];
        myBalls[4] = new int[3];
        myBalls[5] = new int[3];
        myBalls[6] = new int[9];
        
        // fill in myBalls with all luckyBalls elements
        // Using Enhanced For-Loop
        int j = 0;
        for (int[] myBall : myBalls) { 
            int n = 0;
            for (; j <luckyBallsArr.length; j++) {
                if (n >= myBall.length) {
                    break;
                }
                myBall[n] = luckyBallsArr[j];
                n++;
            }
        }
        
        // display them in the format:
        // - row 1:     5 balls
        // - row 2:     9 balls
        // - row 3-6:   3 balls each 
        // - row 7:     9 balls
        for(int row = 0; row < myBalls.length; row++){
            System.out.printf("Row %2d\t\t", row+1);
            for(int ball : myBalls[row]){
                // print balls row by row
                System.out.printf("%2d\t",ball);
            }
            System.out.println();
        }
        
    }// end method displayLuckyBalls (ONLY)
    
    // Display the 35 lucky balls and other stuff
    public void displayLuckyBalls(){
        // collect all luckyballs here
        int[] luckyBalls = processBalls();
        List<Integer> luckyBallList = processBalls2();
        Integer[] luckyBallsArr = luckyBallList.toArray(new Integer[SIZE]);
        // represent the format in multidimenstional array
        int[][] myBalls = new int[7][];
        myBalls[0] = new int[5];
        myBalls[1] = new int[9];
        myBalls[2] = new int[3];
        myBalls[3] = new int[3];
        myBalls[4] = new int[3];
        myBalls[5] = new int[3];
        myBalls[6] = new int[9];
        
        // fill in myBalls with all luckyBalls elements
        // Using Enhanced For-Loop
        int j = 0;
        for (int[] myBall : myBalls) { 
            int n = 0;
            for (; j <luckyBallsArr.length; j++) {
                if (n >= myBall.length) {
                    break;
                }
                myBall[n] = luckyBallsArr[j];
                n++;
            }
        }
    /**
        // For-Loop (non-Enhanced)
        int j = 0;
        for(int i = 0; i < myBalls.length; i++){ 
            int n = 0;
            for(; j <luckyBalls.length; j++){
                if(n >= myBalls[i].length) break;
                myBalls[i][n] = luckyBalls[j];
                n++;
            }
        }         
     */
        
        // display them in the format:
        // - row 1:     5 balls
        // - row 2:     9 balls
        // - row 3-6:   3 balls each 
        // - row 7:     9 balls
        System.out.printf("%nDISPLAYING ALL THE LUCKY BALLS IN THE RIGHT FORMAT%n");
        for(int row = 0; row < myBalls.length; row++){
            System.out.printf("Row %2d\t\t", row+1);
            for(int ball : myBalls[row]){
                // print balls row by row
                System.out.printf("%2d\t",ball);
            }
            System.out.println();
        }
        
        // shuffle the balls like 35x before printing
        int counter = 0;
        while(counter != SIZE*10){ //no effect yet
            luckyBallList = shuffleBalls(luckyBallList);
            counter++;
        }
        // call method displayLeftOver
        displayLeftOverBalls(luckyBallList);
        // call method
        displayAdjustedLuckyBalls(luckyBallList);
        // call displayOddEven method 
        displayOddEven(luckyBallsArr);
        
    }// end displayLuckyBalls
    
    public void displayOddEven(Integer[] luckyBalls){
        System.out.println("\nSEPARATING THE ODDs FROM THE EVENs");
        for(int isOdd = 0; isOdd <= 1; isOdd++){
            System.out.printf("All %s:\t", isOdd == 1? "Odds" : "Evens");
            for(int ball : luckyBalls){
                if(ball%2 == isOdd) System.out.printf("%d\t", ball);
            }
            System.out.println();
        }
    }// end method displayOddEven
    
    public void displayLeftOverBalls(List<Integer> lukcyBalls){
        System.out.println("\nTHE LEFTOVER BALLS");
        for(int count = 0; count < this.balls.length; count++){
            if(!lukcyBalls.contains(this.balls[count])){
                System.out.printf("%d\t", balls[count]);
            }
        }
        System.out.println("\n--Unshuffled-------------------");
        this.ballsWithoutReplacement.forEach((leftOver) -> {
            System.out.printf("%d\t", leftOver);
        });
        System.out.println();
    }// end method displayLeftOverBalls
    
    public void displayAdjustedLuckyBalls(List<Integer> luckyBalls){
        /*      STEPS
        * - Retrieve the luckyballs
          - Retrieve the leftoverballs
          - Now randomly select 13 balls from the luckyballs and replace with 
            the leftover balls  
          - Retain the randomly selected balls to an array
          - Display the adjusted luckyBalls and the replaced balls
        */
        int[] replacedBalls = new int[this.ballsWithoutReplacement.size()];
        for (int i = 0; i < replacedBalls.length; i++) {
            int r = random.nextInt(SIZE);
            replacedBalls[i] = luckyBalls.remove(r);
            luckyBalls.add(r, this.ballsWithoutReplacement.get(i));
        }
        System.out.println("\nTHE REPLACED LEFTOVER BALLS...");
        for(int replacedBall : replacedBalls) System.out.printf("%2d\t",replacedBall);
        System.out.println();
        // Now pass the newly adjusted luckyballs to be displayed on the screen
        System.out.printf("%nDISPLAYING ALL THE ADJUSTED LUCKY BALLS IN THE RIGHT FORMAT%n"); //Header
        displayLuckyBalls(luckyBalls);
    } // end method displayAdjustedLuckyBalls
    
    public int[] processBalls(){
        //CASE I: shuffle the balls and print the first 35 from the list as luckyball
        int[] luckyBalls = new int[35];
        int[] temp = shuffleBalls(balls);
        System.arraycopy(temp, 0, luckyBalls, 0, luckyBalls.length);
        return luckyBalls; 
        
        //CASE III: shuffle the balls and print a randomly picked one from the list as lucky ball
    
    } // end method processBalls
    
    public List processBalls2(){
        //CASE II: shuffle the balls and print the first one from the list as luckball
        List<Integer> luckyBalls = new ArrayList<>();
        int[] shuffledBalls = shuffleBalls(this.balls); 
        // Add all shuffledBalls to the class variable
        for(int element : shuffledBalls) this.ballsWithoutReplacement.add(element);
        // remove the first element in the list and add to luckyBalls
//        luckyBalls.add(0, getBallsWithoutReplacement().remove(0));
        // shuffle the balls and repeat until luckyBalls reach 35
        while(luckyBalls.size() < SIZE){   // Recursive         
            luckyBalls = populateLuckyBalls(luckyBalls, shuffleBalls(getBallsWithoutReplacement()));
        }  
        // display the Header
        System.out.printf("%n%nFINAL LUCKYBALLS (Process Balls II)%n");
        
        return luckyBalls;
        
    } //end method processBalls2
    
    public List populateLuckyBalls(List<Integer> luckyBalls, List<Integer> shuffledBall){
        // fill the luckyBalls with the first element from the shuffledBall
//        luckyBalls.add(0, shuffledBall.remove(0));

        // fill the luckyBalls with a random element from the shuffledBall
        luckyBalls.add(0, shuffledBall.remove(random.nextInt(shuffledBall.size())));
        
        return shuffleBalls(luckyBalls);
        
    } //end method populateLuckyBalls
        
}// end class
