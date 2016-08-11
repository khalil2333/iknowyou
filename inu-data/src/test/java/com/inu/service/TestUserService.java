package com.inu.service;

import com.inu.dto.HistoryMoodDTO;
import com.inu.service.imp.UserServiceImp;
import org.junit.Test;

import java.util.List;

/**
 * Created by potato on 2016/8/11.
 */
public class TestUserService {

    UserServiceImp userServiceImp = new UserServiceImp();

    @Test
    public void getHistoryMoodTest() {
        List<HistoryMoodDTO> historyMoodList = userServiceImp.getHistoryMood("1");
        System.out.println(historyMoodList.size());
    }

    public void insertUserMessageTest() {
        System.out.println(userServiceImp.insertUserMessage("1","1",1L));
    }


}
