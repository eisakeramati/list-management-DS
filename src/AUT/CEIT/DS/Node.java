package AUT.CEIT.DS;

import java.util.ArrayList;

/**
 * Created by eisak on 2017-12-04.
 */
public class Node {
    String serviceName;
    Node link;
    Node sublink;
    String carModel;
    String serviceDescription;
    int numberOfFathers;


    public Node(String name) {
        serviceName = name;
        link = null;
        numberOfFathers = 0;
    }

    public String getServiceName() {
        return serviceName;
    }

    public Node getLink() {
        return link;
    }

    public String getCarModel() {
        return carModel;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public Node getSublink() {
        return sublink;
    }

    public void setNumberOfFathers(int numberOfFathers) {
        this.numberOfFathers = numberOfFathers;
    }

    public int getNumberOfFathers() {

        return numberOfFathers;
    }
}
