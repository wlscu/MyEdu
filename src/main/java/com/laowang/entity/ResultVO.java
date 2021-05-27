package com.laowang.entity;

/**
 * @author 隔壁老王
 */
public class ResultVO {
    private Integer status; //状态
    private String message; //消息
    private Object data; //数据

    public ResultVO() {
    }

    public ResultVO(Integer status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
