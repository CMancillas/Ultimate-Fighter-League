package services;

import java.util.List;
import java.util.Scanner;
import java.util.Collections;
import java.util.LinkedList;

import models.Fighter;
import models.Tournament;
import models.Match;

public class TournamentService {
    private MatchService matchService;
    private List<List<Match>> rounds;

    public TournamentService()
    {
        matchService = new MatchService();
        rounds = new LinkedList<>();
    }
    
    public List<List<Match>> getRounds()
    {
        return rounds;
    }
    
    public Tournament createTournament(List<Fighter> fighters)
    {   
        // Validate size (4,8,16)
        if ( fighters.size() != 4 && fighters.size() != 8 && fighters.size() != 16 )
        {
            System.out.println("A Tournament needs to have 4, 8 or 16 participants.");
            return null;
        }

        Scanner scanner = new Scanner( System.in );
        int answer = 0;
        

        while ( answer != 1 && answer != 2 )
        {
            System.out.println("🔀 Do you want to shuffle the fighters? ");
            System.out.println("1.-Yes");
            System.out.println("2.- No");
            System.out.print("Your option: ");
            answer = scanner.nextInt();
        }   

        if ( answer == 1 )
            Collections.shuffle(fighters);

        //Create and return Tournament
        return new Tournament(fighters);
    }

    public Fighter runTournament(Tournament tournament)
    {
        // Simulate matches in rounds until one winner remains
        List<Fighter> fighters = tournament.getFighters();
        List<Fighter> winners = new LinkedList<Fighter>();
        List<Match> rounds = new LinkedList<>();
        
        if ( fighters.size() == 1 )
        {
            Fighter winner = fighters.get(0);
            tournament.setWinner(winner); // set winner in the tournament object
            return winner;
        }
        else
        {
            
            for ( int i = 0; i < fighters.size(); i += 2)
            {
                Match match = matchService.simulateMatch( fighters.get(i), fighters.get(i + 1));
                rounds.add(match);
                winners.add(match.getWinner());
            }
        }

        this.rounds.add(rounds);

        return runTournament( new Tournament(winners) );
    } 
    
    public void printTournamentFighters( List<Fighter> fighters)
    {
        for( int i = 0; i < fighters.size(); i++)
        {
            System.out.println("Fighter: " + fighters.get(i).getFullName());
        }
    }

    public void printTournament(Tournament tournament)
    {
        List<List<Match>> rounds = tournament.getRounds();
        String f1 = "", f2 = "", winner = "";
        System.out.println("========================================");
        System.out.println("        🏆 Tournament Bracket");
        System.out.println("========================================");

        for ( int i = 0; i < rounds.size(); i++)
        {
            System.out.println();

            if ( i == rounds.size() - 1)
                System.out.printf("Final: \n" );
            else
                System.out.printf("Round %d: \n", i + 1 );
            
            for (int j = 0; j < rounds.get(i).size(); j++)
            {
                f1 = rounds.get(i).get(j).getFighterA().getName();
                f2 = rounds.get(i).get(j).getFighterB().getName();
                winner = rounds.get(i).get(j).getWinner().getFullName(); 
                System.out.printf("🥊 %s vs %s → Winner: %s\n", f1, f2, winner);
            }
        }

        System.out.println();
        System.out.printf("🎉 Tournament Winner: %s\n", winner );
        System.out.println();
    }

}
