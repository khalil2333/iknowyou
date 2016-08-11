package com.webank.inu.logic.pstream.handler;

import com.webank.inu.logic.pstream.context.PStreamContext;

/**
 * Created by adam on 2016/8/11.
 */
public abstract class AsynPStreamHandlerAdapter implements AsynPStreamHandler {
    
    public abstract Object handleCore(PStreamContext context,Object fromData);
    
    public Object handle(PStreamContext context, Object fromData){
        Object ret = handleCore(context,fromData);
        context.getParent().invokeListener(this);
        return ret;
    }

    public abstract HandleFinishListener getFinishListener();
}
