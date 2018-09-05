package com.example.ubuntu.testhttpclient.http.chargestation.station;


import com.example.ubuntu.testhttpclient.http.base.HttpBaseApplicationJson;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zgjxf on 2017/12/5.
 */

public class HttpPostStationTest {

    List<String> imageString=new ArrayList<>();
    List<Integer> intImage=new ArrayList<>();

    String faultCreateDebug = "/fault/create";

    @Test
    public void testFaultCreate() {
        intImage.add(1);
        imageString.add("1");
        Object[][] faultCreateList = {//key-- value
                {"chargingStationId", 1502040},
                {"chargingPileId", 111111},
                {"chargingId", 1},
                {"questionTypeContent", "1212"},
                {"content", "121212"},
                {"faultReportTypes", intImage},
                {"faultReportImages", imageString},

        };
        HttpBaseApplicationJson.postFormByApplicationJson(faultCreateList, faultCreateDebug);
    }


}
