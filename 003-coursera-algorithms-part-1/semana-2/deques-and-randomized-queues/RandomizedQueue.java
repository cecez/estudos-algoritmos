import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] items;
    private int totalDeItens = 0;

    // construct an empty randomized queue
    public RandomizedQueue() {
        items = (Item[]) new Object[1];
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return totalDeItens == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return totalDeItens;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) { throw new IllegalArgumentException(); }
        if (totalDeItens == items.length) resize(2 * items.length);
        items[totalDeItens++] = item;
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < totalDeItens; i++) {
            copy[i] = items[i];
        }
        items = copy;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) { throw new NoSuchElementException(); }

        // swap a random item with last item
        int randomIndex = randomIndex();
        Item tempItem = items[totalDeItens -1];
        items[totalDeItens -1] = items[randomIndex];
        items[randomIndex] = tempItem;

        Item item = items[--totalDeItens];
        items[totalDeItens] = null;
        if (totalDeItens > 0 && totalDeItens == items.length / 4) resize(items.length/2);
        return item;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty()) { throw new NoSuchElementException(); }
        return items[randomIndex()];
    }

    private int randomIndex() {
        return StdRandom.uniform(totalDeItens);
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new ArrayIterator(randomIndex());
    }

    private class ArrayIterator implements Iterator<Item> {
        private int i = 0;
        private int total;
        private final int[] indexes;

        public ArrayIterator(int r) {
            total = 0;
            indexes = new int[totalDeItens];
            for (int j = r; j < totalDeItens; j++) {
                if (total == totalDeItens) break;
                indexes[total] = j;
                total++;
                if (j == totalDeItens -1) j = 0;
            }
        }

        public boolean hasNext() { return i < totalDeItens; }
        public void remove() { throw new UnsupportedOperationException(); }
        public Item next() {
            if (items[indexes[i]] == null) { throw new NoSuchElementException(); }
            Item item = items[indexes[i++]];
            return item;
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        StdOut.println("Iniciando");

        RandomizedQueue<String> rq = new RandomizedQueue<String>();
        StdOut.println("isEmpty? " + rq.isEmpty());
        StdOut.println("size= " + rq.size());
        rq.enqueue("null");
        rq.enqueue("eins");
        rq.enqueue("zwei");
        rq.enqueue("drei");
        rq.enqueue("vier");

        for (String s : rq) {
            StdOut.println(s);
        }

        StdOut.println("Item removido aleatoriamente: " + rq.dequeue());
        StdOut.println("Exemplo aleatorio: " + rq.sample());
        StdOut.println("Item removido aleatoriamente: " + rq.dequeue());
        StdOut.println("Exemplo aleatorio: " + rq.sample());

        for (String s : rq) {
            StdOut.println(s);
        }

        StdOut.println("isEmpty? " + rq.isEmpty());
        StdOut.println("size: " + rq.size());

        StdOut.println("Terminando");
    }

}