package com.ll.wiseSaying.controller;

import com.ll.Container;
import com.ll.Rq;
import com.ll.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingController {
    private long lastWiseSayingId;
    private final List<WiseSaying> phraseList;

    public WiseSayingController() {
        lastWiseSayingId = 0;
        phraseList = new ArrayList<>();
    }

    public void add() {
        long id = lastWiseSayingId + 1;
        System.out.print("명언 : ");
        String phrase = Container.getScanner().nextLine();
        System.out.print("작가 : ");
        String writer = Container.getScanner().nextLine();

        phraseList.add(new WiseSaying(id, writer, phrase)); // 명언목록에 저장

        System.out.printf("%d번 명령이 등록되었습니다.\n", id);
        lastWiseSayingId = id;
    }

    public void printList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("---------------------");

        for (int i = phraseList.size() - 1; i >= 0; i--) {
            System.out.printf("%d / %s / %s\n", phraseList.get(i).getId(), phraseList.get(i).getWriter(), phraseList.get(i).getPhrase());
        }
    }

    public void remove(Rq rq) {
        int id = rq.getIntParam("id", -1);

        if (id == -1) {
            System.out.println("id(정수)값을 입력하세요");
            return;
        }

        WiseSaying wiseSaying = findById(id);
        if (wiseSaying == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
            return;
        }

        phraseList.remove(wiseSaying);
        System.out.printf("%d번 명언이 삭제 되었습니다.\n", id);
    }

    private WiseSaying findById(int id) {
        for (WiseSaying wiseSaying : phraseList) {
            if (wiseSaying.getId() == id) {
                return wiseSaying;
            }
        }
        return null; // 없으면 null 반환
    }

    public void update(Rq rq) {
        int id = rq.getIntParam("id", -1); // rq로 부터 명령 옵션을 분리하고 id값 추출

        if (id == -1) { // id값이 없으면
            System.out.println("id(정수)값을 입력하세요");
            return;
        }

        WiseSaying wiseSaying = findById(id); // id랑 일치하는 명언 객체를 반환

        if (wiseSaying == null) { // 없을 때 처리
            System.out.printf("%d번 명언은 존재하지 않습니다.", id);
            return;
        }

        System.out.printf("명언(기존) : %s\n", wiseSaying.getPhrase()); // 해당 id의 기존 명언을 출력
        System.out.print("명언 : ");
        String phrase = Container.getScanner().nextLine();
        wiseSaying.setPhrase(phrase); // 입력받은 명언을 해당 id 객체에 저장

        System.out.printf("작가(기존) : %s\n", wiseSaying.getWriter()); // 해당 id의 기존 작가를 출력
        System.out.print("작가 : ");
        String writer = Container.getScanner().nextLine();
        wiseSaying.setWriter(writer); // 입력받은 작가를 해당 id 객체에 저장

    }
}
