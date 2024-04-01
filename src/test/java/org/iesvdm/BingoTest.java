package org.iesvdm;

import org.junit.jupiter.api.Test;

public class BingoTest {
    @Test
    void rellenarNumerosCarton(){
    int[] col0 = new int[3];
    int[] col1 = new int[3];
    int[] col2 = new int[3];
    int[] col3 = new int[3];
    int[] col4 = new int[3];
    int[] col5 = new int[3];
    int[] col6 = new int[3];
    int[] col7 = new int[3];
    int[] col8 = new int[3];
    int[][] c = {col0, col1, col2, col3, col4, col5, col6, col7, col8};
        Bingo.rellenarNumerosCarton(c);
    boolean repetido = false;
        for(int i = 0;i<c.length;i++) {
            // Recorro las 3 posiciones de cada columna
            int anterior = c[i][0];
            for (int j = 1; j < c[0].length; j++) {
                if (c[i][j] == anterior) {
                    repetido = true;

                }

            }

        }
    }

    }

