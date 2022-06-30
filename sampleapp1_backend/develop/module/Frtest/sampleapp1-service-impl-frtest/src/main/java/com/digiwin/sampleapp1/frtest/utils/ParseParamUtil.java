package com.digiwin.sampleapp1.frtest.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.digiwin.sampleapp1.frtest.domain.model.AttachmentModel;
import com.digiwin.sampleapp1.frtest.domain.model.QuestionInfoModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParseParamUtil {
    /**
     * 解析增加接口里面的 参数
     * @param std_data
     * @return Map
     */
    public static Map parseInfo(String std_data){
        Map<String,List>map=new HashMap<>();
        JSONObject parameter = JSONObject.parseObject(std_data).getJSONObject("parameter");
        List<QuestionInfoModel> questionInfoModels = JSON.parseArray(parameter.getString("question_info"), QuestionInfoModel.class);
        List<AttachmentModel> attachmentModels = JSON.parseArray(parameter.getString("attachment_info"), AttachmentModel.class);
        map.put("questionInfoModels",questionInfoModels);
        map.put("attachmentModels",attachmentModels);
        return map;
    }

    /**
     * 解析查询接口里面的 查询参数
     * @param std_data
     * @return String
     */
    public static String parseQueryInfo(String std_data){
        JSONObject questionInfo = JSON.parseObject(std_data).getJSONObject("question_info");
        //获取问题追踪id
        String questionId = questionInfo.getString("question_id");
        return questionId;
    }

}
