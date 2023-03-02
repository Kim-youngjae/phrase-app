package com.myphrase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new App().run();
    }
}

class App {
    static void run() {
        Scanner sc = new Scanner(System.in);
        List<Phrase> phraseList = new ArrayList<>();

        int id = 1;

        // 명언 앱 시작
        System.out.println("== 명언 앱 ==");
        while (true) {
            System.out.print("명령) ");
            String cmd = sc.next(); // 명령 입력

            try {
                if (cmd.trim().equals("등록")) {
                    id = save(sc, phraseList, id);
                } else if (cmd.trim().equals("목록")) {
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("---------------------");

                    Collections.reverse(phraseList);
                    for (Phrase p : phraseList) {
                        System.out.printf("%d / %s / %s\n", p.getId(), p.getWriter(), p.getPhrase());
                    }
                } else if (cmd.trim().substring(0, 2).equals("삭제")) {
                    if (Integer.valueOf(cmd.substring(6)) == 1) {
                        phraseList.remove(0);
                        System.out.printf("%d번 명언이 삭제되었습니다.\n", Integer.valueOf(cmd.substring(6)));
                    }

                } else if (cmd.trim().equals("종료")) {
                    break;
                }
            } catch (StringIndexOutOfBoundsException e) {
                sc.nextLine();
            }
        }
    }

    private static int save(Scanner sc, List<Phrase> phraseList, int id) {
        System.out.print("명언 : ");
        String phrase = sc.next();
        System.out.print("작가 : ");
        String writer = sc.next();

        phraseList.add(new Phrase(id, writer, phrase)); // 명언목록에 저장

        System.out.printf("%d번 명령이 등록되었습니다.\n", id++);
        return id;
    }
}

