package ai;

import components.Node;
import model.Disk;
import model.Tower;

import java.util.LinkedList;

public class BFSAgent
{
    private final int numOfDisks;
    private final Tower ATower, BTower, CTower, goalATower, goalBTower, goalCTower;
    
    private final Node goalNode;
    private final LinkedList<Node> frontier, explored;
    
    public BFSAgent( int numOfDisks )
    {
        this.numOfDisks = numOfDisks;
        ATower = new Tower( 'A' );
        BTower = new Tower( 'B' );
        CTower = new Tower( 'C' );
        
        goalATower = new Tower( 'A' );
        goalBTower = new Tower( 'B' );
        goalCTower = new Tower( 'C' );
    
        frontier = new LinkedList<>();
        explored = new LinkedList<>();
        
        for( int i = numOfDisks; i > 0; i-- )
        {
            ATower.push( new Disk( i ) );
            goalCTower.push( new Disk( i ) );
        }
    
        goalNode = new Node( goalATower, goalBTower, goalCTower, null, 0 );
    }
    
    public Node solve()
    {
        frontier.add( new Node( ATower, BTower, CTower, null, 0 ) );
        
        while( true )
        {
            if( frontier.isEmpty() ) return null;
            
            LinkedList<Node> parents = new LinkedList<>( frontier );
            explored.addAll( frontier );
            frontier.clear();
            
            while( !parents.isEmpty() )
                childNodes( parents.poll() );
    
            for( Node node : frontier )
                if( goalTest( node ) ) return node;
        }
    }
    
    public boolean goalTest( Node currentNode )
    {
        return currentNode.equals( goalNode );
    }
    
    public void childNodes( Node parent )
    {
        Node clonedParent = parent.clone();
        
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
        
        if( child1 != null && !stateExploredOrAdded( child1 ) ) frontier.add( child1 );
        if( child2 != null && !stateExploredOrAdded( child2 ) ) frontier.add( child2 );
        if( child3 != null && !stateExploredOrAdded( child3 ) ) frontier.add( child3 );
        if( child4 != null && !stateExploredOrAdded( child4 ) ) frontier.add( child4 );
        if( child5 != null && !stateExploredOrAdded( child5 ) ) frontier.add( child5 );
        if( child6 != null && !stateExploredOrAdded( child6 ) ) frontier.add( child6 );
    }
    
    public boolean stateExploredOrAdded( Node state )
    {
        //State comparision - frontier
        for( Node node : frontier )
            if( node.equals( state ) ) return true;
        
        //State comparision explored
        for( Node node : explored )
            if( node.equals( state ) ) return true;
        
        return false;
    }
}