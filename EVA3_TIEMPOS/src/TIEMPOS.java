
/**
 *
 * @author 15060769
 */
public class TIEMPOS {

    /**
     * @param args the command line arguments
     */
    static int iCont = 0;

    public static void main(String[] args) {
        
         /*int[] valores = {10, 50, 100, 500, 1000, 5000};// 10000, 100000, 1000000};
        //int a = 10, b = 50, c = 100, d = 500, e = 1000, f = 5000, g = 10000, h = 100000, p = 1000000;

        System.out.println(valores[0] + " " + valores[1]);
        for (int j = 0; j < valores.length; j++) {
            int[] iArre1 = new int[j];
            int[] iArre2 = new int[j];
            int[] iArre3 = new int[j];
            int[] iArre4 = new int[j];
            
            if(valores[j]<100){
                valores[j]=100;
            }

            System.out.println("SELECTION DE " + valores[j] + " Datos");
            for (int i = 0; i < 10; i++) {
                llenarArreglos(iArre1, valores[j]);
                long ini = System.nanoTime();
                selectionSort(iArre1);
                long fin = System.nanoTime();
                long total = fin - ini;
                System.out.println(total);
            }
            System.out.println("\nINSERTION DE " + valores[j] + " Datos");
            for (int i = 0; i < 10; i++) {
                llenarArreglos(iArre2, valores[j]);
                long ini = System.nanoTime();
                insertionSort(iArre2);
                long fin = System.nanoTime();
                long total = fin - ini;
                System.out.println(total);
            }
            System.out.println("\nBUBBLE DE " + valores[j] + " Datos");
            for (int i = 0; i < 10; i++) {
                llenarArreglos(iArre3, valores[j]);
                long ini = System.nanoTime();
                bubbleSort(iArre3);
                long fin = System.nanoTime();
                long total = fin - ini;
                System.out.println(total);
            }

            System.out.println("\nQUICK DE " + valores[j] + " Datos");
            for (int i = 0; i < 10; i++) {
                llenarArreglos(iArre4, valores[j]);
                long ini = System.nanoTime();
                quickSort(iArre4, 0, iArre4.length - 1);
                long fin = System.nanoTime();
                long total = fin - ini;
                System.out.println(total);
            }

        }

    }

    public static void llenarArreglos(int[] arre, int limite) {
        for (int i = 0; i < arre.length; i++) {
            arre[i] = (int) (Math.random() * limite);
        }
    }*/
         

        int a = 10, b = 50, c = 100, d = 500, e = 1000, f = 5000, g = 10000, h = 100000, p = 1000000;

        int[] iArre1 = new int[a];
        int[] iArre2 = new int[a];
        int[] iArre3 = new int[a];
        int[] iArre4 = new int[a];

        System.out.println("SELECTION");
        for (int i = 0; i < 10; i++) {
            llenarArreglos(iArre1);
            long ini = System.nanoTime();
            selectionSort(iArre1);
            long fin = System.nanoTime();
            long total = fin - ini;
            System.out.println(total);
        }
        System.out.println("\nINSERTION");
        for (int i = 0; i < 10; i++) {
            llenarArreglos(iArre2);
            long ini = System.nanoTime();
            insertionSort(iArre2);
            long fin = System.nanoTime();
            long total = fin - ini;
            System.out.println(total);
        }
        System.out.println("\nBUBBLE");
        for (int i = 0; i < 10; i++) {
            llenarArreglos(iArre3);
            long ini = System.nanoTime();
            bubbleSort(iArre3);
            long fin = System.nanoTime();
            long total = fin - ini;
            System.out.println(total);
        }

        System.out.println("\nQUICK");
        for (int i = 0; i < 10; i++) {
            llenarArreglos(iArre4);
            long ini = System.nanoTime();
            quickSort(iArre4, 0, iArre4.length - 1);
            long fin = System.nanoTime();
            long total = fin - ini;
            System.out.println(total);
        }

    }

    public static void llenarArreglos(int[] arre) {
        for (int i = 0; i < arre.length; i++) {
            arre[i] = (int) (Math.random() * 100);
        }
    }

    public static void imprimirArreglo(int[] iArre) {//RECIBIMOS UN ARREGLO ENTERO
        for (int j : iArre) {//for (int i = 0; i < iArreglo.length; i++)
            System.out.print("[" + j + "]");
        }
        System.out.println("");
    }

    /* M   E   T   O   D   O   S       D   E       O   R   D   E   N   A   M   I   E   N   T   O*/
    //SELECTION SORT
    public static void selectionSort(int[] iArre) {
        //int iMin ;
        for (int i = 0; i < iArre.length; i++) {
            int iMin = i;//PRIMER ELEMENTO PEQUEÑO
            for (int j = i + 1; j < iArre.length; j++) {
                if (iArre[j] < iArre[iMin]) {
                    iMin = j;
                }
            }
            int a = iArre[i];
            iArre[i] = iArre[iMin];
            iArre[iMin] = a;
        }
    }

    //INSERTION SORT
    public static void insertionSort(int[] iArre) {
        for (int i = 0; i < iArre.length; i++) {
            int j = i;
            while (j > 0 && iArre[j] < iArre[j - 1]) {
                int iAux = iArre[j];
                iArre[j] = iArre[j - 1];
                iArre[j - 1] = iAux;
                j--;
            }
        }
    }

    //BUBBLE SORT
    public static void bubbleSort(int[] iArre) {
        int iAux;
        for (int i = 0; i < iArre.length; i++) {
            for (int j = i + 1; j < iArre.length; j++) {
                if (iArre[j] < iArre[i]) {
                    iAux = iArre[i];
                    iArre[i] = iArre[j];
                    iArre[j] = iAux;
                }
            }
        }
    }

    //DIVIDE E INTERCAMBIA
    public static int divide(int[] arre, int ini, int fin) {
        //int izq,der,pivote, temp;
        int temp;
        int pivote = arre[ini];
        int izq = ini;
        int der = fin;

        /*imprimirArreglo(arre);
        System.out.println("izq= " + izq + "\tder= " + der);*/

        //MIENTRAS NO SE CRUCEN izq Y der
        while (izq < der) {
            while (arre[der] > pivote) {
                der--;
            }
            while ((izq < der) && (arre[izq] <= pivote)) {
                izq++;
            }

            //SI TODAVIA NO SE CRUZAN LOS izq Y der
            if (izq < der) {
                temp = arre[izq];
                arre[izq] = arre[der];
                arre[der] = temp;
            }
        }

        //izq Y der SE CRUZAN, SE PONE EL PIVOTE EN EL LUGAR QUE LE TOCA
        temp = arre[der];
        arre[der] = arre[ini];
        arre[ini] = temp;

        //NUEVA POSICION DEL PIVOTE
        return der;
    }

    //RECURSIVIDAD EN EL QUICK SORT
    public static void quickSort(int[] arre, int ini, int fin) {
        int pivote;
        if (ini < fin) {
            pivote = divide(arre, ini, fin);
            //MENOR
            quickSort(arre, ini, pivote - 1);
            //MAYOR
            quickSort(arre, pivote + 1, fin);
        }
    }
}
