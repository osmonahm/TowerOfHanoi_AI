package controller;

public class Main {
    public static void main(String[] args) {

        GameController gc = new GameController();
        gc.moveDisk('A', 'C');
        gc.printRods();
        gc.moveDisk('A', 'C');
        gc.printRods();
        gc.moveDisk('B', 'C');
        gc.printRods();
        gc.moveDisk('C', 'B');
        gc.printRods();
        gc.moveDisk('C', 'A');
        gc.printRods();
        gc.moveDisk('A', 'C');
        gc.printRods();
        gc.moveDisk('C', 'B');
        gc.printRods();
        gc.moveDisk('B', 'C');
        gc.printRods();

    }
}
