package ai;

import components.MiddleNodeCheck;
import components.Node;
import model.Disk;
import model.Tower;

import java.util.LinkedList;

public class Agent
{
    private static final int LEFT = 0;
    private static final int RIGHT = 1;
    private final int numOfDisks;
    private final Tower leftATower, leftBTower, leftCTower, rightATower, rightBTower, rightCTower;
    
    private final MiddleNodeCheck checker;
    private LinkedList<Node> leftFrontier;
    private LinkedList<Node> exploredLeft;
    private LinkedList<Node> exploredRight;
    private LinkedList<Node> rightFrontier;
    
    public Agent( int numOfDisks )
    {
        this.numOfDisks = numOfDisks;
        leftATower = new Tower( 'A' );
        leftBTower = new Tower( 'B' );
        leftCTower = new Tower( 'C' );
        
        rightATower = new Tower( 'A' );
        rightBTower = new Tower( 'B' );
        rightCTower = new Tower( 'C' );
        
        for( int i = numOfDisks; i > 0; i-- )
        {
            leftATower.push( new Disk( i ) );
            rightCTower.push( new Disk( i ) );
        }
        
        checker = new MiddleNodeCheck( numOfDisks );
    }
    
    public Node[] solve()
    {
        leftFrontier = new LinkedList<>();
        exploredLeft = new LinkedList<>();
        
        exploredRight = new LinkedList<>();
        rightFrontier = new LinkedList<>();
        
        leftFrontier.add( new Node( leftATower, leftBTower, leftCTower, null, 0 ) );
        rightFrontier.add( new Node( rightATower, rightBTower, rightCTower, null, 0 ) );
        
        while( true )
        {
            if( leftFrontier.isEmpty() ) return null;
            
            LinkedList<Node> leftParents = new LinkedList<>( leftFrontier );
            exploredLeft.addAll( leftFrontier );
            leftFrontier.clear();
            
            while( !leftParents.isEmpty() ) childNodes( leftParents.poll(), LEFT );
            
            //Check for middle State
            for( Node leftNode : leftFrontier )
                for( Node rightNode : rightFrontier )
                    if( GoalTest( leftNode, rightNode ) )
                        return new Node[]{ leftNode, rightNode };
            
            if( rightFrontier.isEmpty() ) return null;
            
            LinkedList<Node> rightParents = new LinkedList<>( rightFrontier );
            exploredRight.addAll( rightFrontier );
            rightFrontier.clear();
            
            while( !rightParents.isEmpty() ) childNodes( rightParents.poll(), RIGHT );
        }
    }
    
    public boolean GoalTest( Node leftSideNode, Node rightSideNode )
    {
        return checker.checkNode( leftSideNode, rightSideNode );
    }
    
    public void childNodes( Node parent, int side )
    {
        Node clonedParent = parent.clone();
        
        LinkedList<Node> frontier;
        
        if( side == LEFT ) frontier = leftFrontier;
        else if( side == RIGHT ) frontier = rightFrontier;
        else return;
        
        Node child1 = clonedParent.moveDisk( clonedParent.getBTower(), clonedParent.getATower() );
        clonedParent = parent.clone();
        Node child2 = clonedParent.moveDisk( clonedParent.getBTower(), clonedParent.getCTower() );
        clonedParent = parent.clone();
        Node child3 = clonedParent.moveDisk( clonedParent.getCTower(), clonedParent.getATower() );
        clonedParent = parent.clone();
        Node child4 = clonedParent.moveDisk( clonedParent.getCTower(), clonedParent.getBTower() );
        clonedParent = parent.clone();
        Node child5 = clonedParent.moveDisk( clonedParent.getATower(), clonedParent.getBTower() );
        clonedParent = parent.clone();
        Node child6 = clonedParent.moveDisk( clonedParent.getATower(), clonedParent.getCTower() );
        
        if( child1 != null && !stateExploredOrAdded( child1, side ) ) frontier.add( child1 );
        if( child2 != null && !stateExploredOrAdded( child2, side ) ) frontier.add( child2 );
        if( child3 != null && !stateExploredOrAdded( child3, side ) ) frontier.add( child3 );
        if( child4 != null && !stateExploredOrAdded( child4, side ) ) frontier.add( child4 );
        if( child5 != null && !stateExploredOrAdded( child5, side ) ) frontier.add( child5 );
        if( child6 != null && !stateExploredOrAdded( child6, side ) ) frontier.add( child6 );
    }
    
    public boolean stateExploredOrAdded( Node state, int side )
    {
        LinkedList<Node> frontier;
        LinkedList<Node> explored;
        
        if( side == LEFT )
        {
            frontier = leftFrontier;
            explored = exploredLeft;
        }
        else if( side == RIGHT )
        {
            frontier = rightFrontier;
            explored = exploredRight;
        }
        else return true;
        
        //State comparison - frontier
        for( Node node : frontier )
            if( node.equals( state ) ) return true;
        
        //State comparison explored
        for( Node node : explored )
            if( node.equals( state ) ) return true;
        
        return false;
    }
}