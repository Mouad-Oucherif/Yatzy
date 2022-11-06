/** Class for the Yatzy score computing
 */
public class ScoreYatzy {

    public static int diceScores(CategoryYatzy category, int d1, int d2, int d3, int d4, int d5)
    {
        Yatzy dice = new Yatzy(d1, d2, d3, d4, d5);
        return switch (category) {
            case CHANCE -> dice.chance();
            case YATZY -> dice.yatzy();
            case ONES -> dice.ones();
            case TWOS -> dice.twos();
            case THREES -> dice.threes();
            case FOURS -> dice.fours();
            case FIVES -> dice.fives();
            case SIXES -> dice.sixes();
            case PAIR -> dice.pairs();
            case TWO_PAIRS -> dice.twoPairs();
            case THREE_OF_A_KIND -> dice.threeOfAKind();
            case FOUR_OF_A_KIND -> dice.fourOfAKind();
            case SMALL_STRAIGHT -> dice.smallStraight();
            case LARGE_STRAIGHT -> dice.largeStraight();
            case FULL_HOUSE -> dice.fullHouse();
            default -> throw new IllegalArgumentException("Category not supported");
        };
    }

    // Util method which is not used in the task but might be needed to display the results
    public static void displayScore(CategoryYatzy category, int d1, int d2, int d3, int d4, int d5){
        int score = ScoreYatzy.diceScores(category,  d1,  d2,  d3,  d4,  d5);
        System.out.printf("Dices: %d, %d, %d, %d, %d \nCategory: %s \nScore: %d", d1, d2 , d3, d4, d5, category, score);
    }
}