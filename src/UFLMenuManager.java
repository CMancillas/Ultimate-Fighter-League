import java.util.Scanner;
import java.util.List;

import models.Division;
import models.Fighter;
import models.Match;
import services.DivisionManager;
import services.MatchService;

public class UFLMenuManager{
    
    DivisionManager divisionManager;
    String[] divisions;
    Scanner scanner;    
    
    public UFLMenuManager()
    {
        divisionManager = new DivisionManager();
        divisions = divisionManager.getDivisionsNames();
        scanner = new Scanner(System.in);
    }
    
    public void menu()
    {
        System.out.println("=".repeat(50));
        System.out.println("        🥋 Ultimate Fighter League 🥋 " );
        System.out.println("=".repeat(50));
        System.out.println();
        System.out.println("1️⃣   View All Divisions");
        System.out.println("2️⃣   View Fighters in a Division");
        System.out.println("3️⃣   Simulate a Single Match");
        System.out.println("4️⃣   Create and Run a Tournament");
        System.out.println("5️⃣   Exit");
        System.out.println();
        System.out.println("=".repeat(50));
    }

    public void viewAllDivisions()
    {
        divisionManager.printAllDivisons();
    }

    public void viewADivision()
    {
        
        int option = 0;

        System.out.println("=".repeat(50));
        System.out.println("    🔍 VIEW FIGHTERS IN A DIVISION");
        System.out.println("=".repeat(50));
        System.out.println();
        System.out.println("Select a division: ");
        System.out.println();

        printDivisions();
 
        while (option < 1 || option > 13)
        {
            System.out.print("Enter a division number: ");
            option = scanner.nextInt();
        }

        Division division = new Division(divisions[option - 1], divisionManager.getDivisionRankings(option));
        division.printDivision();
    }

    public void simulateAMatch()
    {
        int option = 0;

        System.out.println("=".repeat(50));
        System.out.println("    👊 Simulate a Single Match");
        System.out.println("=".repeat(50));
        System.out.println();
        System.out.println("📋 Select a Division to choose fighters from:");
        System.out.println();

        printDivisions();

        while (option < 1 || option > 13)
        {
            System.out.print("Enter a division number: ");
            option = scanner.nextInt();
        }

        Division division = new Division(divisions[option - 1], divisionManager.getDivisionRankings(option));
        division.printDivision();
        option = -1;

        List<Fighter> fighters = division.getFighters();

        while ( option < 0 || option > 15) 
        {
            System.out.println("Enter first fighter’s ranking (1-15 or 0 for Champion): ");        
            option = scanner.nextInt();
        }

        Fighter f1 = fighters.get(option);
        int option2 = option;
        option = -1;

        while ( (option < 0 || option > 15) && option != option2) 
        {
            System.out.println("Enter second fighter’s ranking (1-15 or 0 for Champion): ");        
            option = scanner.nextInt();
        }

        Fighter f2 = fighters.get(option);

        matchSimulation(f1, f2);
    }

    private void matchSimulation(Fighter f1, Fighter f2)
    {
        Main.clearScreen();

        System.out.println("=".repeat(50));
        System.out.println("           🔥 Match Simulation");
        System.out.println("=".repeat(50));
        System.out.println();
        System.out.printf("🥊 %s vs %s\n", f1.getFullName(), f2.getFullName());
        System.out.println();
        System.out.println("Simulating match...");
        System.out.println(".");
        System.out.println("..");
        System.out.println("...");
        System.out.println();

        MatchService matchService = new MatchService();
        Match match = matchService.simulateMatch(f1, f2);

        System.out.printf("🏆 Winner: %s\n", match.getWinner().getFullName());

    }

    private void printDivisions()
    {
        for(int i = 0; i < divisions.length; i++)
            System.out.printf("%d. %s\n", i + 1, divisions[i]);
        
        System.out.println();
    }

}
    
