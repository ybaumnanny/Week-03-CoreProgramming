import java.util.LinkedList;
class CustomHashMap<K, V> {
    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next; // Linked List for Separate Chaining
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    private static final int DEFAULT_CAPACITY = 16; // Initial capacity
    private static final float LOAD_FACTOR = 0.75f; // Resize threshold
    private LinkedList<Entry<K, V>>[] buckets;
    private int size;
    @SuppressWarnings("unchecked")
    public CustomHashMap() {
        buckets = new LinkedList[DEFAULT_CAPACITY];
        size = 0;
    }
    private int hash(K key) {
        return Math.abs(key.hashCode() % buckets.length);
    }
    public void put(K key, V value) {
        if (key == null) throw new IllegalArgumentException("Null keys are not allowed.");
        int index = hash(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }
        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) { // Key exists, update value
                entry.value = value;
                return;
            }
        }
        buckets[index].add(new Entry<>(key, value));
        size++;
        if (size > LOAD_FACTOR * buckets.length) {
            resize();
        }
    }
    public V get(K key) {
        int index = hash(key);
        if (buckets[index] == null) return null;
        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }
    public void remove(K key) {
        int index = hash(key);
        if (buckets[index] == null) return;
        Entry<K, V> toRemove = null;
        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                toRemove = entry;
                break;
            }
        }
        if (toRemove != null) {
            buckets[index].remove(toRemove);
            size--;
        }
    }  
     private void resize() {
        int newCapacity = buckets.length * 2;
        LinkedList<Entry<K, V>>[] newBuckets = new LinkedList[newCapacity];
        for (LinkedList<Entry<K, V>> bucket : buckets) {
            if (bucket != null) {
                for (Entry<K, V> entry : bucket) {
                    int index = Math.abs(entry.key.hashCode() % newCapacity);
                    if (newBuckets[index] == null) {
                        newBuckets[index] = new LinkedList<>();
                    }
                    newBuckets[index].add(entry);
                }
            }
        }
        buckets = newBuckets;
    }
    public int size() {
        return size;
    }
    public boolean containsKey(K key) {
        return get(key) != null;
    }
}
