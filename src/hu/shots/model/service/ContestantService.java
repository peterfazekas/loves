package hu.shots.model.service;

import hu.shots.model.domain.Contestant;

public class ContestantService {

	private final Contestant contestant;

	public ContestantService(Contestant contestant) {
		this.contestant = contestant;
	}
	
	public boolean hasTwoSuccedShotInLine() {
		return getShotResult().contains("++");
	}
	
	public int getId() {
		return contestant.getId();
	}
	
	
	private String getShotResult() {
		return contestant.getShotResult();
	}
	
}
