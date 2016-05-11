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
    private String contextura;
    private int peso;
    private String comentario;

    public Extraviado() {
    }

    public Extraviado(String identificador, String nombre, String apellido, int colorPiel, int colorPelo, int colorOjos, double estatura, String contextura, int peso, String comentario) {
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

    public String getContextura() {
        return contextura;
    }

    public void setContextura(String contextura) {
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
    
    
//    public void ingresarExtraviado(String idpersona, String idextraviado, String nombre, String apellido, int colorcabello, int colorpiel, int colorojo, Double medicion, int contextura, int peso, String comentario) {
//        ExtraviadoVO extraviadovo = new ExtraviadoVO();
//        ExtraviadoDAO extraviadodao = new ExtraviadoDAO();
//        extraviadovo.setId_persona(idpersona);
//        extraviadovo.setIdentificacion_ex(idextraviado);
//        extraviadovo.setNombre_ex(nombre);
//        extraviadovo.setApellido_ex(apellido);
//        extraviadovo.setCabello_ex(colorcabello);
//        extraviadovo.setPiel_ex(colorpiel);
//        extraviadovo.setOjos_ex(colorojo);
//        extraviadovo.setMedicion_ex(medicion);
//        extraviadovo.setContextura_ex(contextura);
//        extraviadovo.setPeso_ex(peso);
//        extraviadovo.setComentario_ex(comentario);
//        extraviadodao.insertarExtraviado(extraviadovo);
//    }
//    
//    public void actualizarExtraviado(int idextraviado, String identificacion, String nombre, String apellido, int colorcabello, int colorpiel, int colorojo, Double medicion, int contextura, int peso, String comentario){
//        ExtraviadoVO extraviadovo = new ExtraviadoVO();
//        ExtraviadoDAO extraviadodao = new ExtraviadoDAO();
//        extraviadovo.setIdentificacion_ex(identificacion);
//        extraviadovo.setNombre_ex(nombre);
//        extraviadovo.setApellido_ex(apellido);
//        extraviadovo.setCabello_ex(colorcabello);
//        extraviadovo.setPiel_ex(colorpiel);
//        extraviadovo.setOjos_ex(colorojo);
//        extraviadovo.setMedicion_ex(medicion);
//        extraviadovo.setContextura_ex(contextura);
//        extraviadovo.setPeso_ex(peso);
//        extraviadovo.setComentario_ex(comentario);
//        extraviadovo.setId_extraviado(idextraviado);
//        extraviadodao.editarExtraviado(extraviadovo);
//    }
}