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
		String score="";
		int tempScore=0;
		for (int i=1; i<3; i++)
		{
		    if (i==1) tempScore = firstPlayerScore;
		    else { score+="-"; tempScore = secondPlayerScore;}
		    switch(tempScore)
		    {
		        case 0:
		            score+="Love";
		            break;
		        case 1:
		            score+="Fifteen";
		            break;
		        case 2:
		            score+="Thirty";
		            break;
		        case 3:
		            score+="Forty";
		            break;
		    }
		}
		return score;
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
		return asList(Score.values()).stream()
				.filter(score -> score.getScore() == getPlayerScoreIfEqual())
				.findFirst()
				.get()
				.getScoreIfEquals();
	}
	
	private int getPlayerScoreIfEqual(){
		return firstPlayerScore > 3? 3: firstPlayerScore;
	}
}
