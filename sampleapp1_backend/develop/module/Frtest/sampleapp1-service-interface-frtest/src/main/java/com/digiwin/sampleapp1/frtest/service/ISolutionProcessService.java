package com.digiwin.sampleapp1.frtest.service;

import com.digiwin.app.service.DWService;
import com.digiwin.app.service.DWServiceResult;
import com.digiwin.app.service.restful.DWRequestMapping;
import com.digiwin.app.service.restful.DWRequestMethod;
import com.digiwin.app.service.restful.DWRestfulService;

import java.util.Map;

@DWRestfulService
public interface ISolutionProcessService extends DWService {
    /**
     * 增加
     * @param std_data
     * @return
     * @throws Exception
     */
    @DWRequestMapping(path = "/add/solutionPro",method = DWRequestMethod.POST)
    DWServiceResult solutionProcess(String std_data)throws Exception;

    /**
     * 查询
     * @param std_data
     * @return
     * @throws Exception
     */
    @DWRequestMapping(path = "/query/solutionInfo",method = DWRequestMethod.POST)
    DWServiceResult solutionInfo(String std_data)throws Exception;
}
