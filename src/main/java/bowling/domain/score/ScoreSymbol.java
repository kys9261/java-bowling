package bowling.domain.score;

public enum ScoreSymbol {
    GUTTER(0, "-"),
    STRIKE(10,"X");

    public int score;
    private String scoreText;

    ScoreSymbol(int score, String scoreText) {
        this.score = score;
        this.scoreText = scoreText;
    }

    public static String getScoreTextByScore(int score) {
        for(ScoreSymbol scoreSymbol : values()) {
            if(scoreSymbol.score == score){
                return scoreSymbol.scoreText;
            }
        }
        return String.valueOf(score);
    }
}
