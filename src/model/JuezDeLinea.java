package model;

public class JuezDeLinea extends Arbitro implements IDesplazarseEntreJugada{
    public JuezDeLinea(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
        public String desplazarseEntreJugada() {
        return "El juez de Linea se desplazado sobre el hielo";
    }
}