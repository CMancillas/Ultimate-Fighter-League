package services;

import java.util.List;
import java.util.Scanner;
import java.util.Collections;
import java.util.LinkedList;

import models.Fighter;
import models.Tournament;
import models.Match;

public class TournamentService {
    private MatchService matchService = new MatchService();

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
            System.out.println("Select an option: ");
            System.out.println("1.-Shuffle fighters.");
            System.out.println("2.- Keep figters in order.");
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
                winners.add(match.getWinner());
            }
        }

        return runTournament( new Tournament(winners) );
    } 
    
    public void printTournamentFighters( List<Fighter> fighters)
    {
        for( int i = 0; i < fighters.size(); i++)
        {
            System.out.println("Fighter: " + fighters.get(i).getFullName());
        }
    }

}
