package com.myphrase;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new App().run();
    }
}

class App {
    static void run() {
        Scanner sc = new Scanner(System.in);
        int id = 1;

        // 명언 앱 시작
        System.out.println("== 명언 앱 ==");
        while (true) {
            System.out.print("명령) ");
            String cmd = sc.next(); // 명령 입력

            if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                String phrase = sc.next();
                System.out.print("작가 : ");
                String writer = sc.next();

                System.out.printf("%d번 명령이 등록되었습니다.\n", id++);

            } else if (cmd.equals("종료")) {
                break;
            }
        }
    }
}
