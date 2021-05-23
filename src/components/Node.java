package components;

import model.Tower;

public class Node
{
    private final Tower ATower;
    private final Tower BTower;
    private final Tower CTower;
    private final Node parent;
    private final int cost;
    
    public Node( Tower ATower, Tower BTower, Tower CTower, Node parent, int cost )
    {
        this.ATower = ATower;
        this.BTower = BTower;
        this.CTower = CTower;
        this.parent = parent;
        this.cost = cost;
    }
    
    public Tower getATower()
    {
        return ATower;
    }
    
    public Tower getBTower()
    {
        return BTower;
    }

    public Tower getCTower(){return CTower;}
    
    public Node getParent()
    {
        return parent;
    }

    public int getCost(){
        return cost;
    }

    public Node moveDisk(Tower srcTower, Tower dstTower )
    {
        if( srcTower.isEmpty() || !dstTower.diskSupported( srcTower.peek())) return null;
        else {
            dstTower.push( srcTower.pop() );
            return new Node(ATower, BTower, CTower, this, cost + 1);
        }
    }

    public boolean equals(Node another){
        return getBTower().equals(another.getBTower())
            && getATower().equals(another.getATower())
            && getCTower().equals(another.getCTower());
    }

    public Node clone(){
        return new Node(ATower.clone(), BTower.clone(), CTower.clone(), parent, cost);
    }

    public void printTowers(){
        ATower.printDisks();
        BTower.printDisks();
        CTower.printDisks();
    }

    public void printMoves(){
        Node parent = this.parent;
        while (parent != null){
            parent.printTowers();
            parent = parent.getParent();
        }
    }
}