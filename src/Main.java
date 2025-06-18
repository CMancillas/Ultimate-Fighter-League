import java.util.LinkedList;

import models.Division;
import models.Fighter;
import models.Tournament;
import services.DivisionManager;
import services.TournamentService;
import utils.DataLoader;

public class Main {
    public static void main(String[] args )
    {
        DataLoader data = new DataLoader("data/ufc-fighters-statistics.csv");
        LinkedList<Fighter> fighters = data.loadFighter();
        TournamentService tournamentService = new TournamentService();
        LinkedList<Fighter> tournamentFighters = new LinkedList<>();
        
        DivisionManager divisionManager = new DivisionManager();
        Division flyweight = new Division("bantamweight", divisionManager.getRankings(13));
        divisionManager.printDivision(flyweight.getFighters());
        /*

            
            Womens Bantamweight

         * 1.- Kayla Harrison 4117
         * 2.- Julianna Peña 979
         * 3.- Raquel Pennington 1119
         * 4.- Ketlen Vieira 1157
         * 5.- Norma Dumont 4065
         * 6.- Macy Chiasson 1523
         * 7.- Irene Aldana 1464
         * 8.- Ailin Perez 3769
         * 9.- Mayra Bueno Silva 445
         * 10.-Yana Santos 1736
         * 11.-Karol Rosa 3310
         * 12.-Jacqueline Cavalcanti 2129
         * 13.-Nora Cornolle 2251
         * 14.-Miesha Tate 566
         * 15.-Joselyne Edwards 1556
         * 16.-Chelsea Chandler 3075

            Mens pound for pound

         * 1.- islam makhachev 762
         * 2.-Merab Dvalishvili 1466
         * 3.- 	Jon Jones 1290 
         * 4.-Ilia Topuria 472
         * 5.-Dricus Du Plessis 638
         * 6.- 	Magomed Ankalaev 3859
         * 7.-Alexander Volkanovski 1686
         * 8.-Jack Della Maddalena 1460
         * 9.- 	Alex Pereira 1433
         * 10.-Alexandre Pantoja 797
         * 11.-Tom Aspinall 397
         * 12.- Max Holloway 1529
         * 13.- Belal Muhammad 1677
         * 14.-Charles Oliveira 188
         * 15.-Arman Tsarukyan 3478

            Womens pound for pound
        
        * 1.- Valentina shevchenko 1424
         * 2.- Zhang Weili 1450
         * 3.- 	Kayla Harrison 4117
         * 4.-Manon Fiorot 1935
         * 5.-Julianna Peña 979
         * 6.-Natalia Silva 3742
         * 7.- 	Alexa Grasso 1176
         * 8.-Erin Blanchfield 622
         * 9.-Virna Jandiroba 743
         * 10.-Raquel Pennington 1119
         * 11.-Tatiana Suarez 876
         * 12.-Rose Namajunas 1150
         * 13.-Yan Xiaonan 3535
         * 14.- Amanda Lemos 904
         * 15.-Maycee Barber 1733

         */

        
        /*

        for(int i = 0; i < 4; i++)
        {
            tournamentFighters.add(fighters.get(i));
        }

         
        Tournament tournament = tournamentService.createTournament(tournamentFighters);
        tournamentService.printTournamentFighters(tournamentFighters);
        Fighter winner = tournamentService.runTournament(tournament);
        System.out.println("AND THE WINNER IS: " + winner.getFullName());
        */
        
    }
}
