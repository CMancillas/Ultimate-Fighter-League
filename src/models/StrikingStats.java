package models;

public class StrikingStats {
    private double strikesLandedPerMin;
    private double strikingAccuracy;
    private double strikesAbsorbedPerMin;
    private double strikeDefense;

    // Cosntructors
    public StrikingStats()
    {
        this.strikesLandedPerMin = 0.0;
        this.strikingAccuracy = 0.0;
        this.strikesAbsorbedPerMin = 0.0;
        this.strikeDefense = 0.0;
    }

    public StrikingStats( double strikesLandedPerMin, double strikingAccuracy,
                            double strikesAbsorbedPerMin, double strikeDefense )
    {
        this.strikesLandedPerMin = strikesLandedPerMin;
        this.strikingAccuracy = strikingAccuracy;
        this.strikesAbsorbedPerMin = strikesAbsorbedPerMin;
        this.strikeDefense = strikeDefense;
    }

    // Getters and Setters
    public double getStrikesLandedPerMin()
    {
        return strikesLandedPerMin;
    }

    public void setStrikesLandedPerMin( double strikesLandedPerMin )
    {
        this.strikesLandedPerMin = strikesLandedPerMin;
    }

    public double getStrikingAccuracy()
    {
        return strikingAccuracy;
    }

    public void setStrikingAccuracy( double strikingAccuracy )
    {
        this.strikingAccuracy = strikingAccuracy;
    }

    public double getStrikesAbsorbedPerMin()
    {
        return strikesAbsorbedPerMin;
    }

    public void setStrikesAbsorbedPerMin( double strikesAbsorbedPerMin )
    {
        this.strikesAbsorbedPerMin = strikesAbsorbedPerMin;
    }

    public double getStrikeDefense()
    {
        return strikeDefense;
    }

    public void setStrikeDefense( double strikeDefense )
    {
        this.strikeDefense = strikeDefense;
    }

    @Override
    public String toString()
    {
        return "StrikingStats {" + 
            "strikesLandedPerMin=" + strikesLandedPerMin +
            ", strikingAccuracy=" + strikingAccuracy + "%" +
            ", strikesAbsorbedPerMin=" + strikesAbsorbedPerMin + 
            ", strikeDefense=" + strikeDefense + "%" + 
            '}';
    }
}
