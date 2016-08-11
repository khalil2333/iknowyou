package com.webank.inu.data; /**
 * Created by potato on 2016/8/11.
 */
import java.io.Reader;

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
                    "userMapper.getUser", 1);
            if(user!=null){
                String userInfo = "nickName:"+user.getNickName()+", openId:"+
                        user.getOpenId()+", mood:"+user.getMood();
                System.out.println(userInfo);
            }
        } finally {
            session.close();
        }
    }

}