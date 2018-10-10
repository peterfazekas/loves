package hu.shots.controller;

import java.util.List;
import java.util.stream.Collectors;

import hu.shots.model.domain.Contestant;
import hu.shots.model.service.ContestantService;

public class ContestFacade {

	private final List<Contestant> contestants;

	public ContestFacade(List<Contestant> contestants) {
		this.contestants = contestants;
	}
	
	public String getTwoSuccedShotInLineId() {
		return contestants.stream()
				.map(ContestantService::new)
				.filter(ContestantService::hasTwoSuccedShotInLine)
				.map(ContestantService::getId)
				.map(Object::toString)
				.collect(Collectors.joining(" "));
	}
	
	public String getAll() {
		return contestants.stream().map(i -> i.toString()).collect(Collectors.joining());
	}
	
}
