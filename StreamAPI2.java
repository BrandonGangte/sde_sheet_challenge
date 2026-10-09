import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPI2 {
    public static void main(String[] args){
        int[] nums = new int[]{1,2,3,4,5,5,6,7,8,9,10};
        String[] s = new String[]{"apple","banana","2go","apple","367","cherry","banana","1start","190",};
        List<Integer> numlist = Arrays.stream(nums).boxed().toList();
        int[] arr1 = new int[]{9,4,7,2,0,1};
        int[] arr2 = new int[]{3,9,2,5,1,7};

        //separate odd and even
        Map<String,List<Integer>> oddEvenMap = numlist.stream().collect(Collectors.groupingBy(num->(num%2==0 ? "EVEN" : "ODD")));
        System.out.println(oddEvenMap);

        // Frequency of each character in a String
        String str = "HelloIamdoingmyStreamapipractice";
        Map<String,Long> charCount = Arrays.stream(str.split("")).collect(Collectors.groupingBy(c->c,Collectors.counting()));
        System.out.println(charCount);

        //Sort the list in reverse order
        List<Integer> reverseNumList = numlist.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println(reverseNumList);

        //print multiple of 5 from the list
        numlist.stream().filter(num->num%5==0).forEach(System.out::println);

        //merged two unsorted Arrays into one sorted array
        int[] sortedArray = IntStream.concat(Arrays.stream(arr1),Arrays.stream(arr2)).sorted().toArray();
        System.out.println(Arrays.toString(sortedArray));

        //merged two unsorted Arrays into one sorted array without duplicates
        int[] distinctSorted = IntStream.concat(Arrays.stream(arr1),Arrays.stream(arr2)).distinct().sorted().toArray();
        System.out.println(Arrays.toString(distinctSorted));

        // Three max and min numbers from the list
        List<Integer> maxthree = numlist.stream().sorted(Comparator.reverseOrder()).limit(3).toList();
        List<Integer> minThree = numlist.stream().sorted().limit(3).toList();

        System.out.println(maxthree);
        System.out.println(minThree);

        //Sort list of string in increasing order of their length
        Arrays.stream(s).sorted(Comparator.comparing(String::length)).collect(Collectors.toList()).forEach(System.out::println);

        //Sum and Avg of list of numbers
        System.out.println("Sum = " + numlist.stream().reduce(Integer::sum).get());
        System.out.println("Sum of array = "+ Arrays.stream(nums).sum());

        System.out.println("Average = "+ numlist.stream().mapToInt(num->num).average().getAsDouble());
        System.out.println("Avegrae of array = "+Arrays.stream(nums).average().getAsDouble());

        //Reverse an integer array
        System.out.println(Arrays.toString(IntStream.rangeClosed(1,arr1.length).map(i->arr1[arr1.length-i]).toArray()));

        //Palindrome
        String inputStr = "wow";
        System.out.println(IntStream.range(0,inputStr.length()/2).allMatch(i->inputStr.charAt(i)==inputStr.charAt(inputStr.length()-i-1)));

        //Last element of an array
        System.out.println(Arrays.stream(arr2).skip(arr2.length-1).findFirst().getAsInt());
        System.out.println(numlist.stream().skip(numlist.size()-1).findFirst().get());

        //years in between
        LocalDate birthDate = LocalDate.of(1998,02,07);
        LocalDate presentDate = LocalDate.now();
        System.out.println(ChronoUnit.YEARS.between(birthDate,presentDate));

        //Remove duplicate from list
        System.out.println(numlist.stream().distinct().toList());

        //Frequency of each element in an array
        Map<Integer,Long> freq = numlist.stream().collect(Collectors.groupingBy(i->i,Collectors.counting()));
        System.out.println(freq);

        //Join list of String with delimiter, prefix and suffix
        System.out.println(Arrays.stream(s).collect(Collectors.joining(" ","\"" ,"\"")));

        //max and min in a list
        System.out.println(Arrays.stream(arr2).max().getAsInt());
        System.out.println(numlist.stream().min(Comparator.naturalOrder()).get());

        Arrays.stream(str.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());

        //Sum of all digits in array
        System.out.println("Sum = "+Arrays.stream(arr2).sum());

        //Sum of all digit in num
        int n1 = 40348578;
        System.out.println(Arrays.stream(String.valueOf(n1).split("")).map(Integer::valueOf).reduce(Integer::sum).get());

        //Common in list
        List<Integer> arr1list = Arrays.stream(arr1).boxed().toList();
        List<Integer> arr2list = Arrays.stream(arr2).boxed().toList();

        System.out.println(arr1list.stream().filter(arr2list::contains).toList());

        //reverse each word of a string
        String str2 = "reverse each word of a string";
        System.out.println(Arrays.stream(str2.split(" ")).map(w->new StringBuffer(w).reverse()).collect(Collectors.joining(" ")));

        //reverse each char of a string
        System.out.println(new StringBuffer(str).reverse());

        //reverse each word position in string
        String[] strArr = str2.split(" ");
        System.out.println(IntStream.range(0,strArr.length).mapToObj(i->strArr[strArr.length-i-1]).collect(Collectors.joining(" ")));

        //get first char of each word in string
        System.out.println(Arrays.stream(str2.split(" ")).map(w->w.charAt(0)).toList());

        //First string starts with number
        Arrays.stream(s).filter(w->Character.isDigit(w.charAt(0))).forEach(System.out::println);
        System.out.println("----");
        Arrays.stream(s).filter(w->w.matches(".*\\d.*")).forEach(System.out::println);

        //find duplicates from array
        Set<Integer> set = new HashSet<>();
        System.out.println(numlist.stream().filter(n-> !set.add(n)).collect(Collectors.toSet()));

        //finbonacci series
        Stream.iterate(new int[]{0,1},x->new int[]{x[1],x[0]+x[1]}).limit(10).map(n->n[0]).forEach(i-> System.out.print(i+" "));
        System.out.println("");

        // fetch longest word in a sentence
        String longestword = Arrays.stream(str2.split(" ")).sorted((a,b)->b.length()-a.length()).findFirst().get();
        System.out.println("longest word = "+longestword);

        // fetch shortest word in a sentence
        String shortest = Arrays.stream(str2.split(" ")).sorted((a,b)->a.length()-b.length()).findFirst().get();
        System.out.println("shortest word = "+shortest);

        //Employee with salary greater than 50,000
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Kelly", 29, 75000, "IT"));
        employeeList.add(new Employee("Rahul", 25, 45000, "HR"));
        employeeList.add(new Employee("Priya", 28, 60000, "Finance"));
        employeeList.add(new Employee("Amit", 32, 50000, "IT"));
        employeeList.add(new Employee("Sneha", 26, 90000, "Finance"));
        employeeList.add(new Employee("John", 30, 35000, "HR"));
        employeeList.add(new Employee("Neha", 27, 85000, "IT"));
        employeeList.add(new Employee("Vikram", 35, 70000, "Finance"));

        employeeList.stream().filter(e->e.getSalary()>50000).toList().forEach(System.out::println);
    }
}
