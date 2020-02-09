// linklist -> stack
class LinkedStack {
    private Node first = null;

    private class Node {
        String item;// content
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(String item) {
        Node tmp = new Node();
        tmp.item = item;
        tmp.next = first;
        first = tmp;
    }

    public String pop() {
        String item = first.item;
        first = first.next;
        return item;
    }
}

// array -> Stack
class arrayStack {
    private String[] s;
    private int N = 0;
    // 指针指向第一个空元素

    public arrayStack(int capacity) {
        s = new String[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(String item) {
        s[N++] = item;
    }

    public String pop() {
        return s[--N];
    }
}

// resizing-array  -> stack
class ResizingArrayString {
    private String[] s;
    private int N;

    public ResizingArrayString() {
        s = new String[1];
    }

    public void push(String item) {
        if (N == s.length) {
            resize(2 * s.length);
        }
        s[N++] = item;
    }

    public void resize(int capacity) {
        String[] copy = new String[capacity];
        for (int i = 0; i < N; i++) {
            copy[i] = s[i];
        }
        s = copy;
    }

    public void pop() {
        String item = s[--N];
        s[N] = null;
        if (N > 0 && N == s.length / 4) {
            resize(s.length / 2);
        }
        return item;
    }
}