package Homework3;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by Maya on 17.12.2017. Дан текст, ваша задача — найти слово, которое встречается в тексте наибольшее количество раз.
 * Текст состоит только из латинских букв, пробелов, переводов строк.
 * Слово — это последовательность подряд идущих латинских букв, регистр не имеет значения.
 * Если искомых слов несколько, ваша задача — найти все такие слова.
 * Входные данные
 * Входные данные состоят только из латинских букв, пробелов и символов перевода строки.
 * Гарантируется, что хотя бы одно слово в текст присутствует.
 * Выходные данные
 * Выведите все слова, которые встречаются наибольшее количество раз,
 * при их следут приводить к нижнему регистру, каждое слово выводите на отдельной строке.
 * Слова выводите в лексикографическом порядке. Размер входного файла не превосходит 100 Кб.
 */
public class Solution2056 {
    public static void main(String[] args) {
        Map<String, Integer> wordsInText = new TreeMap<String, Integer>();
        Scanner in = new Scanner(System.in);
        String word;
        Integer amount = 1, maxAmount = 0;
        // заполнение Мапы
        while(in.hasNext()){
            word = in.next();
            if (wordsInText.containsKey(word)) {
                amount = wordsInText.get(word) + 1;
            } else
                amount = 1;
            wordsInText.put(word, amount);

            if (amount > maxAmount)
                maxAmount = amount;
        }

        System.out.println(wordsInText);

        for( Map.Entry<String, Integer> entry : wordsInText.entrySet() ){
            if (entry.getValue() == maxAmount)
                System.out.println(entry.getKey());
        }

    }
}
