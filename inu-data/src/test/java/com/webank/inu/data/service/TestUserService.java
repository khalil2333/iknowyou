package com.webank.inu.data.service;

import com.webank.inu.data.dto.HistoryMoodDTO;
import com.webank.inu.data.service.imp.UserServiceImp;
import org.junit.Test;

import java.util.List;

/**
 * Created by potato on 2016/8/11.
 */
public class TestUserService {

    UserServiceImp userServiceImp = new UserServiceImp();

    @Test
    public void getHistoryMoodTest() {
        List<HistoryMoodDTO> historyMoodList = userServiceImp.getHistoryMood("oALPuwqMm5_YrKSyYBb1C58melvs");
        System.out.println(historyMoodList.size());
    }

    @Test
    public void insertUserMessageTest() {
        System.out.println(userServiceImp.insertUserMessage("4","4",10000L, 0.5));
    }


}
