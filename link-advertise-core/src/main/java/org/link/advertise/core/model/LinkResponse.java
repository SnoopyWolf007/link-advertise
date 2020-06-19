package org.link.advertise.core.model;

import lombok.*;

/**
 * @Author: changmingjiang
 * @Date: 2020/6/19 14:47
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LinkResponse {
    public static final LinkResponse SUCCESS = new LinkResponse(1L, "success", null);
    public static final LinkResponse FAIL = new LinkResponse(0L, "fail", null);

    private Long code;
    private String msg;
    private Object data;

    public LinkResponse code(Long code){
        this.code = code;
     return this;
    }

    public LinkResponse msg(String msg){
        this.msg = msg;
        return this;
    }

    public LinkResponse data(Object data){
        this.data = data;
        return this;
    }
}
