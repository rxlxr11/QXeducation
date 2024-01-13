package com.rxlxr.qxeducation.bean;

import lombok.Data;

@Data
public class Response {
    private int errorCode = 0;
    /**
     * Message returned by the network request.
     */
    private String errorMsg;

    private Object data;

}
