package org.example.bitwiseAND;

public class Client {
    public static void main(String[] args) {
        int left = 1;
        int right = 21474;
        int current = left;

        for(int i=left+1;i<=right;i++){
            current = current & i;
        }

        System.out.println(current);
    }
}
