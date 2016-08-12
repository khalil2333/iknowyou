package com.webank.inu.logic.service.message;

/**
 * Created by adam on 2016/8/11.
 */
public interface IMessageService {

    class ResponseType{
        //文本
        public static final int text = 0x0001;
        //图片
        public static final int picture = 0x0002;
        //语音
        public static final int voice = 0x0003;
        //视屏
        public static final int video = 0x0004;
        //音乐
        public static final int music = 0x005;
        //图文
        public static final int news = 0x006;
    }

    public ResponseInfo processMessage(String openId,String message,int responseType);

    public SingleArticleInfo queryArticleById(String articleId);

}
