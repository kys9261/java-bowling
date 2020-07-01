package bowling2.domain;

import bowling.view.InputView;
import bowling.view.ResultView;
import bowling2.domain.frame.BasicFrame;
import bowling2.domain.frame.Frame;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    public static int FINAL_FRAME_NUMBER = 10;
    private List<Frame> frames = new ArrayList<>();

    public static void main(String[] args) {
        int frameNumber = 1;
        Frame frame = new BasicFrame();
        if(frame.hasTurn()) {
            frame.rollBall(InputView.getHitPinCount(frameNumber));
        }

        if(frame.hasTurn()) {
            frame.rollBall(InputView.getHitPinCount(frameNumber));
        }

        System.out.println(frame.getScoreText());
    }
}
