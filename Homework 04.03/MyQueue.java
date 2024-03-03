public class MyQueue {
    private int CAPACITY = 10;
    private int[] array;
    private int size = 0;
    private int last = -1;
    private int first = 0;
    public MyQueue(){
        array = new int[CAPACITY];
    }
    public MyQueue(int capacity){
        this.CAPACITY = capacity;
        array = new int[CAPACITY];
    }
    public void push(int value){
        if (size == CAPACITY){
            System.out.println("queue is full");
        } else {
            last = (last + 1) % CAPACITY;
            array[last] = value;
            size++;
        }
    }
    public int pop(){
        if (size == 0){
            System.out.println("queue is empty");
            return -1;
        }else {
            int ans = array[first];
            if (size == 1){
                first = -1;
                last = -1;
            }
            first = (first + 1) % CAPACITY;
            size--;
            return ans;
        }
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int peek(){
        return array[first];
    }
}
