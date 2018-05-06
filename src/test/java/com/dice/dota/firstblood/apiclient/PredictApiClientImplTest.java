package com.dice.dota.firstblood.apiclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PredictApiClientImplTest {
    @Autowired
    private  PredictApiClient client;
    final private ObjectMapper mapper = new ObjectMapper();
    @Test
    public void getMatchResult() {
        String res = client.getMatchResult(genMatchPreData());
        String expectStr = "{\n" +
                "  \"result\" : \"success\",\n" +
                "  \"win_probability\" : \"70\",\n" +
                "  \"winner\" : \"5\",\n" +
                "  \"msg\" : \"\"\n" +
                "}";
        try {
            Assert.assertTrue(mapper.readTree(res).equals(mapper.readTree(expectStr)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Map<String,String> genMatchPreData(){
        Map<String,String> msg = new HashMap<>();
        msg.put("radiant_team_id","15");//LGD ID
        msg.put("radiant_hero_1","1");
        msg.put("radiant_hero_2","2");
        msg.put("radiant_hero_3","3");
        msg.put("radiant_hero_4","4");
        msg.put("radiant_hero_5","5");

        msg.put("dire_team_id","5");//IG ID
        msg.put("dire_hero_1","6");
        msg.put("dire_hero_2","7");
        msg.put("dire_hero_3","8");
        msg.put("dire_hero_4","9");
        msg.put("dire_hero_5","10");
        return msg;
    }
}