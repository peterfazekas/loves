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
	
	public int getMaximumNumberOfShotsId() {
		return contestants.stream()
				.map(ContestantService::new)
				.filter(i -> i.getShotLength() == getMaximumNumberOfShots())
				.findAny()
				.map(ContestantService::getId)
				.get();
	}
	
	public int getContestantScore(final int id) {
		return getContestant(id).getScore();
	}
	
	public String getSuccessShotIndexes(final int id) {
		Contestant contestant = getContestant(id);
		return new ContestantService(contestant).getSuccessShotIndexes();
	}
	
	public long getSuccessShotCount(final int id) {
		Contestant contestant = getContestant(id);
		return new ContestantService(contestant).getSuccessShotCount();
	}

	private int getMaximumNumberOfShots() {
		return contestants.stream()
				.map(ContestantService::new)
				.mapToInt(ContestantService::getShotLength)
				.max()
				.getAsInt();
	}
	
	private Contestant getContestant(final int id) {
		return contestants.stream()
				.filter(i -> i.getId() == id)
				.findAny()
				.get();
	}
	
}
