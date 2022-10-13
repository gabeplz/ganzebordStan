import java.nio.BufferOverflowException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Spel {

    ArrayList<String> gansKleuren = new ArrayList<>(Arrays.asList("wit", "rood", "groen", "blauw", "geel", "zwart"));
    //ArrayList<String> gansKleuren = new ArrayList<>(Arrays.asList("wit", "rood", "groen", "blauw", "geel", "zwart"));
    ArrayList<Speler> spelerArrayList = new ArrayList<>();
    ArrayList<Gans> gansArrayList = new ArrayList<>();
    ArrayList<Gans> speelVolgorde = new ArrayList<>();
    Dobbelsteen steen1 = new Dobbelsteen();
    Dobbelsteen steen2 = new Dobbelsteen();

    public void maakSpelers() {
        Bord das = new Bord();
        das.fillVakjeArraylist();

        System.out.println("hoeveel spelers zijn er");
        Scanner in = new Scanner(System.in);
        int userInput = 0;
        int spelers = 0;


        try {
            userInput = Integer.parseInt(in.next());
            System.out.println("je nummer was" + userInput);

            if (userInput < 0) {
                throw new ArithmeticException("negatief!");
            }
            if (userInput >= 7) {
                throw new BufferOverflowException();
            }
            for (int emptyLines = 0; emptyLines < 6; emptyLines++) {
                System.out.println("");
            }

            spelers = userInput;
            for (int i = 0; i < spelers; i++) {

                try {
                    System.out.println("voer je naam in");
                    Scanner in2 = new Scanner(System.in);
                    String userNaamInput = in2.next();

                    System.out.println("je naam is " + userNaamInput);
                    Speler speler = new Speler("usernaam", i + 1);
                    System.out.println(userNaamInput + " jij bent speler " + i + 1 + " je ganskleur is " + gansKleuren.get(i));
                    Gans gans = new Gans(gansKleuren.get(i), speler);
                    spelerArrayList.add(speler);
                    gansArrayList.add(gans);


                } catch (BufferOverflowException ignore) {
                }
            }

            //speler volgorde bepalen
            speelVolgorde = bepaalSpeelVolgorde(gansArrayList,steen1);
            System.out.println(speelVolgorde);
            //methode roll 1

            System.out.println("druk op een toests om terug te gaan");
            userInput = Integer.parseInt(in.next());
            for (int emptyLines = 0; emptyLines < 6; emptyLines++) {
                System.out.println(" ");
            }
//                break; // breaks out of the loop, do not remove fully
        } catch (NumberFormatException ignore) {
            System.out.println("voer alleen getallen ");
        } catch (ArithmeticException ignore) {
            System.out.println("negatief ");
        } catch (BufferOverflowException ignore) {
            System.out.println("veel te groot getal ");
        }
    }


    public void speelronde(ArrayList<Gans> speelVolgorde, Dobbelsteen steen1, Dobbelsteen steen2 ){

        for (Gans gans: speelVolgorde) {
            if (gans.BeurtOverslaan == true){
                continue;
            }
            int waardeSteen1 = steen1.roll();
            int waardeSteen2 = steen2.roll();
            // TODO: 13/10/2022 // check voor specialle combi bij en eerste worp
            int totaalWaardeWorp = waardeSteen1 + waardeSteen2;
            int curPos = gans.getPositie();

        }
        // TODO: 12/10/2022 for each speler, check if beurt overslaan, roll 2 dobbelstenen, addup, check if arrayIndex empty, move on array

    }

    public ArrayList<Gans> bepaalSpeelVolgorde(ArrayList<Gans> gansArrayList, Dobbelsteen steen){
        ArrayList<Gans> newSpeelvolgorde = new ArrayList<>();
        //int[] rolls = new int[gansArrayList.size()];
        int x= 0;
        ArrayList<Integer> rolls = new ArrayList<>();

        for (Gans i: gansArrayList) {
            int currentRoll = steen.roll();
            while (rolls.contains(currentRoll)){ // waarneer 2 spelers dezelfde worp hebben moet de laatste speler gooien tot hij een niet eerder gegooide waarde krijgt.
                currentRoll = steen.roll();
            }
            rolls.add(currentRoll);
            x+=1;

            }
            // sort players ; sort indexes; how to remember reference to player
            // [5,3,4,1]
            // get index max; place index in new VolgordeArray, set value in worp array to 0;


        for (Gans ii: gansArrayList) {
            int max = 0;
            for (int val : rolls) {
                if (val > max) {
                    max = val;
                }
            }
                int indexMax = rolls.indexOf(max);
                newSpeelvolgorde.add(gansArrayList.get(indexMax));
                rolls.set(indexMax, 0);


        }
        
        return newSpeelvolgorde;
    }


}
