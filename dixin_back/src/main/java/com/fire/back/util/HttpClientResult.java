package com.fire.back.util;

import java.io.Serializable;

/**
 * @description   :  sms result
 * @author        :  nicai
 * @createDate    :  2020/2/23 4:16 PM
 * @updateUser    :  nicai
 * @updateDate    :  2020/2/23 4:16 PM
 * @updateRemark  :
 * @version       :  1.0
 */
public class HttpClientResult implements Serializable {

    /**
     * 响应状态码
     */
    private int code;

    /**
     * 响应数据
     */
    private String content;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
