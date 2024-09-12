package alumnos;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class alumno {
    private String nombre;
    private String apaterno;
    private String amaterno;
    private String CURP;
    private String telefono;
    private String correo;
    private boolean discapacidad;
    private String sexo;
    private int edad;

    public alumno(String nombre,String apaterno,String amaterno,String CURP,String telefono,String correo,boolean discapacidad,String sexo)
    {
        this.nombre=nombre;
        this.apaterno=apaterno;
        this.amaterno=amaterno;
        this.CURP=CURP;
        this.telefono=telefono;
        this.correo=correo;
        this.discapacidad=discapacidad;
        this.sexo=sexo;
    }
    public String getNombre() {
        return nombre;
    }
    public String getAPaterno() {
        return apaterno;
    }
    public String getAMaterno() {
        return amaterno;
    }

    public String getCURP() {
        return CURP;
    }
    public String getTelefono() {
        return telefono;
    }
    public String getCorreo() {
        return correo;
    }
    public boolean isDiscapacidad() {
        return discapacidad;
    }
    public String getSexo() {
        return sexo;
    }
    public String getDiscapacidad(){
        if(discapacidad==true)
            return "Si";
        else
            return "No";
    }
    public int getEdad(){
        String fechaNacimiento = getCURP().substring(4, 10);
        String año = fechaNacimiento.substring(0, 2);
        String mes = fechaNacimiento.substring(2, 4);
        String dia = fechaNacimiento.substring(4, 6);
        int añoNacimiento = Integer.parseInt(año);

        if(añoNacimiento < 20){
            añoNacimiento += 2000;
        } else{
            añoNacimiento += 1900;
        }

        String fechaNacimi = añoNacimiento + "-" + mes + "-" + dia;
        LocalDate fechaNac = LocalDate.parse(fechaNacimi, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        LocalDate fechaActual = LocalDate.now();
        Period edad = Period.between(fechaNac, fechaActual);
        return edad.getYears();
    }
}
