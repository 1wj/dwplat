package com.digiwin.sampleapp1.batest.service;

import com.digiwin.app.service.DWService;
import com.digiwin.app.service.restful.DWRequestMapping;
import com.digiwin.app.service.restful.DWRequestMethod;
import com.digiwin.app.service.restful.DWRestfulService;
import java.util.Map;

@DWRestfulService
public interface IEditMessagesService extends DWService {

    @DWRequestMapping(path = "query/editMessage",method = DWRequestMethod.POST)
    public Map addEditMessage(String std_data)throws Exception;
}
