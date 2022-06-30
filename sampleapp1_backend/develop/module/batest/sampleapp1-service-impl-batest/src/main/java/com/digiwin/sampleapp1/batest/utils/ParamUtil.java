package com.digiwin.sampleapp1.batest.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.digiwin.app.service.DWServiceResult;

public class ParamUtil {
    public static JSONArray getJSONArray(String std_data){
        JSONObject jsonObject = JSON.parseObject(std_data);
        JSONObject parameter = jsonObject.getJSONObject("parameter");
        JSONArray solution_infos = parameter.getJSONArray("solution_info");
        return solution_infos;
    }
}
