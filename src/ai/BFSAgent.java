package ai;

import components.MiddleNodeChecker;
import components.Node;
import model.Disk;
import model.Tower;

import java.util.LinkedList;

public class BFSAgent {

    private final int numOfDisks;

    private static final int LEFT = 0;
    private static final int RIGHT = 1;

    private Tower ATower, BTower, CTower, goalATower, goalBTower, goalCTower;

    private Node goalNode;

    private MiddleNodeChecker checker;
    private LinkedList<Node> frontier;
    private LinkedList<Node> explored;

    public BFSAgent(int numOfDisks){
        this.numOfDisks = numOfDisks;
        ATower = new Tower('A');
        BTower = new Tower('B');
        CTower = new Tower('C');

        goalATower = new Tower('A');
        goalBTower = new Tower('B');
        goalCTower = new Tower('C');

        goalNode = new Node(goalATower, goalBTower, goalCTower, null, 0);


        for (int i = numOfDisks; i > 0 ; i--) {
            ATower.push(new Disk(i));
            goalCTower.push(new Disk(i));
        }

        checker = new MiddleNodeChecker(numOfDisks);

    }

    public Node solve(){
        int moves = 1;
        frontier = new LinkedList<>();
        explored = new LinkedList<>();

        frontier.add(new Node(ATower, BTower, CTower, null, 0));

        while(true){
            if(frontier.isEmpty()) {
                return null;
            }
            LinkedList<Node> leftParents = new LinkedList<>(frontier);
            explored.addAll(frontier);
            frontier.clear();

            while(!leftParents.isEmpty()) {
                childNodes(leftParents.poll());
            }

            for(Node node: frontier)
                if(GoalTest(node))
                    return node;
        }
    }

    public boolean GoalTest(Node leftSideNode){
        return checker.goalCheck(leftSideNode, goalNode);
    }

    public void childNodes(Node parent){

        Node clonedParent = parent.clone();

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

        if(child1 != null && !stateExploredOrAdded(child1))
            frontier.add(child1);
        if(child2 != null && !stateExploredOrAdded(child2))
            frontier.add(child2);
        if(child3 != null && !stateExploredOrAdded(child3))
            frontier.add(child3);
        if(child4 != null && !stateExploredOrAdded(child4))
            frontier.add(child4);
        if(child5 != null && !stateExploredOrAdded(child5))
            frontier.add(child5);
        if(child6 != null && !stateExploredOrAdded(child6))
            frontier.add(child6);

    }

    public boolean stateExploredOrAdded(Node state){

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