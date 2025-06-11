package models;

public class GrapplingStats {
    private double takedownsPer15Min;
    private double takedownAccuracy;
    private double takedownDefense;
    private double submissionsPer15Min;

    // Constructors
    public GrapplingStats()
    {
        this.takedownsPer15Min = 0.0;
        this.takedownAccuracy = 0.0;
        this.takedownDefense = 0.0;
        this.submissionsPer15Min = 0.0;
    }

    public GrapplingStats( double takedownsPer15Min, double takedownAccuracy,
                            double takedownDefense, double submissionsPer15Min )
    {
        this.takedownsPer15Min = takedownsPer15Min;
        this.takedownAccuracy = takedownAccuracy;
        this.takedownDefense = takedownDefense;
        this.submissionsPer15Min = submissionsPer15Min;
    }

    // Getters and Setters
    public double getTakedownsPer15Min()
    {
        return takedownsPer15Min;
    }

    public void setTakedownsPer15Min( double takedownsPer15Min )
    {
        this.takedownsPer15Min = takedownsPer15Min;
    }

    public double getTakedownAccuracy()
    {
        return takedownAccuracy;
    }

    public void setTakedownAccuracy( double takedownAccuracy )
    {
        this.takedownAccuracy = takedownAccuracy;
    }

    public double getTakedownDefense()
    {
        return takedownDefense;
    }

    public void setTakedownDefense( double takedownDefense )
    {
        this.takedownDefense = takedownDefense;
    }

    public double getSubmissionsPer15Min()
    {
        return submissionsPer15Min;
    }

    public void setSubmissionsPer15Min( double submissionsPer15Min )
    {
        this.submissionsPer15Min = submissionsPer15Min;
    }

    @Override
    public String toString()
    {
        return "GrapplingStats {" + 
                "takedownsPer15Min=" + takedownsPer15Min + 
                ", takedownAccuracy=" + takedownAccuracy + "%" +
                ", takedownDefense=" + takedownDefense + "%" + 
                ", submissionsPer15Min=" + submissionsPer15Min + 
                '}';
    }
}
