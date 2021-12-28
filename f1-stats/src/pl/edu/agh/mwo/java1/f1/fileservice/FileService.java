package pl.edu.agh.mwo.java1.f1.fileservice;

import org.apache.poi.ss.usermodel.*;
import pl.edu.agh.mwo.java1.f1.data.Race;
import pl.edu.agh.mwo.java1.f1.data.Result;

import java.io.File;;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class FileService {

    private final static int DRIVER_NAME = 2;
    private final static int TEAM = 3;
    private final static int SCORE = 5;


    public List<Race> readFileToList(String filename) throws IOException {

        List<Race> races = new LinkedList<>();

        Workbook workbook = WorkbookFactory.create(new File(filename));

        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {

            Sheet sheet = workbook.getSheetAt(i);

            races.add(readRaceFromFile(sheet));

        }

        return races;

    }


    private Race readRaceFromFile(Sheet sheet) {

        String name = sheet.getSheetName();
        LinkedList<Result> results = new LinkedList<>();

        Row row;
        int i = 0;

        while ((row = sheet.getRow(i)) != null) {

            results.add(readRow(row));
            i++;

        }

        return new Race(name, results);

    }


    private Result readRow(Row row) {

        String driverName = row.getCell(DRIVER_NAME).getStringCellValue();

        String team = row.getCell(TEAM).getStringCellValue();

        int score = Integer.parseInt(row.getCell(SCORE).getStringCellValue());

        return new Result(driverName, team, score);

    }

}
