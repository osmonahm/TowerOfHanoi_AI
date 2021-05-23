package controller;

import model.Disk;
import model.Tower;

import java.util.ArrayList;
import java.util.Stack;

public class Controller
{
    private Stack<Disk> disks = new Stack<>();
    private int diskNum = 5;
    private Disk selectedDisk;
    private Tower towerA, towerB, towerC;
    
    public Controller()
    {
        for( int i = diskNum; i >= 1; i-- )
            disks.add( new Disk( i ) );
        
        towerA = new Tower( 'A', disks );
        towerB = new Tower('B');
        towerC = new Tower('C');
    }
    
    public void moveDisk( Tower srcTower, Tower dstTower )
    {
        if( srcTower.isEmpty() )
        {
            System.out.println( "Empty Rod. Invalid move" );
        }
        else if( dstTower.diskSupported( srcTower.peek() ) )
        {
            System.out.println( "Disk moved: " + srcTower.peek().getDiskSize() + " => " );
            dstTower.push( srcTower.pop() );
        }
        else
        {
            System.out.println( "Disk not moved." );
        }
    }
    
    public void printRods()
    {
        System.out.print( "A : " );
        
        for( Disk disk : towerA.getDisks() )
            System.out.print( disk.getDiskSize() + " " );
        
        System.out.println();
        System.out.print( "B : " );
        
        for( Disk disk : towerB.getDisks() )
            System.out.print( disk.getDiskSize() + " " );
        
        System.out.println();
        System.out.print( "C : " );
        
        for( Disk disk : towerC.getDisks() )
            System.out.print( disk.getDiskSize() + " " );
        
        System.out.println();
    }
    
    public Tower getTowerA() { return towerA; }
    public Tower getTowerB() { return towerB; }
    public Tower getTowerC() { return towerC; }
}