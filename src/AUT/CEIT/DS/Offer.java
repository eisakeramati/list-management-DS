package AUT.CEIT.DS;

/**
 * Created by eisak on 2017-12-06.
 */
public class Offer {

    public Offer(String sn, String il, String cn, int t) {
        serviceName = sn;
        turn = t;
        if (il.equals("normal"))
            immediacyLevel = 1;
        else if (il.equals("urgent"))
            immediacyLevel = 2;
        else if (il.equals("extraUrgent"))
            immediacyLevel = 3;
        customerName = cn;
    }

    String serviceName;
    int immediacyLevel;
    String customerName;
    int turn;

    public int getTurn() {
        return turn;
    }

    public String getServiceName() {
        return serviceName;
    }

    public int getImmediacyLevel() {
        return immediacyLevel;
    }

    public String getCustomerName() {
        return customerName;
    }
}
