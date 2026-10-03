class LRUCache {
 private int capacity;
    private HashMap<Integer,Node> cache;
    private Node left;
    private Node right;
    // least recent used are kept at the left side
    // most recently used are kept at the right side

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.left = new Node(0,0);
        this.right = new Node(0,0);
        this.left.next = right;
        this.right.prev = left;
    }
    
    public int get(int key) {
        // Each key corresponds to a Node.
        // When you "get" a key, it becomes most recently used.
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            this.delete(node); // delete it wherever it is present
            this.insert(node); // put it as right most because it is now most recently used
        } else {
            return -1; // key not previously added
        }
        return cache.get(key).value;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            this.delete(cache.get(key)); // delete found node
        }
        Node newNode = new Node(key, value);
        cache.put(key, newNode); // overwrites existing value of key if present
        // if not present, above creates new cache entry
        this.insert(newNode);
        if(this.cache.size() > this.capacity) {
            this.cache.remove(this.left.next.key); // deleting key & value of LRU item from cache/map
            this.delete(this.left.next); // removing Least Recently Used (LRU) item
        }
    }

    private void insert(Node node){
        // inserts are always done just before right.
        // There are 4 pointers to connect to make this insertion
        Node prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
    }

    private void delete(Node node){
        // Node at any position will be deleted using this in O(1)
        // This is universal. NOT just for flushing out LRU (left.next) node.
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
}

class Node {
    private int key;
    private int value;
    private Node next;
    private Node prev;

    public Node(int key, int value){
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;    
    }
}
