package Logica;

public class Cola {
    private Nodo cajero = new Nodo();
    public Cola(){
        cajero.recibos = -1;
        cajero.clave = "Cajero";
        cajero.sig = cajero;
    }
    public void insertar(int re){
    	Nodo nuevo = new Nodo();
    	nuevo.recibos = re;
    	nuevo.clave = "Cliente";
    	
        if(cajero.sig == cajero){
            cajero.sig = nuevo;
            nuevo.sig = cajero;
        }else {
            Nodo aux = cajero;
            Nodo paux = cajero;
            while(aux.sig != cajero){
                aux = aux.sig;
                paux = aux;
            }
            System.out.println("Insert-"+paux.recibos);
            paux.sig = nuevo;
            nuevo.sig = cajero;
        }
        
    }
    
    public boolean isEmpty() {
    	if(this.cajero.sig==this.cajero) {
    		return true;
    	}
    	return false;
    }
    public void atender() {
    	//boolean bandera = true;
    	//while(bandera) {
    		Nodo at = cajero.sig;
        	if (at == cajero) {
        		System.out.println("No hay nadie en la cola");
        		//break;
        	}else {
        		if (at.recibos <= 5) {
        			cajero.sig = at.sig;
        			at.sig = null;
        			System.out.println("Cliente atendido");
        		}else {
        			Nodo aux = cajero;
                    Nodo paux = cajero;
                    while(aux.sig != cajero){
                        aux = aux.sig;
                        paux = aux;
                    }
                    cajero.sig = at.sig;
                    paux.sig = at;
                    at.sig = cajero;
                    at.recibos -= 5;
        		}
        	}
        	System.out.println();
        	mostrar();
        	System.out.println();
    	//}
    }
    public void mostrar() {
    	Nodo aux = cajero;
        while(aux.sig != cajero){
            aux = aux.sig;
            System.out.println(aux.clave+" | "+aux.recibos);
        }
    }
    
    public String dibujar() {
    	String colaActual=": ";
    	Nodo aux = cajero;
    	while(aux.sig != cajero){
            aux = aux.sig;
            colaActual+=aux.recibos+" | ";
        }
    	return colaActual;	
    }
    
}
