package video3;

import java.util.stream.IntStream;

public class ReduceOperation {
    public static void main(String[] args) {
        System.out.println(
                IntStream.of(1, 2, 3, 4, 5)
                        .reduce(0, (e1, e2) -> e1 + e2)
        );
    }
    //Identity element -> (0) == default value and also initial value

    // ACC   ELEMENT
    //  0(id)   1
    //  1       2
    //  3       3
    //  6       4
    //  10      5
    //  15      -
}
