package hu.shots.model.service.data;

import java.util.List;
import java.util.stream.Collectors;

import hu.shots.model.domain.Contestant;
import hu.shots.model.service.ScoreService;

public class ContestantParser {
	
	private final ScoreService scoreService;
	private int id;
	
	public ContestantParser(ScoreService scoreService) {
		this.scoreService = scoreService;
	}

	public List<Contestant> parse(List<String> lines) {
		lines.remove(0);
		return lines.stream().map(this::createContestant).collect(Collectors.toList());
		
	}

	private Contestant createContestant(String line) {
		return new Contestant(++id, line, scoreService.getScore(line));
	}
}
