package components;

/**
 * The type Middle node check.
 */
public class MiddleNodeCheck
{
    private final int minMovesOnMiddle;
    
    /**
     * Instantiates a new Middle node check.
     *
     * @param numOfDisks the num of disks
     */
    public MiddleNodeCheck( int numOfDisks )
    {
        minMovesOnMiddle = ( ( int ) Math.pow( 2, numOfDisks ) - 1 ) / 2;
    }
    
    /**
     * Check node boolean.
     *
     * @param leftNode  the left node
     * @param rightNode the right node
     * @return the boolean
     */
    public boolean checkNode( Node leftNode, Node rightNode )
    {
        if( leftNode.getCost() >= minMovesOnMiddle && rightNode.getCost() >= minMovesOnMiddle )
            return leftNode.equals( rightNode );
        return false;
    }
}