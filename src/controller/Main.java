package controller;

public class Main
{
    public static void main( String[] args )
    {
        Controller c = new Controller();
        c.moveDisk( c.getTowerA(), c.getTowerC() );
        c.printRods();
        c.moveDisk( c.getTowerA(), c.getTowerC() );
        c.printRods();
        c.moveDisk( c.getTowerB(), c.getTowerC() );
        c.printRods();
        c.moveDisk( c.getTowerC(), c.getTowerB() );
        c.printRods();
        c.moveDisk( c.getTowerC(), c.getTowerA() );
        c.printRods();
        c.moveDisk( c.getTowerA(), c.getTowerC() );
        c.printRods();
        c.moveDisk( c.getTowerC(), c.getTowerB() );
        c.printRods();
        c.moveDisk( c.getTowerB(), c.getTowerC() );
        c.printRods();
    }
}