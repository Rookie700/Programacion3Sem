/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demobanco;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ing
 */
public class Banco {
    
    public ArrayList<Cliente> clientes;

    public Banco() {
        clientes = new ArrayList<>();
    }
    
    public void cargarCuentasArchivo(){
        Scanner fileIn = null;
        
        try {
            fileIn = new Scanner(new FileReader("src/origen.txt"));
            while (fileIn.hasNextLine()) {
                String oneLine = fileIn.nextLine();
                System.out.println(oneLine);
                clientes.add(convertirAObjeto(oneLine));
            }            
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            // Close the stream
            if (fileIn != null) {
                fileIn.close();
            }            
        }
    }
    
    private Cliente convertirAObjeto(String linea){
        if(linea!=null && !linea.isBlank()){
            String[] cuenta = linea.split(";");
            // cuenta[0] = 1
            // cuenta[1] = boris
            // cuenta[2] = 88000000
            // cuenta[3] = boris...@correo.com
            
            String id = cuenta[0];
            String nombre = cuenta[1];
            String correo = cuenta[3];
            // Ojo, acá se puede saltar una excepción.
            double saldo = Double.parseDouble(cuenta[2]);
            
            Cliente c = new Cliente();
            c.setId(id);
            c.setNombre(nombre);
            c.setCorreo(correo);
            c.setSaldo(saldo);
            
            return c;
        }
        return null;
    }
    
    public void printNames(){
        for(Cliente c : clientes){
            System.out.println(c.getNombre());
        }
    }
    
}
