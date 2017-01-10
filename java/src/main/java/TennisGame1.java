import static java.util.Arrays.asList;

public class TennisGame1 implements TennisGame {
    
    private Player firstPlayer;
    private Player secondPlayer;

    public TennisGame1(String firstPlayerName, String secondPlayerName) {
        this.firstPlayer = new Player(firstPlayerName);
        this.secondPlayer = new Player(secondPlayerName);
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
           firstPlayer.addScore();
        else
            secondPlayer.addScore();
    }

    public String getScore() {
        String score;
        if (firstPlayer.getScore()==secondPlayer.getScore())
        {
            score = getScoreIfEqual();
        }
        else if (firstPlayer.getScore()>=4 || secondPlayer.getScore()>=4)
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
				.append(getScore(firstPlayer.getScore()))
				.append("-")
				.append(getScore(secondPlayer.getScore()))
				.toString();		
	}

	private String getScoreForLongerGame() {
		String score;
		int minusResult = firstPlayer.getScore()-secondPlayer.getScore();
		if (minusResult==1) score ="Advantage player1";
		else if (minusResult ==-1) score ="Advantage player2";
		else if (minusResult>=2) score = "Win for player1";
		else score ="Win for player2";
		return score;
	}

	private String getScoreIfEqual() {	
		return getScore(firstPlayer.getScoreIfEqual()).getScoreIfEquals();
	}

	private Score getScore(int score) {
		return asList(Score.values()).stream()
				.filter(scoreEnum -> scoreEnum.getScore() == score)
				.findFirst()
				.get();
	}
}
