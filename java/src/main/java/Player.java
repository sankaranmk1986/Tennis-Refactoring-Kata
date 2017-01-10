
public class Player {
	private String name;
	private int score = 0;

	public Player(String name) {
		this.name = name;
	}

	public void addScore() {
		score++;
	}

	public int getScore() {
		return score;
	}

	public String getName() {
		return name;
	}

	public int getScoreIfEqual() {
		return score > 3 ? 3 : score;
	}

	public int leadBy(Player opponent) {
		return score - opponent.getScore();
	}

	public boolean isLeadingWith(Player opponent) {
		return score > opponent.getScore();
	}

	public boolean isScoreEqual(Player opponent) {
		return score == opponent.getScore();
	}

	public boolean isLongerGame() {
		return score>=4;
	}
}
