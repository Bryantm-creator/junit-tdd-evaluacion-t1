package pregunta2;

public interface CuentaRepository {

    boolean existeCuenta(String cuenta);

    boolean tieneSaldo(String cuenta, double monto);
}