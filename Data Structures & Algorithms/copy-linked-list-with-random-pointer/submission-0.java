/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        HashMap<Node, Node> newList = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            newList.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            newList.get(curr).next = newList.get(curr.next);
            newList.get(curr).random = newList.get(curr.random);
            curr = curr.next;
        }
        return newList.get(head);
    }
}
