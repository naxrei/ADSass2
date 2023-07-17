public class MyLinkedList<E> implements MyList{
    private MyArrayList elements = new MyArrayList<E>();
    private class Node<E> {
        E val;
        Node previous;
        Node next;
        public Node(E v) {
            val = v;
            previous = null;
            next = null;
        }
    }
    private Node<E> head;
    private Node<E> tail;
    private int size;
    MyLinkedList() {
        size = 0;
    }
    /**
     * @function size возвращает длину LinkedList
     * @noparams
     * @return int
     * **/
    @Override
    public int size() {
        return this.size;
    }
    /**
     * @function contains true если Object o в LinkedList
     * @param o объект поиска
     * @return boolean
     * **/
    @Override
    public boolean contains(Object o) {
        return (indexOf(o) != -1 ? true : false);
    }
    /**
     * @function add добавляет объект в LinkedList
     * @param item объект для добавления
     * @return void
     * **/
    @Override
    public void add(Object item) {
        createNode((E) item);
        elements.add(item);
        size++;
    }

    private void createNode(E item) {
        Node<E> node = new Node<>(item);
        if (size == 0) {
            this.head = node;
        } else {
            node.previous = this.tail;
            this.tail.next = node;
        }
        this.tail = node;
    }

    public void add(Object item, boolean notSave) {
        createNode((E) item);
        if (notSave) elements.add(item);
        size++;
    }
    /**
     * @function add добавляет объект на определенный индекс
     * @param item объект для добавления
     * @param index индекс куда нужно добавить item
     * @return void
     * **/
    @Override
    public void add(Object item, int index) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        Node oldNode = getNodeByIndex(index);
        Node node = new Node<E>((E) item);
        if (oldNode == null) {
            this.head = node;
        }
        else if (this.head.equals(oldNode)) {
            node.next = this.head;
            this.head.previous = node;
            this.head = node;
        } else if (this.tail.equals(oldNode)){
            node.next = this.tail;
            node.previous = this.tail.previous;
            this.tail.previous.next = node;
            this.tail.previous = node;
        } else {
            node.previous = oldNode.previous;
            node.next = oldNode;
            oldNode.previous.next = node;
            oldNode.previous = node;
        }
        elements.add(item, index);
        size++;
    }
    /**
     * @function remove удаляет объект из LinkedList
     * @param item объект удаления
     * @return boolean
     * **/
    @Override
    public boolean remove(Object item) {
        int objIndex = indexOf(item);
        if (objIndex >= 0) {
            remove(objIndex);
            size--;
            elements.remove(objIndex);
            return true;
        }
        return false;
    }
    /**
     * @function remove удаляет объект из LinkedList
     * @param index индекст элемента для удаления
     * @return Object
     * **/
    @Override
    public Object remove(int index) {
        checkIndex(index);
        Node node = getNodeByIndex(index);

        if (node.next == null && node.previous == null) {
            this.head = null;
            this.tail = null;
        }
        else if (node.previous == null) {
            this.head = node.next;
            this.head.previous = null;
        }
        else if (node.next == null) {
            this.tail = node.previous;
            this.tail.next = null;
        }
        else {
            node.previous.next = node.next;
            node.next.previous = node.previous;
        }
        elements.remove(index);
        this.size--;
        return node.val;

    }
    /**
     * @function clear очищает LinkedList
     * @noparam
     * @return void
     * **/
    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        size = 0;
    }
    /**
     * @function get возвращает объект из LinkedList под его индексом
     * @param index индекс объекта
     * @return E
     * **/
    @Override
    public Object get(int index) {
        checkIndex(index);
        return getNodeByIndex(index).val;
    }
    /**
     * @function indexOf возвращает индекс первого вхождения объекта
     * @param o объект для поиска
     * @return int
     * **/
    @Override
    public int indexOf(Object o) {
        int i = 0;
        Node<E> nextNode = this.head;
        while (nextNode != null) {
            if (this.head.val.equals(o)) return i;
            nextNode = nextNode.next;
            i++;
        }
        return -1;
    }
    /**
     * @function lastIndexOf возвращает индекс последнего вхождения объекта в LinkedList
     * @param o объект для поиска
     * @return int
     * **/
    @Override
    public int lastIndexOf(Object o) {
        int i = size()-1;
        Node<E> node = this.tail;
        while (i >= 0) {
            if (node.equals(o)) return i;
            node = this.tail.previous;
            i--;
        }
        return -1;
    }
    /**
     * @function sort сортирует LinkedList (bubble sort, O(n^2))
     * @noparam
     * @return void
     * **/
    @Override
    public void sort() {
        try{
            Integer.valueOf((int) this.get(0));
        } catch (ClassCastException e) {
            return;
        }
        elements.sort();
        this.clear();
        for (int i = 0; i < elements.size(); i++) {
            this.add(elements.get(i), false);
        }

    }
    /**
     * @function getNodeByIndex возвращает элемент по его индексу
     * @param index
     * @return Node
     * **/
    private Node getNodeByIndex(int index) {
        if (index == 0) return this.head;
        checkIndex(index);
        Node toSearch;
        toSearch = this.head;
        while (index != 0) {
            toSearch = toSearch.next;
            index--;
        }
        return toSearch;
    }
    /**
     * @function checkIndex проверяет индекс на его валидность
     * @param index
     * @return void
     * **/
    private void checkIndex(int index){
        if(index < 0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
    }
}