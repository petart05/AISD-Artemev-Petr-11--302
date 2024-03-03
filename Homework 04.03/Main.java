public class Main {
    public static void main(String[] args) {
        MyQueue nq = new MyQueue(3);
        System.out.println(nq.isEmpty());
        nq.push(4);
        nq.push(5);
        System.out.println(nq.pop());
        System.out.println(nq.peek());
        System.out.println(nq.isEmpty());
        nq.pop();
        nq.pop();
        nq.push(1);
        nq.push(1);
        nq.push(1);
        nq.push(1);
    }
}