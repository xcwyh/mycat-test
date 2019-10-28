package com.xc.mycat.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 功能模块表
 * </p>
 *
 * @author
 * @since 2019-09-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Travelrecord implements Serializable {

    private static final long serialVersionUID = 1L;

//    @TableId(value = "id", type = IdType.AUTO)
    @TableField("id")
    private Integer id;

    @TableField("user_id")
    private String userId;

    @TableField("traveldate")
    private Date traveldate;

    @TableField("fee")
    private BigDecimal fee;

    @TableField("days")
    private Integer days;

}
