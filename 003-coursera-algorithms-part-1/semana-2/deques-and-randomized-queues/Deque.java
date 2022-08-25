import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int items;

    private class Node {
        Item item;
        Node next;
        Node previous;

        public Node(Item item, Node next, Node previous) {
            this.item = item;
            this.next = next;
            this.previous = previous;
        }
    }

    // construct an empty deque
    public Deque() {
        first = null;
        last = null;
        items = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return items == 0;
    }

    // return the number of items on the deque
    public int size() {
        return items;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) { throw new IllegalArgumentException(); }

        Node newItem = new Node(item, first, null);

        if (first == null) {
            last = newItem;
        } else {
            first.previous = newItem;
        }
        first = newItem;

        items++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) { throw new IllegalArgumentException(); }

        Node newItem = new Node(item, null, last);

        if (last == null) {
            first = newItem;
        } else {
            last.next = newItem;
        }
        last = newItem;

        items++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) { throw new NoSuchElementException(); }

        Item firstItem = first.item;
        if (first == last) {
            last = null;
            first = null;
        } else {
            first = first.next;
            first.previous = null;
        }
        items--;
        return firstItem;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty()) { throw new NoSuchElementException(); }

        Item lastItem = last.item;
        if (last == first) {
            first = null;
            last = null;
        } else {
            last = last.previous;
            last.next = null;
        }
        items--;
        return lastItem;
    }

    private class DequeIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() { return current != null; }
        public void remove() { throw new UnsupportedOperationException(); }
        public Item next() {
            if (current == null) { throw new NoSuchElementException(); }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(1);
        deque.removeLast();


        Deque<String> myDeck = new Deque<>();
        StdOut.println(myDeck.isEmpty());
        StdOut.println(myDeck.size());
        myDeck.addLast("primeiro last");
        myDeck.addFirst("primeiro first");
        myDeck.addFirst("segundo first");
        myDeck.addFirst("terceiro first");
        myDeck.addLast("quarto last");
        myDeck.addLast("quinto last");
        myDeck.removeFirst();
        myDeck.removeLast();
        StdOut.println(myDeck.isEmpty());
        StdOut.println(myDeck.size());

        for (String s : myDeck) {
            StdOut.println(s);
        }
    }

}