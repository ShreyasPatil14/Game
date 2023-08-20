
import funks.*;
import result.*;
import turn.*;
import eror.Input;

class GuessTheNumber2
{ 
    public static void main(String args[])
    {         
        Input i = new Input();
        Function f = new Function();
        Turn t = new Turn();
        Result r = new Result();        
        boolean exitFlag = true;

        f.drawLine('*');
        f.print("Playing the game First time?", 50);
        f.print(" Yes(1)  N0(0) : ", 10);
        int choice = i.input(0, 1);
        if(choice == -2)
        {
            exitFlag = false;
        }

        if(exitFlag)
        {
            if (choice == 1)
            { 
                f.drawLine('-');
                f.introducer();
            }
            else
            { 
                System.out.println();
                f.print("Then...", 10);
                f.delay(1000);
                f.print("Let's Go!", 10);
                f.drawLine('-');
            }
        
            f.print("Select Level : ", 30);f.delay(300);f.print("'Easy Level' ", 50);f.delay(100);
            f.print("range[1-10] (1)   ", 50);f.delay(1000);f.print("'Hard Level' ", 50);f.delay(100);
            f.print("range[1-100] (2) : ", 50);

            int levelChoice = i.input(1, 2);
            if(levelChoice == -2)
            {
                exitFlag = false;
            }

            if(exitFlag)
            {
                f.drawLine('-');

                if(levelChoice == 1)
                { 
                    t.upper = 10;
                }

                int turnCount = 3;
                int userScore = 0;
                int machineScore = 0;

                while(turnCount != 0)
                {  
                    int score = t.userPlay();
                    if(score == -2)
                    {
                        break;
                    }
                    userScore = userScore + score;
                    f.print("Your Score is: ", 30);System.out.println(score);f.delay(1000);

                    score = t.machinePlay();
                    if(score == -2)
                    {
                        break;
                    }
                    machineScore = machineScore + score;
                    f.print("Machine's Score is: ", 30);System.out.println(score);f.delay(1000);

                    f.drawLine('.');
                    turnCount -= 1; 

                    if(turnCount == 0)
                    { 
                        r.showResult(userScore, machineScore);

                        f.print("Play Again(1) Exit game(0) : ", 50);
                        int choice2 = i.input(0, 1);                        
                        if(choice2 == 1)
                        { 
                            f.drawLine('-');
                            turnCount = 3;
                            userScore = 0;
                            machineScore = 0;
                        }               
                    }
                }
            }
        }
        System.out.println();
        f.space(71);
        f.print("Thank You!", 60);
        f.drawLine('*');
   }
}