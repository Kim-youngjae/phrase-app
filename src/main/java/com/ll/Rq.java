package com.ll;

import java.util.HashMap;
import java.util.Map;

public class Rq {
    private String actionCode;
    Map<String, String> params;

    public Rq(String command) {
        String[] commandBits = command.split("\\?", 2); // ? 기준으로 최대 2개 까지 나눔
        actionCode = commandBits[0]; // 삭제?id=1 로 나뉘면 "삭제", "id=1"로 두 조각으로 나뉨
        params = new HashMap<>(); // actioncode에 대한 옵션을 저장하기 위함

        if (commandBits.length == 1) { // ?를 입력하지 않거나 없으면 옵션이 없으므로 종료
            return;
        }

        String[] paramBits = commandBits[1].split("&"); // &기준으로 또 나눔

        for (String paramStr : paramBits) {
            String[] paramStrBits = paramStr.split("=", 2); // = 기준으로 또 나눔

            if (paramStrBits.length == 1) { // = 만 입력하고 숫자 입력안하면 그대로 진행
                continue;
            }

            String key = paramStrBits[0];
            String value = paramStrBits[1];

            params.put(key, value);
        }

    }

    public String getActionCode() {
        return actionCode;
    }

    public String getParam(String name) {
        return params.get(name);
    }

    public int getIntParam(String name, int defaultValue) {
        try {
            return Integer.valueOf(getParam(name));
        } catch (NumberFormatException e) {

        }

        return defaultValue;
    }

}
