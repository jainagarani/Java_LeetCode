package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class
IntegerBasedOperations {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1,2,3,4,5);

        double sum = numbers.stream().filter(num -> num%2 ==0).map(num -> Math.pow(num,2)).reduce(0.0, (a,b) -> a+b);
        //System.out.println(sum);

        IntStream primeNumbers = IntStream.iterate(2,i->i+1).filter(IntegerBasedOperations::isPrimeNumber).limit(10);
        primeNumbers.forEach(System.out::println);

        List<Integer> primeNumberList = numbers.stream().filter(IntegerBasedOperations::isPrimeNumber).toList();
        primeNumberList.stream().forEach(System.out::println);

        //fibonacci
        List<Integer> fibSeries = Stream.iterate(new int[]{0,1}, f-> new int[]{f[1], f[0]+f[1]}).map(f-> f[0]).limit(10).toList();
        System.out.println("fib series "+fibSeries);

        String numStr = numbers.stream().map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println("numStr "+numStr);





    }

    public static boolean isPrimeNumber(int num){
        return num >1 && !IntStream.rangeClosed(2, (int)Math.sqrt(num)).anyMatch(n -> num%n ==0);
    }
}
