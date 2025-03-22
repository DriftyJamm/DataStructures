class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularLinkedList {
    private Node head = null;

    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public void delete(int key) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = head, prev = null;

        do {
            if (current.data == key) {
                if (prev == null) { 
                    Node temp = head;
                    while (temp.next != head) {
                        temp = temp.next;
                    }
                    temp.next = head.next;
                    head = head.next;
                } else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);

        System.out.println("Key " + key + " not found in the list");
    }

    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.append(1);
        cll.append(2);
        cll.append(3);
        cll.display(); 
        cll.delete(2);
        cll.display(); 
    }
}
