package com.webank.inu.logic.pstream;

import com.webank.inu.logic.pstream.context.PStreamContext;
import com.webank.inu.logic.pstream.handler.AsynPStreamHandlerAdapter;
import com.webank.inu.logic.pstream.handler.HandleFinishListener;
import com.webank.inu.logic.pstream.handler.SynPStreamHandler;
import com.webank.inu.logic.pstream.process.PStream;
import com.webank.inu.logic.service.message.IMessageService;
import com.webank.inu.logic.service.message.ResponseInfo;
import com.webank.inu.logic.service.message.impl.BaseMessageServiceImpl;
import org.junit.Test;

/**
 * Created by adam on 2016/8/11.
 */
public class TestPStream {

    @Test
    public void testPStream(){
        PStream pStream = new PStream();
        pStream.addHandler(new SynPStreamHandler() {
            public Object handle(PStreamContext context, Object fromData) {
                System.out.println("handler 1");
                return null;
            }
        });
        pStream.addHandler(new AsynPStreamHandlerAdapter() {
            @Override
            public Object handleCore(PStreamContext context, Object fromData) {
                System.out.println("handler 2");
                return null;
            }

            @Override
            public HandleFinishListener getFinishListener() {
                return null;
            }
        });
        pStream.addHandler(new SynPStreamHandler() {
            public Object handle(PStreamContext context, Object fromData) {
                System.out.println("handler 3");
                return null;
            }
        });

        pStream.process("msgx");
        pStream.synFinish(null);

    }

    @Test
    public void testMessage(){
        long startTime = System.currentTimeMillis();
        IMessageService messageService = new BaseMessageServiceImpl();
        ResponseInfo responseInfo =
                messageService.processMessage("adamchen",
                        "今天又下雨，又打雷，鞋子还湿了，很不开心",
                        IMessageService.ResponseType.news);

        System.out.println(System.currentTimeMillis() - startTime);
        System.out.println(responseInfo);

    }
}
