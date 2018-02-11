package AUT.CEIT.DS;

/**
 * Created by eisak on 2017-12-04.
 */
public class ServiceList {
    private Node first;

    public Node getFirst() {
        return first;
    }

    public ServiceList() {
        first = null;
    }


    public void addService(String x) {
        Node nnode = new Node(x);
        if (first == null) {
            first = nnode;
        } else {
            Node p = first;
            while (p.link != null) {
                p = p.link;
            }
            p.link = nnode;

        }
    }

    public void addSubService(String subName, String servName) {
        Node t = search(servName, first);

        if (t != null) {
            Node snode = new Node(subName);

            if (t.sublink == null) {
                t.sublink = snode;
                snode.setNumberOfFathers(snode.getNumberOfFathers() + 1);
            } else {
                Node p = t.sublink;
                while (p.link != null) {
                    p = p.link;
                }
                p.link = snode;
                snode.setNumberOfFathers(snode.getNumberOfFathers() + 1);

            }
        } else {
            System.out.println("No such parent node exists");
        }
    }

    public void print(Node p) {
        if (p == null)
            return;
        System.out.println(p.serviceName);
        print(p.link);
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
}
