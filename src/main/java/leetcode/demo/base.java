package leetcode.demo;

import java.lang.reflect.Field;

public class base {
    public static void main(String[] args) {
        int x = 10, y = 20; //定义两个变量
        System.out.println("交换前 x=" + x + ",y=" + y);
        swap(x, y);
        System.out.println("交换前 x=" + x + ",y=" + y);
    }

    private static void swap(Integer a, Integer b) {
        int temp = a;
        try {
            Class clazz = a.getClass();
            Field value = clazz.getDeclaredField("value");
            value.setAccessible(true);
            value.setInt(a, b);

            value.setInt(b, temp);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
