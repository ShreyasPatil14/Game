package result;

import funks.*;

public class Result
{

    public void showResult(int userScore, int machineScore)
    {
        Function f = new Function();
        

            f.print("Your Score is " + userScore,50);
            System.out.println();
            f.print("Machine's Score is " + machineScore,50);
            System.out.println();

            if (userScore < machineScore)
            {
                f.delay(2000);
                f.space(68);
                f.print("You Lose The Game ", 50);System.out.println();
                f.delay(1000);
                f.space(66);
                f.print("better luck next time!", 50);
            }
            else if(machineScore < userScore)
            {
                f.delay(2000);
                f.space(69);
                f.print("CONGRATULATIONS! ", 70);System.out.println();
                f.delay(500);
                f.space(67);
                f.print("You Won The Game!!!", 50);

            }
            else
            {
                f.delay(2000);
                f.space(70);
                f.print("Game Is Tie", 50);
            }

            f.drawLine('-');

    }
    
}
