package com.webank.inu.logic.service.portrait;

/**
 * Created by adam on 2016/8/12.
 */
public interface IPortraitService {

    public PortraitInfo analysisUserPortrait(String openId,long start,long end);
}
