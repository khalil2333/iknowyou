package com.webank.inu.logic.service.history.impl;

import com.webank.inu.data.dto.HistoryMoodDTO;
import com.webank.inu.data.service.IUserService;
import com.webank.inu.data.service.imp.UserServiceImp;
import com.webank.inu.logic.service.history.ChatInfo;
import com.webank.inu.logic.service.history.IHistoryChat;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by adam on 2016/8/11.
 */
public class BaseHistoryChatImpl implements IHistoryChat {

    private IUserService userService = new UserServiceImp();

    public List<ChatInfo> queryHistoryChats(String openId) {
        List<ChatInfo> chatInfos = new LinkedList<ChatInfo>();
        List<HistoryMoodDTO> historyMoods = userService.getHistoryMood(openId);
//        System.out.println(historyMoods.size());
        for (HistoryMoodDTO mood : historyMoods){
            ChatInfo chatInfo = new ChatInfo();
            chatInfo.setContent(mood.getMessage());
            if (mood.getTime() != null){
                chatInfo.setTimestamp(mood.getTime().getTime());
            }

            chatInfos.add(chatInfo);
        }
//        Scanner scanner = new Scanner(BaseHistoryChatImpl.class.getResourceAsStream("/testHistoryData.txt"));
//        while(scanner.hasNext()){
//            String line = scanner.nextLine();
//            ChatInfo chatInfo = new ChatInfo();
//            chatInfo.setContent(line);
//            chatInfo.setTimestamp(1234333);
//            chatInfos.add(chatInfo);
//        }
        return chatInfos;
    }
}
