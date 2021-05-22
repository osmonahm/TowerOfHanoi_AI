package components;

import model.Disk;

public class Node {

    private final char srcRod;
    private final char destRod;
    private final Disk disk;
    public Node(char srcRod, char destRod, Disk disk){
        this.srcRod = srcRod;
        this.destRod = destRod;
        this.disk = disk;
    }

    public char getSrcRod() {
        return srcRod;
    }

    public char getDestRod() {
        return destRod;
    }

    public Disk getDisk() {
        return disk;
    }

}
