import java.util.Arrays;

public class MyArrayList<T> implements MyList {
    private T[] arr;
    private int size;
    /**
     * @function constructor
     * @noparam
     * @return void
     **/
    MyArrayList(){
        this.arr = (T[]) new Object[5];
        this.size = 0;
    }
    /**
     * @function increaseBufferIfNeeded увеличиваем буфер массива
     * @noparams
     * @return void
     * **/
    public void increaseBufferIfNeeded(){
        if(size == arr.length){
            T[] newArr = (T[]) new Object[arr.length*5];
            for(int i=0; i< arr.length; i++){
                newArr[i]=arr[i];
            }
            arr = newArr;
        }
    }
    /**
     * @function size выдает длину массива
     * @noparams
     * @return int
     * **/
    @Override
    public int size() {
        return this.size;
    }
    /**
     * @function contains true если Object o в массиве
     * @param o объект поиска
     * @return boolean
     * **/
    @Override
    public boolean contains(Object o) {
        for(T element : arr) {
            if (o.equals(element)) return true;
        }
        return false;
    }
    /**
     * @function add добавляет объект в массив
     * @param item объект для добавления
     * @return void
     * **/
    @Override
    public void add(Object item) {
        increaseBufferIfNeeded();
        arr[size++] = (T) item;
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
        increaseBufferIfNeeded();
        for(int i = size; i>index; i--) {
            arr[i] = arr[i-1];
        }
        arr[index] = (T) item;
        size++;
    }
    /**
     * @function remove удаляет объект из массива
     * @param item объект удаления
     * @return boolean
     * **/
    // Complexity: 0(n^2)
    @Override
    public boolean remove(Object item) {
        int index = indexOf(item);
        if (index >= 0) {
            remove(index);
            return true;
        }
        return false;
    }
    /**
     * @function remove удаляет объект из массива
     * @param index индекст элемента для удаления
     * @return Object
     * **/
    @Override
    public Object remove(int index) {
        checkIndex(index);
        T temporary = this.arr[index];
        for(int i= index + 1; i<=size; i++){
            arr[i-1] = arr[i];
        }
        this.size--;
        return temporary;
    }
    /**
     * @function clear очищает массив
     * @noparam
     * @return void
     * **/
    public void clear(){
        this.arr = (T[]) new Object[5];
        this.size = 0;
    }
    /**
     * @function get возвращает объект из массива под его индексом
     * @param index индекс объекта
     * @return Object
     * **/
    @Override
    public Object get(int index) {
        checkIndex(index);
        return arr[index];
    }
    /**
     * @function indexOf возвращает индекс первого вхождения объекта
     * @param o объект для поиска
     * @return int
     * **/
    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals((T) o)) {
                return i;
            }
        }
        return -1;
    }
    /**
     * @function lastIndexOf возвращает индекс последнего вхождения объекта в массив
     * @param o объект для поиска
     * @return int
     * **/
    @Override
    public int lastIndexOf(Object o) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) if (arr[i].equals((T) o) && i > index) index = i;
        return index;
    }
    /**
     * @function sort сортирует массив (bubble sort, O(n^2))
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
        for(int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                if ((int) arr[j] < (int) arr[i]) {
                    T temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    /**
     * @function checkIndex проверяет индекс на его валидность в рамках структуры данных
     * @param index индекс
     * @return void
     * **/
    private void checkIndex(int index){
        if(index < 0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }

    public void addAllByIndex(T[] elements, int index) {
        increaseBufferIfNeeded();
        T[] left = (T[]) new Object[arr.length+elements.length];
        for (int i = 0; i < index; i++) {
            left[i] = arr[i];
        }
        int j = 0;
        for (int i = index; i < index + elements.length; i++) {
            left[i] = (T) elements[j++];
        }
        for (int i = index; i < this.size; i++) {
            left[++j] = arr[index];
        }
        this.size += elements.length;
        this.arr = left;
    }
}