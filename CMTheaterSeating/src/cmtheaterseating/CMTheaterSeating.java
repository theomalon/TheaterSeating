/*
 * Chris Malon
 * 2/17/13
 * Theater Seating
 */
package cmtheaterseating;

/**
 *
 * @author ZERO
 */

import java.util.Scanner;

public class CMTheaterSeating {

    /**
     * @param args the command line arguments
     */
    
    private static int[][] seating = 
    {
        {10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
        {10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
        {10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
        {10, 10, 20, 20, 20, 20, 20, 20, 10, 10},
        {10, 10, 20, 20, 20, 20, 20, 20, 10, 10},
        {20, 20, 30, 30, 40, 40, 30, 30, 20, 20},
        {20, 30, 30, 40, 50, 50, 40, 30, 30, 20},
        {30, 40, 50, 50, 50, 50, 50, 50, 40, 30}
    };
    
    public static void displaySeating()
    {
        for (int row = 0; row <seating.length; row++)
        {
            for (int col = 0; col<seating[row].length; col++)
            {
                System.out.print(seating[row][col] + " ");
            }
            
            System.out.println(" ");
        }        
    }
    
    public static boolean availability(int r, int s)
    //checks if the seat is available or not
    {
        if (seating[r][s] != 0)
        {
            return true;
        }
        
        else 
        {
            return false;
        }
    }
    
    public static void availabilityPrice(int p)
    //shows the available seating the the price user entered
    {
        String seatPrice = " ";
        for(int row = 0; row<seating.length; row++)
        {
            for(int seat = 0; seat<seating[row].length; seat++)
            {
                if(seating[row][seat] == p)
                {
                    seatPrice = seatPrice + "["+row+","+seat+"]";
                }
            }
        }
        
        if(seatPrice != " ")
        {
            System.out.print("These are the seat that cost $"+p+": "+seatPrice);
            System.out.println();
        }
        
        else
        {
            System.out.println("Sorry there are no available seating in that price.");
        }
    }
    
    public static int[][] changeAvailability(int r, int s)
    {
        seating[r][s] = 0;
        return seating;
    }
    
    public static boolean purchase(int r, int s)
    {
        Scanner in = new Scanner(System.in);
        String purchases;
        boolean status = true;
        System.out.println("Would you like to purchase seat " + s + " in row " + r + " for $" + seating[r][s] + "?");
        System.out.print("Enter (Y)es or (N)o: ");
        purchases = in.next();
        purchases = purchases.toUpperCase();
        System.out.println();
        if(purchases.equalsIgnoreCase("Y"))
        {
            status = true;
        }
        
        else if(purchases.equalsIgnoreCase("N"))
        {
            status = false;
        }
        
        return status;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        int ChoiceRow = 0;
        int ChoiceSeat = 0;
        int price = 0;
        int userChoice; 
        
        Scanner in = new Scanner(System.in);         
        displaySeating();
        System.out.println();
        System.out.println("Welcome to the Malon Theater!");
        System.out.print("Displayed above is the seating chart with prices shown. ");
        System.out.println("Seats with a 0 are seats that are not availabe.");
        do
        {
            System.out.println("1) Enter the row and seat number you would like to have.");
            System.out.println("2) Enter the price you would like to pay.");
            System.out.println("3) Display seating chart.");
            System.out.println("4) Finish.");
            System.out.print("Please make a selection: ");
            userChoice = in.nextInt();
            System.out.println();
            
            switch(userChoice)
            {
                case 1:
                    displaySeating();
                    System.out.println();
                    System.out.println("Top left corner row 0 seat 0 and seating is numbered from 0-9.");
                    System.out.print("Please enter the row you would like: ");
                    ChoiceRow = in.nextInt();
                    System.out.print("Please enter the seat number: ");
                    ChoiceSeat = in.nextInt();
                    if(availability(ChoiceRow, ChoiceSeat ))
                    {
                        if(purchase(ChoiceRow, ChoiceSeat))
                        {
                            changeAvailability(ChoiceRow, ChoiceSeat);
                        }
                        
                        else
                        {
                            break;
                        }                        
                    }
                    
                    else
                    {
                        System.out.println("Sorry, this seat is not available.");
                        System.out.println();
                        break;
                    }
                    
                    break;
                    
                case 2:
                    System.out.print("Enter price: ");
                    price = in.nextInt();
                    availabilityPrice(price);
                    System.out.print("Please enter the row you would like: ");
                    ChoiceRow = in.nextInt();
                    System.out.print("Please enter the seat number: ");
                    ChoiceSeat = in.nextInt();
                    
                    if(availability(ChoiceRow, ChoiceSeat))
                    {
                        if (purchase(ChoiceRow, ChoiceSeat))
                        {
                            changeAvailability(ChoiceRow, ChoiceSeat);
                        }
                        
                        else
                        {
                            break;
                        }
                    }
                    
                    else
                    {
                        System.out.println("Sorry, this seat is not available.");
                    }
                    
                    break;
                    
                case 3:
                    displaySeating();
                    System.out.println();
                    System.out.print("Displayed above is the seating chart with prices shown. ");
                    System.out.println("Seats with a 0 are seats that are not availabe.");
                    break;
            }            
        }while(userChoice != 4);
        
        System.out.println("Thank you for visiting the Malon Theater.");
        System.out.println("Please come again soon.");
    }
}
