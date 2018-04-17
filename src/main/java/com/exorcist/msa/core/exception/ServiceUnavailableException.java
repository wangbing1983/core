package com.exorcist.msa.core.exception;


import com.exorcist.msa.api.CommonErrorCode;
import com.exorcist.msa.api.ErrorCode;

public class ServiceUnavailableException extends AppBusinessException {
  private static final ErrorCode ERROR_CODE;

  public ServiceUnavailableException(String message) {
    super(ERROR_CODE.getCode(), ERROR_CODE.getStatus(), " 远程服务不可用: " + message);
  }

  static {
    ERROR_CODE = CommonErrorCode.SERVICE_UNAVAILABLE;
  }
}
