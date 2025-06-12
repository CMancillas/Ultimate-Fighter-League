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
        int wins = (int) (numberCleaner(row[2]));
        int losses = (int) (numberCleaner(row[3]));
        int draws = (int) (numberCleaner(row[4]));
        double heightCm = numberCleaner(row[5]);
        double weightKg = numberCleaner(row[6]);
        double reachCm = numberCleaner(row[7]);
        String stance = row[8];
        LocalDate birthDate = dateCleaner(row[9]);
        StrikingStats strikingStats = parseStrikingStats(row);
        GrapplingStats grapplingStats = parseGrapplingStats(row);
        
        return new Fighter(name, nickname, wins, losses, draws, heightCm, weightKg, reachCm, stance, birthDate, strikingStats, grapplingStats);
    }

    public StrikingStats parseStrikingStats(String[] row)
    {
        double strikesLandedPerMin = numberCleaner(row[10]);
        double strikingAccuracy = numberCleaner(row[11]);
        double strikesAbsorbedPerMin = numberCleaner(row[12]);
        double strikeDefense = numberCleaner(row[13]);
        
        return new StrikingStats(strikesLandedPerMin,strikingAccuracy,strikesAbsorbedPerMin, strikeDefense);
    }

    public GrapplingStats parseGrapplingStats(String[] row)
    {
        double takedownsPer15Min = numberCleaner(row[14]);
        double takedownAccuracy = numberCleaner(row[15]);
        double takedownDefense = numberCleaner(row[16]);
        double submissionsPer15Min = numberCleaner(row[17]);
        
        return new GrapplingStats(takedownsPer15Min, takedownAccuracy, takedownDefense, submissionsPer15Min);
    }
    
    private double numberCleaner(String value)
    {
        //value = stringCleaner(value);

        if (value.equals("") || value.equals(" "))
            value = "0.0";
        
        return Double.parseDouble(value);
    }

    private LocalDate dateCleaner(String value)
    {
        //value = stringCleaner(value);

        if (value.equals("") || value.equals(" "))
            value = "0000-01-01";
        
        return LocalDate.parse(value);
    }
}