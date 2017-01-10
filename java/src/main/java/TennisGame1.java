import static java.util.Arrays.asList;

public class TennisGame1 implements TennisGame {
    
    private int firstPlayerScore = 0;
    private int secondPlayerScore = 0;
    private String firstPlayerName;
    private String secondPlayerName;

    public TennisGame1(String firstPlayerName, String secondPlayerName) {
        this.firstPlayerName = firstPlayerName;
        this.secondPlayerName = secondPlayerName;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            firstPlayerScore += 1;
        else
            secondPlayerScore += 1;
    }

    public String getScore() {
        String score;
        if (firstPlayerScore==secondPlayerScore)
        {
            score = getScoreIfEqual();
        }
        else if (firstPlayerScore>=4 || secondPlayerScore>=4)
        {
            score = getScoreForLongerGame();
        }
        else
        {
            score = getScoreForNormalGame();
        }
        return score;
    }

	private String getScoreForNormalGame() {
		return new StringBuilder()
				.append(getScore(firstPlayerScore))
				.append("-")
				.append(getScore(secondPlayerScore))
				.toString();		
	}

	private String getScoreForLongerGame() {
		String score;
		int minusResult = firstPlayerScore-secondPlayerScore;
		if (minusResult==1) score ="Advantage player1";
		else if (minusResult ==-1) score ="Advantage player2";
		else if (minusResult>=2) score = "Win for player1";
		else score ="Win for player2";
		return score;
	}

	private String getScoreIfEqual() {	
		return getScore(getPlayerScoreIfEqual()).getScoreIfEquals();
	}

	private Score getScore(int score) {
		return asList(Score.values()).stream()
				.filter(scoreEnum -> scoreEnum.getScore() == score)
				.findFirst()
				.get();
	}
	
	private int getPlayerScoreIfEqual(){
		return firstPlayerScore > 3? 3: firstPlayerScore;
	}
}
