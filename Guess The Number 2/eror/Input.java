package eror;

import java.util.InputMismatchException;
import java.util.Scanner;
import funks.*;

public class Input
{
    
    Function f = new Function();

    public int inputInt(int start, int end)
    {
        Scanner sc = new Scanner(System.in);
        String num = sc.next();
        String exit = "exit";

        try{
            
            
            int num1;
            try{
                num1 = Integer.parseInt(num);

                if(num1 >= start && num1 <= end)
                {
                    return num1;
                }   
                else
                {
                    System.out.print("[Invalid Inpute] ");
                    f.print("Try again : ", 30);
                    return -1;
                }
            }
            catch(NumberFormatException e)
            {
                if(num.equals(exit))
                {
                    return -2;
                }
                System.out.print("[Invalid Inpute] ");
                f.print("Try again : ", 30);
                return -1;
            }
                
        }
        catch(InputMismatchException e){
            System.out.print("[Invalid Inpute] ");
            f.print("Try again : ", 30);                
        }

        
        return -1;
        
    }

    public int input(int start, int end)
    {
        int num = inputInt(start, end);
        while(num == -1)
        {
            num = inputInt(start, end);
            if(num == -2)
            {
                return num;
            }            
        }
        return num;
    }

    
}
