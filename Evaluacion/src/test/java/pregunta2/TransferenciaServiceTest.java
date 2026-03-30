package pregunta2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TransferenciaServiceTest {

    @Mock
    private CuentaRepository cuentaRepository;

    @Mock
    private FraudeService fraudeService;

    @Mock
    private OtpService otpService;

    @Mock
    private TransaccionRepository transaccionRepository;

    @InjectMocks
    private TransferenciaService service;


    @Test
    void deberiaTransferirCorrectamente() {

        when(cuentaRepository.existeCuenta("destino")).thenReturn(true);
        when(cuentaRepository.tieneSaldo("origen", 500)).thenReturn(true);
        when(fraudeService.esSospechoso("origen", 500)).thenReturn(false);

        boolean resultado = service.transferir("origen", "destino", 500);

        assertTrue(resultado);

        verify(transaccionRepository).registrar("origen", "destino", 500);
    }

    @Test
    void deberiaFallarSiCuentaDestinoNoExiste() {

        when(cuentaRepository.existeCuenta("destino")).thenReturn(false);

        assertThrows(RuntimeException.class, () -> {
            service.transferir("origen", "destino", 500);
        });
    }

}

