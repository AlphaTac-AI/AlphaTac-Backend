package com.dice.dota.firstblood.apiclient;

import java.util.Map;

/**
 * The api client to connect the predict module
 * @author yechanglong
 * @date 2018/5/6
 */
public interface PredictApiClient {

    /**
     * @param matchPreData 比赛数据
     * @return 返回json，数据结构见说明文档，失败返回null
     */
    String getMatchResult(Map<String,String> matchPreData);
}
