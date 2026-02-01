package threadsbasic.immutable;

import java.util.*;

public class ImmutableClassExample {
    public static void main(String[] args) {
        List<String> contacts = Arrays.asList("12345", "6789");
        Map<String, String> map = Map.of("1", "one", "2", "two");

        ImmutableClass immutableClass = new ImmutableClass(1,"Peter", map, contacts,  new Date());

        System.out.println(immutableClass);
    }
}
