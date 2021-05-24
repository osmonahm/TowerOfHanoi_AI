package ai;

import components.Node;

public class Main
{
    private static int numOfDisks;
    
    public static void main( String[] args )
    {
        numOfDisks = 3;
        BidirectionalAlgorithm();
        BFSAlgorithm();
        RecursiveAlgorithm();
    }
    
    public static void BidirectionalAlgorithm()
    {
        System.out.println( "Bidirectional Algorithm!\n" );
        
        long start = System.currentTimeMillis();
        
        // Printing the initial state
        System.out.print( "A: " );
        for( int i = numOfDisks; i >= 1; i-- )
            System.out.print( i + " " );
        System.out.println( "\nB: \nC:\n" );
    
        Agent agent = new Agent( numOfDisks );
        Node[] solution = agent.solve();
        solution[0].printRecursiveMoves();
    
        System.out.println( "middle state\n" );
    
        solution[1].printMoves();
        System.out.println( "Cost = " + ( solution[0].getCost() + solution[1].getCost() ) );
    
        long end = System.currentTimeMillis();
        long elapsedTime = end - start;
        System.out.println( "Elapsed time = " + elapsedTime + " ms" );
    }
    
    public static void BFSAlgorithm()
    {
        System.out.println( "\nBFS Algorithm!\n" );
        numOfDisks = 4;
        long start = System.currentTimeMillis();
        
        // Printing the initial state
        System.out.print( "A: " );
        for( int i = numOfDisks; i >= 1; i-- )
            System.out.print( i + " " );
        System.out.println( "\nB: \nC:\n" );
    
        BFSAgent a = new BFSAgent( numOfDisks );
        Node s = a.solve();
        s.printRecursiveMoves();
        System.out.println( "Cost = " + s.getCost() );
        long end = System.currentTimeMillis();
        long elapsedTime = end - start;
        System.out.println( "Elapsed time = " + elapsedTime + " ms" );
    }
    
    public static void RecursiveAlgorithm()
    {
        System.out.println( "\nRecursive Algorithm!\n" );
        
        long start = System.currentTimeMillis();
        
        RecursionSolution rs = new RecursionSolution();
        rs.towerOfHanoi( numOfDisks, 'A', 'C', 'B' );
    
        long end = System.currentTimeMillis();
        long elapsedTime = end - start;
        System.out.println( "Elapsed time = " + elapsedTime + " ms" );
    }
}