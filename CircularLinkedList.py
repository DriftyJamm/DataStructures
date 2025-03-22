class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


class CircularLinkedList:
    def __init__(self):
        self.head = None

    def append(self, data):
        new_node = Node(data)
        if not self.head:
            self.head = new_node
            self.head.next = self.head
        else:
            temp = self.head
            while temp.next != self.head:
                temp = temp.next
            temp.next = new_node
            new_node.next = self.head

    def display(self):
        nodes = []
        if not self.head:
            return "List is empty"
        temp = self.head
        while True:
            nodes.append(temp.data)
            temp = temp.next
            if temp == self.head:
                break
        return " -> ".join(map(str, nodes))

    def delete(self, key):
        if not self.head:
            return "List is empty"
        current = self.head
        prev = None
        while True:
            if current.data == key:
                if prev is None:  
                    temp = self.head
                    while temp.next != self.head:
                        temp = temp.next
                    temp.next = current.next
                    self.head = current.next
                else:
                    prev.next = current.next
                return
            prev = current
            current = current.next
            if current == self.head:
                break
        print(f"Key {key} not found in the list")



cll = CircularLinkedList()
cll.append(1)
cll.append(2)
cll.append(3)
print(cll.display())  
cll.delete(2)
print(cll.display())  
