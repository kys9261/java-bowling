package bowling.domain.frame;

import java.util.List;

public interface Frame {

    void roll(int hitPinCount);
    boolean isAbleLastTry();
    boolean isStrike();
    boolean isSpare();
    void nextFrame(List<Frame> frames);
}
