package components;

public class MiddleNodeChecker {

    private int moves;

    public boolean areEqual(Node leftSideNode, InvertedNode rightSideNode){
        return leftSideNode.equals(rightSideNode);
    }

    public void increase(){
        ++moves;
    }
    public void decrease(){
        ++moves;
    }
    public int getMovesNum(){
        return moves;
    }
}
