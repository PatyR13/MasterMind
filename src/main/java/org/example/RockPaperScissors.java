package org.example;

public class RockPaperScissors {
    public static String rps(String p1, String p2){
        String result = " ";
        if(p1.equals(p2)){
            result = "Draw!";
        } else if (p1.equals("scissors") && p2.equals("paper")) {
            result = "Player 1 won!";
        } else if (p1.equals("scissors") && p2.equals("rock")) {
            result = "Player 2 won!";
        }
        return result;
    }
}
