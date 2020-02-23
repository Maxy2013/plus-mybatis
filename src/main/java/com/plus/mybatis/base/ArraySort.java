package com.plus.mybatis.base;

public class ArraySort {

    public static void main(String[] args) {


        int[] intArr = {2, 5, 8, 6, 11, 23, 17, 13, 4};//9个元素

        for(int i = 0; i < intArr.length; i++){

            for(int j = 0; j < intArr.length - i - 1; j++){
                if(intArr[j] < intArr[j + 1]){
                    int temp = intArr[j];
                    intArr[j] = intArr[j + 1];
                    intArr[j + 1] = temp;
                }
            }
        }
        for(int k = 0; k < intArr.length; k++){
            System.out.print("\t" + intArr[k]);
        }

        System.out.println("最大值是" + intArr[0]);
        for(int i = 0; i < intArr.length; i++){

            for(int j = 0; j < intArr.length - i - 1; j++){
                if(intArr[j] > intArr[j + 1]){
                    int temp = intArr[j];
                    intArr[j] = intArr[j + 1];
                    intArr[j + 1] = temp;
                }
            }
        }
        for(int k = 0; k < intArr.length; k++){
            System.out.print("\t" + intArr[k]);
        }
    }
}
