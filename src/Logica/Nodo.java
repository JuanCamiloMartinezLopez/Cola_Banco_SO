package Logica;


public class Nodo {
    int recibos;
    int indice;
    String clave;
    Nodo sig;
    Nodo(int i){
    	this.indice=i;
    	recibos = 0;
    	clave = "";
    	sig = null;
    }
}
