package hu.shots.model.domain;

public class Contestant {
	
	private final int id;
	private final String shotResult;
	private final Integer score;
	
	public Contestant(int id, String shotResult, Integer score) {
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

	public Integer getScore() {
		return score;
	}

	@Override
	public String toString() {
		return "Contestant [id=" + id + ", shotResult=" + shotResult + ", score=" + score + "]";
	}

	
}
