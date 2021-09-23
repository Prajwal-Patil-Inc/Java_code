import java.util.Scanner;
import java.lang.Thread;
class Task1 extends Thread{
    static int a, beg;
    Main m1 = new Main();
    int[] threadArray = new int[a];
    public void run(){
      beg = 0;
      int j = 0;
      for (int i=beg; i<=a; i++) {
            m1.threadArray[i] = j++;
      } 
    }
}

class Task2 extends Thread{
    static int a, beg;
    Main m2 = new Main();
    int[] threadArray = new int[a];
    public void run(){
        int j = beg;
       //beg=80 end=170
       for(int i=beg; i<=a+beg; i++) {
            m2.threadArray[i] = j++;
        } 
    }
}

class Task3 extends Thread{
    static int a, beg;    
    Main m3 = new Main();
    int[] threadArray = new int[a]; 
    public void run(){
        int j = beg;
        for(int i=beg; i<a+beg; i++) {
            m3.threadArray[i] = j++;
        }
    }
}
public class Main {
        public static final int[] threadArray = new int[300];
        public static volatile String i = 0+"";
    public boolean test() throws InterruptedException
    {
        Task1 task1 = new Task1();
        Task2 task2 = new Task2();
        Task3 task3 = new Task3();
        Thread task2Thread = new Thread(task2);
        Thread task3Thread = new Thread(task3);
        task1.start();
        task2Thread.start();
        task1.join();
        task2Thread.join();
        task3Thread.start();
        int first = Task1.a+Task2.a;
        int containsSecondThread = Task1.a;
        String oneAndTwo = "";
        String sizeOfTask1 = "";
        for(int i=0;i<first;i++)
        {
            oneAndTwo += threadArray[i]+" ";
            //System.out.println("oneAndTwo: "+oneAndTwo);
        }
        for(int i=0;i<containsSecondThread;i++)
        {
            sizeOfTask1 += threadArray[i]+" ";
            //System.out.println("sizeOfTask1: "+sizeOfTask1);
        }
        int begOfTask3 = Task3.beg;
        String checkingString = "";
        for(int i=begOfTask3;i<threadArray.length;i++)
        {
            checkingString += i + " ";
            //System.out.println("checkingString: "+checkingString);
        }
        String task3String = "";
        for(int j = begOfTask3;j<threadArray.length;j++)
        {
            task3String += threadArray[j]+" ";
        }
       /* System.out.println("oneAndTwo: "+oneAndTwo);
        System.out.println("begOfTask3: "+begOfTask3);
        System.out.println("sizeOfTask1: "+sizeOfTask1);
        System.out.println("Task2: "+Task2.beg);
        System.out.println("task3String: "+task3String);
        System.out.println("checkingString: "+checkingString); */
        System.out.println("This: "+sizeOfTask1.contains(Task2.beg+""));
        if(!(oneAndTwo.contains(begOfTask3+"") && sizeOfTask1.contains(Task2.beg+"")) && task3String.equals(checkingString))
        {
            return true;
        }
        return false;
    }
    public static void main(String[] args) throws InterruptedException 
    {
        Scanner sc= new Scanner(System.in);
            Main solution = new Main();
            int one = sc.nextInt();
            Task1.a = one;
            Task1.beg = 0;
            int two = sc.nextInt();
            Task2.a = two;
            Task2.beg = one;
            int three = sc.nextInt();
            Task3.a = three;
            Task3.beg = one+two;
            System.out.print("Final: "+solution.test());
    }
}
