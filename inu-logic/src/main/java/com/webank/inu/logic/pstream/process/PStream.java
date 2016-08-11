package com.webank.inu.logic.pstream.process;

import com.webank.inu.logic.pstream.context.PStreamContext;
import com.webank.inu.logic.pstream.handler.AsynPStreamHandler;
import com.webank.inu.logic.pstream.handler.HandleFinishListener;
import com.webank.inu.logic.pstream.handler.StreamFinishListener;
import com.webank.inu.logic.pstream.handler.SynPStreamHandler;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by adam on 2016/8/11.
 */
public class PStream {

    private PStreamContext context;

    private Node head;

    private Node tail;

    //较差的实现，后续再优化
    private AtomicInteger handleNum = new AtomicInteger(0);

    public PStream(){
        context = new PStreamContext();
        context.setParent(this);
    }

    public boolean isFinish(){
        return handleNum.get() == 0;
    }

    public Object synFinish(StreamFinishListener listener){
        while(!isFinish()) System.out.println("....");
        return listener.actionFinish(context);
    }

    public void addHandler(SynPStreamHandler handler){
        addNext(Node.newSynNode(handler));
        //+1
        handleNum.getAndIncrement();
    }

    public void addHandler(AsynPStreamHandler handler){
        addNext(Node.newAsynNode(handler));
        //+1
        handleNum.getAndIncrement();
    }

    public void invokeListener(AsynPStreamHandler handler){
        HandleFinishListener listener = handler.getFinishListener();
        if (listener != null) listener.actionFinish(context);
        //-1
        handleNum.getAndDecrement();
    }

    public void process(Object data){
        if (head == null) return;
        Node tmp = head;
        Object fromData = data;
        while(tmp != null){
            if (!tmp.isAsyn){
                fromData = tmp.getSynPStreamHandler().handle(context,fromData);
                //-1
                handleNum.getAndDecrement();
            }else{
                final AsynPStreamHandler pStreamHandler = tmp.getAsynPStreamHandler();
                final Object[] finalFromData = {fromData};
                Thread thread = new Thread(new Runnable() {
                    public void run() {
                        finalFromData[0] = pStreamHandler.handle(context, finalFromData[0]);
                    }
                });
                thread.start();
                fromData = finalFromData[0];
            }
            tmp = tmp.next;
        }
    }

    private void addNext(Node node){
        if (head == null){
            head = node;
            tail = head;

            return;
        }

        tail.next = node;
        tail = node;
    }

    private static class Node{
        private boolean isAsyn;

        private SynPStreamHandler synPStreamHandler;

        private AsynPStreamHandler asynPStreamHandler;

        private Node next;

        public static Node newSynNode(SynPStreamHandler synPStreamHandler){
            Node node = new Node();
            node.setAsyn(false);
            node.setSynPStreamHandler(synPStreamHandler);

            return node;
        }

        public static Node newSynNode(SynPStreamHandler synPStreamHandler,Node next){
            Node node = newSynNode(synPStreamHandler);
            node.setNext(next);

            return node;
        }

        public static Node newAsynNode(AsynPStreamHandler asynPStreamHandler){
            Node node = new Node();
            node.setAsyn(true);
            node.setAsynPStreamHandler(asynPStreamHandler);

            return node;
        }

        public static Node newAsynNode(AsynPStreamHandler asynPStreamHandler,Node next){
            Node node = newAsynNode(asynPStreamHandler);
            node.setNext(next);

            return node;
        }

        public boolean isAsyn() {
            return isAsyn;
        }

        public void setAsyn(boolean asyn) {
            isAsyn = asyn;
        }

        public SynPStreamHandler getSynPStreamHandler() {
            return synPStreamHandler;
        }

        public void setSynPStreamHandler(SynPStreamHandler synPStreamHandler) {
            this.synPStreamHandler = synPStreamHandler;
        }

        public AsynPStreamHandler getAsynPStreamHandler() {
            return asynPStreamHandler;
        }

        public void setAsynPStreamHandler(AsynPStreamHandler asynPStreamHandler) {
            this.asynPStreamHandler = asynPStreamHandler;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
