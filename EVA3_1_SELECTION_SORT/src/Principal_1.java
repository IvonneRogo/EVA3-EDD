
import java.util.Scanner;

/**
 *
 * @author 15060769
 */
public class Principal_1 {

    /**
     * @param args the command line arguments
     */
    static int iCont = 0;

    public static void main(String[] args) {
        Scanner SOp=new Scanner(System.in);
        int[] iArreglo = new int[100];
        //imprimirArreglo(iArreglo);
        for (int i = 0; i < iArreglo.length; i++) {
            iArreglo[i] = (int) (Math.random() * 100);
        }
        System.out.println("Elige el metodo para ordenar\n1.-SelectionSort\n2.-InsertionSort\n3.-QuickSort\n4.-BubbleSort");
        int op=SOp.nextInt();
        
        switch(op){
            case 1:
                System.out.println("SelectionSort");
                selectionSort(iArreglo);
                imprimirArreglo(iArreglo);
                break;
            case 2:
                System.out.println("InsertionSort");
                insertionSort(iArreglo);
                imprimirArreglo(iArreglo);
                break;
            case 3:
                System.out.println("QuickSort");
                quickSort(iArreglo, 0, iArreglo.length-1);
                imprimirArreglo(iArreglo);
                break;
            case 4:
                System.out.println("BubbleSort");
                bubbleSort(iArreglo);
                imprimirArreglo(iArreglo);
                break;
            default:
                System.out.println("Opcion incorrecta.");
        }
        
        /*imprimirArreglo(iArreglo);
        long in = System.nanoTime();
        quickSort(iArreglo, 0, iArreglo.length - 1);
        long fi = System.nanoTime();
        long to = fi - in;
        System.out.println(to);
        imprimirArreglo(iArreglo);*/

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el valor a buscar");
        int iVal = sc.nextInt();
        int iBin = binarySearch(iArreglo, iVal);
        int iLin = linealSearch(iArreglo, iVal);
        System.out.println("El valor " + iVal + " se encuentra en la posicion " + (iBin));
        System.out.println("El valor " + iVal + " se encuentra en la posicion " + (iLin));
        //System.out.println(iCont);
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

    /*  B   U   S   C   A   R   */
    //PARA INICIAR
    public static int binarySearch(int arreglo[], int iValBus) {
        return binSearch(arreglo, iValBus, 0, arreglo.length - 1);
    }

    public static int binSearch(int arreglo[], int iValBus, int iLo, int iHi) {
        iCont++;
        int iPos = -1;
        int iMid = iLo + ((iHi - iLo) / 2);
        if (iLo <= iHi) {
            if (iValBus == arreglo[iMid]) {
                iPos = iMid;
            } else if (iValBus > arreglo[iMid]) {
                iPos = binSearch(arreglo, iValBus, iMid + 1, iHi);
            } else if (iValBus < arreglo[iMid]) {
                iPos = binSearch(arreglo, iValBus, iLo, iMid - 1);
            }
        }
        return iPos;
    }

    public static int linealSearch(int arre[], int iValor) {
        //int i = 0;
        int pos = 0;
        for (int j = 0; j < arre.length; j++) {
            if (arre[j] == iValor) {
                pos = j;
                break;
            }
        }
        return pos;
    }

}
