package com.webank.inu.logic.messsage;

import com.webank.inu.logic.service.message.IMessageService;
import com.webank.inu.logic.service.message.SingleArticleInfo;
import com.webank.inu.logic.service.message.impl.BaseMessageServiceImpl;
import org.junit.Test;

/**
 * Created by adam on 2016/8/12.
 */
public class TestArticle {

    @Test
    public void testGetArticleById(){
        int id = 27;
        IMessageService messageService = new BaseMessageServiceImpl();
        SingleArticleInfo singleArticleInfo
                 = messageService.queryArticleById(id);

        System.out.println(singleArticleInfo);

    }
}
