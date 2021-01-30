package concurrent;

import sun.rmi.runtime.Log;

import java.util.*;
import java.util.stream.Collectors;

import static javafx.scene.input.KeyCode.L;


public class Test {
    static volatile int i = 10000;
    public static void main(String[] args) {

        new Thread(() -> {
            while (i >0){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i--;
                System.out.println(i);
            }
        }).start();

        new Thread(() -> {
            while (i <20000){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
                System.out.println(i);
            }
        }).start();


    }
}

