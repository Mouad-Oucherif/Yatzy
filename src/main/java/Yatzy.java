/** Core class for the Yatzy game
 */
public class Yatzy {

    protected int[] dices;

    /** Construct for Yatzy class
     * @param d1 Result value of the dice number 1
     * @param d2 Result value of the dice number 2
     * @param d3 Result value of the dice number 3
     * @param d4 Result value of the dice number 4
     * @param d5 Result value of the dice number 4
     */
    public Yatzy(int d1, int d2, int d3, int d4, int d5) {
        dices = new int[5];
        dices[0] = d1;
        dices[1] = d2;
        dices[2] = d3;
        dices[3] = d4;
        dices[4] = d5;
    }

    public int chance() {
        int total = 0;
        for (int dice : dices) {
            total += dice;
        }
        return total;
    }

    public int yatzy() {
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

    public   int pairs() {
        return repeatedNumber(2, dices, false);
    }

    public  int twoPairs() {
        return repeatedNumber(2, dices, true);
    }

    public  int fourOfAKind() {
        return repeatedNumber(4, dices, false);

    }

    public  int threeOfAKind() {
        return repeatedNumber(3, dices, false);
    }

    public  int smallStraight() {
       return straight(0,4, dices,15);
    }

    public  int largeStraight() {
        return straight(1,5, dices,20);
    }

    public  int fullHouse() {
        boolean pair = false;
        int i;
        int pairAt = 0;
        boolean threeOfAKind = false;
        int threeOfAKindAt = 0;
        int[] counts = new int[6];

        for(int dice : dices) {
            counts[dice-1] += 1;
        }

        for (i = 0; i != 6; i += 1) {
            if (counts[i] == 2) {
                pair = true;
                pairAt = i+1;
            }
        }

        for (i = 0; i != 6; i += 1) {
            if (counts[i] == 3) {
                threeOfAKind = true;
                threeOfAKindAt = i+1;
            }
        }

        if (pair && threeOfAKind) {
            return pairAt * 2 + threeOfAKindAt * 3;
        }
        else {
            return 0;
        }
    }

    private int numberOf(int value) {
        int count = 0;
        for(int dice : dices) {
            if(dice == value) count += value;
        }
        return count;
    }

    private int repeatedNumber(int times, int[] dices, boolean doubles) {
        int[] counts = new int[6];
        int score = 0;
        for(int dice : dices)
            counts[dice-1]++;
        for(int at = 6; at > 0; at--) {
            if(counts[at-1] >= times) {
                score += at;
                if(!doubles) break;
            }
        }
        return score * times;
    }

    private int straight(int start, int end, int[] dices, int score) {
        int[] counts = new int[6];
        for(int dice : dices)
            counts[dice-1] += 1;
        for(int i=start; i<end; i++) {
            if(counts[i] != 1) {
                return 0;
            }
        }
        return score;
    }
}