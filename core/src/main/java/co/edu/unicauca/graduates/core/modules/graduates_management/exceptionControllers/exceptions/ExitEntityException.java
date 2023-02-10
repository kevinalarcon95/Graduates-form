package co.edu.unicauca.graduates.core.modules.graduates_management.exceptionControllers.exceptions;

import lombok.Getter;

@Getter
public class ExitEntityException extends RuntimeException {

  private final String keyMenssage;
  private final String codigo;

  public ExitEntityException(ErrorCode code) {
    super(code.getCode());
    this.keyMenssage = code.getKeyMessage();
    this.codigo = code.getCode();
  }

  public ExitEntityException(final String message) {
    super(message);
    this.keyMenssage = ErrorCode.ENTIDAD_YA_EXISTE.getKeyMessage();
    this.codigo = ErrorCode.ENTIDAD_YA_EXISTE.getCode();
  }
}
