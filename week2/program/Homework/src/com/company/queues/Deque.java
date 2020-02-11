import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int n;

    private  class Node {
        Item item;
        Node next;
        Node prev;
    }

    // construct an empty deque
    public Deque() {
        n = 0;
        first = null;
        last = null;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return n == 0;
    }

    // return the number of items on the deque
    public int size() {
        return n;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        Node newFirst = new Node();
        newFirst.prev = null;
        newFirst.item = item;
        if (isEmpty()) {
            first = newFirst;
            last = newFirst;
            last.next = null;
        }
        else {
            newFirst.next = first;
            first.prev = newFirst;
            first = newFirst;
        }
        n += 1;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        Node newLast = new Node();
        newLast.next = null;
        newLast.item = item;
        if(isEmpty()) {
            first = newLast;
            last = newLast;
            last.prev = null;
        }
        else {
            last.next = newLast;
            newLast.prev = last;
            last = newLast;
        }
        n += 1;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item rtItem = first.item;
        n -= 1;
        if (isEmpty()) {
            first = null;
            last = null;
        }
        else {
            first = first.next;
            first.prev = null;
        }
        return rtItem;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (n == 0) {
            throw new NoSuchElementException();
        }
        Item rtItem = last.item;
        n -= 1;
        if (isEmpty()) {
            first = null;
            last = null;
        }
        else {
            last = last.prev;
            last.next = null;
        }
        return rtItem;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            //StdOut.println("log:" + item);
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<String> q = new Deque<>();
        StdOut.println("Type yes to start");
        String s = StdIn.readString();
        while (s.equals("yes")) {
            StdOut.println("Input your choice");
            int choice = StdIn.readInt();
            switch (choice) {
                case 1:
                    StdOut.println("Type a string to add first.");
                    String item1 = StdIn.readString();
                    q.addFirst(item1);
                    StdOut.print(q.iterator());
                    break;

                case 2:
                    StdOut.println("Type a string to add last.");
                    String item2 = StdIn.readString();
                    q.addLast(item2);
                    StdOut.println(q.iterator());
                    break;

                case 3:
                    StdOut.println(q.isEmpty());
                    StdOut.println(q.iterator());
                    break;

                case 4:
                    StdOut.println("size = " + q.size());
                    break;

                case 5:
                    StdOut.println("Remove first");
                    StdOut.println(q.removeFirst());
                    StdOut.println(q.iterator());
                    break;

                case 6:
                    StdOut.println("Remove Last");
                    StdOut.println(q.removeLast());
                    StdOut.println(q.iterator());
                    break;

                default:
                    StdOut.println("No such option");
                    break;
            }
            StdOut.println("Input your choice to go on:");
        }
        StdOut.println(q.iterator());
    }
}
