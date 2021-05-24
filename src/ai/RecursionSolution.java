package ai;

public class RecursionSolution
{
    public void towerOfHanoi( int n, char start, char end, char aux )
    {
        
        if( n == 1 )
        {
            System.out.println( "Move disk 1 from tower " + start + " to tower " + end );
            return;
        }
        
        towerOfHanoi( n - 1, start, aux, end );
        System.out.println( "Move disk " + n + " from tower " + start + " to tower " + end );
        towerOfHanoi( n - 1, aux, end, start );
    }
}