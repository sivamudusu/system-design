package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
       String s = "cabaabac";

       int n = s.length();
       int left = 0;
       int right = n-1;
       while(left< right){
           char l = s.charAt(left);
           char r = s.charAt(right);
           if(l==r){
               char chosen  = s.charAt(left);
               while(s.charAt(left)==chosen && left < right){
                   left++;
                   n--;
               }
               while (s.charAt(right)==chosen && left< right){
                   right--;
                   n--;
               }
           }else {
               System.out.println(n);
           }
       }
        System.out.println(n);
    }
}