package com.yash.java8assignments.Ques14;

//User will input the “ABCD” now you need to print how many permutation is created like BACD, CBAD, and many others.

import java.util.Scanner;

public class Ques14 {

    public static void main(String[] args)
    {
        System.out.println("Enter the String you want to permutate: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        //determines the length of the given string
        int length = str.length();
        Ques14 per= new Ques14();

        //calling the method to find the permutation
        per.permutation(str, 0, length-1);
    }
    //function to determine the permutations
    private void permutation(String str, int si, int li)
    {
        if (si == li)
            System.out.println(str);
        else
        {
            for (int i = si; i <= li; i++)
            {
                //calling user-defined swapping method
                str = swapChar(str,si,i);
                //calling permutation() method
                permutation(str, si+1, li);
                str = swapChar(str,si,i);
            }
        }
    }
    //method to swap characters
    public String swapChar(String str, int i, int j)
    {
        char temp;
        char[] chArray = str.toCharArray();
        temp = chArray[i] ;
        chArray[i] = chArray[j];
        chArray[j] = temp;
        return String.valueOf(chArray);
    }

}
