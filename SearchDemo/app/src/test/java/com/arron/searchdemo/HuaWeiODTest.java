package com.arron.searchdemo;

import org.junit.Test;

import java.util.Scanner;

/**
 * create by Aaron Xie
 * on 2021/3/30
 * description:
 */
public class HuaWeiODTest {

    @Test
    public void main() {
        Scanner sc = new Scanner(System.in);
        sc.hasNext();
        System.out.println();
        Integer integer;
    }

    @Test
    public void main2() {
        int count = count(8, 6);
        System.out.println(count);
    }

    private int count(int m, int n) {
        if (m == 0 || n == 1) {
            return 1;
        } else if (m < n) {
            return count(m, m);
        } else {
            return count(m, n - 1) + count(m - n, n);
        }
    }
}
