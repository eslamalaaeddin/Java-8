package video4;

import java.util.stream.Stream;

public class MethodReference {
    public static void main(String[] args) {
        example4();
    }

    //What is method reference?
    static void example1() {
        Stream.of("1","2","3")
                    //regular lambda expression
//                .forEach(element -> System.out.println(element));
                //This is method reference
                .forEach(System.out::println);
    }

    static void example2(){
        MethodReference methodReference = new MethodReference();
        Stream.of("1","2","3")
                .map(Integer::parseInt)//Static method ref
                .map(Integer::floatValue)//Method called on items from stream
                .forEach(methodReference::justPrint);//Instance method ref

    }
    //Method reference have two arguments
    static void example3(){
        System.out.println(Stream.of("1", "2", "3")
                .map(Integer::parseInt)
//                .reduce(0, (acc, e) -> Integer.sum(acc, e)));
                .reduce(0, Integer::sum));

    }

    //Method reference have two arguments and we call method on first arg
    static void example4(){
        System.out.println(Stream.of("1", "2", "3")
//                .reduce("", (acc, e) -> acc.concat(e)));
                .reduce("", String::concat));

    }
    void justPrint(Float e){
        System.out.println(e);
    }

}
