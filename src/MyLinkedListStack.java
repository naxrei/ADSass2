import java.util.EmptyStackException;

public class MyLinkedListStack<T> {

    MyLinkedList myLinkedList = new <T>MyLinkedList();

    MyLinkedListStack() {}
    /**

     Adds an element to the top of the stack.
     @param element The element to be added.
     */
    public void push(T element) {
        myLinkedList.add(element, 0);
    }
    /**

     Removes and returns the element at the top of the stack.
     @return The element at the top of the stack.
     @throws EmptyStackException If the stack is empty.
     */
    public T pop() {
        isEmptyThrowException();
        return (T) myLinkedList.remove(0);
    }
    /**

     Returns the element at the top of the stack without removing it.
     @return The element at the top of the stack.
     @throws EmptyStackException If the stack is empty.
     */
    public T peek() {
        isEmptyThrowException();
        return (T) myLinkedList.get(0);
    }
    /**

     Returns the number of elements in the stack.
     @return The number of elements in the stack.
     */
    public int size() {
        return myLinkedList.size();
    }
    /**

     Returns the number of elements in the queue.
     @return The number of elements in the queue.
     */
    private void isEmptyThrowException() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
    }
    /**

     Returns true if the stack is empty, false otherwise.
     @return True if the stack is empty, false otherwise.
     */
    public boolean isEmpty() {
        return this.size() == 0;
    }
}