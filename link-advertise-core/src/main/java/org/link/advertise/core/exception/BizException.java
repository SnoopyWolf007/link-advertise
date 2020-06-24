package org.link.advertise.core.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: changmingjiang
 * @date: 2020/6/24 19:00
 */
@Getter
@Setter
public class BizException extends RuntimeException {
    public static final BizException SERVICE_ERR = new BizException(1, "service execute error.");

    private final int code;
    private final String message;

    public BizException(Integer errCode, String errMsg) {
        super(errMsg);
        this.code = errCode;
        this.message = errMsg;
    }
}
