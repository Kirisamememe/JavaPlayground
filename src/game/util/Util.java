package game.util;

import java.util.Scanner;

public class Util {
    public static void pressEnter(){
        System.out.println("\n＝＝＝＝Enterキーを押して続けます＝＝＝＝");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        scanner.close();
    }

    public static void sleepWithoutException(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            //何もしない
        }
    }

    public static void print(String str, int millis){
        String[] strToPrint = str.split("");
        for (String s : strToPrint){
            System.out.print(s);
            sleepWithoutException(millis);
        }
    }
}