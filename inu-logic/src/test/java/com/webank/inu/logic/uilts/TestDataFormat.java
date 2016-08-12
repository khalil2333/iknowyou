package com.webank.inu.logic.uilts;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by adam on 2016/8/12.
 */
public class TestDataFormat {

    private String transferLongToDate(String dateFormat,Long millSec){
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Date date= new Date(millSec);
        return sdf.format(date);
    }

    @Test
    public void test(){
        String dataFormat = "yyyy mm dd : hh MM ss";
        System.out.println(transferLongToDate(dataFormat,System.currentTimeMillis()));
    }
}
