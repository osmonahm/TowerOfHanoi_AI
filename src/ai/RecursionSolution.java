package ai;

/**
 * The type Recursion solution.
 */
public class RecursionSolution
{
    private int cost = 0;
    
    /**
     * Tower of hanoi.
     *
     * @param n     the n
     * @param start the start
     * @param end   the end
     * @param aux   the aux
     */
    public void towerOfHanoi( int n, char start, char end, char aux )
    {
        if( n == 1 )
        {
            System.out.println( "Move disk 1 from tower " + start + " to tower " + end );
            cost++;
            return;
        }
        
        towerOfHanoi( n - 1, start, aux, end );
        System.out.println( "Move disk " + n + " from tower " + start + " to tower " + end );
        cost++;
        towerOfHanoi( n - 1, aux, end, start );
    }
    
    /**
     * Gets cost.
     *
     * @return the cost
     */
    public int getCost()
    {
        return cost;
    }
}