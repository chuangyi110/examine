package com.lzdn.examine.entity;



import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
@TableName("app_version")
public class VersionEntity implements Serializable {
    @TableId
    private Integer id;

    private Integer versionCode;

    private String versionName;

    private Integer statue;

    private String remarks;

    private String realSrc;

    private String httpSrc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(Integer versionCode) {
        this.versionCode = versionCode;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public Integer getStatue() {
        return statue;
    }

    public void setStatue(Integer statue) {
        this.statue = statue;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRealSrc() {
        return realSrc;
    }

    public void setRealSrc(String realSrc) {
        this.realSrc = realSrc;
    }

    public String getHttpSrc() {
        return httpSrc;
    }

    public void setHttpSrc(String httpSrc) {
        this.httpSrc = httpSrc;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", versionCode=" + versionCode +
                ", versionName='" + versionName + '\'' +
                ", statue=" + statue +
                ", remarks='" + remarks + '\'' +
                ", realSrc='" + realSrc + '\'' +
                ", httpSrc='" + httpSrc + '\'' +
                '}';
    }
}
