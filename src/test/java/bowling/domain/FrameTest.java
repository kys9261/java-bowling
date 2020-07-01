package bowling.domain;

import bowling.domain.frame.Frame;
import bowling.domain.score.Score;
import bowling.domain.score.ScoreSymbol;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Frame 테스트")
class FrameTest {

    @DisplayName("첫번째 투구 확인")
    @ParameterizedTest
    @ValueSource(ints = {4,1,9,10})
    void firstTry(int score) {
        Frame frame = new Frame(1);
        frame.firstTry(score);
        assertThat(frame.getScore1().getScore()).isEqualTo(new Score(score).getScore());
    }

    @DisplayName("두번째 투구 확인")
    @ParameterizedTest
    @ValueSource(ints = {5,6,2,0})
    void secondTry(int score) {
        Frame frame = new Frame(1);
        frame.secondTry(score);
        assertThat(frame.getScore2().getScore()).isEqualTo(new Score(score).getScore());
    }

    @DisplayName("두번째 프레임 시도 가능여부")
    @Test
    void isAbleSecondTry_가능() {
        Frame frame = new Frame(1);
        frame.firstTry(ScoreSymbol.SIX.getScore());
        assertThat(frame.isAbleSecondTry()).isTrue();

        frame.firstTry(ScoreSymbol.STRIKE.getScore());
        assertThat(frame.isAbleSecondTry()).isFalse();
    }

    @DisplayName("스트라이크 여부 확인")
    @Test
    void isStrike() {
        Frame frame = new Frame(1);
        frame.firstTry(ScoreSymbol.STRIKE.getScore());
        assertThat(frame.isStrike()).isTrue();

        frame.firstTry(ScoreSymbol.SIX.getScore());
        assertThat(frame.isStrike()).isFalse();
    }

    @DisplayName("스페어처리 여부 확인")
    @Test
    void isSpare() {
        Frame frame = new Frame(1);
        frame.firstTry(ScoreSymbol.STRIKE.getScore());
        assertThat(frame.isSpare()).isFalse();

        frame.firstTry(ScoreSymbol.SIX.getScore());
        frame.secondTry(ScoreSymbol.FOUR.getScore());
        assertThat(frame.isSpare()).isTrue();
    }

    @DisplayName("마지막 프레임 체크")
    @Test
    void isFinalFrame() {
        Frame frame = new Frame(10);
        assertThat(frame.isFinalFrame()).isTrue();

        frame = new Frame(9);
        assertThat(frame.isFinalFrame()).isFalse();
    }

    @DisplayName("프레임 결과 출력")
    @Test
    void testToString() {
        Frame frame = new Frame(5);
        frame.firstTry(ScoreSymbol.STRIKE.getScore());
        assertThat(frame.toString()).isEqualTo("X");

        frame.firstTry(ScoreSymbol.THREE.getScore());
        frame.secondTry(ScoreSymbol.SEVEN.getScore());
        assertThat(frame.toString()).isEqualTo("3|/");

        frame.firstTry(ScoreSymbol.GUTTER.getScore());
        frame.secondTry(ScoreSymbol.NINE.getScore());
        assertThat(frame.toString()).isEqualTo("-|9");
    }
}
