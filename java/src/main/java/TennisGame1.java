import static java.util.Arrays.asList;

public class TennisGame1 implements TennisGame {
    
    private Player firstPlayer;
    private Player secondPlayer;

    public TennisGame1(String firstPlayerName, String secondPlayerName) {
        this.firstPlayer = new Player(firstPlayerName);
        this.secondPlayer = new Player(secondPlayerName);
    }

    public void wonPoint(String playerName) {
        if(firstPlayer.getName().equalsIgnoreCase(playerName)){
           firstPlayer.addScore();
        }else{
           secondPlayer.addScore();
        }
    }

    public String getScore() {
        if (firstPlayer.isScoreEqual(secondPlayer)){
            return getScoreIfEqual();
        }else if (isLongerGame()){
            return getScoreForLongerGame();
        }
        return getScoreForNormalGame();
    }

	private boolean isLongerGame() {
		return firstPlayer.isLongerGame() || secondPlayer.isLongerGame();
	}

	private String getScoreForNormalGame() {
		return new StringBuilder()
				.append(firstPlayer.getScoreInWords())
				.append("-")
				.append(secondPlayer.getScoreInWords())
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
		return asList(Score.values()).stream()
				.filter(scoreEnum -> scoreEnum.getScore() == firstPlayer.getScoreIfEqual())
				.findFirst()
				.get()
				.getScoreIfEquals();
	}
	
}
