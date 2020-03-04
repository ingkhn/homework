package de.telran;

import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        IntStream is1 = IntStream.of(90, 3, 5, 4, 4, 10);
        IntStream is2 = IntStream.of(30, 2, 3, 15);
        getNumbersCanBeDividedBy3and5(is1, is2).forEach(System.out::println);

        System.out.println(getSumOfAllBetween(2, 4));
    }

    public static IntStream getNumbersCanBeDividedBy3and5(IntStream is1, IntStream is2) {
        return IntStream.concat(is1.filter(value -> value % 3 == 0 && value % 5 == 0),
                is2.filter(value -> value % 3 == 0 && value % 5 == 0))
                .sorted()
                .skip(2);
    }

    public static int getSumOfAllBetween(int a, int b) {
        return IntStream.rangeClosed(a, b)
                .reduce((currentSum, currentNum) -> currentSum + currentNum)
                .orElse(0);
    }
}
