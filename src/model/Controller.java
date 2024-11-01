package model;

import java.util.Random;

public class Controller {

    private Equipo[] equipos;
    private Arbitro[] arbitros;

    private final int CANTIDAD_EQUIPOS = 4;
    private final int CANTIDAD_ARBITROS = 4;

    private int contadorEquipos = 0;

    /**
     * Constructor de la clase Controller para inicializar variables globales.
     *
     * @pre No se requieren precondiciones específicas.
     * @post Se crea una instancia de Controller con un arreglo de personas vacío.
     */
    public Controller() {
        equipos = new Equipo[CANTIDAD_EQUIPOS];
        arbitros = new Arbitro[CANTIDAD_ARBITROS];
    }

    public String fixture() {
        String fixture = "";
        Random random = new Random();
        int equipo1 = random.nextInt(4);
        int equipo2;
        do {
            equipo2 = random.nextInt(4);
        } while (equipo2 == equipo1);

        fixture += "Partido 1: Equipo " + equipo1 + " vs Equipo " + equipo2;
        fixture += "\n";

        do {
            equipo1 = random.nextInt(4);
            equipo2 = random.nextInt(4);
        } while (equipo2 == equipo1);

        fixture += "Partido 2: Equipo " + equipo1 + " vs Equipo " + equipo2;
        return fixture;
    }

    public Equipo crearEquipo(String nombreEquipo){
        Equipo newEquipo = new Equipo(nombreEquipo);
        anadirEquipo(newEquipo);
        return newEquipo;
    }

    public void anadirEquipo(Equipo equipo) {
        if (equipo != null && contadorEquipos < equipos.length) {
            equipos[contadorEquipos++] = equipo;
          }
    } 

    public void anadirJugador(String nombre, int edad, Posicion posicion, int equipoIndex) {
    if (equipoIndex >= 0 && equipoIndex < equipos.length) {
        JugadorHockey jugador = new JugadorHockey(nombre, edad, posicion);

        equipos[equipoIndex].agregarJugador(jugador, 0); 
    }
}

    public void precargarInformacion(){
        
        equipos[0] = new Equipo("Equipo A");

        anadirJugador("Jugador1", 20, Posicion.PORTERO, 0);
        anadirJugador("Jugador2", 25, Posicion.ALA, 0);
        anadirJugador("Jugador3", 24, Posicion.CENTRO, 1);
        anadirJugador("Jugador4", 29, Posicion.DEFENSA, 1);
        anadirJugador("Jugador5", 27, Posicion.DEFENSA, 2);
        anadirJugador("Jugador6", 22, Posicion.ALA, 2);

        arbitros[0] = new ArbitroPrincipal("Arbitro Principal 1", 40);
        arbitros[1] = new ArbitroPrincipal("Arbitro Principal 2", 35);
        arbitros[2] = new JuezDeLinea("Juez de Linea 1", 30);
        arbitros[3] = new JuezDeLinea("Juez de Linea 2", 32);

    }

     public void simularJugada() {
        Random random = new Random();
        System.out.println("Simulando jugada de gol...");

        int[] jugadores = {1, 10, 9, 3, 7, 9};
        
        for (int i = 0; i < 5; i++) {
            System.out.println("Jugador numero " + jugadores[i] + " se la pasa a Jugador numero " + jugadores[i + 1]);

            int arbitroIndex = random.nextInt(CANTIDAD_ARBITROS);
            System.out.println(arbitros[arbitroIndex].desplazarse());
        }
        
        System.out.println("Jugador numero " + jugadores[5] + " entra el disco en la red. Gol!");
    }

}