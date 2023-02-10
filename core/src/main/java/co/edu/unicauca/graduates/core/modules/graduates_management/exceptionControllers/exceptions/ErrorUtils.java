package co.edu.unicauca.graduates.core.modules.graduates_management.exceptionControllers.exceptions;

public final class ErrorUtils {

  ErrorUtils() {

  }

  /**
   * Crea un nuevo objeto de <code>Error</code>
   * 
   * @param errorCode
   * @param keyMessage
   * @param codeHttp
   * @return - Objeto creado
   */
  public static Error createError(final String errorCode, final String keyMessage, final Integer codeHttp) {
    final Error error = new Error();
    error.setErrorCode(errorCode);
    error.setMessage(keyMessage);
    error.setCodeHttp(codeHttp);
    return error;
  }
}
