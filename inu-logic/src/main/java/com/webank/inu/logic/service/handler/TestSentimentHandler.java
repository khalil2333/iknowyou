package com.webank.inu.logic.service.handler;

import com.sun.org.apache.xpath.internal.operations.String;
import com.webank.inu.logic.pstream.context.PStreamContext;
import com.webank.inu.logic.pstream.handler.SynPStreamHandler;

/**
 * Created by adam on 2016/8/11.
 */
public class TestSentimentHandler implements SynPStreamHandler {

    public Object handle(PStreamContext context, Object fromData) {
        if (!(fromData instanceof String)) return null;

        String chatMsg = (String) fromData;

        return null;
    }
}
