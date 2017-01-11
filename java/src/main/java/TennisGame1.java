public class TennisGame1 implements TennisGame {
    
    private Player firstPlayer;
    private Player secondPlayer;
    private ScoreCalculator scoreCalculator;

    public TennisGame1(String firstPlayerName, String secondPlayerName) {
        this.firstPlayer = new Player(firstPlayerName);
        this.secondPlayer = new Player(secondPlayerName);
        this.scoreCalculator=new ScoreCalculator();
    }

    public void wonPoint(String playerName) {
        if(firstPlayer.getName().equalsIgnoreCase(playerName)){
           firstPlayer.addScore();
        }else{
           secondPlayer.addScore();
        }
    }

    public String getScore() {
    	return scoreCalculator.getScoreInWords(firstPlayer, secondPlayer);
    }
	
}
