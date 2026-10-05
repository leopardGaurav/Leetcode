class MyHashSet {
    private static final int CAPACITY = 769; // A prime number to minimize collisions
    private final Node[] buckets;

    private static class Node {
        int key;
        Node next;

        Node(int key) {
            this.key = key;
        }
    }

    public MyHashSet() {
        buckets = new Node[CAPACITY];
    }

    private int getHash(int key) {
        return Integer.hashCode(key) % CAPACITY;
    }

    public void add(int key) {
        int hash = getHash(key);
        if (buckets[hash] == null) {
            buckets[hash] = new Node(key);
            return;
        }

        Node curr = buckets[hash];
        if (curr.key == key) return; // Key already exists

        while (curr.next != null) {
            if (curr.next.key == key) return; // Key already exists
            curr = curr.next;
        }
        curr.next = new Node(key);
    }

    public void remove(int key) {
        int hash = getHash(key);
        Node curr = buckets[hash];
        if (curr == null) return;

        // If the key is at the head of the bucket
        if (curr.key == key) {
            buckets[hash] = curr.next;
            return;
        }

        while (curr.next != null) {
            if (curr.next.key == key) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }

    public boolean contains(int key) {
        int hash = getHash(key);
        Node curr = buckets[hash];
        
        while (curr != null) {
            if (curr.key == key) return true;
            curr = curr.next;
        }
        return false;
    }
}