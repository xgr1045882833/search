package com.arron.searchdemo;

import org.junit.Test;

/**
 * create by Aaron Xie
 * on 2021/1/25
 * description:
 */
public class StringTest {

    @Test
    public void test() {
        String string = "adjaljdlajlf";
        String substring = string.substring(5);
        System.out.println(substring);
        String substring1 = string.substring(1, 3);
        System.out.println(substring1);
    }

    @Test
    public void test02() {
        String string1 = "abc";
        String string2 = "abc";
        String concat = string1.concat(string2);
        System.out.println(concat);
    }

    @Test
    public void test03() {
        String string1 = "abc\\abc";
        String[] split = string1.split("\\\\");
        System.out.println(split.length);
        for (String name : split) {
            System.out.println(name);
        }
    }

    @Test
    public void test04() {
        char c1 = 'A';
        System.out.println((int) c1);
        char c2 = 'Z';
        System.out.println((int) c2);
        char c3 = 'a';
        System.out.println((int) c3);
        char c4 = 'z';
        System.out.println((int) c4);
    }

    @Test
    public void test05() {
        String str = " ";
        System.out.println(str.length());
        StringBuffer sb = new StringBuffer("dfadaf");
        StringBuffer reverse = sb.reverse();
        reverse.toString();
    }

    @Test
    public void test06() {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

    @Test
    public void test07() {
        String str = "dfaflajf)()(&*&^^^^}}{{{}})**";
        String replace = str.replace("a", "c");
        String exp = replace.replaceAll("(?<![0-9)}\\]])(?=-[0-9({\\[])", "0") + "#";
        System.out.println(exp);
        char[] chars = str.toCharArray();
        char c = 'a';
        boolean digit = Character.isDigit(c);
        System.out.println(digit);

    }

    @Test
    public void test08() {
        String str = "adf\\afa";
        //String h = str.replace(".", "h");
        //System.out.println(h);
        String[] split = str.split("\\\\");
        for (String s : split) {
            System.out.println(s);
        }

    }
    @Test
    public void test09(){

    }

    @Test
    public void test10(){

    }

    @Test
    public void test11(){

    }

}
