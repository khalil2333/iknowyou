package com.webank.inu.logic.service.history;

import java.util.List;

/**
 * Created by adam on 2016/8/11.
 */
public interface IHistoryChat {

    public List<ChatInfo> queryHistoryChats(String openId);
}
