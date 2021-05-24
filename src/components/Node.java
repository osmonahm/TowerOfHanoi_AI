package components;

import model.Tower;

import java.util.Stack;

/**
 * The type Node.
 */
public class Node
{
    private final Tower ATower;
    private final Tower BTower;
    private final Tower CTower;
    private Node parent;
    private int cost;
    
    /**
     * Instantiates a new Node.
     *
     * @param ATower the a tower
     * @param BTower the b tower
     * @param CTower the c tower
     * @param parent the parent
     * @param cost   the cost
     */
    public Node( Tower ATower, Tower BTower, Tower CTower, Node parent, int cost )
    {
        this.ATower = ATower;
        this.BTower = BTower;
        this.CTower = CTower;
        this.parent = parent;
        this.cost = cost;
    }
    
    /**
     * Gets a tower.
     *
     * @return the a tower
     */
    public Tower getATower() { return ATower; }
    
    /**
     * Gets b tower.
     *
     * @return the b tower
     */
    public Tower getBTower() { return BTower; }
    
    /**
     * Gets c tower.
     *
     * @return the c tower
     */
    public Tower getCTower() { return CTower; }
    
    /**
     * Gets parent.
     *
     * @return the parent
     */
    public Node getParent() { return parent; }
    
    /**
     * Gets cost.
     *
     * @return the cost
     */
    public int getCost() { return cost; }
    
    /**
     * Move disk node.
     *
     * @param srcTower the src tower
     * @param dstTower the dst tower
     * @return the node
     */
    public Node moveDisk( Tower srcTower, Tower dstTower )
    {
        if( srcTower.isEmpty() || !dstTower.diskSupported( srcTower.peek() ) ) return null;
        else
        {
            dstTower.push( srcTower.pop() );
            return new Node( ATower, BTower, CTower, this, cost + 1 );
        }
    }
    
    /**
     * Equals boolean.
     *
     * @param another the another
     * @return the boolean
     */
    public boolean equals( Node another )
    {
        return getATower().equals( another.getATower() ) && getBTower().equals( another.getBTower() ) && getCTower().equals( another.getCTower() );
    }
    
    public Node clone()
    {
        return new Node( ATower.clone(), BTower.clone(), CTower.clone(), parent, cost );
    }
    
    /**
     * Print towers.
     */
    public void printTowers()
    {
        ATower.printDisks();
        BTower.printDisks();
        CTower.printDisks();
        System.out.println();
    }
    
    /**
     * Print moves.
     */
    public void printMoves()
    {
        Node parent = this.parent;
        while( parent != null )
        {
            parent.printTowers();
            parent = parent.getParent();
        }
    }
    
    /**
     * Print recursive moves.
     */
    public void printRecursiveMoves()
    {
        Node parent = this.parent;
        Stack<Node> moves = new Stack<>();
        while( parent != null )
        {
            moves.push( parent );
            parent = parent.getParent();
        }
        
        while( !moves.isEmpty() )
            moves.pop().printTowers();
    }
}