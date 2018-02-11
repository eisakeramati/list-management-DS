package AUT.CEIT.DS;

import java.util.ArrayList;

/**
 * Created by eisak on 2017-12-04.
 */
public class AgenceyNode {

    AgenceyNode next;
    Node service;
    String name;
    PriorityQueue priorityQueue;

    public PriorityQueue getPriorityQueue() {
        return priorityQueue;
    }

    public AgenceyNode getNext() {
        return next;
    }

    public Node getService() {
        return service;
    }

    public String getName() {
        return name;
    }


    public AgenceyNode(String name) {
        this.name = name;
        next = null;
        service = null;
        priorityQueue = new PriorityQueue();

    }
}
