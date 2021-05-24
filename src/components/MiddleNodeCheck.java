package components;

public class MiddleNodeCheck
{
    private final int minMovesOnMiddle;
    
    public MiddleNodeCheck( int numOfDisks )
    {
        minMovesOnMiddle = ( ( int ) Math.pow( 2, numOfDisks ) - 1 ) / 2;
    }
    
    public boolean checkNode( Node leftNode, Node rightNode )
    {
        if( leftNode.getCost() >= minMovesOnMiddle && rightNode.getCost() >= minMovesOnMiddle )
            return leftNode.equals( rightNode );
        return false;
    }
}