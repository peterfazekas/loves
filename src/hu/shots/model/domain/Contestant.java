package hu.shots.model.domain;

public class Contestant {
	
	private final int id;
	private final String shotResult;
	private final int score;
	
	public Contestant(int id, String shotResult, int score) {
		this.id = id;
		this.shotResult = shotResult;
		this.score = score;
	}

	public int getId() {
		return id;
	}

	public String getShotResult() {
		return shotResult;
	}

	public int getScore() {
		return score;
	}

	@Override
	public String toString() {
		return "Contestant [id=" + id + ", shotResult=" + shotResult + ", score=" + score + "]";
	}

	
}
