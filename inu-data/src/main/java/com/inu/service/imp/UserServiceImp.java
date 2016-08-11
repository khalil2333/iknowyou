package com.inu.service.imp;

import com.inu.dto.HistoryMoodDTO;
import com.inu.service.IUserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by potato on 2016/8/11.
 */
public class UserServiceImp implements IUserService{


    public List<HistoryMoodDTO> getHistoryMood(String openId) {
        List<HistoryMoodDTO> historyMoodDTOList = new ArrayList<HistoryMoodDTO>();
        HistoryMoodDTO historyMoodDTO = new HistoryMoodDTO();
        historyMoodDTO.setId(1);
        historyMoodDTO.setMessage("123");
        historyMoodDTO.setTime(123L);
        historyMoodDTOList.add(historyMoodDTO);
        return historyMoodDTOList;
    }

    public void insertUserMessage(String openId, String message, Long time) {
    }

}
