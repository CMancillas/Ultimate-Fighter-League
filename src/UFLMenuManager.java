import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.time.LocalDate;

import models.Division;
import models.Fighter;
import models.Match;
import models.Tournament;
import services.DivisionManager;
import services.MatchService;
import services.TournamentService;

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
        System.out.println("5️⃣   View Fighter Details");
        System.out.println("6️⃣   Exit");
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
            System.out.println("Enter first fighter (1-15 or 0 for Champion): ");        
            option = scanner.nextInt();
        }

        Fighter f1 = fighters.get(option);
        int option2 = option;
        option = -1;

        while ( (option < 0 || option > 15) || option == option2) 
        {
            System.out.println("Enter second fighter (1-15 or 0 for Champion): ");        
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
        System.out.println(
        );
    }

    public void runTournament()
    {

        int option = 0;

        System.out.println("=".repeat(50));
        System.out.println("        🎯 Create and Run a Tournament");
        System.out.println("=".repeat(50));
        System.out.println();
        System.out.println("📋 Select a Division to create a tournament:");
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
        
        while (option != 4 && option != 8 && option != 16) 
        {
            System.out.print("✅ How many participants? (4, 8, or 16): " );
            option = scanner.nextInt();
        }

        int tournament_size = option;

        List<Fighter> fightersInTournament = selectTournamentFighters(tournament_size, division);
        
        TournamentService tournamentService = new TournamentService();
        Tournament tournament = tournamentService.createTournament(fightersInTournament);
        tournament.setWinner(tournamentService.runTournament(tournament));
        tournament.setRounds(tournamentService.getRounds());
        tournamentService.printTournament(tournament);
        

    }

    private List<Fighter> selectTournamentFighters(int tournament_size, Division division)
    {
        List<Fighter> divisionFighters = division.getFighters();
        List<Integer> fightersInTournament = new LinkedList<>();
        List<Fighter> fighters = new LinkedList<>();
        
        int option = -1;

        String[] places = { "first", "second", "third", "fourth", "fifth", "sixth",
                            "seventh", "eighth", "ninth", "tenth", "eleventh", "twelfth",
                            "thirteenth", "fourteenth", "fifteenth", "sixteenth"};


        for ( int i = 0; i < tournament_size; i++)
        {
            while ( option < 0 || option > 15 || fightersInTournament.contains(option)) 
            {
                System.out.printf("Enter %s fighter (1-15 or 0 for Champion): ", places[i]);        
                option = scanner.nextInt();
            }

            fightersInTournament.add(option);
            fighters.add( divisionFighters.get(option));
            option = -1;
        }
        
        return fighters;
    }

    private void printDivisions()
    {
        for(int i = 0; i < divisions.length; i++)
            System.out.printf("%d. %s\n", i + 1, divisions[i]);
        
        System.out.println();
    }

    public void printFighterDetails()
    {
        int option = 0;
        System.out.println("========================================");
        System.out.println("        🔍 View Fighter Details");
        System.out.println("========================================");
        System.out.println();
        System.out.println("📋 Select a Division to choose fighter from:");
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
            System.out.println("Enter fighter (1-15 or 0 for Champion): ");        
            option = scanner.nextInt();
        }

        Fighter f1 = fighters.get(option);
        Main.clearScreen();

        System.out.println("========================================");
        System.out.println("        🧾 Fighter Details");
        System.out.println("========================================");
        System.out.println();
                
        System.out.printf("Name: %s\n", f1.getFullName());
        System.out.printf("Division: %s\n", division.getName());
        System.out.printf("Height: %s\n", convertHeight(f1.getHeightCm()));
        System.out.printf("Weight: %s\n", convertWeight(f1.getWeightKg()));
        System.out.printf("Reach: %s\n", convertReach(f1.getReachCm()));
        System.out.printf("Stance: %s\n", f1.getStance());
        System.out.printf("DOB: %s\n", convertDOB(f1.getBirthDate()));
        System.out.println();
        
        System.out.printf("🏅 Stats:\n");
        System.out.printf("Significant Strikes Landed per Minute: %.2f\n", f1.getStrikingStats().getStrikesLandedPerMin());
        System.out.printf("Striking Accuracy: %.2f\n", f1.getStrikingStats().getStrikingAccuracy());
        System.out.printf("Significant Strikes Absorbed per Min: %.2f\n", f1.getStrikingStats().getStrikesAbsorbedPerMin());
        System.out.printf("Striking Defense: %.2f\n", f1.getStrikingStats().getStrikeDefense());
        
        System.out.printf("Takedown Avg per 15 Min: %.2f\n", f1.getGrapplingStats().getTakedownsPer15Min());
        System.out.printf("Takedown Accuracy: %.2f\n", f1.getGrapplingStats().getTakedownAccuracy());
        System.out.printf("Takedown Defense: %.2f\n", f1.getGrapplingStats().getTakedownDefense());
        System.out.printf("Submission Avg per 15 Min: %.2f\n", f1.getGrapplingStats().getSubmissionsPer15Min());
        
        System.out.println();
        System.out.printf("Record: %d-%d-%d\n", f1.getWins(), f1.getLosses(), f1.getDraws());
        System.out.println();        
    }

    private String convertHeight(double heightCm)
    {
        double totalInches = heightCm / 2.54;
        int feet = (int) (totalInches / 12);
        int inches = (int) Math.round(totalInches - (feet * 12));
        return String.format("%d'%d\"", feet, inches);
    }
    
    private String convertWeight(double weightKg)
    {
        int pounds = (int) Math.round( weightKg * 2.20462);

        return String.format("%d lbs", pounds);
    }

    private String convertReach(double reachCm)
    {
        int reach = (int) Math.round( 180/ 2.54);

        return String.format("%d\"", reach);
    }

    private String convertDOB( LocalDate localDate)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        return localDate.format(formatter);
    }

}
    
