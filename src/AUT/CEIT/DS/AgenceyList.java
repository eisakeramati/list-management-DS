package AUT.CEIT.DS;

/**
 * Created by eisak on 2017-12-04.
 */
public class AgenceyList {
    AgenceyNode first;

    ServiceList serviceList;

    public AgenceyNode getFirst() {
        return first;
    }

    public ServiceList getServiceList() {
        return serviceList;
    }

    public AgenceyList() {
        first = null;
        serviceList = new ServiceList();
    }

    void addOffer(String agenceyName, String serviceName) {
        AgenceyNode t = first;
        if (t != null) {
            while (!t.name.equals(agenceyName) && t.next != null) {
                t = t.next;
            }
        }
        if (t != null) {
            if (search(serviceName, serviceList.getFirst()) != null) {
                if (search(serviceName, t.getService()) == null) {
                    Node snode = new Node(serviceName);
                    snode.sublink = search(serviceName,serviceList.getFirst()).sublink;

                    if (t.service == null) {
                        t.service = snode;
                        snode.setNumberOfFathers(snode.getNumberOfFathers() + 1);
                    } else {
                        Node p = t.service;
                        while (p.link != null) {
                            p = p.link;
                        }
                        p.link = snode;
                        snode.setNumberOfFathers(snode.getNumberOfFathers() + 1);
                    }
                } else {
                    System.out.println("subservice is already added.");
                }
            } else {
                System.out.println("this service is not available.");
            }
        } else {
            System.out.println("No such agency exists.");
        }

    }

    void delete(String serviceName, String agenceyName) {
        if (findAgency(agenceyName, first)) {
            AgenceyNode t = first;
            while (!t.name.equals(agenceyName)) {
                t = t.next;
            }
            if (search(serviceName, first.getService()) != null) {

                if (t.getService() != null) {
                    Node p = t.getService();
                    if (p.getServiceName().equals(serviceName)) {
                        t.service = t.service.link;
                        p.setNumberOfFathers(p.getNumberOfFathers() - 1);
                    } else {
                        while (!p.link.getServiceName().equals(serviceName)) {
                            p = p.link;
                        }
                        p.link = p.link.link;
                        p.setNumberOfFathers(p.getNumberOfFathers() - 1);
                    }
                    if (p.getNumberOfFathers() == 0) {
                        Node q = serviceList.getFirst();
                        if (q.getServiceName().equals(serviceName))
                            q = q.link;
                        else {
                            while (!q.link.getServiceName().equals(serviceName)) {
                                q = q.link;
                            }
                            q.link = q.link.link;
                        }
                    }
                }
            } else {
                System.out.println("this service is already not available.");
            }

        } else {
            System.out.println("this agency doesn't exist.");
        }
    }

    void addAgencey(String agenceyName) {
        boolean a = findAgency(agenceyName, first);
        if (a == false) {

            AgenceyNode aNode = new AgenceyNode(agenceyName);
            if (first == null) {
                first = aNode;
            } else {
                AgenceyNode p = first;
                while (p.next != null) {
                    p = p.next;
                }
                p.next = aNode;

            }
        }
    }

    public boolean findAgency(String aname, AgenceyNode n) {
        if (n == null) return false;
        if (n.getName().equals(aname)) return true;
        return findAgency(aname, n.next);

    }

    void listAgencies() {
        listAgencies(first);
    }

    void listAgencies(AgenceyNode agenceyNode) {
        if (agenceyNode == null) return;
        System.out.println(agenceyNode.getName());
        listAgencies(agenceyNode.next);
    }

    void listServices() {
        listServices(serviceList.getFirst());
    }

    void listServices(Node node) {
        if (node == null) {
            return;
        }
        System.out.print("-" + node.getServiceName());
        System.out.print("<");
        listServices(node.getSublink());
        System.out.print(">");
        listServices(node.getLink());
    }

    void getSub(Node n) {
        if (n == null) return;
        System.out.println("    -" + n.getServiceName());
        getSub(n.link);
    }

    void listServicesFrom(String serviceName) {
        Node p = serviceList.getFirst();
//        while (!p.serviceName.equals(serviceName)) {
//            p = p.link;
//        }
        //getSub(p.sublink);
        listServices(search(serviceName, p).sublink);
    }

    public Node search(String name, Node t) {
        Node p = t;
        if (p == null) return null;
        if (p.getServiceName().equals(name)) {
            return p;
        }
        Node temp;
        if (p.getSublink() != null) {
            temp = search(name, p.getSublink());
            if (temp != null)
                return temp;
        }
        if (p.getLink() != null) {
            return search(name, p.getLink());
        }
        return null;
    }

    public void order(String agencyName, String serviceName, String customerName, String immediacyLevel) {

        if (findAgency(agencyName, first) == true) {
            AgenceyNode t = first;
            while (!t.name.equals(agencyName)) {
                t = t.next;
            }
            if (search(serviceName, t.getService()) != null) {
                t.getPriorityQueue().order(serviceName, customerName, immediacyLevel);
            } else {
                System.out.println("this service is not available in this agency");
            }
        } else {
            System.out.println("no such agency exists");
        }
    }

    public void listOrders(String agencyName) {
        AgenceyNode t = first;
        while (!t.name.equals(agencyName)) {
            t = t.next;
        }

        t.getPriorityQueue().listOrders();
    }

    public void listt() {
        listt(serviceList.getFirst());
    }

    public void listt(Node first) {
        if (first == null)
            return;
        Node p = first;
        System.out.println(p.getServiceName());
        listt(p.link);
    }

}
