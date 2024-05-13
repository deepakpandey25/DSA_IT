class Node {
    int data;
    Node next, arb;

    Node(int d) {
        data = d;
        next = arb = null;
    }
}

public class CloneLinkedListWithRandomPointers {
    Node copyList(Node head) {
        Node temp = head;
        while (temp != null) {
            Node copy = new Node(temp.data);
            copy.next = temp.next;
            temp.next = copy;
            temp = copy.next;
        }

        temp = head;

        while (temp != null) {
            if (temp.arb != null) {
                temp.next.arb = temp.arb.next;
            } else {
                temp.next.arb = null;
            }
            temp = temp.next.next;
        }
        temp = head;
        Node dummyNode = new Node(-1);
        Node res = dummyNode;

        while (temp != null) {
            res.next = temp.next;
            res = res.next;
            temp.next = res.next;
            temp = temp.next;
        }
        return dummyNode.next;
    }
}
