package hu.shots.model.service;

import java.util.Arrays;

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
	
	public int getShotLength() {
		return contestant.getShotResult().length();
	}
	
	public String getSuccessShotIndexes() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < getShotLength(); i++) {
			if (getShotResult().charAt(i) == '+') {
				sb.append((i + 1) + " ");
			}
		}
		return sb.toString();
	}
	
	public long getSuccessShotCount() {
		return getShotResult().chars()
				.filter(i -> (char) i == '+')
				.count();
	}
	
	public int getLongestSuccessSequent() {
		return Arrays.stream(getShotResult().split("-"))
				.mapToInt(i -> i.length())
				.max()
				.getAsInt();
	}
	
	private String getShotResult() {
		return contestant.getShotResult();
	}
	
}
