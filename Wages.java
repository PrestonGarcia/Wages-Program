//Author: Preston Garcia
import java.util.Scanner;
import java.util.InputMismatchException;

public class Wages{//Start bracket for Wages class
   
   public static void main(String[] args){//Start bracket for main function
      
      //Constants
      final int EMPLOYEENAMEINDEX = 0;
      final int TIMEINDEX = 1;
      final int PAYINDEX = 2;
      final int MOREEMPLOYEESINDEX = 3;
      final int MINNAMECHARAMOUNT = 3;
      final int MINTIME = 800;
      final int MAXTIME = 1900;
      final int TENSPLACEOFFSET = 2;
      final int MAXTENSPLACE = 6;
      final int FOURLETTERSLONG = 4;
      final int THREELETTERSLONG = 3;
      final int STARTINDEX = 0;
      final int ENDINDEXFOURLETTERS = 2;
      final int ONEHOUR = 1;
      final int MINMINUTES = 0;
      final int SIXTYMINUTES = 60;
      final float MINPAY = 8.50f;
      final float MAXPAY = 49.99f;
         
      //boolean variables
      boolean bEmployeeNameDone = false;
      boolean bTimeDone = false;
      boolean bPayPerHourDone = false;
      boolean bMoreEmployeesDone = false;
      boolean bAllDone[] = {bEmployeeNameDone, bTimeDone, bPayPerHourDone, bMoreEmployeesDone};
      boolean bProgramDone = false;
      
      //char variable
      char cLastEmployee;
      char cTensPlaceCheckIn;
      char cTensPlaceCheckOut;
      char cMoreEmployees;
      
      //float variables, set to 0 if placeholder is needed
      float fEmployeePay = 0;
      float fTotalPay;
      
      //int variables, set to 0 if placeholder is needed
      int iEmployeeNameCharAmount;
      int iCheckInTime = 0;
      int iCheckInTimeLength = 0;
      int iCheckInTensPlaceIndex;
      int iCheckInTensPlace;
      int iCheckOutTime = 0;
      int iCheckOutTimeLength = 0;
      int iCheckOutTensPlaceIndex;
      int iCheckOutTensPlace;
      int iCheckInHours = 0;
      int iCheckOutHours = 0;
      int iHoursSpent;
      int iCheckInMinutes;
      int iCheckOutMinutes;
      int iMinutesSpent;
      int iCounter;
      
      //Scanner instance
      Scanner scanner = new Scanner(System.in); 
      
      //String variables, set to empty string if placeholder is needed
      String sEmployeeName = "";
      String sEmployeeNameNoSpaces;
      String sCheckInTime = "";
      String sCheckOutTime = "";
      
      while (!bProgramDone){//Start bracket iterating through entire program
      
         while (!bAllDone[EMPLOYEENAMEINDEX]){ //Start bracket for while loop checking to see if a valid employee name has been given 
            
            try{//Start bracket for try statement
            
               System.out.printf("Please enter the employee's name, must have more than %d non-blank characters \n", MINNAMECHARAMOUNT); //Min char amount is 3
               sEmployeeName = scanner.nextLine().trim(); //Reads the employee name inputted, and takes out blank spaces around
               scanner = new Scanner(System.in); //Resets scanner
               sEmployeeNameNoSpaces = sEmployeeName.replace(" ", ""); //Removes blank characters
               iEmployeeNameCharAmount = sEmployeeNameNoSpaces.length(); //Counts non blank characters
               
               if(iEmployeeNameCharAmount < MINNAMECHARAMOUNT){//If statement checking if name char amount is < 3
                  
                  throw new InputMismatchException();//Goes to catch statement
               
               }//End bracket for if statement checking char amount of name
               
               bAllDone[EMPLOYEENAMEINDEX] = true;//Ends while loop
            
            } //End bracket for try statement
            
            catch(InputMismatchException ime){ //Start bracket to catch statement
               
               System.out.println("That is not a valid employee name. Please try again.");
            
            }//End bracket to catch statement
         
         }//End bracket for while loop checking to see if a valid employee name has been given
      
         while (!bAllDone[TIMEINDEX]){//Start bracket for while loop checking to see if a valid times have been given
            
            try{//Start bracket for try statement
               
               System.out.printf("Please enter the employee's check-in time in military format. Must be between %3d and %4d \n", MINTIME, MAXTIME);//mintime is 800, maxtime is 1900
               iCheckInTime = scanner.nextInt(); //Reads next int input
               scanner = new Scanner(System.in); //Resets scanner
               sCheckInTime = Integer.toString(iCheckInTime);//Converts to string
               iCheckInTimeLength = sCheckInTime.length(); //Gets length
               iCheckInTensPlaceIndex = iCheckInTimeLength - TENSPLACEOFFSET; //2nd to last index of string
               cTensPlaceCheckIn = sCheckInTime.charAt(iCheckInTensPlaceIndex); //gets char at 2nd to last index
               iCheckInTensPlace = Character.getNumericValue(cTensPlaceCheckIn); //Converts to int for comparison
               
               if (iCheckInTensPlace >= MAXTENSPLACE || iCheckInTime < MINTIME || iCheckInTime > MAXTIME){ //If statement checking if check-in time is outside 0-2400 range
               
                  throw new InputMismatchException();//Goes to the catch statement
               
               } //End bracket for if statement checking check-in time range
               
               System.out.printf("Please enter the employee's check-out time in military format. Must be between %3d and %4d \n", MINTIME, MAXTIME); //Asks user for check-out time
               iCheckOutTime = scanner.nextInt(); //Reads next int input
               scanner = new Scanner(System.in); //Resets scanner
               sCheckOutTime = Integer.toString(iCheckOutTime);//Converts to string
               iCheckOutTimeLength = sCheckOutTime.length(); //Gets length
               iCheckOutTensPlaceIndex = iCheckOutTimeLength - TENSPLACEOFFSET; //2nd to last index of string
               cTensPlaceCheckOut = sCheckOutTime.charAt(iCheckOutTensPlaceIndex); //gets char at 2nd to last index
               iCheckOutTensPlace = Character.getNumericValue(cTensPlaceCheckOut); //Converts to int for comparison
               
               if (iCheckOutTime < iCheckInTime || iCheckOutTensPlace >= MAXTENSPLACE || iCheckOutTime < MINTIME || iCheckOutTime > MAXTIME){//If statement checking if check-out time is outside 0-2400 range
               
                  throw new InputMismatchException(); //Goes to catch statement
               
               }//End bracket for if statement checking if check-out time is outside 0-2400 range
               
               bAllDone[TIMEINDEX] = true; //Ends while loop
            
            }//End bracket for try statement
            
            catch(InputMismatchException ime){//Start bracket for catch statement for InputMismatchException
            
               System.out.println("That is not a valid check-in/check-out time. Please try again.");
            
            }//End bracket for catch statement for InputMismatchException
            
            catch (StringIndexOutOfBoundsException sioobe){//Start bracket for catch statement for StringIndexOutOfBounds exception
            
               System.out.println("That is not a valid check-in/check-out time. Please try again.");         
            
            }//End bracket for catch statement for StringIndexOutOfBounds exception
         
         }//End bracket while loop checking to see if a valid times have been given

         while (!bAllDone[PAYINDEX]){//Start bracket for loop checking if a valid pay per hour was given
            
            try{ //Start bracket for try statement
            
               System.out.printf("Please enter the employee's pay. Must be between %.2f and %.2f \n", MINPAY, MAXPAY);//Min pay 8.50, max pay 49.99 
               fEmployeePay = scanner.nextFloat();//Reads next float input
               scanner = new Scanner(System.in); //Resets scanner
            
               if (fEmployeePay < MINPAY || fEmployeePay > MAXPAY){//If statement checking if input pay is in 8.50 to 49.99 range
            
                  throw new InputMismatchException();
            
               }//end of if statement checking if input pay is in 8.50 to 49.99 range
               
               bAllDone[PAYINDEX] = true;
            
            }//End bracket for try statement
            
            catch(InputMismatchException ime){//Start bracket for catch statement
         
               System.out.println("That is not a valid pay per hour. Please try again.");
         
            }//end bracket for catch statement
      
         }//End bracket for loop checking if valid pay per hour was given
      
         switch (iCheckInTimeLength) {//Start bracket for switch checking length of checkin, to avoid outofbounds index errors
            
            case FOURLETTERSLONG: iCheckInHours = Integer.parseInt(sCheckInTime.substring(STARTINDEX, ENDINDEXFOURLETTERS)); //turns first two characters of string to int
               break;
            case THREELETTERSLONG: iCheckInHours = Character.getNumericValue(sCheckInTime.charAt(STARTINDEX));//turns first character of string to int
               break;
         
         }//End bracket for switch checking length of checkin
         
         switch (iCheckOutTimeLength) {//Start bracket for switch checking length of checkout, to avoid outofbounds index errors
           
            case FOURLETTERSLONG: iCheckOutHours = Integer.parseInt(sCheckOutTime.substring(STARTINDEX, ENDINDEXFOURLETTERS));//turns first two characters into int
               break;
            case THREELETTERSLONG: iCheckOutHours = Character.getNumericValue(sCheckOutTime.charAt(STARTINDEX));//turns first character into int
               break;
         
         }//End bracket for switch checking length of checkout
         
         iHoursSpent = iCheckOutHours - iCheckInHours; //finding change in hours
         iCheckInMinutes = Integer.parseInt(sCheckInTime.substring(iCheckInTimeLength - TENSPLACEOFFSET, iCheckInTimeLength)); //shortens string to last two chars, then converts to int
         iCheckOutMinutes = Integer.parseInt(sCheckOutTime.substring(iCheckOutTimeLength - TENSPLACEOFFSET, iCheckOutTimeLength));
         iMinutesSpent = iCheckOutMinutes - iCheckInMinutes;//finding change in minutes
         
         if (iMinutesSpent < MINMINUTES){//Start bracket for checking if minutes is negative
         
            iHoursSpent -= ONEHOUR;
            iMinutesSpent += SIXTYMINUTES;
         
         }//End bracket for checking if minutes is negative
         
         iHoursSpent += iMinutesSpent / SIXTYMINUTES; //Converts the minutes to hours
         fTotalPay = iHoursSpent * fEmployeePay; //Converts hours to $
         //Final display of prints
         System.out.println("Employee Name:" + sEmployeeName);
         System.out.printf("Check in time: %d \n", iCheckInTime);
         System.out.printf("Check out time: %d \n", iCheckOutTime);
         System.out.printf("Pay per hour: $%.2f \n", fEmployeePay);
         System.out.printf("Total pay: $%.2f \n", fTotalPay);
         
         while (!bAllDone[MOREEMPLOYEESINDEX]){//Start of while loop checking to see if input for more employees was given
         
            try{//Start of try statement
         
               System.out.println("Would you like to enter in another employee? (y/n)"); //Prompts user
               cMoreEmployees = scanner.nextLine().charAt(0);//Stores next user character input
               scanner = new Scanner(System.in); //resets scanner
               if (cMoreEmployees == 'y'){//Start of if statement checking if input is 'y'
         
                  for (iCounter = 0;iCounter < 3; iCounter++){ //for loop setting the past booleans to false
         
                     bAllDone[iCounter] = false;//Sets all to false in order to restart
         
                  }//End bracket of for loop setting past booleans to false
         
                  break; 
         
               }//End bracket for if statement checking if input is 'y'
         
               else if (cMoreEmployees != 'n'){//Start of if statement checking if input is anything but n or y
         
                  throw new InputMismatchException();//goes to catch staetemnt
         
               }//End of if statement checking if input is anything but n or y
         
               else{//Start bracket for n input
         
                  System.out.println("Thank you for using this program!");
                  bProgramDone = true;
                  bAllDone[MOREEMPLOYEESINDEX] = true;
        
               }//End bracket for n input
        
            }//End bracket for try statement
            
            catch(InputMismatchException ime){//Start bracket for catch statement
        
               System.out.println("That is not a valid input. Please try again");   
        
            }//End bracket for catch statement
        
         } //End bracket for while loop checking to see if if input for more employees was given
      
      }//End bracket for while loop iterating through entire program
   
   }//End bracket for main function

}//End bracket for Wages class