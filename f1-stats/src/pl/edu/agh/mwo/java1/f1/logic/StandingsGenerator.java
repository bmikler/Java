package pl.edu.agh.mwo.java1.f1.logic;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pl.edu.agh.mwo.java1.f1.data.Race;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class StandingsGenerator {

    private List<Race> races;

    public StandingsGenerator(List<Race> races) {
        this.races = races;
    }

    //Przygotuj arkusz o nazwie Standings, który będzie zawierał sumaryczną liczbę punktów zawodników po każdym wyścigu.

    public void createStandingsFile() throws IOException {

        String fileName = "./files/Standings.xlsx";

        Workbook workBook = new XSSFWorkbook();

        Sheet sheet = workBook.createSheet("Standings");

        writeHeader(sheet);

        writeResults(sheet);

        saveFile(fileName, workBook);

        System.out.println("Standings file created!");


    }

    private void saveFile(String fileName, Workbook workBook) throws IOException {

        OutputStream fileOut = new FileOutputStream(fileName);

        workBook.write(fileOut);

    }

    private void writeHeader(Sheet sheet) {

        Row row = sheet.createRow(0);

        Cell cell = row.createCell(0);
        cell.setCellValue("Driver/Race");

        int k = 1;

        for (Race race : races) {

            cell = row.createCell(k);
            cell.setCellValue(race.getName());

            k++;

        }

    }

    private void writeResults(Sheet sheet) {

        int rowNumber = 1;

        for(String driver : getListOfDrivers()) {

            Row row = sheet.createRow(rowNumber);
            writeRow(driver, row);
            rowNumber++;

        }

    }

    private void writeRow(String driver, Row row) {


        row.createCell(0).setCellValue(driver);

        int columnNumber = 1;

        for (Race race : races) {

            int previousScore = 0;

            Cell previousCell = row.getCell(columnNumber -1);

            if (previousCell.getCellType().equals(CellType.NUMERIC))
            {
                previousScore = (int) previousCell.getNumericCellValue();
            }

            int score = race.getScoreForDriver(driver);
            row.createCell(columnNumber).setCellValue(score + previousScore);

            columnNumber++;

        }


    }



    private List<String> getListOfDrivers() {

        return races.stream()
                .flatMap(n -> n.getResults().stream())
                .map(n -> n.getdriverName())
                .distinct()
                .toList();

    }

}
