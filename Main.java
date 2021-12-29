package com.company;
import java.util.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;
import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {
        System.out.println("Input n");
        Integer k;
        Scanner input = new Scanner(System.in);
        k = input.nextInt();
        Integer n = new Integer(k);
        Double[][] matrix = new Double[n][n];
        Double[][] matrix2 = new Double[n][n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++) {
                matrix[i][j] = Math.random()*12;
                matrix2[i][j] = Math.random()*12;
            }
        }
        System.out.println("Matrix 1");
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(4);
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++) {
                System.out.print(matrix[i][j].doubleValue() + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        Double[][] matrix3 = new Double[n][n];
        for(int i = 0; i<n; i++){
            Double mul = new Double (1);

            for(int j = 0; j<n; j++) {
                mul *= matrix2[i][j];

            }
            System.out.println("Multiplication of i = " + i +" row: " + mul);
            for(int j = 0; j<n; j++) {
                matrix3[i][j] = matrix[i][j] + mul;
            }

        }
        System.out.println("New Matrix");
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++) {
                 System.out.print(df.format(matrix3[i][j].doubleValue()) + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        Double[] matrix4 = new Double[n];
        System.out.println("Copying first row");
        matrix4 = Arrays.copyOfRange(matrix2[0], 1,n+1);
        for(int i = 0; i<n-1; i++){
            System.out.println(df.format(matrix4[i].doubleValue())+" ");
        }
        System.out.println();
        System.out.println();
        System.out.println("Matrix 2");
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++) {
                System.out.print(df.format(matrix2[i][j].doubleValue()) + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println("Input i, j");
        k = input.nextInt();
        Integer m;
        m = input.nextInt();
        matrix4 = Arrays.copyOfRange(matrix2[0], k, m);

        Arrays.sort(matrix4, new myComparator());
        for(int i = k; i<m; i++){
            matrix2[0][i] = matrix4[i-k];
        }
        System.out.println("Sorted Matrix");
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++) {
                System.out.print(df.format(matrix2[i][j].doubleValue()) + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("2 Strings using Special DecimalFormat Methods");
        String pattern = "%";
        df.applyPattern(pattern);
        for (int i = 0; i < n; i++)
            System.out.print(df.format(matrix2[0][i]) + " ");
        System.out.println();
        pattern = "¤";
        df.applyPattern(pattern);
        for (int i = 0; i < n; i++)
            System.out.print(df.format(matrix2[1][i]) + " ");
        System.out.println();
    }

}

