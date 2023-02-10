package co.edu.unicauca.graduates.core.modules.graduates_management.exceptionControllers.exceptions;

public class BusinessRuleExcepcion extends ClientManagementRuntimeException {

  private static final String FORMATO_EXCEPCION = "%s - Violación a regla de negocio: %s";

  private final String reglaNegocio;

  public BusinessRuleExcepcion(final String reglaNegocio) {
    super(ErrorCode.VIOLACION_REGLA_DE_NEGOCIO);
    this.reglaNegocio = reglaNegocio;
  }

  @Override
  public String formatException() {
    return String.format(FORMATO_EXCEPCION, errorCode.getCode(), reglaNegocio);
  }
}
