package components;

public class MiddleNodeChecker {

    private final int minMoves;
    private final int minMovesOnMiddle;

    public MiddleNodeChecker(int numOfDisks){
        minMoves = (int) Math.pow(2, numOfDisks) - 1;
        minMovesOnMiddle = minMoves / 2;
    }


    public boolean checkNode(Node leftNode, Node rightNode){
        if(leftNode.getCost() >= minMovesOnMiddle && rightNode.getCost() >= minMovesOnMiddle)
            return leftNode.equals(rightNode);
        return false;
    }

    public boolean goalCheck(Node currentNode, Node goalNode){
        return currentNode.equals(goalNode);
    }

}
