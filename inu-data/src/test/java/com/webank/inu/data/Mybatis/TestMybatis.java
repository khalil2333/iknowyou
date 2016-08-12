package com.webank.inu.data.Mybatis; /**
 * Created by potato on 2016/8/11.
 */
import java.io.Reader;
import java.sql.Timestamp;
import java.util.List;

import com.webank.inu.data.mybatis.model.Article;
import com.webank.inu.data.mybatis.model.HistoryMood;
import com.webank.inu.data.mybatis.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.junit.Test;

public class TestMybatis {
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


    @Test
    public void testUser() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            User user = (User) session.selectOne(
                    "getUser", 1);
            if(user!=null){
                String userInfo = "nickName:"+user.getNickName()+", openId:"+
                        user.getOpenId()+", mood:"+user.getMood();
                System.out.println(userInfo);
            }
        } finally {
            session.close();
        }
    }

    @Test
    public void testHistoryMood() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            List<HistoryMood> historyMoodList = session.selectList(
                    "getHistoryMood", "1");
            if(historyMoodList!=null){
                HistoryMood historyMood = historyMoodList.get(0);
                String historyMoodInfo = historyMood.getRecordTime() + ":" + historyMood.getMessage();
                System.out.println(historyMoodInfo);
            }
        } finally {
            session.close();
        }
    }

    @Test
    public void testInsertMessage() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            HistoryMood historyMood = new HistoryMood();
            historyMood.setOpenId("abc");

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            historyMood.setRecordTime(timestamp);
            historyMood.setMessage("2222222");
            int result = session.insert(
                    "insertUserMessage", historyMood);
        } finally {
            session.close();
        }
    }

    @Test
    public void testGetArticle() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            List<Article> articleList = session.selectList(
                    "getArticle", 1.0);
            if(articleList!=null){
                Article article = articleList.get(0);
                String articleInfo = article.getTitle() + ":" + article.getDescription();
                System.out.println(articleInfo);
            }
        } finally {
            session.close();
        }
    }
}
