package bowling2.domain.frame;

public interface Frame {
    int FINAL_FRAME_TURN = 3;

    void rollBall(int hitPinCount);
    boolean hasTurn();
    Frame nextFrame();
    boolean isSpare();
    boolean isStrike();

    String getScoreText();
}
