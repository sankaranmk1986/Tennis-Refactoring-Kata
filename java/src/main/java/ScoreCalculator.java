import static java.util.Arrays.asList;

public class ScoreCalculator {
	
	  public String getScoreInWords(Player firstPlayer, Player secondPlayer) {
	        if (firstPlayer.isScoreEqual(secondPlayer)){
	            return getScoreIfEqual(firstPlayer);
	        }else if (isLongerGame(firstPlayer, secondPlayer)){
	            return getScoreForLongerGame(firstPlayer,secondPlayer);
	        }
	        return getScoreForNormalGame(firstPlayer,secondPlayer);
	    }

		private boolean isLongerGame(Player firstPlayer, Player secondPlayer) {
			return firstPlayer.isLongerGame() || secondPlayer.isLongerGame();
		}		

		private String getScoreIfEqual(Player firstPlayer) {	
			return asList(Score.values()).stream()
					.filter(scoreEnum -> scoreEnum.getScore() == firstPlayer.getScoreIfEqual())
					.findFirst()
					.get()
					.getScoreIfEquals();
		}

		private String getScoreForLongerGame(Player firstPlayer, Player secondPlayer) {
			if(firstPlayer.isLeadingWith(secondPlayer)){
				return getTextForScoreDifference(
						firstPlayer.leadBy(secondPlayer),firstPlayer.getName());
			}else{
				return getTextForScoreDifference(
						secondPlayer.leadBy(firstPlayer),secondPlayer.getName());
			}
		}

		private String getScoreForNormalGame(Player firstPlayer, Player secondPlayer) {
			return new StringBuilder()
					.append(firstPlayer.getScoreInWords())
					.append("-")
					.append(secondPlayer.getScoreInWords())
					.toString();		
		}
		
		private String getTextForScoreDifference(int scoreDifference, String leadingPlayerName){
			if(scoreDifference == 1){
				return "Advantage "+leadingPlayerName;
			}
			return "Win for "+leadingPlayerName;
		}


}
