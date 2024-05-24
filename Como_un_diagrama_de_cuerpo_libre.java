package fisica;
import java.util.Scanner;

public class Como_un_diagrama_de_cuerpo_libre {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        // Pedir la cantidad de fuerzas y crear un array
        System.out.println();
        System.out.println("Ingrese la cantidad de fuerzas a considerar:");
        int cantidadFuerzas = sc.nextInt();
        int fuerzaHorizontalNeta = 0;
        int fuerzaVerticalNeta = 0;
        int velocidad=0;
        int fuerzaHorizontalNetaDerecha = 0;
        int fuerzaHorizontalNetaIzquierda = 0;
        int fuerzaVerticalNetaDerecha = 0;
        int fuerzaVerticalNetaIzquierda = 0;
        
        String sentidov=null;
        String direccionv=null;
        String fnhs=null;
        String fnvs=null;
        String velocidad_resultado="";
        
        int[] fuerzas = new int[cantidadFuerzas];

        String[] direccion = new String[cantidadFuerzas];
        String[] sentido = new String [cantidadFuerzas];
        
        // Ingresar las fuerzas en el array
        for (int i = 0; i < cantidadFuerzas; i++) {
            System.out.println("Ingrese el módulo de la fuerza " + (i+1) + ":");
            fuerzas[i] = sc.nextInt();
            do {
                System.out.println("Ingrese la dirección de la fuerza (H= horizontal),(V=vertical) ");
                direccion[i] = sc.next(); 
                if (direccion[i].equals("h")){
                    direccion[i]="H";
                }else if (direccion[i].equals("v")){
                    direccion[i]="V";
                }
            }while ((!direccion[i].equals("H")) && (!direccion[i].equals("V")) );

            do {
            if (direccion[i].equals("H")) {
	            System.out.println("Ingrese el sentido de la fuerza (I= Izquierda), (D= Derecha)");
	            sentido[i]= sc.next();
                if (sentido[i].equals("i")){
                    sentido[i]="I";
                }else if (sentido[i].equals("d")){
                    sentido[i]="D";
                }
            }else {
                System.out.println("Ingrese el sentido de la fuerza (A= Arriba), (B= Abajo)");
	            sentido[i]= sc.next();
                if (sentido[i].equals("a")){
                    sentido[i]="A";
                }else if (sentido[i].equals("b")){
                    sentido[i]="B";
                }
            }
            }while(!(sentido[i].equals("I")) && !(sentido[i].equals("D")) && !(sentido[i].equals("A")) && !(sentido[i].equals("B")) );
         }
    
     // Definir las fuerzas netas
        for (int i = 0; i < fuerzas.length - 1; i += 2) {
            if ((direccion[i].equals("H") && sentido[i].equals("I")) && (direccion[i + 1].equals("H") && sentido[i + 1].equals("D"))) {
                if (fuerzas[i] > fuerzas[i + 1]) {
                    fuerzaHorizontalNetaIzquierda += fuerzas[i] - fuerzas[i + 1];
                } else if (fuerzas[i] < fuerzas[i + 1]) {
                    fuerzaHorizontalNetaDerecha += fuerzas[i + 1] - fuerzas[i];

                } else {
                    fuerzaHorizontalNeta = 0;
                }
            } else if ((direccion[i].equals("H") && sentido[i].equals("I")) && (direccion[i + 1].equals("H") && sentido[i + 1].equals("I"))) {
                fuerzaHorizontalNetaIzquierda += fuerzas[i] + fuerzas[i + 1];
            } else if ((direccion[i].equals("H") && sentido[i].equals("D")) && (direccion[i + 1].equals("H") && sentido[i + 1].equals("D"))) {
                fuerzaHorizontalNetaDerecha += fuerzas[i] + fuerzas[i + 1];
            } else if ((direccion[i].equals("H") && sentido[i].equals("D")) && (direccion[i + 1].equals("H") && sentido[i + 1].equals("I"))) {
	                if (fuerzas[i] > fuerzas[i + 1]) {
	                    fuerzaHorizontalNetaDerecha += fuerzas[i] - fuerzas[i + 1];
	                } else if (fuerzas[i] < fuerzas[i + 1]) {
	                    fuerzaHorizontalNetaIzquierda += fuerzas[i + 1] - fuerzas[i];
	                }
             } else {
               fuerzaHorizontalNeta = 0;
                }
            
        
        
            if ((direccion[i].equals("V") && sentido[i].equals("A")) && (direccion[i + 1].equals("V") && sentido[i + 1].equals("B"))) {
                if (fuerzas[i] > fuerzas[i + 1]) {
                    fuerzaVerticalNetaIzquierda += fuerzas[i] - fuerzas[i + 1];
                } else if (fuerzas[i] < fuerzas[i + 1]) {
                    fuerzaVerticalNetaDerecha += fuerzas[i + 1] - fuerzas[i];

                } else {
                    fuerzaHorizontalNeta = 0;
                }
            } else if ((direccion[i].equals("V") && sentido[i].equals("A")) && (direccion[i + 1].equals("V") && sentido[i + 1].equals("A"))) {
                fuerzaHorizontalNetaIzquierda += fuerzas[i] + fuerzas[i + 1];
            } else if ((direccion[i].equals("V") && sentido[i].equals("B")) && (direccion[i + 1].equals("V") && sentido[i + 1].equals("A"))) {
                fuerzaHorizontalNetaDerecha += fuerzas[i] + fuerzas[i + 1];
            } else if ((direccion[i].equals("V") && sentido[i].equals("B")) && (direccion[i + 1].equals("H") && sentido[i + 1].equals("A"))) {
	                if (fuerzas[i] > fuerzas[i + 1]) {
	                    fuerzaHorizontalNetaDerecha += fuerzas[i] - fuerzas[i + 1];
	                } else if (fuerzas[i] < fuerzas[i + 1]) {
	                    fuerzaHorizontalNetaIzquierda += fuerzas[i + 1] - fuerzas[i];
	                }
             } else {
               fuerzaHorizontalNeta = 0;
                }
            if (cantidadFuerzas%2!=0) {
            	if (direccion[cantidadFuerzas-1].equals("H") && sentido[cantidadFuerzas-1].equals("I")) {
            		fuerzaHorizontalNetaIzquierda+=fuerzas[cantidadFuerzas-1];
            	}else if (direccion[cantidadFuerzas-1].equals("H") && sentido[cantidadFuerzas-1].equals("D")) {
            		fuerzaHorizontalNetaDerecha+=fuerzas[cantidadFuerzas-1];
            	}else if (direccion[cantidadFuerzas-1].equals("V") && sentido[cantidadFuerzas-1].equals("A")) {
            		fuerzaVerticalNetaIzquierda+=fuerzas[cantidadFuerzas-1];
            	}else if (direccion[cantidadFuerzas-1].equals("V") && sentido[cantidadFuerzas-1].equals("B")) {
            		fuerzaVerticalNetaDerecha+=fuerzas[cantidadFuerzas-1];
            	}
            }
        }
        //Fuerzas Netas Definitiva
        if (fuerzaVerticalNetaIzquierda > fuerzaVerticalNetaDerecha) {
        	 fuerzaVerticalNeta=fuerzaVerticalNetaIzquierda - fuerzaVerticalNetaDerecha;
        	 fnvs="I";
        }else if (fuerzaVerticalNetaIzquierda < fuerzaVerticalNetaDerecha) {
       	 fuerzaVerticalNeta=fuerzaVerticalNetaDerecha - fuerzaVerticalNetaIzquierda;
       	 fnvs="D";
       }else if (fuerzaVerticalNetaIzquierda == fuerzaVerticalNetaDerecha) {
      	 fuerzaVerticalNeta=fuerzaVerticalNetaIzquierda + fuerzaVerticalNetaDerecha;
      	 fnvs="N";
      }
        
        if (fuerzaHorizontalNetaIzquierda > fuerzaHorizontalNetaDerecha) {
       	 fuerzaHorizontalNeta=fuerzaHorizontalNetaIzquierda - fuerzaHorizontalNetaDerecha;
       	 fnhs="I";
       }else if (fuerzaHorizontalNetaIzquierda < fuerzaHorizontalNetaDerecha) {
      	 fuerzaHorizontalNeta=fuerzaHorizontalNetaDerecha - fuerzaHorizontalNetaIzquierda;
      	 fnhs="D";
      }else if (fuerzaHorizontalNetaIzquierda == fuerzaHorizontalNetaDerecha) {
     	 fuerzaHorizontalNeta=fuerzaHorizontalNetaIzquierda + fuerzaHorizontalNetaDerecha;
     	 fnhs="N";
     }
       
        //Velocidad
        System.out.println("Ingrese el módulo de la velocidad");
    	velocidad=sc.nextInt();
    	if (velocidad!=0) {
	        do{
	        	
	        	
	            System.out.println("¿Cuál es la dirección de la velocidad de movimiento del objeto? (H= Horizontal),(V= Vertical)");
	            direccionv = sc.next(); 
	            if (direccionv.equals("h")){
	                direccionv="H";
	            }else if (direccionv.equals("v")){
	                direccionv="V";
	            }
	            do {
	            if (direccionv.equals("H")) {
		            System.out.println("Ingrese el sentido de la fuerza (I= Izquierda), (D= Derecha)");
		            sentidov= sc.next();
	                if (sentidov.equals("i")){
	                    sentidov="I";
	                }else if (sentidov.equals("d")){
	                    sentidov="D";
	                }
	            }else {
	                System.out.println("Ingrese el sentido de la fuerza (A= Arriba), (B= Abajo)");
		            sentidov= sc.next();
	                if (sentidov.equals("a")){
	                    sentidov="A";
	                }else if (sentidov.equals("b")){
	                    sentidov="B";
	                }
	            }
	            
	            }while (!(sentidov.equals("I")) && !(sentidov.equals("D")) && !(sentidov.equals("A")) && !(sentidov.equals("B")));
	        }while (!direccionv.equals("H") && !direccionv.equals("V"));
    	}
    
        if (velocidad==0) {
        	velocidad_resultado="La velocidad es constante";
        }else if ((velocidad!=0 && sentidov.equals(fnhs) && direccionv.equals("H")) || (velocidad!=0 && sentidov.equals(fnvs) && direccionv.equals("V"))) {
        	velocidad_resultado="La velocidad aumenta";
        }else if ((fuerzaHorizontalNeta!=0 && velocidad!=0 && !sentidov.equals(fnhs) && direccionv.equals("H")) ||(fuerzaHorizontalNeta!=0 && velocidad!=0 && !sentidov.equals(fnvs) && direccionv.equals("V"))) {
        	velocidad_resultado="La velocidad disminuye";
        	}
        
        // Mostrar resultados
        System.out.println();
        //System.out.println("La fuerza neta Horizontal es de "+fuerzaHorizontalNeta);
        //System.out.println("La fuerza neta Vertical es de "+ fuerzaVerticalNeta);
        System.out.println(velocidad_resultado);
      
        sc.close();
        
}
}


    
