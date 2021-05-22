package model;

import java.util.EmptyStackException;
import java.util.Stack;

public class Rod
{
    
    private final char rodName;
    private Stack<Disk> disks;
    
    public Rod( char rodName, int diskNum )
    {
        this.rodName = rodName;
        disks = new Stack<>();
        
        for( int i = diskNum; i >= 1; i-- )
            disks.add( new Disk( i ) );
        
    }
    
    public Rod( char rodName )
    {
        this.rodName = rodName;
        disks = new Stack<>();
    }
    
    public boolean diskSupported( Disk disk )
    {
        return disks.isEmpty() || peek().getDiskSize() > disk.getDiskSize();
    }
    
    public void add( Disk disk )
    {
        if( diskSupported( disk ) ) disks.add( disk );
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
    
    public char getRodName()
    {
        return rodName;
    }
    
    public boolean isEmpty()
    {
        return disks.isEmpty();
    }
}
