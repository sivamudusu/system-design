package org.example.poeroftwo;

public class Main {
    public static void main(String[] args) {
        boolean answer = poweroftwo(12);
        System.out.println(answer);

    }
    public static boolean poweroftwo(int n){
        if (n ==1 || n == 2 ){
            return true;
        }
        if ( n%2 !=0)return false;
        while (n > 2){
            if ( n% 2 == 0){
                n = n/2;
            }else{
                return false;
            }
        }
        if (n ==2 )return true;
        return false;
    }
}
