import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BlackJackTest {
    private String[] obtenerValoresDeCartas;
    private boolean[] resultadosEsperados;

    @BeforeEach
    public void init(){
        obtenerValoresDeCartas = new String[] {"AS","DOS","TRES","CUATRO","CUATRO","CINCO"};
        resultadosEsperados = new boolean[] {};
    }

    @Test
    public void valoresDeCartas(){
        for(int i = 0; i < obtenerValoresDeCartas.length; i++){
            List<Integer> valoresObtenidos = Blackjack.obtenerValoresCartas(obtenerValoresDeCartas[i]);
            assertEquals(valoresObtenidos, resultadosEsperados);
        }
    }

    @Test
    @DisplayName("Caso excepción donde el jugador está vacío")
    void verificarGanadorCasoJugadorVacio(){
        var logger = Logger.getLogger("BlackjackSemana2Test.class");
        var manoDealer = new String[]{"10: corazones", "as: picas"};
        assertThrows(NullPointerException);
    }
}