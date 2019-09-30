package com.hrh.mt.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "mt_swapper")
public class MtSwapper implements Serializable {
    @Id
    @Column(name = "unid_swapper_id")
    private String unidSwapperId;

    /**
     * 轮播图名
     */
    @Column(name = "swapper_name")
    private String swapperName;

    /**
     * 轮播图地址
     */
    @Column(name = "swapper_url")
    private String swapperUrl;

    /**
     * 状态 0：OK 1:no
     */
    @Column(name = "swapper_state")
    private Integer swapperState;

    /**
     * 轮播图跳转地址
     */
    @Column(name = "swapper_href")
    private String swapperHref;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 更新时间
     */
    @Column(name = "update_date")
    private Date updateDate;

    private static final long serialVersionUID = 1L;
}