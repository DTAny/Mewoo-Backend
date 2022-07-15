package com.github.dtanything.mewoobackend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName memo
 */
@TableName(value ="memo")
@Data
public class Memo implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer mid;

    /**
     * 
     */
    private Integer uid;

    /**
     * 
     */
    private String content;

    /**
     * 
     */
    private Date time;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}