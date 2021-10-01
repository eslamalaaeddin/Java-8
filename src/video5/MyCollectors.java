package video5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MyCollectors {
    static class User implements Comparable<User> {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(User o) {
            return o.age;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<User> users = new ArrayList<>() {{
            add(new User(7, "Ahmad"));
            add(new User(7, "Mohammad"));
            add(new User(7, "Islam"));
            add(new User(15, "Said"));
            add(new User(15, "Khalid"));
        }};

        System.out.println(users.stream()
                .map(user -> user.age)
                .collect(Collectors.toList()));

        users.stream()
                .max(Comparator.comparing(user -> user.age))
                .ifPresent(user -> System.out.println(user.name));

        users.stream()
                .collect(Collectors.partitioningBy(user -> user.age >= 10 ))
                .forEach((aBoolean, partitionedUsers) -> System.out.println(aBoolean + "->" + partitionedUsers));

        users.stream()
                .collect(Collectors.groupingBy(user -> user.age))
                .forEach((integer, groupedUsers) -> System.out.println(integer + "->" + groupedUsers));
    }
}
