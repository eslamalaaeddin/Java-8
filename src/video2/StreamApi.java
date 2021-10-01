package video2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamApi {
    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>(){{
            add(new Order(4,"A",120));
            add(new Order(2,"B",250));
            add(new Order(1,"C",395));
            add(new Order(6,"D",418));
            add(new Order(5,"E",513));
            add(new Order(3,"F",21));
        }};

        Comparator<Order> comparator = (Order o1,Order o2) -> o1.id - o2.id;

        System.out.println(orders.stream()
                .filter(order -> order.id % 2 == 0)//Take even orders
                .sorted(comparator)//Sort them ASC
                .map(order -> order.price)//Map each order to its price
                .collect(Collectors.toList()));//Get a list of order prices
    }

    static class Order{
        int id;
        String name;
        int price;

        public Order(int id, String name, int price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }
    }


}
