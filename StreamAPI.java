import java.util.Arrays;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPI {
    public static void main(String[] args){
        int[] nums = new int[]{1,2,3,4,5,5,6,7,8,9,10};
        String[] s = new String[]{"apple","banana","apple","367","cherry","banana","1start","190","2go"};
        List<Integer> numbers = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<String> strings = Arrays.asList(s);

        // Separate odd and even numbers
        System.out.println("1. Separate Even and Odd:");
        Map<String, List<Integer>> evenOdd = numbers.stream().collect(Collectors.groupingBy(i->(i%2==0 ? "even" : "odd")));
        System.out.println(evenOdd);

        //Remove duplicate from list
        System.out.println("2. Remove dupblicate from list");
        List<String> unique = strings.stream().distinct().collect(Collectors.toList());
        List<Integer> nq = numbers.stream().distinct().collect(Collectors.toList());
        System.out.println(unique);
        System.out.println(nq);

        //Frequency of characters
        System.out.println("3. Frequency of characters");
        String input = "programming";
        System.out.println(input.chars().mapToObj(c->(char) c).collect(Collectors.groupingBy(c->c,Collectors.counting())));

        //Frequency of elements
        System.out.println("4. Frequency of elements");
        Map<Integer,Long> elementFreq = numbers.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(elementFreq);

        //Sort Reverse
        System.out.println("5. Sort in reverse");
        numbers.stream().sorted(Comparator.reverseOrder()).forEach(System.out::print);
        System.out.println();
        List<Integer> listRevSorted = numbers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        int[] revNum = Arrays.stream(nums).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
        System.out.println(listRevSorted);

        //Join with Prefix and Suffix
        System.out.println("6. Join with prefix and suffix");
        String joined = strings.stream().collect(Collectors.joining("|","{","}"));
        System.out.println(joined);
        String joinedNum = numbers.stream().sorted(Comparator.reverseOrder()).map(String::valueOf).collect(Collectors.joining("/","[","]"));
        System.out.println(joinedNum);


        System.out.println("13. Sum & Average:");
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        double avg = numbers.stream().mapToInt(Integer::intValue).average().getAsDouble();
        System.out.println("Sum: " + sum + ", Avg: " + avg);

        System.out.println("Second Largest");
        int secondLargest = numbers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println(secondLargest);
        String sentence = "ksdf erw dflsje ererw et   rtd   jfdrweras sdfserrr";
        String firstChar = Arrays.stream(sentence.split("\\s+")).map(w->String.valueOf(w.charAt(0))).collect(Collectors.joining(" "));
        System.out.println(firstChar);
        List<Character> charList = Arrays.stream(sentence.split(" ")).filter(word->!word.isEmpty()).map(c->c.charAt(0)).collect(Collectors.toList());
        System.out.println(charList);

        System.out.println("Avg ");
        //char[] charArr = Arrays.stream(sentence.split(" ")).filter(word->!word.isEmpty()).map(c->c.charAt(0)).toArray();
        int sumAvg = IntStream.range(1,11).sum();
        System.out.println(sumAvg);

        //Min & Max in a list
        int minNum = numbers.stream().min(Comparator.naturalOrder()).get();
        int maxNum = numbers.stream().max(Comparator.naturalOrder()).get();
        System.out.println("Min = "+minNum+"\n"+"Max = "+maxNum);

        //Sum of all digits in a number
        int numExample = 4672319;
        int sumAllDigit = Stream.of(String.valueOf(numExample).split("")).collect(Collectors.summingInt(Integer::parseInt));
        System.out.println("Sum  = " + Arrays.stream(String.valueOf(numExample).split("")).mapToInt(Integer::parseInt).sum());
        System.out.println("Sum of all digits = "+sumAllDigit);

        List<Integer> threeMaxList = numbers.stream().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList());
        System.out.println(threeMaxList);

        //Sort list of string in increasing order of their length
        List<String> sortedStrings = strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());

        System.out.println(sortedStrings);

        List<String> numbersonly = strings.stream().filter(w->w.matches("\\d+")).collect(Collectors.toList());
        System.out.println(numbersonly);
        
    }
}
