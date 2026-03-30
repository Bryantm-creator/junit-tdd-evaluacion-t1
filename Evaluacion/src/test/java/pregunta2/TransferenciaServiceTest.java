package pregunta2;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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

}