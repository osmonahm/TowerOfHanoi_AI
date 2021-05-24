package ai;

public class RecursionSolution
{
    private int cost = 0;
    
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
    
    public int getCost()
    {
        return cost;
    }
}