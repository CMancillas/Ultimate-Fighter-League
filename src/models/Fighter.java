package models;

import java.time.LocalDate;

public class Fighter {
    private String name;
    private String nickname;
    private int wins;
    private int losses;
    private int draws;
    private double heightCm;
    private double weightKg;
    private double reachCm;
    private String stance;
    private LocalDate birthDate;
    private StrikingStats strikingStats;
    private GrapplingStats grapplingStats;

    // Constructors
    public Fighter()
    {
        this.strikingStats = new StrikingStats();
        this.grapplingStats = new GrapplingStats();
    }

    public Fighter( String name, String nickname, int wins, int losses,
                    int draws, double heightCm, double weightKg,
                    double reachCm, String stance, LocalDate birthDate,
                    StrikingStats strikingStats, GrapplingStats grapplingStats )
    {
        this.name = name;
        this.nickname = nickname;
        this.wins = wins;
        this.losses = losses;
        this.draws = draws;
        this.heightCm = heightCm;
        this.weightKg = weightKg;
        this.reachCm = reachCm;
        this.stance = stance;
        this.birthDate = birthDate;
        this.strikingStats = strikingStats;
        this.grapplingStats = grapplingStats;
    }

    // constructor for test purposes
    public Fighter( String name, String nickname, int wins, int losses, int draws )
    {
        this.name = name;
        this.nickname = nickname;
        this.wins = wins;
        this.losses = losses;
        this.draws = draws;
        this.strikingStats = new StrikingStats();
        this.grapplingStats = new GrapplingStats();
    }

    // Getters and Setters
    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getNickname()
    {
        return nickname;
    }

    public void setNickname( String nickname )
    {
        this.nickname = nickname;
    }

    public int getWins()
    {
        return wins;
    }

    public void setWins( int wins )
    {
        this.wins = wins;
    }

    public int getLosses()
    {
        return losses;
    }

    public void setLosses( int losses )
    {
        this.losses = losses;
    }


    public int getDraws()
    {
        return draws;
    }

    public void setDraws( int draws )
    {
        this.draws = draws;
    }

    public double getHeightCm()
    {
        return heightCm;
    }

    public void setHeightCm( double heightCm )
    {
        this.heightCm = heightCm;
    }
    public double getWeightKg()
    {
        return weightKg;
    }

    public void setWeightKg( double weightKg )
    {
        this.weightKg = weightKg;
    }

    public double getReachCm()
    {
        return reachCm;
    }

    public void setReachCm( double reachCm )
    {
        this.reachCm = reachCm;
    }

    public String getStance()
    {
        return stance;
    }

    public void setStance( String stance )
    {
        this.stance = stance;
    }

    public LocalDate getBirthDate()
    {
        return birthDate;
    }

    public void setBirthDate( LocalDate birthDate )
    {
        this.birthDate = birthDate;
    }

    public StrikingStats getStrikingStats()
    {
        return strikingStats;
    }

    public void setStrikingStats( StrikingStats strikingStats )
    {
        this.strikingStats = strikingStats;
    }

    public GrapplingStats getGrapplingStats()
    {
        return grapplingStats;
    }

    public void setGrapplingStats( GrapplingStats grapplingStats )
    {
        this.grapplingStats = grapplingStats;
    }

    public String getFullName()
    {
        if ( nickname == null || nickname.isBlank() )
            return name;
        
        return name + " AKA \"" + nickname + "\""; 
    }

    @Override
    public String toString()
    {
        return "Fighter {" +
                "name='" + name + '\'' +
                ", nickname='" + nickname + '\'' + 
                ", wins=" + wins + 
                ", losses=" + losses +
                ", draws=" + draws +
                ", heightCm=" + heightCm +
                ", weightKg=" + weightKg + 
                ", reachCm=" + reachCm +
                ", stance='"+ stance + '\'' +
                ", birthDate=" + birthDate +
                ", strikingStats=" + strikingStats +
                ", grapplingStats=" + grapplingStats +
                '}';
    }
}