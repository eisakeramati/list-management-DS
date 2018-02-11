package AUT.CEIT.DS;

/**
 * Created by eisak on 2017-12-04.
 */
public class PriorityQueue {

    private Offer[] heap;
    private int last;

    public PriorityQueue() {
        heap = new Offer[51];
        last = 0;
    }

    public int getLast() {
        return last;
    }

    public Offer[] getHeap() {
        return heap;
    }

    public boolean heapIsfull() {
        if (last == 20)
            return true;
        else
            return false;
    }

    public boolean heapIsEmpty() {
        if (last == 0)
            return true;
        else
            return false;
    }

    public void order(String serviceName, String customerName, String immediacyLevel) {
        if (heapIsfull()) return;
        Offer offer = new Offer(serviceName, immediacyLevel, customerName, last);
        if (heapIsEmpty()) {
            last++;
            heap[last] = offer;
        } else {
            last++;
            heap[last] = offer;
            int temp = last;
            while (calculateTurn(heap[temp], heap[getTempParent(temp)])) {
                Offer change = heap[getTempParent(temp)];
                heap[getTempParent(temp)] = heap[temp];
                heap[temp] = change;

                temp = getTempParent(temp);
            }
        }
    }

    public boolean calculateTurn(Offer h1, Offer h2) {
        if (h1.getImmediacyLevel() > h2.getImmediacyLevel()) {
            return true;
        }
        if (h1.getImmediacyLevel() == h2.getImmediacyLevel()) {
            if (h1.getTurn() < h2.getTurn())
                return true;
        }
        return false;
    }

    public Offer calculateThePrior(Offer h1, Offer h2) {

        if (h1 == null)
            return h2;
        if (h2 == null)
            return h1;
        if (h1.getImmediacyLevel() > h2.getImmediacyLevel()) {
            return h1;

        }
        if (h1.getImmediacyLevel() == h2.getImmediacyLevel()) {
            if (h1.getTurn() < h2.getTurn())
                return h1;
        }
        return h2;

    }

    public boolean rightOrleft(Offer h1, Offer h2) {
        if (h1 == null)
            return false;
        if (h2 == null)
            return true;
        if (h1.getImmediacyLevel() > h2.getImmediacyLevel()) {
            return true;

        }
        if (h1.getImmediacyLevel() == h2.getImmediacyLevel()) {
            if (h1.getTurn() < h2.getTurn())
                return true;
        }
        return false;
    }

    public void listOrders() {
        int makeSure = last;
        for (int i = 1; i <= makeSure; i++) {
            deletMax();
        }
    }


//    public void listOrders(int d) {
//        if (heap[d] == null) return;
//        System.out.println(heap[d].getServiceName() + "---" + heap[d].getCustomerName() + "---" + heap[d].getImmediacyLevel());
//        heap[d] = null;
//        listOrders(d + 1);
//    }

    public int getTempParent(int t) {
        if (t == 1)
            return 1;
        return t / 2;
    }

    public int getTempChild(int t) {
        return t * 2;
    }

    public int findMax(int a1, int a2) {
        if (a1 > a2)
            return a1;
        else
            return a2;
    }

    public void deletMax() {
        System.out.println(heap[1].getServiceName() + "---" + heap[1].getCustomerName() + "---" + heap[1].getImmediacyLevel());
        heap[1] = heap[last];
        heap[last] = null;
        last--;
        int temp = 1;
        while ((heap[getTempChild(temp)] != null || heap[getTempChild(temp) + 1] != null) && calculateTurn(calculateThePrior(heap[getTempChild(temp)], heap[getTempChild(temp) + 1]), heap[temp])) {
            Offer change = calculateThePrior(heap[getTempChild(temp)], heap[getTempChild(temp) + 1]);
            int change2;
            if (rightOrleft(heap[getTempChild(temp)], heap[getTempChild(temp) + 1]))
                change2 = getTempChild(temp);
            else change2 = getTempChild(temp) + 1;
            heap[change2] = heap[temp];
            heap[temp] = change;

            temp = change2;
        }
    }

    public void p() {
        for (int i = 1; i <= last; i++) {
            System.out.println(heap[i].getServiceName() + "---" + heap[i].getCustomerName() + "---" + heap[i].getImmediacyLevel());
        }
    }


}

