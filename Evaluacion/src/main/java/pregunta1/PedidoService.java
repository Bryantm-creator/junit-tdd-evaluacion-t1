package pregunta1;

import java.time.LocalDate;

public class PedidoService {

    public String registrarPedido(String codigo, String nombre, Integer mesa, Double monto, LocalDate fecha) {

        // 1. CAMPOS VACÍOS
        if (codigo == null || nombre == null || nombre.isEmpty() || mesa == null || monto == null || fecha == null) {
            return "Debe ingresar todos los datos requeridos";
        }

        // 2. CÓDIGO
        if (!codigo.matches("P\\d{3}")) {
            return "Ingrese un código de pedido válido";
        }

        // 3. NOMBRE
        if (!nombre.matches("[a-zA-Z]{3,}")) {
            return "El nombre del cliente debe tener al menos tres caracteres alfabéticos";
        }

        // 4. MESA
        if (mesa < 1 || mesa > 50) {
            return "Ingrese un número de mesa válido";
        }

        return "";
    }
}