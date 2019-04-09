package com.lzdn.examine.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("app_sign")
public class SignEntity  {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String httpSrc;
    private String realSrc;
    private Integer uploadUserId;
    private String uploadUsername;
    private String plateNumber;
    private String md5;



    public SignEntity(){};

    public SignEntity(Integer id, String httpSrc, String realSrc, Integer uploadUserId, String uploadUsername, String plateNumber, String md5) {
        this.id = id;
        this.httpSrc = httpSrc;
        this.realSrc = realSrc;
        this.uploadUserId = uploadUserId;
        this.uploadUsername = uploadUsername;
        this.plateNumber = plateNumber;
        this.md5 = md5;
    }

    public SignEntity(Integer id, String httpSrc, String realSrc, Integer uploadUserId, String uploadUsername, String plateNumber) {
        this.id = id;
        this.httpSrc = httpSrc;
        this.realSrc = realSrc;
        this.uploadUserId = uploadUserId;
        this.uploadUsername = uploadUsername;
        this.plateNumber = plateNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHttpSrc() {
        return httpSrc;
    }

    public void setHttpSrc(String httpSrc) {
        this.httpSrc = httpSrc;
    }

    public String getRealSrc() {
        return realSrc;
    }

    public void setRealSrc(String realSrc) {
        this.realSrc = realSrc;
    }

    public Integer getUploadUserId() {
        return uploadUserId;
    }

    public void setUploadUserId(Integer uploadUserId) {
        this.uploadUserId = uploadUserId;
    }

    public String getUploadUsername() {
        return uploadUsername;
    }

    public void setUploadUsername(String uploadUsername) {
        this.uploadUsername = uploadUsername;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }
    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    @Override
    public String toString() {
        return "SignEntity{" +
                "id=" + id +
                ", httpSrc='" + httpSrc + '\'' +
                ", realSrc='" + realSrc + '\'' +
                ", uploadUserId=" + uploadUserId +
                ", uploadUsername='" + uploadUsername + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                ", md5='" + md5 + '\'' +
                '}';
    }
}
