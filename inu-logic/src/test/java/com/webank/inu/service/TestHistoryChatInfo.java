package com.webank.inu.service;

import com.webank.inu.service.history.ChatInfo;
import com.webank.inu.service.history.IHistoryChat;
import com.webank.inu.service.history.impl.BaseHistoryChatImpl;
import org.junit.Test;

import java.util.List;

/**
 * Created by adam on 2016/8/11.
 */
public class TestHistoryChatInfo {

    @Test
    public void testHistoryChatInfos(){
        IHistoryChat historyChat = new BaseHistoryChatImpl();
        List<ChatInfo> chatInfos = historyChat.queryHistoryChats("aaaaa");

        for (ChatInfo info : chatInfos){
            System.out.println(info);
        }
    }
}
