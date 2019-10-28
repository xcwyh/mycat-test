package com.xc.mycat.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xc.mycat.dao.TravelrecordMapper;
import com.xc.mycat.entity.Travelrecord;
import com.xc.mycat.param.TravelrecordParam;
import com.xc.mycat.service.ITravelrecordService;
import com.xc.mycat.util.WrapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 管理组 服务类
 * </p>
 *
 * @author xc
 * @since 2019-03-26
 */
@Service
public class TravelrecordService extends ServiceImpl<TravelrecordMapper, Travelrecord> implements ITravelrecordService {

    @Autowired
    private TravelrecordMapper travelrecordMapper;

    /**
     * 根据请求参数查询列表
     * @param param
     * @return
     */
    @Override
    public List<Travelrecord> listByParam(TravelrecordParam param){
        QueryWrapper<Travelrecord> wrapper = getWrapper(param);
        WrapperUtil.setOrder(wrapper, param, "id");
        Page<Travelrecord> page = WrapperUtil.getPage(param);
        if (ObjectUtils.isNotEmpty(page)) {
            return travelrecordMapper.selectPage(page, wrapper).getRecords();
        } else {
            return travelrecordMapper.selectList(wrapper);
        }
    }

    /**
     * 根据请求参数查询总数
     * @param param
     * @return
     */
    @Override
    public Integer countByParam(TravelrecordParam param) {
        Wrapper<Travelrecord> wrapper = getWrapper(param);
        return travelrecordMapper.selectCount(wrapper);
    }
    /**
     * 自定义查询参数
     * @param param
     * @return
     */
    private QueryWrapper<Travelrecord> getWrapper(TravelrecordParam param){
        QueryWrapper<Travelrecord> wrapper = new QueryWrapper<Travelrecord>();
        if(ObjectUtils.isNotEmpty(param.getId())) {
            wrapper.eq("id", param.getId());
        }
        return wrapper;
    }
}
