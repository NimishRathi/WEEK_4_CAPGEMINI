package com.capgeminitraining.day2;
import java.util.*;
class ReverseList{
    public static <T> void  reverseList(List<T> list ){
        int left = 0; int right = list.size() -1;
        while(left<right) {
            T temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        ReverseList.reverseList(arrayList);
        System.out.println(arrayList);

        List<Integer> linkedList  = new LinkedList<>(Arrays.asList(8,9,6,2,1,74));
        ReverseList.reverseList(linkedList);
        System.out.println(linkedList);
    }
}