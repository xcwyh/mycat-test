package com.xc.mycat.controller;

import com.alibaba.fastjson.JSONObject;
import com.xc.mycat.entity.Travelrecord;
import com.xc.mycat.param.TravelrecordParam;
import com.xc.mycat.service.ITravelrecordService;
import com.xc.mycat.util.ObjectUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/travelrecord")
@Slf4j
public class TravelrecordController {

    @Autowired
    private ITravelrecordService travelrecordService;

    @GetMapping
    public JSONObject listByParam(TravelrecordParam travelrecordParam) {
        log.info("查看开始");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", HttpServletResponse.SC_OK);
        jsonObject.put("data", travelrecordService.listByParam(travelrecordParam));
        jsonObject.put("message", "获取成功");
        log.info("查看结束");
        return jsonObject;
    }

    @PostMapping
    public JSONObject add(TravelrecordParam travelrecordParam) {
        log.info("添加开始");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", HttpServletResponse.SC_OK);
        Travelrecord travelrecord = ObjectUtils.convert(travelrecordParam, Travelrecord.class);
        jsonObject.put("data", travelrecordService.save(travelrecord));
        jsonObject.put("message", "添加成功");
        log.info("添加结束");
        return jsonObject;
    }

    @PutMapping
    public JSONObject update(TravelrecordParam travelrecordParam) {
        log.info("修改开始");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", HttpServletResponse.SC_OK);
        Travelrecord travelrecord = ObjectUtils.convert(travelrecordParam, Travelrecord.class);
        jsonObject.put("data", travelrecordService.updateById(travelrecord));
        jsonObject.put("message", "修改成功");
        log.info("修改结束");
        return jsonObject;
    }

    @DeleteMapping(value = "{id}")
    public JSONObject delete(@PathVariable Integer id) {
        log.info("删除开始");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", HttpServletResponse.SC_OK);
        jsonObject.put("data", travelrecordService.removeById(id));
        jsonObject.put("message", "删除成功");
        log.info("删除结束");
        return jsonObject;
    }

    @GetMapping(value = "{id}")
    public JSONObject get(@PathVariable Integer id) {
        log.info("ID查看开始");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", HttpServletResponse.SC_OK);
        jsonObject.put("data", travelrecordService.getById(id));
        jsonObject.put("message", "ID查看成功");
        log.info("ID查看结束");
        return jsonObject;
    }

}
