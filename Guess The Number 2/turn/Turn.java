package turn;

import java.util.concurrent.ThreadLocalRandom;
import funks.*;
import eror.*;

public class Turn{

    Input i = new Input(); 
    Function f = new Function();
    
    public int lower = 1;
    public int upper = 100;
    public int score;
    public boolean cheatingFlag = false;

    public int userPlay()
    {
        score = 100;

        f.print("USERS TURN:", 10);System.out.println();System.out.println();
        f.delay(800);
        f.print("Let me consider a number...", 20);System.out.println();
        int num = ThreadLocalRandom.current().nextInt(lower,upper+1);System.out.println();
        f.delay(2000);
        
        while(true)
        {
            if(score == 50)
            {
                f.print("Your Turn is Over", 100);System.out.println();
                f.delay(1000);
                return score;
            }

            f.print("Guess : ", 10);
            int guess = i.input(lower, upper);
            if(guess == -2)
            {
                return guess;
            }
            

            if(guess == num)
            {
                
                
                if(cheatingFlag)
                {
                    f.delay(1000);
                    f.print("Ohh sorry! ", 10);
                    f.delay(500);
                    f.print("Actually i forgot that number", 30);System.out.println();
                    f.delay(1000);
                    cheatingFlag = false;
                    return 50;
                }
                f.print("You guessed it!", 30);System.out.println();
                f.delay(1000);
                return score;
            }
            else if(guess < num)
            {
                f.print("No! ", 30);
                f.delay(300);
                f.print("It's Smaller", 50);System.out.println();
                score -= 5;
            }
            else if(guess > num)
            {
                f.print("No! ", 30);
                f.delay(300);
                f.print("It's Larger", 50);System.out.println();
                score -= 5;
            }

            f.delay(1000);
        }

    }


   
    
    public int machinePlay()
    {
        score = 100;
        int low = lower;
        int up = upper+1;
        boolean flg = false;

        System.out.println();System.out.println();
        f.print("MACHINES TURN:", 10);System.out.println();System.out.println();
        f.delay(800);
        f.print("Consider a number  ", 50);
        f.delay(4000);
        f.print("Done?", 10);System.out.println();
        f.delay(1000);

        while(true)
        {
            if(low == up)
            {
                f.delay(1000);
                f.print("Sorry! ", 50);
                f.delay(500);
                f.print("i can't guess further", 50);System.out.println();
                cheatingFlag = true;
                return score;
            }

            if(score == 40)
            {
                f.delay(1000);
                f.print("I'm Out!", 30);System.out.println();
                return score;                
            }


            int num;
            if(upper == 100)
            {                
                if( flg )
                {
                    num = (int) ( ((low+up+1)/2)-1 );
                    flg = false;
                }
                else
                {
                    num = ThreadLocalRandom.current().nextInt(low,up);
                    flg = true;
                }

            }
            else
            {
                num = ThreadLocalRandom.current().nextInt(low,up);                
            }

            f.print("number is ", 50);System.out.print(num + "?");System.out.println();  

            f.print("(1)YES  (2)It's Larger  (3)It's Smaller : ", 10);
            int choice = i.input(1, 3);
            if(choice == -2)
            {
                return choice;
            }
            
            if(choice == 1)
            {
                return score;
            }
            else if(choice == 2)
            {
                f.delay(500);
                f.print("tyring smaller one...", 20);f.delay(1000); System.out.println();
                up = num;
                score -= 5;
            }
            else
            {
                f.delay(500);
                f.print("tyring larger one...", 20);f.delay(1000); System.out.println();
                low = num+1;
                score -= 5;
            }

        }

        
    }
        
    
    
}
