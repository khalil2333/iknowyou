package com.webank.inu.logic.uilts;

import com.webank.inu.logic.utils.ConfigInfo;
import org.junit.Test;

/**
 * Created by adam on 2016/8/11.
 */
public class TestConfigInfo {
    private ConfigInfo configInfo = ConfigInfo.getInstance();

    @Test
    public void testSecretInfo(){
        assert configInfo.TXSecretId().equals("AKIDO5ww7DaEHa5kZaxuIqKtRsNzXhK4stBE");
        assert configInfo.TXSecretKey().equals("JveGtS1WL5gl8A43LX1TdpKkQwQJte7a");
    }
}
