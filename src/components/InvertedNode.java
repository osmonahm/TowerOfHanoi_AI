package components;

import model.Rod;

public class InvertedNode{
    private final Rod srcRod;
    private final Rod destRod;
    private final InvertedNode parent;
    public InvertedNode(Rod destRod, Rod srcRod, InvertedNode parent){
        this.destRod = destRod;
        this.srcRod = srcRod;
        this.parent = parent;
    }

    public Rod getSrcRod() {
        return srcRod;
    }

    public Rod getDestRod() {
        return destRod;
    }

}
