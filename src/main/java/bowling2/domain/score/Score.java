package bowling2.domain.score;

import bowling.domain.score.ScoreSymbol;

public class Score {
    private static final int MIN_SCORE = 0;
    private static final int MAX_SCORE = 10;

    private int hitPinCount;
    private String symbol;

    public Score(int hitPinCount) {
        checkValidScore(hitPinCount);
        this.hitPinCount = hitPinCount;
        this.symbol = getSymbol();
    }

    private String getSymbol() {
    }

    private void checkValidScore(int hitPinCount) {
        if(hitPinCount < MIN_SCORE || hitPinCount > MAX_SCORE) {
            throw new IllegalArgumentException("볼링핀 점수가 잘못됐다!!");
        }
    }

    public boolean isStrike() {
        return this.hitPinCount == MAX_SCORE;
    }

    public boolean isSpare(Score score) {
        return this.hitPinCount + score.hitPinCount == MAX_SCORE;
    }
}
