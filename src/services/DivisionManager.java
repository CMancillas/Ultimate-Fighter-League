package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import models.Fighter;
import utils.DataLoader;

public class DivisionManager {
    private HashMap<String, HashMap<Integer, Fighter>> divisions;
    DataLoader data;
    List<Fighter> fighters;

    // Constructor
    public DivisionManager()
    {
        this.divisions = new HashMap<>();
        data = new DataLoader("data/ufc-fighters-statistics.csv");
        fighters = new ArrayList<>(data.loadFighter());
        initializeDivisons();
    }

    private void initializeDivisons()
    {
        divisions.put("Flyweight", getMenFlyweight());
        divisions.put("Bantamweight",getMenBantamweight());
        divisions.put("Featherweight", getMenFeatherweight());
        divisions.put("Lightweight", getLightweight());
        divisions.put("Welterweight", getWelterweight());
        divisions.put("Middleweight", getMiddleweight());
        divisions.put("Light Heavyweight", getLightHeavyweightweight());
        divisions.put("Heavyweight", getHeavyweight());
        divisions.put("Women's Strawweight", getStrawweight());
        divisions.put("Women's Flyweight", getWomensFlyweight());
        divisions.put("Women's Bantamweight", getWomensBantamweight());
        divisions.put("Men's Pound For Pound", getMenPoundForPound());
        divisions.put("Women's Pound For Pound", getWomenPoundForPound());
    }

    // Getter and Setter
    public HashMap<String, HashMap<Integer, Fighter>> getDivisions()
    {  
        return divisions;
    }

    public void setDivisons(HashMap<String, HashMap<Integer, Fighter>> divisions)
    {
        this.divisions = divisions;
    }
    
    public String[] getDivisionsNames()
    {
        return new String[] {"Flyweight",
        "Bantamweight",
        "Featherweight",
        "Lightweight",
        "Welterweight",
        "Middleweight",
        "Light Heavyweight",
        "Heavyweight",
        "Women's Strawweight",
        "Women's Flyweight",
        "Women's Bantamweight",
        "Men's Pound For Pound",
        "Women's Pound For Pound"};
    } 

    public void printAllDivisons() {
    String[] divisionNames = getDivisionsNames();

    for (int i = 0; i < divisionNames.length; i++) {
        String title = divisionNames[i];
        LinkedList<Fighter> division = getDivisionRankings(i + 1);

        System.out.println("=".repeat(50));
        if (i == divisionNames.length - 1 || i == divisionNames.length - 2)
            System.out.printf("🥊 %-40s 🥊\n", title);
        else
            System.out.printf(" %-40s \n", title);
        System.out.println("=".repeat(50));

        for (int j = 0; j < division.size(); j++) {
            Fighter f = division.get(j);
            
            if ( i != divisionNames.length - 1 && i != divisionNames.length - 2)
            {   if (j == 0)
                    System.out.printf("%2s. %-30s🏆\n","C", f.getFullName());
                else
                    System.out.printf("%2d. %-30s\n", j, f.getFullName());
            }
            else
                System.out.printf("%2d. %-30s\n", j + 1, f.getFullName());

        }

        System.out.println(); 
    }
}

    public LinkedList<Fighter> getDivisionRankings(int ranking)
    {
        switch (ranking) {
            case 1:
                return new LinkedList<>(divisions.get("Flyweight").values());
            case 2:
                return new LinkedList<>(divisions.get("Bantamweight").values());
            case 3:
                return new LinkedList<>(divisions.get("Featherweight").values());
            case 4:
                return new LinkedList<>(divisions.get("Lightweight").values());
            case 5:
                return new LinkedList<>(divisions.get("Welterweight").values());
            case 6:
                return new LinkedList<>(divisions.get("Middleweight").values());
            case 7:
                return new LinkedList<>(divisions.get("Light Heavyweight").values());
            case 8:
                return new LinkedList<>(divisions.get("Heavyweight").values());
            case 9:
                return new LinkedList<>(divisions.get("Women's Strawweight").values());
            case 10:
                return new LinkedList<>(divisions.get("Women's Flyweight").values());
            case 11:
                return new LinkedList<>(divisions.get("Women's Bantamweight").values());
            case 12:
                return new LinkedList<>(divisions.get("Men's Pound For Pound").values());
            case 13:
                return new LinkedList<>(divisions.get("Women's Pound For Pound").values());
            default:
                System.out.println("There's no such existing ranking.");
                return new LinkedList<>();
        }
    }

    
    private HashMap<Integer, Fighter> getMenFlyweight()
    {

        HashMap<Integer, Fighter> menFlyweight = new HashMap<>();

        menFlyweight.put(1, fighters.get(797));
        menFlyweight.put(2, fighters.get(242));
        menFlyweight.put(3, fighters.get(1225));
        menFlyweight.put(4, fighters.get(1023));
        menFlyweight.put(5, fighters.get(3082));
        menFlyweight.put(6, fighters.get(171));
        menFlyweight.put(7, fighters.get(1351));
        menFlyweight.put(8, fighters.get(542));
        menFlyweight.put(9, fighters.get(122));
        menFlyweight.put(10, fighters.get(685));
        menFlyweight.put(11, fighters.get(697));
        menFlyweight.put(12, fighters.get(2121));
        menFlyweight.put(13, fighters.get(813));
        menFlyweight.put(14, fighters.get(4112));
        menFlyweight.put(15, fighters.get(1478));
        menFlyweight.put(16, fighters.get(4113));

        return menFlyweight;
    } 

    private HashMap<Integer, Fighter> getMenBantamweight()
    {
        HashMap<Integer, Fighter> menBantamweight = new HashMap<>();

        menBantamweight.put(1, fighters.get(1466));
        menBantamweight.put(2, fighters.get(1427));
        menBantamweight.put(3, fighters.get(851));
        menBantamweight.put(4, fighters.get(1770));
        menBantamweight.put(5, fighters.get(1574));
        menBantamweight.put(6, fighters.get(1693));
        menBantamweight.put(7, fighters.get(430));
        menBantamweight.put(8, fighters.get(860));
        menBantamweight.put(9, fighters.get(1485));
        menBantamweight.put(10, fighters.get(525));
        menBantamweight.put(11, fighters.get(4111));
        menBantamweight.put(12, fighters.get(3025));
        menBantamweight.put(13, fighters.get(1120));
        menBantamweight.put(14, fighters.get(442));
        menBantamweight.put(15, fighters.get(1459));
        menBantamweight.put(16, fighters.get(3858));

        return menBantamweight;
    } 

    private HashMap<Integer, Fighter> getMenFeatherweight()
    {
        HashMap<Integer, Fighter> menFeatherweight = new HashMap<>();

        menFeatherweight.put(1, fighters.get(1686));
        menFeatherweight.put(2, fighters.get(1529));
        menFeatherweight.put(3, fighters.get(62));
        menFeatherweight.put(4, fighters.get(472));
        menFeatherweight.put(5, fighters.get(1596));
        menFeatherweight.put(6, fighters.get(997));
        menFeatherweight.put(7, fighters.get(1522));
        menFeatherweight.put(8, fighters.get(573));
        menFeatherweight.put(9, fighters.get(812));
        menFeatherweight.put(10, fighters.get(918));
        menFeatherweight.put(11, fighters.get(1750));
        menFeatherweight.put(12, fighters.get(1829));
        menFeatherweight.put(13, fighters.get(652));
        menFeatherweight.put(14, fighters.get(1513));
        menFeatherweight.put(15, fighters.get(1577));
        menFeatherweight.put(16, fighters.get(1748));

        return menFeatherweight;
    }

    private HashMap<Integer, Fighter> getLightweight()
    {
        HashMap<Integer, Fighter> lightweight = new HashMap<>();

        lightweight.put(1, fighters.get(762));
        lightweight.put(2, fighters.get(3478));
        lightweight.put(3, fighters.get(188));
        lightweight.put(4, fighters.get(3335));
        lightweight.put(5, fighters.get(1529));
        lightweight.put(6, fighters.get(617));
        lightweight.put(7, fighters.get(1453));
        lightweight.put(8, fighters.get(1705));
        lightweight.put(9, fighters.get(230));
        lightweight.put(10, fighters.get(818));
        lightweight.put(11, fighters.get(987));
        lightweight.put(12, fighters.get(3215));
        lightweight.put(13, fighters.get(827));
        lightweight.put(14, fighters.get(517));
        lightweight.put(15, fighters.get(483));
        lightweight.put(16, fighters.get(548));

        return lightweight;
    }

    private HashMap<Integer, Fighter> getWelterweight()
    {
        HashMap<Integer, Fighter> welterweight = new HashMap<>();

        welterweight.put(1, fighters.get(1460));
        welterweight.put(2, fighters.get(1677));
        welterweight.put(3, fighters.get(592));
        welterweight.put(4, fighters.get(454));
        welterweight.put(5, fighters.get(1458));
        welterweight.put(6, fighters.get(1787));
        welterweight.put(7, fighters.get(4052));
        welterweight.put(8, fighters.get(2021));
        welterweight.put(9, fighters.get(2619));
        welterweight.put(10, fighters.get(1635));
        welterweight.put(11, fighters.get(1198));
        welterweight.put(12, fighters.get(1776));
        welterweight.put(13, fighters.get(3455));
        welterweight.put(14, fighters.get(3876));
        welterweight.put(15, fighters.get(1311));
        welterweight.put(16, fighters.get(3128));

        return welterweight;
    }

    private HashMap<Integer, Fighter> getMiddleweight()
    {
        HashMap<Integer, Fighter> middleweight = new HashMap<>();

        middleweight.put(1, fighters.get(638));
        middleweight.put(2, fighters.get(399));
        middleweight.put(3, fighters.get(1695));
        middleweight.put(4, fighters.get(186));
        middleweight.put(5, fighters.get(1730));
        middleweight.put(6, fighters.get(2291));
        middleweight.put(7, fighters.get(1251));
        middleweight.put(8, fighters.get(3464));
        middleweight.put(9, fighters.get(400));
        middleweight.put(10, fighters.get(169));
        middleweight.put(11, fighters.get(1292));
        middleweight.put(12, fighters.get(401));
        middleweight.put(13, fighters.get(4114));
        middleweight.put(14, fighters.get(3319));
        middleweight.put(15, fighters.get(3124));
        middleweight.put(16, fighters.get(2733));

        return middleweight;
    }


    private HashMap<Integer, Fighter> getLightHeavyweightweight()
    {
        HashMap<Integer, Fighter> lightHeavyweight = new HashMap<>();

        lightHeavyweight.put(1, fighters.get(3859));
        lightHeavyweight.put(2, fighters.get(1433));
        lightHeavyweight.put(3, fighters.get(1507));
        lightHeavyweight.put(4, fighters.get(1483));
        lightHeavyweight.put(5, fighters.get(2834));
        lightHeavyweight.put(6, fighters.get(1568));
        lightHeavyweight.put(7, fighters.get(1637));
        lightHeavyweight.put(8, fighters.get(1777));
        lightHeavyweight.put(9, fighters.get(1383));
        lightHeavyweight.put(10, fighters.get(1742));
        lightHeavyweight.put(11, fighters.get(508));
        lightHeavyweight.put(12, fighters.get(3926));
        lightHeavyweight.put(13, fighters.get(707));
        lightHeavyweight.put(14, fighters.get(2442));
        lightHeavyweight.put(15, fighters.get(3995));
        lightHeavyweight.put(16, fighters.get(1474));

        return lightHeavyweight;
    }


    private HashMap<Integer, Fighter> getHeavyweight()
    {
        HashMap<Integer, Fighter> heavyweight = new HashMap<>();

        heavyweight.put(1, fighters.get(1290));
        heavyweight.put(2, fighters.get(397));
        heavyweight.put(3, fighters.get(1262));
        heavyweight.put(4, fighters.get(1708));
        heavyweight.put(5, fighters.get(2730));
        heavyweight.put(6, fighters.get(2192));
        heavyweight.put(7, fighters.get(223));
        heavyweight.put(8, fighters.get(2708));
        heavyweight.put(9, fighters.get(1718));
        heavyweight.put(10, fighters.get(1324));
        heavyweight.put(11, fighters.get(2581));
        heavyweight.put(12, fighters.get(3602));
        heavyweight.put(13, fighters.get(56));
        heavyweight.put(14, fighters.get(1307));
        heavyweight.put(15, fighters.get(4115));
        heavyweight.put(16, fighters.get(1565));

        return heavyweight;
    }

    private HashMap<Integer, Fighter> getStrawweight()
    {
        HashMap<Integer, Fighter> strawweight = new HashMap<>();

        strawweight.put(1, fighters.get(1450));
        strawweight.put(2, fighters.get(743));
        strawweight.put(3, fighters.get(876));
        strawweight.put(4, fighters.get(3535));
        strawweight.put(5, fighters.get(904));
        strawweight.put(6, fighters.get(1418));
        strawweight.put(7, fighters.get(493));
        strawweight.put(8, fighters.get(968));
        strawweight.put(9, fighters.get(1345));
        strawweight.put(10, fighters.get(820));
        strawweight.put(11, fighters.get(1647));
        strawweight.put(12, fighters.get(651));
        strawweight.put(13, fighters.get(1783));
        strawweight.put(14, fighters.get(1717));
        strawweight.put(15, fighters.get(1689));
        strawweight.put(16, fighters.get(947));

        return strawweight;
    }


private HashMap<Integer, Fighter> getWomensFlyweight()
    {
        HashMap<Integer, Fighter> flyweight = new HashMap<>();

        flyweight.put(1, fighters.get(1424));
        flyweight.put(2, fighters.get(3742));
        flyweight.put(3, fighters.get(1935));
        flyweight.put(4, fighters.get(1176));
        flyweight.put(5, fighters.get(622));
        flyweight.put(6, fighters.get(1733));
        flyweight.put(7, fighters.get(3484));
        flyweight.put(8, fighters.get(1150));
        flyweight.put(9, fighters.get(1034));
        flyweight.put(10, fighters.get(1418));
        flyweight.put(11, fighters.get(1584));
        flyweight.put(12, fighters.get(1263));
        flyweight.put(13, fighters.get(101));
        flyweight.put(14, fighters.get(999));
        flyweight.put(15, fighters.get(4116));
        flyweight.put(16, fighters.get(3042));

        return flyweight;
    }

    private HashMap<Integer, Fighter> getWomensBantamweight()
    {
        HashMap<Integer, Fighter> bantamweight = new HashMap<>();

        bantamweight.put(1, fighters.get(4117));
        bantamweight.put(2, fighters.get(979));
        bantamweight.put(3, fighters.get(1119));
        bantamweight.put(4, fighters.get(1157));
        bantamweight.put(5, fighters.get(4065));
        bantamweight.put(6, fighters.get(1523));
        bantamweight.put(7, fighters.get(1464));
        bantamweight.put(8, fighters.get(3769));
        bantamweight.put(9, fighters.get(445));
        bantamweight.put(10, fighters.get(1736));
        bantamweight.put(11, fighters.get(3310));
        bantamweight.put(12, fighters.get(2129));
        bantamweight.put(13, fighters.get(2251));
        bantamweight.put(14, fighters.get(566));
        bantamweight.put(15, fighters.get(1556));
        bantamweight.put(16, fighters.get(3075));

        return bantamweight;
    }

    private HashMap<Integer, Fighter> getMenPoundForPound()
    {
        HashMap<Integer, Fighter> poundForPound = new HashMap<>();

        poundForPound.put(1, fighters.get(762));
        poundForPound.put(2, fighters.get(1466));
        poundForPound.put(3, fighters.get(1290));
        poundForPound.put(4, fighters.get(472));
        poundForPound.put(5, fighters.get(638));
        poundForPound.put(6, fighters.get(3859));
        poundForPound.put(7, fighters.get(1686));
        poundForPound.put(8, fighters.get(1460));
        poundForPound.put(9, fighters.get(1433));
        poundForPound.put(10, fighters.get(797));
        poundForPound.put(11, fighters.get(397));
        poundForPound.put(12, fighters.get(1529));
        poundForPound.put(13, fighters.get(1677));
        poundForPound.put(14, fighters.get(188));
        poundForPound.put(15, fighters.get(3478));

        return poundForPound;
    }

    private HashMap<Integer, Fighter> getWomenPoundForPound()
    {
        HashMap<Integer, Fighter> poundForPound = new HashMap<>();

        poundForPound.put(1, fighters.get(1424));
        poundForPound.put(2, fighters.get(1450));
        poundForPound.put(3, fighters.get(4117));
        poundForPound.put(4, fighters.get(1935));
        poundForPound.put(5, fighters.get(979));
        poundForPound.put(6, fighters.get(3742));
        poundForPound.put(7, fighters.get(1176));
        poundForPound.put(8, fighters.get(622));
        poundForPound.put(9, fighters.get(743));
        poundForPound.put(10, fighters.get(1119));
        poundForPound.put(11, fighters.get(876));
        poundForPound.put(12, fighters.get(1150));
        poundForPound.put(13, fighters.get(3535));
        poundForPound.put(14, fighters.get(904));
        poundForPound.put(15, fighters.get(1733));

        return poundForPound;
    }



}
