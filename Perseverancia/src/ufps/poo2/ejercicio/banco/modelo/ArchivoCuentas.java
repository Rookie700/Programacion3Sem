/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufps.poo2.ejercicio.banco.modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ing
 */
public class ArchivoCuentas {

    public static void actualizarSaldo(String archivo, String numeroCuenta, double nuevoSaldo) {
        List<String> lineas = new ArrayList<>();
        boolean encontrado = false;

        // Se abre el archivo para leer
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            // Se lee el contenido de la línea
            while ((linea = br.readLine()) != null) {
                // Se divide la linea en sus partes: numerocuenta | saldo | tipocuenta
                String[] partes = linea.split(";");

                // Saco el número de la cuenta para poder actualizar el saldo
                String numCuenta = partes[0];

                if (numCuenta.equals(numeroCuenta)) {

                    // Se asigna el saldo en la posicion correspondiente del arreglo
                    partes[1] = String.valueOf(nuevoSaldo);
                    // En caso de que el valor lleve decimales muchos decimales, 
                    // el valor se puede formatear a String con solo dos decimales.
                    // partes[1] = String.format("%.2f", nuevoSaldo);

                    // Se usa la función String.join para unir las partes de un arreglo
                    // y separarlas con el caracter indicado.
                    linea = String.join(";", partes);

                    /*
                        Otra forma de hacerlo hubiera sido:
                        linea = partes[0]+";"+partes[1]+";"+partes[2];
                        Pero, si eventualmente el arreglo de String se crece, tocaría
                        hacer la adición de forma manual. En cambio la función join
                        se encarga de eso automáticamente.
                     */
                    encontrado = true;
                }
                // Se van consolidando las lineas en un ArrayList.
                // Esto se hace para luego escribirlas en un archivo.
                lineas.add(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        if (!encontrado) {
            System.out.println("Número de cuenta no encontrado.");
            return;
        }

        //  Escribir de nuevo el archivo con las modificaciones
        /*  Importante: Se reescribe todo el archivo usando new FileWriter(archivo), 
            que borra el contenido original antes de escribir la nueva versión.
            Si se quisiera agregar contenido al final del archivo, se tendría que usar
            el constructor FileWriter(archivo, boolean append).
            Esto será útil para cuando se creen nuevas cuentas.
         */
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (String linea : lineas) {
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }
    }

    public static void add(String archivo, Account dto) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true))) {
            String linea = dto.getAccountNumber() + ";" + dto.getBalance();
            bw.write(linea);
            bw.newLine();

        } catch (IOException e) {
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }
    }

    public static boolean Contains(String numeroCuenta) {
        List<String> lineas = new ArrayList<>();
        String archivoCorriente = "C:\\Users\\igork\\OneDrive\\Escritorio\\Perseverancia\\HerenciaBancoBase\\src\\ufps\\poo2\\ejercicio\\banco\\textoPlano\\currentAccounts.txt";
        String archivoAhorros = "C:\\Users\\igork\\OneDrive\\Escritorio\\Perseverancia\\HerenciaBancoBase\\src\\ufps\\poo2\\ejercicio\\banco\\textoPlano\\savingAccounts.txt";

        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(archivoAhorros))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");

                String numCuenta = partes[0];

                if (numCuenta.equals(numeroCuenta)) {
                    encontrado = true;
                }
                lineas.add(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        try (BufferedReader br = new BufferedReader(new FileReader(archivoCorriente))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");

                String numCuenta = partes[0];

                if (numCuenta.equals(numeroCuenta)) {
                    encontrado = true;
                }
                lineas.add(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return encontrado;
    }

    public static ArrayList<Account> listar(String archivo, char tipo) {
        ArrayList<Account> lista = new ArrayList();
        ArrayList<String> lineas = new ArrayList<>();

        // Se abre el archivo para leer
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            // Se lee el contenido de la línea
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");

                String numCuenta = partes[0];
                String balance = partes[1];
                if (tipo == 'A') {
                    lista.add(new SavingAccount(Integer.parseInt(numCuenta), 0.0, Double.parseDouble(balance)));
                } else {
                    lista.add(new CurrentAccount(Integer.parseInt(numCuenta), 0.0, Double.parseDouble(balance)));
                }

                lineas.add(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        return lista;
    }
}
