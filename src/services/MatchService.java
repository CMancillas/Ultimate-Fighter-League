package services;
import models.Match;
import models.StrikingStats;
import models.Fighter;
import models.GrapplingStats;

public class MatchService {
    public Match simulateMatch( Fighter f1, Fighter f2)
    {
        Match match = new Match(f1,f2);

        double winRateF1 = weightedStrikingStats(f1.getStrikingStats()) + weightedGrapplingStats(f1.getGrapplingStats());
        double winRateF2 = weightedStrikingStats(f2.getStrikingStats()) + weightedGrapplingStats(f2.getGrapplingStats());
        
        // Adding randomness to make fights a little unpredictable (Upset Factor)
        winRateF1 += Math.random();
        winRateF2 += Math.random();
    
        Fighter winner = winRateF1 > winRateF2 ? f1 : f2;

        match.setWinner(winner);

        return match;
    }   

    // Methods to add weight to each striking and grappling variable to determine importantness on each stat for the fight's outcome
    private double weightedStrikingStats( StrikingStats strikingStats )
    {
        double total = strikingStats.getStrikesLandedPerMin() * 0.20 + // Agression
                        strikingStats.getStrikingAccuracy() * 0.15 + // Precision
                        (strikingStats.getStrikesLandedPerMin() / 2 - strikingStats.getStrikesAbsorbedPerMin()) * 0.10 + // Defense
                        strikingStats.getStrikeDefense() * 0.10; // Defense
        
        return total;
    }

    private double weightedGrapplingStats( GrapplingStats grapplingStats )
    {
        double total = grapplingStats.getTakedownsPer15Min() * 0.15 + // Grappling offense
                        grapplingStats.getTakedownAccuracy() * 0.10 + // Grappling technique
                        grapplingStats.getTakedownDefense() * 0.10 +  // Grappling defense
                        grapplingStats.getSubmissionsPer15Min() * 0.10; // Submission threat
        
        return total;
    }
}
