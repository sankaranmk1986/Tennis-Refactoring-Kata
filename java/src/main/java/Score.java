
public enum Score {	
	Love(0,"Love-All"),
	Fifteen(1,"Fifteen-All"),
	Thirty(2, "Thirty-All"),
	Forty(3,"Deuce");
	
	private int score;
	private String scoreIfEquals;
	
	Score(int score, String scoreIfEquals){
		this.score=score;
		this.scoreIfEquals=scoreIfEquals;
	}

	public int getScore() {
		return score;
	}

	public String getScoreIfEquals() {
		return scoreIfEquals;
	}
	
}
