package pregunta1;

import java.time.LocalDate;

public class PedidoService {

    public String registrarPedido(String codigo, String nombre, Integer mesa, Double monto, LocalDate fecha) {

        // 1. VALIDAR VACÍOS PRIMERO
        if (codigo == null || nombre == null || nombre.isEmpty() || mesa == null || monto == null || fecha == null) {
            return "Debe ingresar todos los datos requeridos";
        }

        // 2. VALIDAR CÓDIGO
        if (!nombre.matches("[a-zA-Z]{3,}")) {
            return "El nombre del cliente debe tener al menos tres caracteres alfabéticos";
        }

        return "";
    }
}