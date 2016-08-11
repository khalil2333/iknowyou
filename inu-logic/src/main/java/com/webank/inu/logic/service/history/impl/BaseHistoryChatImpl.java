package com.webank.inu.logic.service.history.impl;

import com.webank.inu.logic.service.history.ChatInfo;
import com.webank.inu.logic.service.history.IHistoryChat;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by adam on 2016/8/11.
 */
public class BaseHistoryChatImpl implements IHistoryChat {

    public List<ChatInfo> queryHistoryChats(String openId) {
        Scanner scanner = new Scanner(BaseHistoryChatImpl.class.getResourceAsStream("/testHistoryData.txt"));
        List<ChatInfo> chatInfos = new LinkedList<ChatInfo>();
        while(scanner.hasNext()){
            String line = scanner.nextLine();
            ChatInfo chatInfo = new ChatInfo();
            chatInfo.setContent(line);
            chatInfo.setTimestamp(1234333);
            chatInfos.add(chatInfo);
        }
        return chatInfos;
    }
}
