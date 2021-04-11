package solution4.bread;

import util.Util;

import java.util.ArrayList;
import java.util.HashSet;

public class FindingPrimeNum {
    public static class Solution {
        HashSet<Integer> numberArray;
        public int solution(String numbers) {
            numberArray = new HashSet<>();

            int answer = 0;
            int len = numbers.length();
            String[] numberList = numbers.split("");

            for(int i=1; i<=len; i++) {
                permutation(numberList, 0, len, i);
            }

            for(Integer i : numberArray) {
                System.out.println(i);
            }

            return numberArray.size();
        }
        public void permutation(String[] arr, int depth, int n, int r) {
            if (depth == r) {
                int number = getNumber(arr, r);

                boolean isPrime = false;

                // 소수 검사
                for(int i=2 ; i<=number/2 ; i++) {
                    if(number%i == 0) {
                        isPrime = true;
                        break;
                    }
                }
                if(!isPrime && number >1) {
                    numberArray.add(number);
                }

                return;
            }

            for (int i=depth; i<n; i++) {
                swap(arr, depth, i);
                permutation(arr, depth + 1, n, r);
                swap(arr, depth, i);
            }
        }

        public void swap(String[] arr, int depth, int i) {
            String temp = arr[depth];
            arr[depth] = arr[i];
            arr[i] = temp;
        }

        public int getNumber(String[] arr, int r) {
            String temp = "";

            for (int i = 0; i < r; i++) {
                temp += arr[i];
            }
            int number = Integer.parseInt(temp);

            return number;
        }
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        String numbers = "110";

        int ans = s.solution(numbers);

        Util.print(ans);
    }
}
