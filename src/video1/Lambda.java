package video1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class Lambda {

    public static void main(String[] args) {
        example1();
        example2();
        example3();
        example4();
        example5();
    }

    static int sum(MyInterface myInterface) {
        return myInterface.getSum(3, 4);
    }

    @FunctionalInterface
    interface MyInterface {
        int getSum(int arg1, int arg2);
    }

    static void example1() {
        //Example 1
        //Old Way
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello Old");
            }
        });

        //New Way
        Thread thread2 = new Thread(() -> System.out.println("Hello New"));

        thread1.start();
        thread2.start();
    }

    static void example2() {
        //Example 2
        MyInterface myInterface = (int arg1, int arg2) -> arg1 + arg2;
        System.out.println(sum(myInterface));
    }

    static void example3() {
        List<Integer> numbers = new ArrayList<>() {{
            add(4);
            add(3);
            add(2);
            add(1);
            add(5);
        }};

        //it takes functional interface as an argument
        numbers.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

        //Another way
        Consumer<Integer> consumer = (integer) -> System.out.println(integer);
        numbers.forEach(consumer);

        //With lambda expression
        numbers.forEach((Integer integer) -> System.out.println(integer));


    }

    static void example4() {
        List<Integer> numbers = new ArrayList<>() {{
            add(4);
            add(3);
            add(2);
            add(1);
            add(5);
        }};


        //Sorting
//        Collections.sort(numbers, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                //ASC
//                return o1 - o2;
//                //DESC
//                //return o2 - o1;
//            }
//        });
//        System.out.println(numbers);

        //Another Way
//        Comparator<Integer> comparator = (Integer integer1, Integer integer2) -> integer1 - integer2;
//        Collections.sort(numbers, comparator);
//        System.out.println(numbers);

        //With video1.Lambda
//        Collections.sort(numbers, (Integer integer1, Integer integer2) -> integer1 - integer2);
//        System.out.println(numbers);
    }

    static void example5() {
        //Method reference
        List<Integer> numbers = new ArrayList<>() {{
            add(4);
            add(3);
            add(2);
            add(1);
            add(5);
        }};
        //You can define a method and pass it as a parameter to sort method
        Collections.sort(numbers, Lambda::compareForExample5);
    }

    static int compareForExample5(Integer integer1, Integer integer2){
        System.out.println(integer1);
        System.out.println(integer2);
        return integer1 - integer2;
    }
}
