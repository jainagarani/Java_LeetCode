package Streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CharacterBasedOperations {
    public static void main(String[] args) {
        String s1 = "abhcccdfjoooiiieq";


        List<Character> vowels = Arrays.asList('a','e','i','o','u');
        Map<Boolean, List<Character>> map = s1.chars().mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(vowels::contains));
        map.forEach((k,v)->
        {
            if(k){
                System.out.println("vowel is");
                System.out.println("value is "+v);
            }
            else{
                System.out.println("consonant is");
                System.out.println("value is "+v);
            }

        });

       Map<Character, Long> map1 = s1.chars().mapToObj(ch-> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
      // map1.entrySet().forEach(System.out::println);

       List<Character> charList= s1.chars().mapToObj(ch-> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(entry-> entry.getValue() > 1)
                .map(Map.Entry::getKey).toList();

       //charList.stream().forEach(System.out::println);

      Map<Character, Long> map3 = s1.chars().mapToObj(ch -> (char) ch)
               .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
               .entrySet().stream().filter(entry -> entry.getValue() >1)
               .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a,b) -> b, HashMap::new));

        map3.entrySet().forEach(System.out::println);

        //find first unique character

       Character firstUniqueCharacter = s1.chars().mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(e-> e.getValue() ==1)
                .map(Map.Entry::getKey).findFirst().get();
        //System.out.println("firstUniqueCharacter "+firstUniqueCharacter);

        //find the most repeated character

        Character mostRepeatedChar = s1.chars().mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(Comparator.comparingLong(e-> e.getValue()))
                .map(Map.Entry::getKey)
                .get();
        // System.out.println("mostRepeatedChar "+mostRepeatedChar);

        //reverse character in a string

        String reversedChar = s1.chars().mapToObj(ch -> (char) ch)
                .collect(Collectors.collectingAndThen(Collectors.toList(), list ->{
                    Collections.reverse(list);
                    return list.stream().map(String::valueOf).collect(Collectors.joining());

        }));
       // System.out.println("reversedChar "+reversedChar);

        //find palindrome
        String str = "raceuicar";
        Boolean isPalindrome = IntStream.rangeClosed(0, str.length()/2).allMatch(i -> str.charAt(i) == str.charAt(str.length()-1-i));
       // System.out.println("isPalindrome "+isPalindrome);

        //remove all duplicates
        String s2 = s1.chars().mapToObj(ch -> (char) ch)
                .distinct().map(String::valueOf).collect(Collectors.joining());
        //System.out.println("uniquestr "+s2);

        //sort characters alphabetically
        String s3 = s1.chars().mapToObj(ch -> (char) ch).sorted().map(String::valueOf).collect(Collectors.joining());
        //System.out.println("sort character "+s3);

        List<String> words = Arrays.asList("listen", "silent", "enlist", "hello", "world", "below", "elbow");
        Map<String, List<String>> map2 = words.stream().collect(Collectors.groupingBy(e -> e.chars()
                .mapToObj(ch-> (char) ch).sorted().map(String::valueOf).collect(Collectors.joining())));

        //System.out.println("anagram list "+map2);

        String str2 = "This is a coding practice";
        String[] arr = str2.split(" ");
        String s4 =IntStream.range(0, str2.length()).mapToObj(i -> str2.charAt(str2.length()-1-i)).collect(Collectors.collectingAndThen(Collectors.toList()
        ,list -> list.stream().map(String::valueOf).collect(Collectors.joining())));
        //System.out.println("reversed sentence "+s4);

        String s5 = Arrays.stream(arr).map(word -> new StringBuffer(word).reverse()).collect(Collectors.joining(" "));
        System.out.println("s5 is "+s5
        );





    }


}
