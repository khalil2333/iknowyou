package com.webank.inu.thirdService;

import com.qcloud.Module.Wenzhi;
import com.qcloud.QcloudApiModuleCenter;
import com.qcloud.Utilities.Json.JSONObject;
import org.junit.Test;

import java.util.TreeMap;

/**
 * Created by adam on 2016/8/10.
 */
public class TestSentiment {

    public static void main(String[] args) {
		/* 如果是循环调用下面举例的接口，需要从此处开始你的循环语句。切记！ */
        TreeMap<String, Object> config = new TreeMap<String, Object>();
        config.put("SecretId", "AKIDO5ww7DaEHa5kZaxuIqKtRsNzXhK4stBE");
        config.put("SecretKey", "JveGtS1WL5gl8A43LX1TdpKkQwQJte7a");
		/* 请求方法类型 POST、GET */
        config.put("RequestMethod", "GET");
		/* 区域参数，可选: gz:广州; sh:上海; hk:香港; ca:北美;等。 */
        config.put("DefaultRegion", "sz");

		/*
		 * 你将要使用接口所在的模块，可以从 官网->云api文档->XXXX接口->接口描述->域名
		 * 中获取，比如域名：cvm.api.qcloud.com，module就是 new Cvm()。
		 */
		/*
		 * 示例：DescribeInstances
		 * 的api文档地址：http://www.qcloud.com/wiki/v2/DescribeInstances
		 */
        QcloudApiModuleCenter module = new QcloudApiModuleCenter(new Wenzhi(),
                config);

        TreeMap<String, Object> params = new TreeMap<String, Object>();
		/* 将需要输入的参数都放入 params 里面，必选参数是必填的。 */
		/* DescribeInstances 接口的部分可选参数如下 */
//		params.put("offset", 0);
//		params.put("limit", 3);
//		params.put("title","今天下雨了，我很不开心");
        params.put("content","傅园慧凭借着自己的丰富表情,和那句“我用了洪荒之力”,被广大网民封为“表情帝”");

		/* generateUrl方法生成请求串,可用于调试使用 */
        System.out.println(module.generateUrl("TextClassify", params));
        String result = null;
        try {
			/* call 方法正式向指定的接口名发送请求，并把请求参数params传入，返回即是接口的请求结果。 */
            result = module.call("TextClassify", params);
            JSONObject json_result = new JSONObject(result);
            System.out.println(json_result);
        } catch (Exception e) {
            System.out.println("error..." + e.getMessage());
        }

    }

    @Test
    public void testSentiment(){

    }
}
