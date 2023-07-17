import java.util.EmptyStackException;

public class MyArrayListStack<T> {
    MyArrayList myArrayList = new <T>MyArrayList();

    MyArrayListStack() {}
    /**

     Adds an element to the top of the stack.
     @param element The element to be added.
     */
    public void push(T element) {
        myArrayList.add(element, 0);
    }
    /**

     Removes and returns the element at the top of the stack.
     @return The element at the top of the stack.
     @throws EmptyStackException If the stack is empty.
     */
    public T pop() {
        isEmptyThrowException();
        return (T) myArrayList.remove(0);
    }
    /**

     Returns the element at the top of the stack without removing it.
     @return The element at the top of the stack.
     @throws EmptyStackException If the stack is empty.
     */
    public T peek() {
        isEmptyThrowException();
        return (T) myArrayList.get(0);
    }
    /**

     Returns the number of elements in the stack.
     @return The number of elements in the stack.
     */
    public int size() {
        return myArrayList.size();
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

    public boolean isEmpty() {
        return this.size() == 0;
    }
}