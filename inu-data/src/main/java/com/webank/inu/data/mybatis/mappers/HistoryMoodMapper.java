package com.webank.inu.data.mybatis.mappers;

import com.webank.inu.data.dto.HistoryMoodDTO;
import com.webank.inu.data.mybatis.model.HistoryMood;

import java.util.List;

/**
 * Created by potato on 2016/8/11.
 */
public interface HistoryMoodMapper {

    public List<HistoryMoodDTO> getHistoryMood(String openId);

    public int insertUserMessage(HistoryMood historyMood);
}
