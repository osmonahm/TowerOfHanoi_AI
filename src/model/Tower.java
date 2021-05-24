package model;

import java.util.EmptyStackException;
import java.util.Stack;

public class Tower
{
    private final char towerName;
    private Stack<Disk> disks;
    
    public Tower( char towerName, Stack<Disk> disks )
    {
        this.disks = disks;
        this.towerName = towerName;
    }
    
    public Tower( char towerName )
    {
        disks = new Stack<>();
        this.towerName = towerName;
    }
    
    public boolean diskSupported( Disk disk )
    {
        if( disks.isEmpty() ) return true;
        else if( disk == null ) return false;
        else return peek().getDiskSize() > disk.getDiskSize();
    }
    
    public void push( Disk disk )
    {
        if( diskSupported( disk ) ) disks.push( disk );
    }
    
    public Stack<Disk> getDisks()
    {
        return disks;
    }
    
    public Disk peek()
    {
        try { return disks.peek(); } catch( EmptyStackException e ) { return null; }
    }
    
    public Disk pop()
    {
        return disks.pop();
    }
    
    public boolean isEmpty()
    {
        return disks.isEmpty();
    }
    
    public boolean equals( Tower otherTower )
    {
        if( disks.size() != otherTower.disks.size() ) return false;
        
        for( int i = 0; i < disks.size(); i++ )
            if( disks.get( i ).getDiskSize() != otherTower.disks.get( i ).getDiskSize() ) return false;
        
        return true;
    }
    
    public char getTowerName()
    {
        return towerName;
    }
    
    public Tower clone()
    {
        Stack<Disk> clonedDisks = new Stack<>();
        clonedDisks.addAll( disks );
        return new Tower( towerName, clonedDisks );
    }
    
    public void printDisks()
    {
        System.out.print( towerName + ": " );
        for( Disk disk : disks )
            System.out.print( disk.getDiskSize() + " " );
        System.out.println();
    }
}