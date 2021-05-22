package components;

import model.Disk;
import model.Tower;

public class Node
{
    private final Tower srcTower;
    private final Tower dstTower;
    private final Node parent;
    
    public Node( Tower srcTower, Tower dstTower, Node parent )
    {
        this.srcTower = srcTower;
        this.dstTower = dstTower;
        this.parent = parent;
    }
    
    public Tower getSrcTower()
    {
        return srcTower;
    }
    
    public Tower getDstTower()
    {
        return dstTower;
    }
    
    public Tower getParent()
    {
        return parent;
    }
}