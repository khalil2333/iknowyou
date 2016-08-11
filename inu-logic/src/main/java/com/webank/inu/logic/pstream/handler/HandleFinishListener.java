package com.webank.inu.logic.pstream.handler;

import com.webank.inu.logic.pstream.context.PStreamContext;

/**
 * Created by adam on 2016/8/11.
 */
public interface HandleFinishListener {

    public void actionFinish(PStreamContext context);
}
