package Hanoi.src;

import java.util.NoSuchElementException;

public class Tower {

    private int[] floors;

    public Tower(int diskNumber, boolean withDisks) {

        floors = new int[diskNumber];

        if (withDisks) {
            fillWithDisks(diskNumber);
        }
    }

    private void fillWithDisks(int diskNumber) {
        int diskSize = 1;

        for (int i = 0; i < diskNumber; i++) {
            floors[i] = diskSize;
            diskSize++;
        }
    }

    public int getHeight() {
        return floors.length;
    }

    public int getDiskFromFloor(int floorNumber) {
        return floors[floorNumber];
    }

    public void removeDiskFromTheTop() {
        floors[getTopDiscIndex()] = 0;
    }

    public void addDiskOnTheTop(int disk) {
        floors[getFirstEmptyFloorIndex()] = disk;
    }

    public int getTopDiscValue() {

        return floors[getTopDiscIndex()];
    }

    public int getTopDiscIndex() {

        for (int i = 0; i < floors.length; i++) {
            if (floors[i] != 0) {
                return i;
            }

        }

        throw new NoSuchElementException();
    }

    public int getFirstEmptyFloorIndex() {

        for (int i = floors.length - 1 ; i >= 0; i--) {
            if (floors[i] == 0) {
                return i;
            }
        }

        throw new NoSuchElementException();
    }


}
