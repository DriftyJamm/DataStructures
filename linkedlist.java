class Node {
    int data;       
    Node next;      
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;  

    public LinkedList() {
        this.head = null;
    }

    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {  
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {  
            current = current.next;
        }
        current.next = newNode; 
    }

    public void display() {
        Node current = head;
        while (current != null) {  
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("None");
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.append(10);
        ll.append(20);
        ll.append(30);
        ll.display();  
    }
}
