package com.hrh.mt.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "mt_user")
public class MtUser implements Serializable {
    /**
     * 用户id
     */
    @Id
    @Column(name = "unid_user_id")
    private String unidUserId;

    /**
     * 用户登录账号，也是手机号码
     */
    @Column(name = "user_phone")
    private String userPhone;

    /**
     * 用户密码
     */
    @Column(name = "user_password")
    private String userPassword;

    /**
     * 用户创建时间
     */
    @Column(name = "user_created")
    private Date userCreated;

    /**
     * 用户更新事件
     */
    @Column(name = "user_updated")
    private Date userUpdated;

    /**
     * 用户昵称
     */
    @Column(name = "user_name")
    private String userName;

    private static final long serialVersionUID = 1L;
}
