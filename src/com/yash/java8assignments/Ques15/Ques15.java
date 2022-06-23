package com.yash.java8assignments.Ques15;

//From a given set of numbers in array, you need to find out how many number satisfy the Pythagoras template

import java.util.Scanner;

public class Ques15 {
    public static void main(String[] args)
    {
        System.out.println("Enter the length of array: ");
        Scanner sr = new Scanner(System.in);
        int n = sr.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter the element "+(i+1)+": ");
            arr[i] = sr.nextInt();
        }
        int a,b,c;
        //selecting the element
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n-1;j++)
            {
                for(int k=i+2;k<n;k++)
                {
                    a = arr[i];
                    b = arr[j];
                    c = arr[k];
                    if(a*a + b*b == c*c)
                        System.out.println("Elements satisfying the pythagoras triplets are: "+a +"  "+b+"  "+c);
                }
            }
        }
    }
}
