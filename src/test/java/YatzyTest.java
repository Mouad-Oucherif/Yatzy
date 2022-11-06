import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class YatzyTest {

    @Test
    public void chanceScore() {
        int expected = 15;
        int actual = new Yatzy(2,3,4,5,1).chance();
        assertEquals(expected, actual);
        assertEquals(16, new Yatzy(3,3,4,5,1).chance());
    }

    @Test public void yatzyScore() {
        int expected = 50;
        int actual = new Yatzy(1,1,1,1,1).yatzy();
        assertEquals(expected, actual);
        assertEquals(50, new Yatzy(6,6,6,6,6).yatzy());
        assertEquals(0, new Yatzy(6,6,6,6,3).yatzy());
    }

    @Test public void onesScore() {
        assertEquals(1, new Yatzy(1, 2, 3, 4, 5).ones());
        assertEquals(2, new Yatzy(1,2,1,4,5).ones());
        assertEquals(0, new Yatzy(6,2,2,4,5).ones());
        assertEquals(4, new Yatzy(1,2,1,1,1).ones());
    }

    @Test
    public void twosScore() {
        assertEquals(4, new Yatzy(1,2,3,2,6).twos());
        assertEquals(10, new Yatzy(2,2,2,2,2).twos());
    }

    @Test
    public void threesScore() {
        assertEquals(6, new Yatzy(1,2,3,2,3).threes());
        assertEquals(12, new Yatzy(2,3,3,3,3).threes());
    }

    @Test
    public void foursScore()
    {
        assertEquals(12, new Yatzy(4,4,4,5,5).fours());
        assertEquals(8, new Yatzy(4,4,5,5,5).fours());
        assertEquals(4, new Yatzy(4,5,5,5,5).fours());
    }

    @Test
    public void fivesScore() {
        assertEquals(10, new Yatzy(4,4,4,5,5).fives());
        assertEquals(15, new Yatzy(4,4,5,5,5).fives());
        assertEquals(20, new Yatzy(4,5,5,5,5).fives());
    }

    @Test
    public void sixesScore() {
        assertEquals(0, new Yatzy(4,4,4,5,5).sixes());
        assertEquals(6, new Yatzy(4,4,6,5,5).sixes());
        assertEquals(18, new Yatzy(6,5,6,6,5).sixes());
    }

    @Test
    public void onePair() {
        assertEquals(6, new Yatzy(3,4,3,5,6).pairs());
        assertEquals(10, new Yatzy(5,3,3,3,5).pairs());
        assertEquals(12, new Yatzy(5,3,6,6,5).pairs());
    }

    @Test
    public void twoPairs() {
        assertEquals(16, new Yatzy(3,3,5,4,5).twoPairs());
        assertEquals(16, new Yatzy(3,3,5,5,5).twoPairs());
    }

    @Test
    public void threeOfAKind()
    {
        assertEquals(9, new Yatzy(3,3,3,4,5).threeOfAKind());
        assertEquals(15, new Yatzy(5,3,5,4,5).threeOfAKind());
        assertEquals(9, new Yatzy(3,3,3,3,5).threeOfAKind());
    }

    @Test
    public void fourOfAKind() {
        assertEquals(12, new Yatzy(3,3,3,3,5).fourOfAKind());
        assertEquals(20, new Yatzy(5,5,5,4,5).fourOfAKind());
        assertEquals(16, new Yatzy(4,4,4,4,3).fourOfAKind());
    }

    @Test
    public void smallStraight() {
        assertEquals(15, new Yatzy(1,2,3,4,5).smallStraight());
        assertEquals(15, new Yatzy(2,3,4,5,1).smallStraight());
        assertEquals(0, new Yatzy(1,2,2,4,5).smallStraight());
    }

    @Test
    public void largeStraight() {
        assertEquals(20, new Yatzy(6,2,3,4,5).largeStraight());
        assertEquals(20, new Yatzy(2,3,4,5,6).largeStraight());
        assertEquals(0, new Yatzy(1,2,2,4,5).largeStraight());
    }

    @Test
    public void fullHouse() {
        assertEquals(18, new Yatzy(6,2,2,2,6).fullHouse());
        assertEquals(0, new Yatzy(2,3,4,5,6).fullHouse());
        assertEquals(0, new Yatzy(5,5,4,5,2).fullHouse());
        assertEquals(0, new Yatzy(2,3,4,5,6).fullHouse());
    }

    @Test
    public void categoryScore() {
        ScoreYatzy scoreYatzy = new ScoreYatzy();
        assertEquals(50, scoreYatzy.diceScores(CategoryYatzy.YATZY,1,1,1,1,1));
        assertEquals(10, scoreYatzy.diceScores(CategoryYatzy.CHANCE,3,4,1,1,1));
        assertEquals(3, scoreYatzy.diceScores(CategoryYatzy.ONES,3,4,1,1,1));
        assertEquals(6, scoreYatzy.diceScores(CategoryYatzy.TWOS,3,2,2,2,1));
        assertEquals(3, scoreYatzy.diceScores(CategoryYatzy.THREES,3,2,2,2,1));
        assertEquals(12, scoreYatzy.diceScores(CategoryYatzy.FOURS,4,4,4,2,1));
        assertEquals(10, scoreYatzy.diceScores(CategoryYatzy.FIVES,5,5,1,1,1));
        assertEquals(18, scoreYatzy.diceScores(CategoryYatzy.SIXES,6,4,6,6,1));
        assertEquals(6, scoreYatzy.diceScores(CategoryYatzy.PAIR,3,4,1,3,1));
        assertEquals(10, scoreYatzy.diceScores(CategoryYatzy.TWO_PAIRS,3,2,2,3,1));
        assertEquals(6, scoreYatzy.diceScores(CategoryYatzy.THREE_OF_A_KIND,3,2,2,2,1));
        assertEquals(8, scoreYatzy.diceScores(CategoryYatzy.FOUR_OF_A_KIND,2,2,2,2,1));
        assertEquals(15, scoreYatzy.diceScores(CategoryYatzy.SMALL_STRAIGHT,5,4,3,1,2));
        assertEquals(20, scoreYatzy.diceScores(CategoryYatzy.LARGE_STRAIGHT,3,2,4,5,6));
        assertEquals(12, scoreYatzy.diceScores(CategoryYatzy.FULL_HOUSE,3,2,2,2,3));
    }

}