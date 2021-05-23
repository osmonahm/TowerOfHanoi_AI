package ai;

import components.MiddleNodeChecker;
import components.Node;
import model.Disk;
import model.Tower;

import java.util.LinkedList;

public class Agent {

    private final int numOfDisks;

    private static final int LEFT = 0;
    private static final int RIGHT = 1;

    private Tower leftATower, leftBTower, leftCTower, rightATower, rightBTower, rightCTower;

    private MiddleNodeChecker checker;
    private LinkedList<Node> leftFrontier;
    private LinkedList<Node> exploredLeft;
    private LinkedList<Node> exploredRight;
    private LinkedList<Node> rightFrontier;

    public Agent(int numOfDisks){
        this.numOfDisks = numOfDisks;
        leftATower = new Tower('A');
        leftBTower = new Tower('B');
        leftCTower = new Tower('C');

        rightATower = new Tower('A');
        rightBTower = new Tower('B');
        rightCTower = new Tower('C');

        for (int i = numOfDisks; i > 0 ; i--) {
            leftATower.push(new Disk(i));
            rightCTower.push(new Disk(i));
        }

        checker = new MiddleNodeChecker(numOfDisks);

    }

    public Node solve(){
        int moves = 1;
        leftFrontier = new LinkedList<>();
        exploredLeft = new LinkedList<>();

        exploredRight = new LinkedList<>();
        rightFrontier = new LinkedList<>();

        leftFrontier.add(new Node(leftATower, leftBTower, leftCTower, null, 0));
        rightFrontier.add(new Node(rightATower, rightBTower, rightCTower, null, 0));

        while(true){
            if(leftFrontier.isEmpty()) {
              //  System.out.println("Left Side");
                return null;
            }
            LinkedList<Node> leftParents = new LinkedList<>(leftFrontier);
            exploredLeft.addAll(leftFrontier);
            leftFrontier.clear();

            while(!leftParents.isEmpty()) {
              //  System.out.println("Exploring Left Parents");
                childNodes(leftParents.poll(), LEFT);
            }

            for(Node leftNode: leftFrontier)
                for(Node rightNode: rightFrontier) {
                //    System.out.println("Goal Check");
                    if (GoalTest(leftNode, rightNode)) {
                       // System.out.println("Goal Reached");
                        return leftNode;
                    }
                }

            if(rightFrontier.isEmpty()) {
               // System.out.println("Right Side");
                return null;
            }
            LinkedList<Node> rightParents = new LinkedList<>(rightFrontier);
            exploredRight.addAll(rightFrontier);
            rightFrontier.clear();

            while(!rightParents.isEmpty()) {
               // System.out.println("Exploring Right Parents");
                childNodes(rightParents.poll(), RIGHT);
            }

        }
    }

    public boolean GoalTest(Node leftSideNode, Node rightSideNode){
        return checker.checkNode(leftSideNode, rightSideNode);
    }

    public void childNodes(Node parent, int side){

        Node clonedParent = parent.clone();

        LinkedList<Node> frontier;

        if(side == LEFT) frontier = leftFrontier;

        else if(side == RIGHT) frontier = rightFrontier;

        else return;

        Node child1 = clonedParent.moveDisk(clonedParent.getBTower(), clonedParent.getATower());
        clonedParent = parent.clone();
        Node child2 = clonedParent.moveDisk(clonedParent.getBTower(), clonedParent.getCTower());
        clonedParent = parent.clone();
        Node child3 = clonedParent.moveDisk(clonedParent.getCTower(), clonedParent.getATower());
        clonedParent = parent.clone();
        Node child4 = clonedParent.moveDisk(clonedParent.getCTower(), clonedParent.getBTower());
        clonedParent = parent.clone();
        Node child5 = clonedParent.moveDisk(clonedParent.getATower(), clonedParent.getBTower());
        clonedParent = parent.clone();
        Node child6 = clonedParent.moveDisk(clonedParent.getATower(), clonedParent.getCTower());

        if(child1 != null && !stateExploredOrAdded(child1, side))
            frontier.add(child1);
        if(child2 != null && !stateExploredOrAdded(child2, side))
            frontier.add(child2);
        if(child3 != null && !stateExploredOrAdded(child3, side))
            frontier.add(child3);
        if(child4 != null && !stateExploredOrAdded(child4, side))
            frontier.add(child4);
        if(child5 != null && !stateExploredOrAdded(child5, side))
            frontier.add(child5);
        if(child6 != null && !stateExploredOrAdded(child6, side))
            frontier.add(child6);

    }

    public boolean stateExploredOrAdded(Node state, int side){
        LinkedList<Node> frontier;
        LinkedList<Node> explored;

        if(side == LEFT){
            frontier = leftFrontier;
            explored = exploredLeft;
        }
        else if(side == RIGHT) {
            frontier = rightFrontier;
            explored = exploredRight;
        }
        else return true;

        //State comparision - frontier
        for(Node node: frontier)
            if(node.equals(state))
                return true;

        //State comparision explored
        for(Node node: explored)
            if(node.equals(state))
                return true;

        return false;
    }

}