import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.*;

public class Blackjack {
    public static void main(String[] args) {
        crearBaraja();
    }

    public static String[][] crearBaraja(){
        var pintas = new String[]{"Corazón","Diamante","Trébol","Pica"};
        var numerosCartas = new String[]{"Dos","Tres","Cuatro","Cinco","Seis","Siete","Ocho","Nueve","Diez","As","Queen","King","Kaiser"};
        return new String[][]{pintas, numerosCartas};
    }

    public static void barajar(){
        String[][] baraja = new String[0][0];

        for(int i = 0; i < baraja.length; i++){
            Random ronda = new Random();
            for(int o = baraja[i].length - 1; o > 0; o++){
                int index = ronda.nextInt(o + 1);
                String a = baraja[i][index];
                baraja[i][index] = baraja[i][o];
                baraja[i][o] = a;
            }
        }
    }

    public static void repartir(String[][] baraja, String [] mano){
        var carta = new String[2];
        for (var j = 0; j < mano.length; j++) {
            for (var i = 0; i < baraja.length; i++) {
                carta[i] = baraja[i][(int) (Math.random() * baraja[i].length)];
            }
            mano[j] = carta[0] + " " + carta[1];
        }
    }

    public static HashMap<String, Integer> crearMapa(){
        var cartas = List.of("AS","DOS","TRES","CUATRO","CUATRO","CINCO","SEIS","SIETE","OCHO","NUEVE","DIEZ","JOTA","QUINA","KAISER");
        var mapa = new HashMap<String, Integer>();
        var valorCarta = 0;

        for(var carta : cartas){
            if(valorCarta > 10){
                valorCarta = 10;
            }
            mapa.put(carta, valorCarta);
            valorCarta++;
        }

        return mapa;
    }

    public static List<Integer> obtenerValoresCartas(String obtenerValoresDeCarta){
        List<String> mano = null;

        var valoresCartas = new ArrayList<Integer>();
        var mapa = crearMapa();
        for(var carta : mano){
            valoresCartas.add(mapa.get(carta));
        }

        return valoresCartas;
    }

    public static void bajarse(String[] manoJugador, String[][] manoDealer, String[] baraja){
        String[] ganador = verificarGanador(List.of(manoJugador), List.of(manoJugador)).toArray(new String[0]);

        if(ganador == manoJugador){
            System.out.println("Has ganado!!");
        }else{
            System.out.println("Has perdido!!");
        }
    }

    public static int obtenerValorDeMano(List<String> mano){
        int valorTotal = 0;
        for(String carta : mano){
            valorTotal += obtenerValorDeMano(Collections.singletonList(carta));
        }

        return valorTotal;
    }

    public static boolean sePasoDe21(){
        String mano = String.valueOf(0);

        /*if(obtenerValorDeMano(Collections.singletonList((mano))) > 21){
            return  true;
        }else{
            return false;
        }*/

        // Una forma de simplificar el if else anterior es con el siguiente retorno:
        return obtenerValorDeMano(Collections.singletonList((mano))) > 21;
    }

    public static int obtenerValorDeCarta(String carta) {
        String valorCarta = carta.split(" ")[1];

        return switch (valorCarta) {
            case "AS" -> 1;
            case "DOS" -> 2;
            case "TRES" -> 3;
            case "CUATRO" -> 4;
            case "CINCO" -> 5;
            case "SEIS" -> 6;
            case "SIETE" -> 7;
            case "OCHO" -> 8;
            case "NUEVE" -> 9;
            case "DIEZ" -> 10;
            case "JOTA" -> 10;
            case "QUINA" -> 10;
            case "KAISER" -> 10;
            default -> 0;
        };

    }

    public static boolean esBlackjack(List<String> mano){
        if ((mano.size()) == 0 || mano.size() > 2) {
            return false;
        }
        boolean existeAs = false;
        boolean existe10 = false;

        for (String carta : mano) {
            int valorNumericoDeCarta = obtenerValorDeCarta(carta);
            if (carta.equals("1")) {
                existeAs = true;
            }
            if (carta.equals("10")) {
                existe10 = true;
            }
        }
        return (existeAs && existe10);

        /*List<String> mano = null;

        if(mano.size() > 2){
            return false;
        }

        boolean hayAs = false;
        boolean hay10 = false;

        for(String carta : mano){
            if(carta.split(" ")[1].equals("AS")){
                hayAs = true;
            }
            if(obtenerValoresCartas(carta) == 10){
                hay10 = true;
            }
        }

        return (hayAs && hay10);*/
    }

    public static List<String> verificarGanador(List<String> manoJugador, List<String> manoDealer){
        return new ArrayList<>();
    }

    public static String[] crearMano(){
        String[] mano = new String[2];
        return mano;
    }

    public static void jugar(){
        repartir();
        bajarse();
        sePasoDe21();
        esBlackjack();
        verificarGanador();
        crearMano();
        barajar();
        obtenerValoresCartas();
        crearMapa();
        jugar();
        mostrarMenu();
    }

    public static void mostrarMenu(){

    }
}