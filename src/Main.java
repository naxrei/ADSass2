public class Main {
    public static void main(String[] args) throws NoSuchFieldException {
//      ## MyLinkedListStack
        System.out.println("MyLinkedListStack");
        MyLinkedListStack myLinkedListStack = new <Integer>MyLinkedListStack();
        myLinkedListStack.push(1);
        myLinkedListStack.push(2);
        myLinkedListStack.push(3);
        System.out.println(myLinkedListStack.pop());
        System.out.println(myLinkedListStack.pop());
        System.out.println(myLinkedListStack.peek());


//      ## MyLinkedListQueue
        System.out.println("MyLinkedListQueue");
        MyLinkedListQueue myLinkedListQueue = new <Integer>MyLinkedListQueue();
        myLinkedListQueue.enqueue(1);
        myLinkedListQueue.enqueue(2);
        myLinkedListQueue.enqueue(3);
        System.out.println(myLinkedListQueue.dequeue());
        System.out.println(myLinkedListQueue.dequeue());
        System.out.println(myLinkedListQueue.peek());


//      ## MyArrayListStack
        System.out.println("MyArrayListStack");
        MyArrayListStack myArrayListStack = new <Integer>MyArrayListStack();
        myArrayListStack.push(1);
        myArrayListStack.push(2);
        myArrayListStack.push(3);
        System.out.println(myArrayListStack.pop());
        System.out.println(myArrayListStack.pop());
        System.out.println(myArrayListStack.peek());


//      ## MyArrayListQueue
        System.out.println("MyArrayListQueue");
        MyArrayListQueue myArrayListQueue = new <Integer>MyArrayListQueue();
        myArrayListQueue.enqueue(1);
        myArrayListQueue.enqueue(2);
        myArrayListQueue.enqueue(3);
        System.out.println(myArrayListQueue.dequeue());
        System.out.println(myArrayListQueue.dequeue());
        System.out.println(myArrayListQueue.peek());
    }
}