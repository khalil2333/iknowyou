package com.webank.inu.logic.pstream.handler;

import com.webank.inu.logic.pstream.context.PStreamContext;

/**
 * Created by adam on 2016/8/11.
 */
public abstract class AsynPStreamHandlerAdapter implements AsynPStreamHandler {
    
    public abstract void handleCore(PStreamContext context,Object fromData);
    
    public void handle(PStreamContext context, Object fromData){
        handleCore(context,fromData);
        context.getParent().invokeListener(this);
    }

    public abstract HandleFinishListener getFinishListener();
}
