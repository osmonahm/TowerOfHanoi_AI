package model;

import java.util.EmptyStackException;
import java.util.Stack;

public class Tower
{
    private Stack<Disk> disks;
    
    public Tower( Stack<Disk> disks )
    {
        this.disks = disks;
    }
    
    public Tower()
    {
        disks = new Stack<>();
    }
    
    public boolean diskSupported( Disk disk )
    {
        return disks.isEmpty() || peek().getDiskSize() > disk.getDiskSize();
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

    public boolean equals(Tower otherRod){
        if(disks.size() != otherRod.disks.size())
            return false;

        for(int i = 0; i < disks.size(); i++)
            if(disks.get(i).getDiskSize() != otherRod.disks.get(i).getDiskSize())
                return false;

        return true;
    }
}
