package hu.shots.controller;

import java.util.List;
import java.util.stream.Collectors;

import hu.shots.model.domain.Contestant;
import hu.shots.model.service.ContestantService;

public class ContestFacade {

	private static final String NEW_LINE = "\r\n";
	private static final char TAB = (char) 9;
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
	public int getLongestSuccessSequent(final int id) {
		Contestant contestant = getContestant(id);
		return new ContestantService(contestant).getLongestSuccessSequent();	
	}
	
	public String getOrder() {
		contestants.sort((j, i) -> i.getScore().compareTo(j.getScore()));
		StringBuilder sb = new StringBuilder();
		int prevScore = 0, prevPos = 0;
		for (int i = 0; i < contestants.size(); i++) {
			int score = contestants.get(i).getScore();
			int pos = prevScore == score ? prevPos : i + 1;
			sb.append(pos)
			.append(TAB)
			.append(contestants.get(i).getId())
			.append(TAB)
			.append(score)
			.append(NEW_LINE);
			prevScore = score;
			prevPos = pos;
		}
		return sb.toString();
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
