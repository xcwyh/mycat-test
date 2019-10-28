package com.xc.mycat.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xc.mycat.entity.Travelrecord;
import com.xc.mycat.param.TravelrecordParam;

import java.util.List;

/**
 * <p>
 * 管理组 服务类
 * </p>
 *
 * @author xc
 * @since 2019-03-26
 */
public interface ITravelrecordService extends IService<Travelrecord> {

    /**
     * 根据请求参数查询列表
     * @param param
     * @return
     */
    List<Travelrecord> listByParam(TravelrecordParam param);

    /**
     * 根据请求参数查询总数
     * @param param
     * @return
     */
    Integer countByParam(TravelrecordParam param);
}
