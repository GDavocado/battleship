package CITIM21_01.Vista;

import java.util.Scanner;

public class Vista {
    protected Scanner scanner;
    protected Vista(Scanner scanner){
        this.scanner = scanner;
    }

    public void printSalida(String salida){
        System.out.println(salida);
    }
}
