class MyHashMap {

    // Node structure for Separate Chaining
    private static class Node {
        int key, value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int CAPACITY = 10009; // A prime number helps distribute keys uniformly and minimize collisions
    private Node[] buckets;

    public MyHashMap() {
        buckets = new Node[CAPACITY];
    }
    
    // Hash function to map key to an index
    private int getIndex(int key) {
        return Integer.hashCode(key) % CAPACITY;
    }

    public void put(int key, int value) {
        int index = getIndex(key);
        
        // If bucket is empty, create a new head node
        if (buckets[index] == null) {
            buckets[index] = new Node(key, value);
            return;
        }

        // Traverse the bucket to check if key already exists
        Node curr = buckets[index];
        while (true) {
            if (curr.key == key) {
                curr.value = value; // Update existing key's value
                return;
            }
            if (curr.next == null) break;
            curr = curr.next;
        }

        // Key not found, append new node at the end of the list
        curr.next = new Node(key, value);
    }
    
    public int get(int key) {
        int index = getIndex(key);
        Node curr = buckets[index];

        // Search through the linked list
        while (curr != null) {
            if (curr.key == key) {
                return curr.value;
            }
            curr = curr.next;
        }

        return -1; // Key not found
    }
    
    public void remove(int key) {
        int index = getIndex(key);
        Node curr = buckets[index];

        if (curr == null) return;

        // If the head node is the one to be removed
        if (curr.key == key) {
            buckets[index] = curr.next;
            return;
        }

        // Search for the node to remove
        while (curr.next != null) {
            if (curr.next.key == key) {
                curr.next = curr.next.next; // Bypass the node
                return;
            }
            curr = curr.next;
        }
    }
}