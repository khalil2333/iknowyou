package com.webank.inu.logic.messsage;

import com.webank.inu.logic.service.history.ChatInfo;
import com.webank.inu.logic.service.history.IHistoryChat;
import com.webank.inu.logic.service.history.impl.BaseHistoryChatImpl;
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
