package bowling.domain.frame;

import bowling.domain.score.Score;

import java.util.List;

public class FinalFrame implements Frame {
    private List<Score> scores;

    @Override
    public void roll(int hitPinCount) {
        this.scores.add(new Score(hitPinCount));
    }

    @Override
    public boolean isAbleLastTry() {
        return isStrike() || isSpare();
    }

    @Override
    public boolean isStrike() {
        return scores.get(0).isStrike();
    }

    @Override
    public boolean isSpare() {
        return scores.get(0).isSpare(scores.get(1));
    }
}
