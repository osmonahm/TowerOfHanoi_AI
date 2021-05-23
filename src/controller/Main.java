package controller;

import ai.Agent;
import ai.BFSAgent;
import components.Node;

import java.util.Calendar;

public class Main
{
    public static void main( String[] args )
    {
        System.out.println(Calendar.getInstance().get(Calendar.SECOND));

        Agent agent = new Agent(2);
        Node solution = agent.solve();
        //solution.printMoves();
        System.out.println(solution.getCost());
        //DUHET ME MARR EDHE PJESEN TJETER TE LEVIZJEVE TEK RIGHTSIDENODE....

        System.out.println(Calendar.getInstance().get(Calendar.SECOND));

//        BFSAgent a = new BFSAgent(9);
//        Node s = a.solve();
//        s.printTowers();
//        System.out.println(Calendar.getInstance().get(Calendar.SECOND));

    }
}