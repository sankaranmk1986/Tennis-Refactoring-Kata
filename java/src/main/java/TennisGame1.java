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
        if (firstPlayer.isScoreEqual(secondPlayer))
        {
            score = getScoreIfEqual();
        }
        else if (firstPlayer.isLongerGame() || secondPlayer.isLongerGame())
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
		if(firstPlayer.isLeadingWith(secondPlayer)){
			return getTextForScoreDifference(firstPlayer.leadBy(secondPlayer),firstPlayer.getName());
		}else{
			return getTextForScoreDifference(secondPlayer.leadBy(firstPlayer),secondPlayer.getName());
		}
	}
	
	private String getTextForScoreDifference(int scoreDifference, String leadingPlayerName){
		if(scoreDifference == 1){
			return "Advantage "+leadingPlayerName;
		}
		return "Win for "+leadingPlayerName;
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
