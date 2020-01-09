// Copyright (C) 2018 Baidu Inc. All rights reserved.

package com.baidu.acu.pie.exception;

import lombok.Getter;

/**
 * 服务端返回报错
 */
@Getter
public class AsrException extends RuntimeException {
    private String traceId;
    private int errorCode;

    @Deprecated
    public AsrException(int errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
    }

    public AsrException(String traceId, int errorCode, String errorMessage) {
        super(errorMessage);
        this.traceId = traceId;
        this.errorCode = errorCode;
    }

    @Deprecated
    public AsrException(int errorCode, Throwable t) {
        super(t);
        this.errorCode = errorCode;
    }

    public AsrException(int errorCode, String errorMessage, Throwable t) {
        super(errorMessage, t);
        this.errorCode = errorCode;
    }

    @Override
    public String getMessage() {
        return String.format("\ntraceId = %s\nerrorCode = %d\nerrorMessage = %s",
                traceId,
                errorCode,
                super.getMessage());
    }
}
