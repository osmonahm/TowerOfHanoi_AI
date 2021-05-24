package model;

/**
 * The type Disk.
 */
public class Disk
{
    private final int size;
    
    /**
     * Instantiates a new Disk.
     *
     * @param size the size
     */
    public Disk( int size ) { this.size = size; }
    
    /**
     * Gets disk size.
     *
     * @return the disk size
     */
    public int getDiskSize() { return size; }
}