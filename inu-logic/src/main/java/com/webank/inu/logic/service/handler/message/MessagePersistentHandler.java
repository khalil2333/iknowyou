package com.webank.inu.logic.service.handler.message;

import com.webank.inu.logic.pstream.context.PStreamContext;
import com.webank.inu.logic.pstream.handler.AsynPStreamHandlerAdapter;
import com.webank.inu.logic.pstream.handler.HandleFinishListener;

/**
 * Created by adam on 2016/8/11.
 */
public class MessagePersistentHandler extends AsynPStreamHandlerAdapter {
    public Object handleCore(PStreamContext context, Object fromData) {
        if (!(fromData instanceof java.lang.String)) return fromData;
        System.out.println("插入消息 : "+fromData);
        return fromData;
    }

    public HandleFinishListener getFinishListener() {
        return null;
    }
}
