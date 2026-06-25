class LRUCache {

    DLLNode head;
    DLLNode tail;
    Map<Integer,DLLNode> map = new HashMap<>();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        head = new DLLNode(0,0);
        tail = new DLLNode(0,0);
        head.next = tail;
        tail.next = head;
    }
    
    public int get(int key) {
        DLLNode node = map.get(key);
        if(node!=null){
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        DLLNode oldNode = map.get(key);
        if(oldNode!=null) remove(oldNode);
        if(map.size()==capacity) remove(tail.prev);
        DLLNode newNode = new DLLNode(key,value);
        insert(newNode);
    }

    void insert(DLLNode node){
        head.next.prev = node;
        node.next = head.next;
        node.prev = head;
        head.next = node;
        map.put(node.key,node);
    }

    void remove(DLLNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        map.remove(node.key);
    }

    class DLLNode {
        int key;
        int value;
        DLLNode prev;
        DLLNode next;
        DLLNode(){}
        DLLNode(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
}
