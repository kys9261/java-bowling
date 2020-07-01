package bowling2.domain.frame;

public class BasicFrame implements Frame {
    private static final int BASIC_FRAME_TURN = 2;
    private Scores scores;

    public BasicFrame() {
        this.scores = new Scores();
    }

    @Override
    public void rollBall(int hitPinCount) {
        if(!hasTurn()) {
            throw new IllegalArgumentException("");
        }
        scores.addScore(hitPinCount);
    }

    @Override
    public boolean hasTurn() {
        return scores.checkScoreSize(BASIC_FRAME_TURN);
    }

    @Override
    public boolean isStrike() {
        return scores.isStrike();
    }

    @Override
    public String getScoreText() {
        return scores.getScoreText();
    }

    @Override
    public boolean isSpare() {
        return scores.isSpare();
    }

    @Override
    public Frame nextFrame() {
        return new BasicFrame();
    }

    public Scores getScores() {
        return scores;
    }
}
