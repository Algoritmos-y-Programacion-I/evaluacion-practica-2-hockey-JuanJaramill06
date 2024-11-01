package model;

public class ArbitroPrincipal extends Arbitro implements IDesplazarseEntreJugada{
    public ArbitroPrincipal(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
        public String desplazarseEntreJugada() {
            return "El arbitro principal se desplazado sobre el hielo";
    }
}