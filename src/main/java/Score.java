public class Score {


    public static int diceScores(CategoryYatzy category, int d1, int d2, int d3, int d4, int d5)
    {
        int score = switch (category) {
            case CHANCE -> Yatzy.chance(d1, d2, d3, d4, d5);
            case YATZY -> Yatzy.yatzy(d1, d2, d3, d4, d5);
            case ONES -> Yatzy.ones(d1, d2, d3, d4, d5);
            case TWOS -> Yatzy.twos(d1, d2, d3, d4, d5);
            case THREES -> Yatzy.threes(d1, d2, d3, d4, d5);
            case FOURS -> new Yatzy(d1, d2, d3, d4, d5).fours();
            case FIVES -> new Yatzy(d1, d2, d3, d4, d5).fives();
            case SIXES -> new Yatzy(d1, d2, d3, d4, d5).sixes();
            case PAIR -> Yatzy.score_pair(d1, d2, d3, d4, d5);
            case TWO_PAIRS -> Yatzy.two_pair(d1, d2, d3, d4, d5);
            case THREE_OF_A_KIND -> Yatzy.three_of_a_kind(d1, d2, d3, d4, d5);
            case FOUR_OF_A_KIND -> Yatzy.four_of_a_kind(d1, d2, d3, d4, d5);
            case SMALL_STRAIGHT -> Yatzy.smallStraight(d1, d2, d3, d4, d5);
            case LARGE_STRAIGHT -> Yatzy.largeStraight(d1, d2, d3, d4, d5);
            case FULL_HOUSE -> Yatzy.fullHouse(d1, d2, d3, d4, d5);
            default -> throw new IllegalArgumentException("Category not supported");
        };
        return score;
    }

    public static void displayScore(CategoryYatzy category, int d1, int d2, int d3, int d4, int d5){
        int score = Score.diceScores(category,  d1,  d2,  d3,  d4,  d5);
        System.out.printf("Dices: %d, %d, %d, %d, %d \nCategory: %s \nScore: %d", d1, d2 , d3, d4, d5, category, score);
    }


}


