package Codesoft;

import java.util.*;
public class NumberGame {
    public static void main(String args[])
    {
        Random rand = new Random();
        int number = rand.nextInt(100);
        Scanner sc=new Scanner(System.in);
        for(int i=1;i<=5;i++){
            System.out.println("Guess the number between 1 to 100 : ");
            int Guess=sc.nextInt();
            if(Guess==number){
                System.out.println("Correct!");
                System.out.println("You Won");
                System.out.println("You have guessed the number in : " +i + " Chance");
                break;
            }
            else if(Guess>number){
                System.out.println("Too High");
            }
            else{
                System.out.println("Too Low");
            }
            for(int j=i;j==5;){
                System.out.println("Sorry! You lost the Game.");
                System.out.println("Do you want to Play again?");
                break;
            }

        }
    }
}