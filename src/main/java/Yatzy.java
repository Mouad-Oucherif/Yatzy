import java.util.Arrays;

public class Yatzy {

    protected int[] dices;
    public Yatzy(int d1, int d2, int d3, int d4, int d5)
    {
        dices = new int[5];
        dices[0] = d1;
        dices[1] = d2;
        dices[2] = d3;
        dices[3] = d4;
        dices[4] = d5;
    }
    public  int chance()
    {
        int total = 0;
        for (int dice : dices) {
            total += dice;
        }
        return total;
    }

    public  int yatzy()
    {
        int a = repeatedNumber(5, dices,false);
        if(a != 0) {
            return 50;
        }
        else {
            return 0;
        }
    }

    public  int ones() {
        return numberOf(1);
    }


    public  int twos() {
        return numberOf(2);
    }

    public  int threes() {
        return numberOf(3);
    }

    public int fours() {
        return numberOf(4);

    }

    public int fives() {
        return numberOf(5);

    }

    public int sixes() {
        return numberOf(6);

    }

    public   int score_pair() {
        return repeatedNumber(2, dices, false);
    }

    public  int two_pair() {
        return repeatedNumber(2, dices, true);
    }

    public  int four_of_a_kind() {
        return repeatedNumber(4, dices, false);

    }

    public  int three_of_a_kind() {
        return repeatedNumber(3, dices, false);

    }

    public static int smallStraight(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies;
        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;
        if (tallies[0] == 1 &&
            tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1)
            return 15;
        return 0;
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies;
        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;
        if (tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1
            && tallies[5] == 1)
            return 20;
        return 0;
    }

    public  int fullHouse() {

        int a = repeatedNumber(2, dices,false);
        int b = repeatedNumber(3, dices,false);
        if(a != 0 && b != 0)
            return a+b;
        else
            return 0;
    }

    private int numberOf(int value){
        int count = 0;
        for(int dice : dices)
        {
            if(dice == value) count+=value;
        }
        return count;
    }

    private int repeatedNumber(int times, int[] dices, boolean doubles) {
        int[] counts = new int[6];
        int score = 0;
        for(int dice : dices)
            counts[dice-1]++;
        for(int at = 6; at > 0; at--){
            if(counts[at-1] >= times){
                score += at;
                if(!doubles) break;
            }
        }
        return score * times;
    }
}


