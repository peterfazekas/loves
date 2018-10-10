package hu.shots;

import hu.shots.controller.ContestFacade;
import hu.shots.model.service.data.DataApi;
import hu.shots.model.service.data.FileDataReader;

public class App {

	private final ContestFacade contest;
	
	public App() {
		DataApi data = new DataApi(new FileDataReader());
		contest = new ContestFacade(data.getData("verseny.txt"));
	}


	public static void main(String[] args) {
		App app = new App();
		app.run();
	}


	private void run() {
		System.out.println("2. feladat: " + contest.getTwoSuccedShotInLineId());
	}

}
