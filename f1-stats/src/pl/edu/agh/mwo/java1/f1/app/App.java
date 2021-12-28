package pl.edu.agh.mwo.java1.f1.app;

import pl.edu.agh.mwo.java1.f1.fileservice.FileService;
import pl.edu.agh.mwo.java1.f1.data.Race;
import pl.edu.agh.mwo.java1.f1.logic.F1Statistics;
import pl.edu.agh.mwo.java1.f1.logic.StandingsGenerator;

import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) {

        String fileName = "./files/f1-results.xlsx";
        FileService fileService = new FileService();

        try {
            List<Race> races = fileService.readFileToList(fileName);

            F1Statistics stats = new F1Statistics(races);

            stats.printStats();

            StandingsGenerator standings = new StandingsGenerator(races);
            standings.createStandingsFile();


        } catch (IOException e) {
            System.err.println("File not found!");
            e.printStackTrace();
        }

    }

}
