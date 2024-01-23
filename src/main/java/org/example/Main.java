package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] list = new String[]{};
        System.out.println(total(list));
    }


    public static String total(String[] groceryList) {
        if (groceryList.length == 0) {
            return "The list is empty";
        }
        List<Integer> numbers = new ArrayList<>();
        char[] arrayOfCharacters = groceryList[0].toCharArray();
        for (char character : arrayOfCharacters) {
            if (Character.isDigit(character)) {
                numbers.add(Character.getNumericValue(character));
            }
        }
        if (numbers.isEmpty()) {
            return "The list doesn't contain the necessary data";
        }
        List<Integer> prices = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numbers.size(); i = i + 2) {
            int price = numbers.get(i) * numbers.get(i + 1);
            prices.add(price);
            stringBuilder.append(price);
            if (i + 2 < numbers.size()) {
                stringBuilder.append("+");
            }
        }
        stringBuilder.append("=");
        stringBuilder.append(prices.stream().reduce(0, Integer::sum));
        return stringBuilder.toString();
    }
}
