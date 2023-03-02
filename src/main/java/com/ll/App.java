package com.ll;

import com.ll.system.controller.SystemController;
import com.ll.wiseSaying.controller.WiseSayingController;

import java.util.HashMap;
import java.util.Map;

class App {
    public void run() {

        SystemController systemController = new SystemController();
        WiseSayingController wiseSayingController = new WiseSayingController();

        // 명언 앱 시작
        System.out.println("== 명언 앱 ==");
        while (true) {
            System.out.print("명령) ");
            String cmd = Container.getScanner().nextLine().trim(); // 명령 입력
            Rq rq = new Rq(cmd);

            switch (rq.getActionCode()) {
                case "종료":
                    systemController.exit();
                    return;
                case "등록":
                    wiseSayingController.add();
                    break;
                case "목록":
                    wiseSayingController.printList();
                    break;
                case "삭제":
                    wiseSayingController.remove(rq);
                    break;
            }
        }
    }
}
