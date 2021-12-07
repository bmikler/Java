
import java.util.Scanner;

public class HanoiTowersApp {

    static final int SOURCE_TOWER = 0;
    static final int BUFFER_TOWER = 1;
    static final int TARGET_TOWER = 2;

    static GameBoard GAMEBOARD;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Prompt number of disks:");

        int diskNumber = scanner.nextInt();

        GAMEBOARD = new GameBoard(diskNumber);

        GAMEBOARD.printView();
        solvePuzzle(diskNumber, SOURCE_TOWER, BUFFER_TOWER, TARGET_TOWER);

        System.out.println("Solved!");


    }

    static void solvePuzzle(int diskNumbers, int sourceTower, int bufferTower, int targetTower) {
        if (diskNumbers == 1) {
            GAMEBOARD.moveDisc(sourceTower, targetTower);
            GAMEBOARD.printView();
            return;
        } else {
            solvePuzzle(diskNumbers - 1,sourceTower, targetTower, bufferTower);
            GAMEBOARD.moveDisc(sourceTower, targetTower);
            solvePuzzle(diskNumbers - 1, bufferTower, sourceTower, targetTower);
        }

    }


}
