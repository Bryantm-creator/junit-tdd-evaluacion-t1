package pregunta2;

public interface TransaccionRepository {

    void registrar(String origen, String destino, double monto);
}