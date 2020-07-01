package bowling;

import bowling.domain.frame.BasicFrame;
import bowling.domain.frame.FinalFrame;
import bowling.domain.frame.Frame;
import bowling.view.InputView;
import bowling.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    public static int FINAL_FRAME_NUMBER = 10;

    private List<Frame> frames = new ArrayList<>();
    private String playerName;

    public BowlingGame(String playerName) {
        this.playerName = playerName;
        ResultView.printEmptyScoreBoard(playerName);
    }

    public void start() {
        Frame frame = new BasicFrame();
        for (int i = 1; i <= FINAL_FRAME_NUMBER; i++) {
            playFrame(frame, i);
        }
    }

    private void playFrame(Frame frame, int frameNumber) {
        frame.roll(InputView.getHitPinCount(frameNumber));
        ResultView.printScoreBoard(playerName, frames);

        if (frame.isAbleLastTry()) {
            frame.roll(InputView.getHitPinCount(frameNumber));
            ResultView.printScoreBoard(playerName, frames);
        }

        if (frameNumber + 1 == FINAL_FRAME_NUMBER) {
            playFinalFrame(frame);
        }
        frame.nextFrame(frames);
    }

    private void playFinalFrame(Frame frame) {
        FinalFrame finalFrame = (FinalFrame) frame;

        if (finalFrame.isAbleLastTry()) {
            finalFrame.roll(InputView.getHitPinCount(FINAL_FRAME_NUMBER));
        }
        ResultView.printScoreBoard(playerName, frames);
    }
}
