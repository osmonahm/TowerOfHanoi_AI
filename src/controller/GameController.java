package controller;

import model.Disk;
import model.Rod;

public class GameController {
    private Disk selectedDisk;
    private Rod ARod;
    private Rod BRod;
    private Rod CRod;

    public GameController(){
        ARod = new Rod('A', 7);
        BRod = new Rod('B');
        CRod = new Rod('C');
    }

    public void moveDisk(char sourceRod, char destRod){

        Rod srcRod = getRod(sourceRod);
        Rod dstRod = getRod(destRod);

        if(srcRod.isEmpty()){
            System.out.println("Empty Rod. Invalid move");
        }

        else if(dstRod.diskSupported(srcRod.peek())){
            System.out.println("Disk moved: " + sourceRod + srcRod.peek().getDiskSize() + " " + destRod);
            dstRod.add(srcRod.pop());
        }

        else{
            System.out.println("Disk not moved.");
        }

    }

    private Rod getRod(char rodName){
        if(rodName == 'A')
            return ARod;
        else if(rodName == 'B')
            return BRod;
        else if(rodName == 'C')
            return CRod;
        else
            return null;
    }

    public void printRods(){
        System.out.print("A : ");
        for(Disk disk: ARod.getDisks()){
            System.out.print(disk.getDiskSize() + " ");
        }
        System.out.println();
        System.out.print("B : ");
        for(Disk disk: BRod.getDisks()){
            System.out.print(disk.getDiskSize() + " ");
        }
        System.out.println();
        System.out.print("C : ");
        for(Disk disk: CRod.getDisks()){
            System.out.print(disk.getDiskSize() + " ");
        }
        System.out.println();
    }

}
