package com.xc.mycat.param;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class TravelrecordParam extends BaseSearchParam {

    private Integer id;

    private String userId;

    private Date traveldate;

    private BigDecimal fee;

    private Integer days;

}
