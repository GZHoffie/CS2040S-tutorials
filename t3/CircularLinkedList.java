class CircularLinkedList {

    public int size; 
    public ListNode head; 
    public ListNode tail;

    public void addFirst(int element) {
        size++;
        head = new ListNode(element, head);  
        if (tail == null)
            tail = head;
        tail.setNext(head);
    }

    public void swap(int index) {
        if (size < 2)
            return; // if 0 or 1 nodes, don’t bother

        if (size == 2) {
            ListNode newTail = head;
            head = tail;
            tail = newTail; 
            return;
        } // if 2 nodes, only need to swap head and tail references

        // At this point, the list has >2 nodes
        index %= _size; // ensure that index < size of list first

        // get the 3 desired nodes 
        ListNode prev = _tail;
        for (int loopIdx = 0; loopIdx < index; loopIdx++) 
            prev = prev.getNext();
        ListNode curr = prev.getNext(); // curr now at indexed node 
        ListNode succ = curr.getNext();
        
        // swap the 2 nodes: Note the order! 
        curr.setNext(succ.getNext()); 
        succ.setNext(curr); 
        prev.setNext(succ);

        if (index == 0) {
            head = succ; // head incorrect
        } else if (index == size - 2) {
            tail = curr; // swap(tail-1), tail incorrect
        } else if (index == size - 1) {
            head = curr; // swap(tail), both head & tail swapped
            tail = succ;
        }
    }
}