package de.telran;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
    }


    public static int getSumOfPow(List<Integer> numbers){

        return numbers.stream().collect(Collectors.reducing(0, (res, elt) -> res + elt * elt));
    }


    public static Map<Boolean, List<String>> isPalindrome (List<String> words){

        return words.stream().collect(Collectors.partitioningBy(word -> {
            int length = word.length();
            for (int i = 0; i < length / 2; i++)
                if (word.charAt(i) != word.charAt(length - 1 - i))
                    return false;
            return true;
        }));
    }

    public static Map<Integer, Long> getTotalSumForEachAccount(List<Transaction> transactions){

        return transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getAccId, 
                        Collectors.summingLong(Transaction::getSum)));
    }
}
