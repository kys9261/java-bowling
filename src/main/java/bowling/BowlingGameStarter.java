package bowling;

import bowling.view.InputView;

public class BowlingGameStarter {
    public static void main(String[] args) {
        String userName = Validator.checkPlayerName(InputView.getPlayerName());

        BowlingGame bowlingGame = new BowlingGame(userName);
        bowlingGame.start();
    }
}
