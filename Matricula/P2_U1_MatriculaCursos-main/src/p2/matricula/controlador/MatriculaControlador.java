/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p2.matricula.controlador;

import p2.matricula.modelo.Universidad;
import p2.matricula.vista.MatriculaVista;

/**
 *
 * @author Boris Perez
 */
public class MatriculaControlador {
    
    private MatriculaVista frame;
    private Universidad uni;

    public MatriculaControlador(MatriculaVista frame) {
        this.frame = frame;
        uni = new Universidad();
    }
    
    public void registrarEstudiante(){
        String cod = frame.getTxtCodigoEstudiante().getText();
        String nom = frame.getTxtNombreEstudiante().getText();
        String cor = frame.getTxtCorreoEstudiante().getText();
        String tel = frame.getTxtTelefonoEstudiante().getText();
        String prom = frame.getTxtPromedioEstudiante().getText();
        double promDouble = Double.parseDouble(prom);
        
        uni.agregarEstudiante();
        
    }
    
    public void cancelarEstudiante(){
        frame.getTxtCodigoEstudiante().setText("");
    }
    
    public void registrarCurso(){
        // Obtener atributos
        
        String programa = frame.getCmbProgramaAcad().getModel().getSelectedItem().toString();
        String codigo = frame.getTxtCodigoCurso().getText();
        String nombre = frame.getTxtNombreCurso().getText();
        
        // ...
        
        
    }
    
    public void mostrarCursosMatriculados(){
        // Obtener atributos
        
    }
    
    public void matricular(){
        // Obtener atributos
        
    }
    
}
