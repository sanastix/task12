package com.stepanyan;

public class Iteration {

    /*
    List of K sorted arrays:
    [1,2,5]
    [2,3]
    [1,3,4,7]
    create iterator:
    [1,1,2,2,3,3,4,5,7]
     */

    public static void main(String[] args) {

        int[][] arr = {
                {1,2,5},
                {2,3},
                {1,3,4,7}
        };

        NewIterator iterator = new NewIterator(arr);
        while(iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

    }

}
