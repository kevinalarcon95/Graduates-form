package co.edu.unicauca.graduates.core.modules.graduates_management.exceptionControllers.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public abstract class ClientManagementRuntimeException extends RuntimeException {

  protected ErrorCode errorCode;

  public abstract String formatException();
}
