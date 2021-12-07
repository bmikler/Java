package Hanoi.src;

public class GameBoard {

    private static final int TOWER_NUMBER = 3;

    private Tower[] towers = new Tower[TOWER_NUMBER];

    public GameBoard(int diskNumber) {

        towers[0] = new Tower(diskNumber, true);
        towers[1] = new Tower(diskNumber, false);
        towers[2] = new Tower(diskNumber, false);

    }


    public void moveDisc(int sourceTowerNumber, int targetTowerNumber) {

        Tower sourceTower = towers[sourceTowerNumber];
        Tower targetTower = towers[targetTowerNumber];

        int disk = sourceTower.getTopDiscValue();

        targetTower.addDiskOnTheTop(disk);
        sourceTower.removeDiskFromTheTop();

    }


    public void printView() {

        int towerHeight = towers[0].getHeight();

        for (int floorNumber = 0; floorNumber < towerHeight; floorNumber++) {
            for (int towerNumber = 0; towerNumber < towers.length; towerNumber++) {

                int diskSize = towers[towerNumber].getDiskFromFloor(floorNumber);

                if (diskSize != 0) {
                    System.out.print("*".repeat(diskSize) + " ".repeat(towerHeight - diskSize + 2));
                } else {
                    System.out.print("|" + " ".repeat(towerHeight + 1));
                }
            }
            System.out.println();

        }
        System.out.println();
    }


}
