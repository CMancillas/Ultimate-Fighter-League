package utils;
import java.time.LocalDate;

import models.Fighter;
import models.GrapplingStats;
import models.StrikingStats;


public class FighterParser {
    public Fighter parseFromCSVRow(String[] row)
    {   
        String name = row[0];
        String nickname = row[1];
        int wins = Integer.parseInt(row[2]); 
        int losses = Integer.parseInt(row[3]);
        int draws = Integer.parseInt(row[4]);
        double heightCm = Double.parseDouble(row[5]);
        double weightKg = Double.parseDouble(row[6]);
        double reachCm = Double.parseDouble(row[7]);
        String stance = row[8];
        LocalDate birthDate = LocalDate.parse(row[9]);
        StrikingStats strikingStats = parseStrikingStats(row);
        GrapplingStats grapplingStats = parseGrapplingStats(row);
        
        return new Fighter(name, nickname, wins, losses, draws, heightCm, weightKg, reachCm, stance, birthDate, strikingStats, grapplingStats);
    }

    public StrikingStats parseStrikingStats(String[] row)
    {
        double strikesLandedPerMin = Double.parseDouble(row[10]);
        double strikingAccuracy = Double.parseDouble(row[11]);
        double strikesAbsorbedPerMin = Double.parseDouble(row[12]);
        double strikeDefense = Double.parseDouble(row[13]);
        
        return new StrikingStats(strikesLandedPerMin,strikingAccuracy,strikesAbsorbedPerMin, strikeDefense);
    }

    public GrapplingStats parseGrapplingStats(String[] row)
    {
        double takedownsPer15Min = Double.parseDouble(row[14]);
        double takedownAccuracy = Double.parseDouble(row[15]);
        double takedownDefense = Double.parseDouble(row[16]);
        double submissionsPer15Min = Double.parseDouble(row[17]);
        
        return new GrapplingStats(takedownsPer15Min, takedownAccuracy, takedownDefense, submissionsPer15Min);
    }  
}