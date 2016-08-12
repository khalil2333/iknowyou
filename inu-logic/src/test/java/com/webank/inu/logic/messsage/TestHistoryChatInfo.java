package com.webank.inu.logic.messsage;

import com.webank.inu.logic.service.history.ChatInfo;
import com.webank.inu.logic.service.history.IHistoryChat;
import com.webank.inu.logic.service.history.impl.BaseHistoryChatImpl;
import com.webank.inu.logic.service.message.IMessageService;
import com.webank.inu.logic.service.message.impl.BaseMessageServiceImpl;
import org.junit.Test;

import java.util.List;

/**
 * Created by adam on 2016/8/11.
 */
public class TestHistoryChatInfo {

    @Test
    public void testHistoryChatInfos() {
        IHistoryChat historyChat = new BaseHistoryChatImpl();
        List<ChatInfo> chatInfos = historyChat.queryHistoryChats("4");

        for (ChatInfo info : chatInfos) {
            System.out.println(info);
        }
    }

    @Test
    public void testT() {
        new BaseMessageServiceImpl().processMessage("aa", "aa",IMessageService.ResponseType.news);
    }
}
