package Modelo;

/**
 *
 * @author DerFlow
 */
public class Extraviado {
    private String identificador;
    private String nombre;
    private String apellido;
    private int colorPiel;
    private int colorPelo;
    private int colorOjos;
    private double estatura;
    private int contextura;
    private int peso;
    private String comentario;
    
    public Extraviado() {
    }

    public Extraviado(String identificador, String nombre, String apellido, int colorPiel, int colorPelo, int colorOjos, double estatura, int contextura, int peso, String comentario) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.colorPiel = colorPiel;
        this.colorPelo = colorPelo;
        this.colorOjos = colorOjos;
        this.estatura = estatura;
        this.contextura = contextura;
        this.peso = peso;
        this.comentario = comentario;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getColorPiel() {
        return colorPiel;
    }

    public void setColorPiel(int colorPiel) {
        this.colorPiel = colorPiel;
    }

    public int getColorPelo() {
        return colorPelo;
    }

    public void setColorPelo(int colorPelo) {
        this.colorPelo = colorPelo;
    }

    public int getColorOjos() {
        return colorOjos;
    }

    public void setColorOjos(int colorOjos) {
        this.colorOjos = colorOjos;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public int getContextura() {
        return contextura;
    }

    public void setContextura(int contextura) {
        this.contextura = contextura;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}