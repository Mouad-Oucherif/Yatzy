public class Score {


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
            case PAIR -> dice.score_pair();
            case TWO_PAIRS -> dice.two_pair();
            case THREE_OF_A_KIND -> dice.three_of_a_kind();
            case FOUR_OF_A_KIND -> dice.four_of_a_kind();
            case SMALL_STRAIGHT -> Yatzy.smallStraight(d1, d2, d3, d4, d5);
            case LARGE_STRAIGHT -> Yatzy.largeStraight(d1, d2, d3, d4, d5);
            case FULL_HOUSE -> dice.fullHouse();
            default -> throw new IllegalArgumentException("Category not supported");
        };
    }

    public static void displayScore(CategoryYatzy category, int d1, int d2, int d3, int d4, int d5){
        int score = Score.diceScores(category,  d1,  d2,  d3,  d4,  d5);
        System.out.printf("Dices: %d, %d, %d, %d, %d \nCategory: %s \nScore: %d", d1, d2 , d3, d4, d5, category, score);
    }


}


