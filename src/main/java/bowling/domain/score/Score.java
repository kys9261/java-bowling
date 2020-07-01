package bowling.domain.score;

import static bowling.Validator.MAX_HIT_PIN;
import static bowling.Validator.MIN_HIT_PIN;

public class Score {
    private final int score;

    public Score(int score) {
        scoreValidator(score);
        this.score = score;
    }

    public void scoreValidator(int score) {
        if(score < MIN_HIT_PIN || score > MAX_HIT_PIN) {
            throw new IllegalArgumentException("쓰러진 볼링핀은 0~10개중 하나만 입력 가능합니다.");
        }
    }

    public boolean isStrike() {
        return this.score == ScoreSymbol.STRIKE.score;
    }

    public boolean isSpare(Score secondScore) {
        return (this.score + secondScore.score) == ScoreSymbol.STRIKE.score;
    }
}
