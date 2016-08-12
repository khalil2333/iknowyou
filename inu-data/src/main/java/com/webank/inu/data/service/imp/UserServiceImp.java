package com.webank.inu.data.service.imp;

import com.webank.inu.data.dto.HistoryMoodDTO;
import com.webank.inu.data.mybatis.model.HistoryMood;
import com.webank.inu.data.service.IUserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.sql.Timestamp;
import java.util.*;

/**
 * Created by potato on 2016/8/11.
 */
public class UserServiceImp implements IUserService {

    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;

    static {
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static SqlSessionFactory getSession() {
        return sqlSessionFactory;
    }


    public List<HistoryMoodDTO> getHistoryMood(String openId) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            List<HistoryMood> historyMoods = session.selectList("getHistoryMood", openId);
            if(historyMoods!=null){
                List<HistoryMoodDTO> historyMoodDTOs = new ArrayList<HistoryMoodDTO>();

                for(HistoryMood item : historyMoods) {
                    HistoryMoodDTO historyMoodDTO = makeHistoryDTO(item);
                    historyMoodDTOs.add(historyMoodDTO);
                }

                return historyMoodDTOs;
            }

        } finally {
            session.close();
        }
        return null;
    }

    public int insertUserMessage(String openId, String message, Long time, double userMood) {
        SqlSession session = sqlSessionFactory.openSession();

        HistoryMood historyMood = new HistoryMood();
        historyMood.setRecordTime(new Timestamp(time));
        historyMood.setMessage(message);
        historyMood.setOpenId(openId);
        historyMood.setUserMood(userMood);

        try{
            int result = session.insert("insertUserMessage",historyMood);
            session.commit();
            return result;
        }finally {
            session.close();
        }
    }

    private HistoryMoodDTO makeHistoryDTO(HistoryMood historyMood) {
        HistoryMoodDTO historyMoodDTO = new HistoryMoodDTO();
        historyMoodDTO.setMessage(historyMood.getMessage());
        historyMoodDTO.setRecordTime(historyMood.getRecordTime());

        return historyMoodDTO;
    }
}
