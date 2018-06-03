package com.lectures.lecture10;

import lombok.Data;

import java.util.*;

@Data
public class CollectionUtils {


    public static int countUnique(List<Integer> list) {
        int count = 0;
        if (list == null) {
            return 0;
        }
        HashSet<Integer> uniqueList = new HashSet<>();
        for (Integer ilist : list) {
            uniqueList.add((Integer) ilist);
        }

        for (Integer ilist : uniqueList) {
            count++;
        }
        return count;
    }

    public static boolean isUnique(HashMap<String, String> map) {
        Iterator<Map.Entry<String, String>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, String> entry = entries.next();
            String temp = (String) entry.getValue();
            int mark = 0;
            for (Map.Entry entry2 : map.entrySet()) {
                if (temp.equals(entry2.getValue())) {
                    mark++;
                }
            }
            if (mark > 1) {
                return false;
            }
        }
        return true;
    }

    public static void printPolynomial(LinkedHashMap<Integer, Integer> map) {
        int mark = 0;
        Iterator<Map.Entry<Integer,Integer>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<Integer, Integer> entry = entries.next();
            if ((!(mark == 0)) && (!((int) (entry.getValue()) == 0))&&(entry.getValue()) > 0) {
                System.out.print(" + ");
            }
            if (!((int) entry.getValue() == 0)) {
                if ((!((int) (entry.getKey()) == 0)) && (!((int) (entry.getKey()) == 1))) {
                    System.out.print(entry.getValue() + "x^" + entry.getKey());
                    mark = 1;
                } else if ((int) (entry.getKey()) == 1) {
                    System.out.print(entry.getValue() + "x");
                    mark = 1;
                } else if ((int) (entry.getKey()) == 0) {
                    System.out.print(entry.getValue());
                }
            }
        }
        System.out.println("");

    }
}

