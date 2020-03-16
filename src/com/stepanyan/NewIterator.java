package com.stepanyan;

import java.util.ArrayList;
import java.util.List;

public class NewIterator {

    private int[][] arr;
    private List<innerList> inList;
    private int size;
    private int cur;

    public NewIterator(int[][] arr) {
        this.arr = arr;
        this.size = getSize();
        this.cur = -1;
        this.inList = mergedList();
    }

    public boolean hasNext() {
        return cur < size - 1;
    }

    public int next() {
        int index = 0;
        int min = 0;
        for (NewIterator.innerList innerList : inList) {
            if (innerList.hasNext()) {
                min = innerList.getCur();
                break;
            }
        }
        for (int i = 0; i < inList.size(); i++) {
            if (inList.get(i).hasNext() && inList.get(i).getCur() <= min) {
                min = inList.get(i).getCur();
                index = i;
            }
        }
        cur++;
        return inList.get(index).next();
    }

    public int getSize() {
        for (int[] ints : arr) {
            size += ints.length;
        }
        return size;
    }

    private List<innerList> mergedList() {
        List<innerList> inList = new ArrayList<>();
        for (int[] ints : arr) {
            inList.add(new innerList(ints));
        }
        return inList;
    }

    private static class innerList {

        private int[] arr;
        private int cur; //TODO rename this

        public innerList(int[] arr) {
            this.arr = arr;
            this.cur = -1;
        }

        public boolean hasNext() {
            return cur < arr.length - 1;
        }

        public int next() {
            return arr[++cur];
        }

        public int getCur() {
            return arr[cur + 1];
        }

    }

}
