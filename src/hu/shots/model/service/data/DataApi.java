package hu.shots.model.service.data;

import java.util.List;

import hu.shots.model.domain.Contestant;
import hu.shots.model.service.ScoreService;

public class DataApi {
	
	private final ShotDataReader file;
	private final ContestantParser data;
	
	public DataApi(ShotDataReader file) {
		this.file = file;
		data = new ContestantParser(new ScoreService());
	}
	
	public List<Contestant> getData(final String input) {
		return data.parse(file.read(input));
	}
	
	

}
