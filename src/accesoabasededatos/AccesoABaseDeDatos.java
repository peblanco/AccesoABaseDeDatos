/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoabasededatos;

import java.text.ParseException;
import java.time.LocalDate;

/**
 *
 * @author alejo
 */
public class AccesoABaseDeDatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {  
        Conexion conexion;
        try {
            conexion = new Conexion("jdbc:mysql://localhost/prueba", "root", "");
            AlumnoData alumnoData = new AlumnoData(conexion);                      
            Alumno alumno1 = new Alumno("Diaz, Ramon", LocalDate.of(2003, 2, 15));
            alumnoData.guardarAlumno(alumno1);
            System.out.println("El id del alumno es: " + alumno1.getId());

            alumnoData.obtenerAlumnos().forEach(alumno -> {
                System.out.println("Nombre: " + alumno.getNombre() );
            });
            
            
        } catch (Exception e) {
            System.out.println("Error al instanciar la clase conexion: " + e.getMessage());
        }
   
        
    }
    
}
