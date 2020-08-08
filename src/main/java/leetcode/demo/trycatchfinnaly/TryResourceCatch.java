package leetcode.demo.trycatchfinnaly;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TryResourceCatch {

    public static void main(String[] args) {
        // 读取文本文件的内容
        try (Scanner scanner = new Scanner(new File("src/main/resources/test"))) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
