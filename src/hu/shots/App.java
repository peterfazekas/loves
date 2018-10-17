package hu.shots;

import hu.shots.controller.ContestFacade;
import hu.shots.model.service.data.Console;
import hu.shots.model.service.data.DataApi;
import hu.shots.model.service.data.FileDataReader;
import hu.shots.model.service.data.FileDataWriter;

public class App {

	private final ContestFacade contest;
	private final Console console;
	private final FileDataWriter dataWriter;
	
	public App() {
		DataApi data = new DataApi(new FileDataReader());
		contest = new ContestFacade(data.getData("verseny.txt"));
		console = new Console();
		dataWriter = new FileDataWriter("sorrend.txt");
	}

	public static void main(String[] args) {
		App app = new App();
		app.run();
	}

	private void run() {
		System.out.println("2. feladat: " + contest.getTwoSuccedShotInLineId());
		System.out.println("3. feladat: " + contest.getMaximumNumberOfShotsId());
		int id = console.readInt("5. feladat: Adjon meg egy rajtszámot: ");
		System.out.println("5.a feladat: Célt érő lövések: " + contest.getSuccessShotIndexes(id));
		System.out.println("5.b feladat: Az eltalált korongok száma: " + contest.getSuccessShotCount(id));
		System.out.println("5.c feladat: A leghosszabb hibátlan sorozat hossza: " + contest.getLongestSuccessSequent(id));
		System.out.println("5.d feladat: A versenyző pontszáma: "+ contest.getContestantScore(id));
		dataWriter.printAll(contest.getOrder());
	}

}
