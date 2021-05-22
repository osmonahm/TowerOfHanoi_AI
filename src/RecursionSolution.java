public class RecursionSolution
{
    public static void main( String args[] )
    {
        int n = 3;
        TowerOfHanoi( n, 'A', 'C', 'B' );
    }
    
    public static void TowerOfHanoi( int n, char start, char end, char aux )
    {
        
        if( n == 1 )
        {
            System.out.println( "Move disk 1 from rod " + start + " to rod " + end );
            return;
        }
        
        TowerOfHanoi( n - 1, start, aux, end );
        System.out.println( "Move disk " + n + " from rod " + start + " to rod " + end );
        TowerOfHanoi( n - 1, aux, end, start );
    }
}