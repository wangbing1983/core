package com.exorcist.msa.core.exception;

import com.exorcist.msa.api.Error;

public class RemoteCallException extends AppBusinessException {
  private Error originError;

  public RemoteCallException(Error error, int httpStatus) {
    super(error.getCode(), httpStatus, "调用远程服务异常, cause: " + error.getMessage());
    this.originError = error;
  }

  public Error getOriginError() {
    return this.originError;
  }
}
