package com.webank.inu.logic.thirdService;

import com.webank.inu.logic.service.handler.Sentiment.TextSentimentHandler;
import org.junit.Test;

/**
 * Created by adam on 2016/8/11.
 */
public class TestTextSentimentHandler {

    @Test
    public void testSentiment(){
        TextSentimentHandler sentimentHandler = new TextSentimentHandler();
        sentimentHandler.handle(null,"我心情很不好");
    }
}
