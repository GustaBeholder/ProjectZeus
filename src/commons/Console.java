/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commons;

import java.sql.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Aluno
 */
public class Console{
    private static Scanner scanner = new Scanner(System.in);


    public static boolean verificaString(String palavra){
        if(palavra.isEmpty() || palavra.isBlank())
            return true;
        else
            return false;
    }

    public static Date pedirData(){
        String dataStr = Console.leLinhaTexto();

        String temp = dataStr;
        dataStr = temp.substring(6,10) + "-" + temp.substring(3,5) + "-" + temp.substring(0,2);

        Date date=Date.valueOf(dataStr);

        return date;
    }
    
    public static Date toSQLDate(String data){
        String temp = data;
        data = temp.substring(6,10) + "-" + temp.substring(3,5) + "-" + temp.substring(0,2);

        Date date=Date.valueOf(data);

        return date;
    }

    public static Integer leNumeroInteiro() {
        while (true) {
            try {
                Integer valorLido = scanner.nextInt();
                scanner.nextLine();
                return valorLido;
            } catch (Exception var2) {
                escreve("Valor inteiro inválido");
                scanner.nextLine();
            }
        }
    }

    public static Double leNumeroDouble() {
        while (true) {
            try {
                Double valorLido = scanner.nextDouble();
                scanner.nextLine();
                return valorLido;
            } catch (Exception var2) {
                escreve("Valor double inválido");
                scanner.nextLine();
            }
        }
    }

    public static Float leNumeroFloat() {
        while (true) {
            try {
                Float valorLido = scanner.nextFloat();
                scanner.nextLine();
                return valorLido;
            } catch (Exception var2) {
                escreve("Valor Float inválido");
                scanner.nextLine();
            }
        }
    }

    public static String leLinhaTexto() {
        return scanner.nextLine().toUpperCase(Locale.ROOT);
    }

    public static void escreve(String textoASerEscrito) {
        System.out.println(textoASerEscrito);
    }

}