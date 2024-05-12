public class Main {
    public static void main(String[] args) {
        double[] array = Tests.generateArray(10000);
        Tests.createFile(array, "testarray");
        RedBlackTree tree = new RedBlackTree();
        long startTime;
        long endTime;
        //adding
        double[] time = new double[10000];
        double[] operations = new double[10000];
        for (int i = 0; i < 10000; i++) {
            startTime = System.nanoTime();
            tree.insert((int) array[i]);
            endTime = System.nanoTime();
            time[i] = (double) (endTime - startTime) / 10000;
            operations[i] = RedBlackTree.operations;
            RedBlackTree.operations = 0;
        }
        Tests.createFile(time, "addTime");
        Tests.createFile(operations, "addOperations");
        //finding
        time = new double[100];
        operations = new double[100];
        for (int i = 0; i < 100; i++) {
            int randIndex = (int) (Math.random() * 10000);
            startTime = System.nanoTime();
            tree.search((int) array[randIndex]);
            endTime = System.nanoTime();
            time[i] = (double) (endTime - startTime) / 10000;
            operations[i] = RedBlackTree.operations;
            RedBlackTree.operations = 0;
        }
        Tests.createFile(time, "findTime");
        Tests.createFile(operations, "findOperations");
        //delete
        time = new double[1000];
        operations = new double[1000];
        for (int i = 0; i < 1000; i++) {
            int randIndex = (int) (Math.random() * 9000);
            startTime = System.nanoTime();
            tree.delete((int) array[randIndex]);
            endTime = System.nanoTime();
            time[i] = (double) (endTime - startTime) / 10000;
            operations[i] = RedBlackTree.operations;
            RedBlackTree.operations = 0;
        }
        Tests.createFile(time, "deleteTime");
        Tests.createFile(operations, "deleteOperations");
    }

}
