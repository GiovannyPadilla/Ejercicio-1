import javax.swing.*;

public class Pila {
    public Nodo cima;
    public int tamano;

    public Pila() {
        cima = null;
        tamano = 0;
    }

    public void apilar(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        nuevoNodo.siguiente = cima;
        cima = nuevoNodo;
        tamano++;
    }

    public boolean estaVacia() {
        return cima == null;
    }

    public int desapilar() {
        if (estaVacia()) {
            JOptionPane.showMessageDialog(null, "La pila está vacía");
            return -1;
        }
        int dato = cima.dato;
        cima = cima.siguiente;
        tamano--;
        return dato;
    }

    public String mostrarPila() {
        if (estaVacia()) {
            return "La pila está vacía";
        } else {
            StringBuilder pilaStr = new StringBuilder();
            Nodo actual = cima;
            while (actual != null) {
                pilaStr.append(actual.dato).append(" ");
                actual = actual.siguiente;
            }
            return pilaStr.toString();
        }
    }

    public void invertir() {
        if (!estaVacia()) {
            int dato = desapilar();
            invertir();
            insertarAlFondo(dato);
        }
    }


    private void insertarAlFondo(int dato) {
        if (estaVacia()) {
            apilar(dato);
        } else {
            int temp = desapilar();
            insertarAlFondo(dato);
            apilar(temp);
        }
    }
}