package com.inu.service;

import com.inu.dto.HistoryMoodDTO;

import java.util.List;

/**
 * Created by potato on 2016/8/11.
 */
public interface IUserService {
    /**
     * 储存用户发送的消息
     * @param openId
     * @param message
     * @param time
     */
    public void insertUserMessage(String openId, String message, Long time);


    /**
     * 根据openId获取用户历史心情
     * @param openId
     * @return
     */
    public List<HistoryMoodDTO> getHistoryMood(String openId);

}
