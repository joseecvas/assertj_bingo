package org.iesvdm;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Array;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class BingoTest {
    @Test
    void rellenarNumerosCarton() {
        //when
        int[] col0 = new int[3];
        int[] col1 = new int[3];
        int[] col2 = new int[3];
        int[] col3 = new int[3];
        int[] col4 = new int[3];
        int[] col5 = new int[3];
        int[] col6 = new int[3];
        int[] col7 = new int[3];
        int[] col8 = new int[3];
        int[][] carton = {col0, col1, col2, col3, col4, col5, col6, col7, col8};
        //do
        Bingo.rellenarNumerosCarton ( carton );
        //then
        boolean repetido = false;
        for(int i = 0;i<carton.length;i++) {
            // Recorro las 3 posiciones de cada columna
            assertNotNull (carton[i]);
            int anterior = carton[i][0];
            for (int j = 1; j < carton[0].length; j++) {
                if (carton[i][j] == anterior) {
                    repetido = true;
                }
                anterior=carton[i][j];
                assertFalse ( repetido );
            }
        }
    }
    @Test
    void ponerBlancosTest(){
        int[] col0 = new int[3];
        int[] col1 = new int[3];
        int[] col2 = new int[3];
        int[] col3 = new int[3];
        int[] col4 = new int[3];
        int[] col5 = new int[3];
        int[] col6 = new int[3];
        int[] col7 = new int[3];
        int[] col8 = new int[3];
        int[][] carton = {col0, col1, col2, col3, col4, col5, col6, col7, col8};
        Bingo.rellenarNumerosCarton ( carton );
        Bingo.ponerBlancos ( carton );
        for(int columna = 0;columna<carton.length;columna++) {
            int columnaBlancos=0;
            // Recorro las 3 posiciones de cada columna
            for (int fila = 0; fila < carton[0].length; fila++) {
                if (carton[columna][fila] == -1) {
                    columnaBlancos++;
                    assertTrue ( columnaBlancos < 3 );
                }
            }
        }
        for(int fila=0;fila<carton[0].length;fila++)
        {
            int filaBlancos=0;
            //Recorro las 9 posiciones de cada fila
            for(int columna=0;columna<carton.length;columna++)
            {
                if (carton[columna][fila] == -1)
                {
                    filaBlancos++;
                   assertTrue ( filaBlancos<5 );
                }
            }
        }
    }
    @Test
    void buscaFilaTest(){
        int[] col0 = {-1, 1, 2};
        int[] col1 = {-1, 2, 3};
        int[] col2 = {-1, 5, 6};
        int[][]array = {col0, col1, col2};
        //No hay ningún -1 en la fila 1
        assertFalse (  Bingo.buscarFila (array, 1, 2));
        //Hay -1 en la fila 0
        assertTrue ( Bingo.buscarFila ( array, 0, 1 ));
    }
    @Test
    void buscarColumnaTest(){
        int[] col0 = {-1, 1, 2};
        int[] col1 = {-1, -1, 3};
        int[] col2 = {-1, 5, 6};
        int[][]array = {col0, col1, col2};
        //No hay dos -1 en la columna 0
        assertFalse (Bingo.buscarColumna(array, 0));
        //Hay dos -1 en la columna 1
        assertTrue ( Bingo.buscarColumna(array, 1));
    }
    @Test
        void buscarValorRepetidoTest(){
            int[]array={0, 1, 1};
            int[]array2={0, 1, 2};
            //En el primer array no está el 2
            assertFalse ( Bingo.buscarValorRepetido ( array, 2 ) );
            //En el segundo array está el 2
            assertTrue ( Bingo.buscarValorRepetido ( array2, 2 ) );
    }
    @Test
        void pintarCartonTest(){
        int[] col0 = {1, -1, -1};
        int[] col1 = {10, 15, 16};
        int[] col2 = {20, -1, 25};
        int[] col3 = {-1, 33, 39};
        int[] col4 = {-1, -1, 45};
        int[] col5 = {-1, 53, -1};
        int[] col6 = {-1, 62, -1};
        int[] col7 = {73, 75, -1};
        int[] col8 = {84, -1, 90};
        //Los números coinciden con los que hay en el cartón, por lo que
        //al pintar el cartón hay 15 aciertos.
        int[]bolasBingo={1, 10, 15, 16, 20, 21, 25, 33, 39, 45, 53, 62, 75, 73, 84, 90 };
        int[][] carton = {col0, col1, col2, col3, col4, col5, col6, col7, col8};
        assertTrue ( Bingo.pintarCarton ( carton, bolasBingo)==15 );
    }
    @Test
    void insertarAlFinalTest(){
        int[]array={0, 1, 2};
        int elemento=3;
        int[]ArrayNuevo=Bingo.insertarAlFinal ( array, 3 );
        assertTrue(ArrayNuevo[ArrayNuevo.length-1]==elemento);
        assertTrue(ArrayNuevo.length==array.length+1);
        assertArrayEquals(array, Arrays.copyOfRange(ArrayNuevo, 0, array.length));
    }
    @Test
    void ordenar(){
        int[]array={5, 4, 3, 2, 1, 0};
        int[]arrayOrdenado={0, 1, 2, 3, 4, 5};
        assertArrayEquals(arrayOrdenado, Arrays.copyOfRange(Bingo.ordenar ( array ), 0, array.length));
    }
}
