public class MyArrayListQueue<T> {
    MyArrayList myArrayList = new <T>MyArrayList();

    MyArrayListQueue() {}
    /**

     Adds an element to the back of the queue.
     @param element The element to be added.
     */
    public void enqueue(T element) {
        myArrayList.add(element);
    }
    /**

     Remove elements from the front of queue
     */
    public T dequeue() {
        return (T) myArrayList.remove(0);
    }
    /**

     Returns the element at the front of the queue without removing it.
     @return The element at the front of the queue.
     @throws NoSuchFieldException If the queue is empty.
     */
    public T peek() throws NoSuchFieldException {
        isEmptyThrowException();
        return (T) myArrayList.get(0);
    }
    /**

     Returns the number of elements in the queue.
     @return The number of elements in the queue.
     */
    public int size() {
        return myArrayList.size();
    }
    /**

     Returns the number of elements in the queue.
     @return The number of elements in the queue.
     */
    private void isEmptyThrowException() throws NoSuchFieldException {
        if (isEmpty()) {
            throw new NoSuchFieldException();
        }
    }
    /**

     Returns true if the queue is empty, false otherwise.
     @return True if the queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        return this.size() == 0;
    }
}