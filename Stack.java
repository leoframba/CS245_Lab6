public class Stack<E> {

    //Top of the stack
    private Node<E> head;

    private static class Node<E> {
        E data;
        Node<E> next;

        public Node(E e) {
            data = e;
        }
    }

    public boolean isEmpty() {
        //if the head points to null the stack is empty
        return (head == null);
    }

    public void push(E e) {
        //Create new node to be added
        Node<E> node = new Node<>(e);
        //New node goes on top of the stack and points at the previous top
        node.next = head;
        //Set the new node as the top of the stack
        head = node;
    }

    public E pop() {
        //Can't pop from an empty stack
        if (isEmpty()) throw new IndexOutOfBoundsException();
        //Temp to hold the return data
        E temp = head.data;
        //Head becomes the next item in the stack
        head = head.next;
        return temp;
    }

    public E peek() {
        //Can't peek an empty stack
        if (isEmpty()) throw new IndexOutOfBoundsException();
        //Return the data of the top item stack
        return head.data;
    }
}
