package bowling.domain.frame;

import bowling.domain.score.Score;

import java.util.ArrayList;
import java.util.List;

public class BasicFrame implements Frame {
    private boolean ableSecondTry = false;
    private List<Score> scores = new ArrayList<>();


    @Override
    public void roll(int hitPinCount) {
        this.scores.add(new Score(hitPinCount));
        checkRollState();
    }

    @Override
    public boolean isAbleLastTry() {
        return ableSecondTry;
    }

    @Override
    public boolean isStrike() {
        return scores.get(0).isStrike();
    }

    @Override
    public boolean isSpare() {
        return scores.get(0).isSpare(scores.get(1));
    }

    private void checkRollState() {
        if(this.scores.size() == 1) {
            this.ableSecondTry = true;
        }

        if(this.scores.size() > 2) {
            throw new IllegalArgumentException("던질 수 있는 횟수를 초과했습니다.");
        }
    }

    @Override
    public void nextFrame(List<Frame> frames) {
        frames.add(new BasicFrame());
    }
}
