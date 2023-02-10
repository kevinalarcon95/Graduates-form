package co.edu.unicauca.graduates.core.modules.graduates_management.exceptionControllers.exceptions;

import lombok.Getter;

@Getter
public class NoExistEntityException extends RuntimeException {

  private final String keyMessage;
  private final String code;

  public NoExistEntityException(ErrorCode code) {
    super(code.getCode());
    this.keyMessage = code.getKeyMessage();
    this.code = code.getCode();
  }

  public NoExistEntityException(final String message) {
    super(message);
    this.keyMessage = ErrorCode.ENTIDAD_NO_ENCONTRADA.getKeyMessage();
    this.code = ErrorCode.ENTIDAD_NO_ENCONTRADA.getCode();
  }
}
