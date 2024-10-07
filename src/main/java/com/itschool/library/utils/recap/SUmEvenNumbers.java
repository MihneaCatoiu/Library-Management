package com.itschool.library.utils.recap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SUmEvenNumbers {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 55, 12, 42, 21, 33, 22, 16);

        int sum = 0;

        for (int number : numbers) {
            if (number % 2 == 0){
                sum += number;
            }
        }
        System.out.println("Your sum is: " + sum);

        int total = numbers.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("2nd sum: " + total);
    }
}
