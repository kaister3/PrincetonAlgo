package com.company;

import java.util.NoSuchElementException;
import java.lang.IllegalArgumentException;
import java.lang.UnsupportedOperationException;
import java.lang.Iterable;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private item[] q;
    private int N = 0;// the number of elements

    // construct an empty randomized queue
    public RandomizedQueue() {
        q = (Item[]) new Object()[1];
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return N == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return N;
    }

    private void resize(int max) {
        assert max >= N;
        Item[] tmp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            tmp[i] = q[i];
        }
        q = tmp;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw NullPointerException;
        }
        if (N == q.length) {
            resize(2 * q.length);
        }
        q[N] = item;
        N++;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int k = Std.
    }

    // return a random item (but do not remove it)
    public Item sample()

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {

        public boolean hasNext() {
            
        }
    }

    // unit testing (required)
    public static void main(String[] args)

}