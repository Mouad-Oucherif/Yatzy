public class Score {


    public static int diceScores(CategoryYatzy category, int d1, int d2, int d3, int d4, int d5)
    {
        int score = 0;
        switch (category){
            case CHANCE:
                break;
            case YATZY:
                score = Yatzy.yatzy(d1, d2, d3, d4, d5);
                break;
            case ONES:
                score = Yatzy.ones(d1, d2, d3, d4, d5);
                break;
            case TWOS:
                score =  Yatzy.twos(d1, d2, d3, d4, d5);
                break;
            case THREES:
                score = Yatzy.threes(d1, d2, d3, d4, d5);
                break;
            case FOURS:
                score = new Yatzy(d1, d2, d3, d4, d5).fours();
                break;
            case FIVES:
                score =  new Yatzy(d1, d2, d3, d4, d5).fives();
                break;
            case SIXES:
                score = new Yatzy(d1, d2, d3, d4, d5).sixes();
                break;
            case PAIR:
                score = Yatzy.score_pair(d1, d2, d3, d4, d5);
                break;
            case TWO_PAIRS:
                score = Yatzy.two_pair(d1, d2, d3, d4, d5);
                break;
            case THREE_OF_A_KIND:
                score = Yatzy.three_of_a_kind(d1, d2, d3, d4, d5);
                break;
            case FOUR_OF_A_KIND:
                score = Yatzy.four_of_a_kind(d1, d2, d3, d4, d5);
                break;
            case SMALL_STRAIGHT:
                score = Yatzy.smallStraight(d1, d2, d3, d4, d5);
                break;
            case LARGE_STRAIGHT:
                score = Yatzy.largeStraight(d1, d2, d3, d4, d5);
                break;
            case FULL_HOUSE:
                score = Yatzy.fullHouse(d1, d2, d3, d4, d5);
                break;

        }
        return score;
    }

}


