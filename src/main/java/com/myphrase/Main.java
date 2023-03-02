package com.myphrase;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    }
}

class App {
    static void run() {
        Scanner sc = new Scanner(System.in);

        // 명언 앱 시작
        System.out.println("== 명언 앱 ==");
        while (true) {
            System.out.print("명령) ");
            String cmd = sc.next(); // 명령 입력

            if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                sc.next();
                System.out.print("작가 : ");
                sc.next();
            } else if (cmd.equals("종료")) {
                break;
            }
        }
    }
}
