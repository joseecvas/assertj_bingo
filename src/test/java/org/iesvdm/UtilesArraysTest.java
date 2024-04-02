package org.iesvdm;

import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.function.BooleanSupplier;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class UtilesArraysTest {
    @Test
    void limpiarTest() {
        assertThat ( UtilesArrays.limpiar () ).isNotNull ();
        assertThat ( UtilesArrays.limpiar () ).isEmpty ();
    }

    @Test
    void rellenarTest() {
        int[] tresCeros = UtilesArrays.rellenar ( new int[0], 3 );
        assertThat ( tresCeros ).contains ( 0, 0, 0 );
    }

    @Test
    void rellenarValorTest() {
        int[] tresCincos = UtilesArrays.rellenarValor ( new int[0], 3, 5 );
        assertThat ( tresCincos ).contains ( 5, 5, 5 );
    }

    @Test
    void insertarAlFinalTest() {
        int[] array = {0, 1, 2};
        int elemento = 3;
        int[] arrayNuevo = UtilesArrays.insertarAlFinal ( array, 3 );
        assertThat ( arrayNuevo ).contains ( 0, 1, 2, 3 );
    }

    @Test
    void insertarAlPrincipioTest() {
        int[] array = {0, 1, 2};
        int elemento = 3;
        int[] arrayNuevo = UtilesArrays.insertarAlPrincipio ( array, 3 );
        assertThat ( arrayNuevo ).contains ( 3, 0, 1, 2 );
    }

    @Test
    void insertarEnPosicionTest() {
        int[] array = {0, 1, 2, 4};
        int elemento = 3;
        int[] arrayNuevo = UtilesArrays.insertarEnPosicion ( array, 3, 3 );
        assertThat ( arrayNuevo ).contains ( 0, 1, 2, 3, 4 );
    }

    @Test
    void insertarEnPosicionNoEstaTest() {
        int[] array = {0, 1, 2, 4};
        int elemento = 3;
        int[] arrayNuevo = UtilesArrays.insertarEnPosicion ( array, 3, 5 );
        assertEquals ( Arrays.toString ( array ), Arrays.toString ( arrayNuevo ) );
    }

    @Test
    void eliminarUltimoTest() {
        int[] array = {0, 1, 2, 3, 4};
        int[] arrayNuevo = UtilesArrays.eliminarUltimo ( array );
        assertEquals ( Arrays.toString ( arrayNuevo ), Arrays.toString ( Arrays.copyOfRange ( array, 0, array.length - 1 ) ) );
    }

    @Test
    void eliminarPrimeroTest() {
        int[] array = {0, 1, 2, 3, 4};
        int[] arrayNuevo = UtilesArrays.eliminarPrimero ( array );
        assertEquals ( Arrays.toString ( arrayNuevo ), Arrays.toString ( Arrays.copyOfRange ( array, 1, array.length ) ) );
    }

    @Test
    void eliminarPosicionTest() {
        int[] array = {0, 1, 2, 3, 4};
        int[] arrayNuevo = UtilesArrays.eliminarPosicion ( array, 0 );
        assertEquals ( Arrays.toString ( arrayNuevo ), Arrays.toString ( Arrays.copyOfRange ( array, 1, array.length ) ) );
    }

    @Test
    void eliminarPosicionNoEstaTest() {
        int[] array = {0, 1, 2, 3, 4};
        int[] arrayNuevo = UtilesArrays.eliminarPosicion ( array, 6 );
        assertEquals ( Arrays.toString ( arrayNuevo ), Arrays.toString ( array ) );
    }

    @Test
    void eliminar() {
        int[] array = {0, 1, 2, 3, 4};
        int elemento = 4;
        int[] arrayNuevo = UtilesArrays.eliminar ( array, 4 );
        assertEquals ( Arrays.toString ( arrayNuevo ), Arrays.toString ( Arrays.copyOfRange ( array, 0, array.length - 1 ) ) );
    }

    @Test
    void eliminarElementoNoEstaTest() {
        int[] array = {0, 1, 2, 3, 4};
        int elemento = 4;
        int[] arrayNuevo = UtilesArrays.eliminar ( array, 5 );
        assertEquals ( Arrays.toString ( arrayNuevo ), Arrays.toString ( array ) );
    }

    @Test
    void ordenarTest() {
        int[] array = {0, 2, 4, 3, 1};
        int[] arrayNuevo = UtilesArrays.ordenar ( array );
        assertThat ( arrayNuevo ).isSorted ();
    }

    @Test
    void desordenarTest() {
        int[] array = {0, 1, 2, 3, 4};
        UtilesArrays.desordenar ( array );
        assertFalse ( UtilesArrays.estaOrdenado ( array ) );
    }

    @Test
    void invertirTest() {
        int[] array = {0, 1, 2, 3, 4};
        int[] arrayNuevo = UtilesArrays.invertir ( array );
        assertEquals ( Arrays.toString ( arrayNuevo ), Arrays.toString ( new int[]{4, 3, 2, 1, 0} ) );
    }@Test
    void estaOrdenadoTest(){
        int[] array = {0, 1, 2, 3, 4};
        assertTrue ( UtilesArrays.estaOrdenado ( array ) );
        UtilesArrays.desordenar ( array );
        assertFalse ( UtilesArrays.estaOrdenado ( array ) );
    }
    @Test
    void buscarTest(){
        int[] array = {0, 1, 2, 3, 4};
        assertThat (UtilesArrays.buscar ( array, 2 )).isSameAs ( 2 );
        assertThat (UtilesArrays.buscar ( array, 5 )).isSameAs ( -1 );
    }
    @Test
    void buscarNoEstaTest(){
        int[] array = {0, 1, 2, 3, 4};
        assertThat (UtilesArrays.buscar ( array, 5 )).isSameAs ( -1 );
    }
    @Test
    void partirPorTest(){
        int[] array = {0, 1, 2, 3, 4};
        int[] arrayNuevo = UtilesArrays.partirPor ( array, 1, 4 );
        assertEquals ( Arrays.toString ( arrayNuevo), Arrays.toString ( Arrays.copyOfRange ( array, 1, 4 ) ) );
    }
    @Test
    void sonIgualesTest(){
        //El Test falla porque el método "elementosIguales" usado en "sonIguales" lanza una excepción por desbordamiento.
        int[]arrayIgual1 = {0, 1, 2};
        int[]arrayIgual2 = Arrays.copyOf ( arrayIgual1, arrayIgual1.length);
        int[]diferente = {0, 1, 2};
        assertTrue ( UtilesArrays.sonIguales ( arrayIgual1, arrayIgual2 ));
        assertFalse ( UtilesArrays.sonIguales ( arrayIgual1, diferente ));
    }
    @Test
    void elementosIgualesTest(){
        int[]array1 = {0, 1, 2, 3, 4};
        int[]array2 = {0, 2, 4, 6, 8};
        assertTrue ( UtilesArrays.elementosIguales ( array1, array2, 0 ) );
    }
    @Test
    void concatenarArraysTest(){
        int[]array1 = {1, 2, 3};
        int[]array2 = {4, 5};
        int[]arrayNuevo = UtilesArrays.concatenarArrays ( array1, array2 );
        assertThat ( arrayNuevo ).containsExactly ( 1, 2, 3, 4, 5 );
    }
}
