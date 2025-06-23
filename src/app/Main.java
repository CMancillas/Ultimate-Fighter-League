package app;
import services.UFLMenuManager;
import java.util.Scanner;

public class Main {
    public static void main(String[] args )
    {
        /*
         * Display a menu.
             Let the user pick a division.
             Let the user select fighters for a tournament.
            Optionally shuffle or keep the order.
            Simulate the tournament and print results.
         */
        //Display a menu.
        UFLMenuManager ufl = new UFLMenuManager();
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        boolean loop = true;
        
        while (loop)
        {
            ufl.menu();
            while (option != 1 && option != 2 && option != 3 && option != 4 && option != 5 && option != 6)
            {
                System.out.print("Please select an option (1-6): ");
                option = scanner.nextInt();
                scanner.nextLine();
            }
            System.out.println();    
            clearScreen();

            switch (option) 
            {
                case 1:
                    System.out.println();
                    ufl.viewAllDivisions();   
                    break;
                case 2:
                    System.out.println();
                    ufl.viewADivision();
                    break;
                case 3:
                    ufl.simulateAMatch();
                    break;
                case 4:
                    ufl.runTournament();
                    break;
                case 5:
                    ufl.printFighterDetails();
                    break;
                case 6:
                    loop = false;
                    System.out.println("Thank you!");
                    break;
            
                default:
                    break;
            }
            
            if (option == 6)
                break;
            
            option = 0;
            System.out.println("(Press Enter to return to main menu)");
            scanner.nextLine();
            clearScreen();
        }
    }
    

    public static void clearScreen()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
