package com.lzdn.examine.entity;

public class TransportEntity {
    /**
     * 加密
     */
    private String transport;
    /**
     * url
     */
    private String url;
    /**
     * 时间戳
     */
    private String timestamp;

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "{" +
                "transport='" + transport + '\'' +
                ", url='" + url + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
