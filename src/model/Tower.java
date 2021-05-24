package model;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * The type Tower.
 */
public class Tower
{
    private final char towerName;
    private Stack<Disk> disks;
    
    /**
     * Instantiates a new Tower.
     *
     * @param towerName the tower name
     * @param disks     the disks
     */
    public Tower( char towerName, Stack<Disk> disks )
    {
        this.disks = disks;
        this.towerName = towerName;
    }
    
    /**
     * Instantiates a new Tower.
     *
     * @param towerName the tower name
     */
    public Tower( char towerName )
    {
        disks = new Stack<>();
        this.towerName = towerName;
    }
    
    /**
     * Disk supported boolean.
     *
     * @param disk the disk
     * @return the boolean
     */
    public boolean diskSupported( Disk disk )
    {
        if( disks.isEmpty() ) return true;
        else if( disk == null ) return false;
        else return peek().getDiskSize() > disk.getDiskSize();
    }
    
    /**
     * Push.
     *
     * @param disk the disk
     */
    public void push( Disk disk )
    {
        if( diskSupported( disk ) ) disks.push( disk );
    }
    
    /**
     * Gets disks.
     *
     * @return the disks
     */
    public Stack<Disk> getDisks()
    {
        return disks;
    }
    
    /**
     * Peek disk.
     *
     * @return the disk
     */
    public Disk peek()
    {
        try { return disks.peek(); } catch( EmptyStackException e ) { return null; }
    }
    
    /**
     * Pop disk.
     *
     * @return the disk
     */
    public Disk pop()
    {
        return disks.pop();
    }
    
    /**
     * Is empty boolean.
     *
     * @return the boolean
     */
    public boolean isEmpty()
    {
        return disks.isEmpty();
    }
    
    /**
     * Equals boolean.
     *
     * @param otherTower the other tower
     * @return the boolean
     */
    public boolean equals( Tower otherTower )
    {
        if( disks.size() != otherTower.disks.size() ) return false;
        
        for( int i = 0; i < disks.size(); i++ )
            if( disks.get( i ).getDiskSize() != otherTower.disks.get( i ).getDiskSize() ) return false;
        
        return true;
    }
    
    /**
     * Gets tower name.
     *
     * @return the tower name
     */
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
    
    /**
     * Print disks.
     */
    public void printDisks()
    {
        System.out.print( towerName + ": " );
        for( Disk disk : disks )
            System.out.print( disk.getDiskSize() + " " );
        System.out.println();
    }
}