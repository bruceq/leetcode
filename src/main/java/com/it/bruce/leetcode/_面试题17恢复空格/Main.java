package com.it.bruce.leetcode._面试题17恢复空格;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
//        String[] dictionary = {"looked", "just", "like", "her", "brother"};
//        String sentence = "jesslookedjustliketimherbrother";
//        String[] dictionary = {"vprkj", "sqvuzjz", "ptkrqrkussszzprkqrjrtzzvrkrrrskkrrursqdqpp",
//                "spqzqtrqs", "rkktkruzsjkrzqq", "rk", "k", "zkvdzqrzpkrukdqrqjzkrqrzzkkrr",
//                "pzpstvqzrzprqkkkd", "jvutvjtktqvvdkzujkq", "r", "pspkr", "tdkkktdsrkzpzpuzvszzzzdjj",
//                "zk", "pqkjkzpvdpktzskdkvzjkkj", "sr", "zqjkzksvkvvrsjrjkkjkztrpuzrqrqvvpkutqkrrqpzu"};
//        String[] dictionary = {"vprkj", "sqvuzjz", "ptkrqrkussszzprkqrjrtzzvrkrrrskkrrursqdqpp",
//                "spqzqtrqs", "rkktkruzsjkrzqq", "rk", "k","zkvdzqrzpkrukdqrqjzkrqrzzkkrr",
//                "pzpstvqzrzprqkkkd", "jvutvjtktqvvdkzujkq", "r"};
//        String[] dictionary = {"rkktkruzsjkrzqq", "zkvdzqrzpkrukdqrqjzkrqrzzkkrr", "r"};
//        String sentence = "rkktkruzsjkrzqqzkvdzqrzpkrukdqrqjzkrqrzzkkrr";
        String[] dictionary = {"aaysaayayaasyya", "yyas", "yayysaaayasasssy",
                "yaasassssssayaassyaayaayaasssasysssaaayysaaasaysyaasaaaaaasayaayayysasaaaa",
                "aya", "sya", "ysasasy", "syaaaa", "aaaas", "ysa", "a", "aasyaaassyaayaayaasyayaa",
                "ssaayayyssyaayyysyayaasaaa", "aya", "aaasaay", "aaaa",
                "ayyyayssaasasysaasaaayassasysaaayaassyysyaysaayyasayaaysyyaasasasaayyasasyaaaasysasy",
                "aaasa", "ysayssyasyyaaasyaaaayaaaaaaaaassaaa", "aasayaaaayssayyaayaaaaayaaays", "s"};
        String sentence = "asasayaayaassayyayyyyssyaassasaysaaysaayaaaaysyaaaa";
        Main main = new Main();
        System.out.println(main.respace(dictionary, sentence));
    }

    public int respace(String[] dictionary, String sentence) {
        int[] dp = new int[sentence.length() + 1];
        for (int i = 1; i <= sentence.length(); i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 0; j < dictionary.length; j++) {
                if (sentence.substring(0, i).endsWith(dictionary[j])) {
                    int diff = i - dictionary[j].length();
                    dp[i] = Math.min(dp[diff], dp[i]);
                }
            }
        }
        return dp[sentence.length()];
    }




}
