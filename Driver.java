/*
 * Class: CMSC203 
 * Instructor: Pingwei-Tsai
 * Description: This application generates a random integer between 1 and 100 and asks the user to guess repeatedly  until they guess correctly
 * Due: 09/27/2022
 * Platform/compiler: Eclipse/Java
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Kim Ngan Mai
*/

import java.util.Scanner;

class Driver {

	public static void main(String[] args) {
		// Declaring variables
		int userGuess=0,lowGuess=0,highGuess=0;
		boolean bool=false;
		String choice=null;
		/*
		 * Creating an Scanner class object which is used to get the inputs
		 * entered by the user
		 */
		Scanner sc = new Scanner(System.in);
		

		   /* This while loop continues to execute 
		    * until the user enters either 'No' or 'no'
		    */
		while(true)
		{
			lowGuess=1;
			highGuess=100;
			int randomNo = RNG.rand();
			System.out.println("This application generates a random integer between 1 and 100");
			System.out.println(" and asks the user to guess repeatedly  until they guess correctly.");
			System.out.println("\nEnter the first guess:");
			userGuess=sc.nextInt();
			
				if(userGuess==randomNo)
				{
					System.out.println("Congratulations, you guessed correctly");
				}
				else
				{
					
						while(true)
						{
							do
							{
								bool=RNG.inputValidation(userGuess,lowGuess,highGuess);
								if(bool)
								{
									break;
								}
								userGuess=sc.nextInt();
							}while(!bool);
							
							if(userGuess<randomNo)
							{
								lowGuess=userGuess+1;
								System.out.println("Your guess is too low");
							}
							else if(userGuess>randomNo)
							{
								highGuess=userGuess;
								System.out.println("Your guess is too high");
							}
							else
							{
								System.out.println("Congratulations, you guessed correctly");
								break;
							}
							if(RNG.getCount()==7)
							{
								System.out.println("You have exceeded the maximum number of guesses, "+RNG.getCount()+". Try again");
								System.exit(0);
							}
							System.out.println("Number of guesses is: "+RNG.getCount());
							System.out.println("Enter your next guess between "+lowGuess+" and "+highGuess);
							userGuess=sc.nextInt();
						}
				
				
				}
			System.out.println("Try again? (yes or no)");
			sc.nextLine();
			choice=sc.nextLine();
			if(choice.equalsIgnoreCase("no"))
			{
				System.out.println("Thanks for playing...\nProgrammer name: Kim Ngan Mai");
				break;
			}
			else
			{
				RNG.resetCount();
			}
		    
		}
	}

}
