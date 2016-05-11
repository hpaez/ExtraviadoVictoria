package Datos;

/**
 *
 * @author DerKow
 */
public class ExtraviadoVO {
    private int id_extraviado;
    private String id_persona;
    private String identificacion_ex;
    private String nombre_ex;
    private String apellido_ex;
    private int cabello_ex;
    private int piel_ex;
    private int ojos_ex;
    private Double medicion_ex;
    private int contextura_ex;
    private int peso_ex;
    private String comentario_ex;

    public ExtraviadoVO() {
    }

    public ExtraviadoVO(int id_extraviado, String id_persona, String identificacion_ex, String nombre_ex, String apellido_ex, int cabello_ex, int piel_ex, int ojos_ex, Double medicion_ex, int contextura_ex, int peso_ex, String comentario_ex) {
        this.id_extraviado = id_extraviado;
        this.id_persona = id_persona;
        this.identificacion_ex = identificacion_ex;
        this.nombre_ex = nombre_ex;
        this.apellido_ex = apellido_ex;
        this.cabello_ex = cabello_ex;
        this.piel_ex = piel_ex;
        this.ojos_ex = ojos_ex;
        this.medicion_ex = medicion_ex;
        this.contextura_ex = contextura_ex;
        this.peso_ex = peso_ex;
        this.comentario_ex = comentario_ex;
    }

    public int getId_extraviado() {
        return id_extraviado;
    }

    public void setId_extraviado(int id_extraviado) {
        this.id_extraviado = id_extraviado;
    }

    public String getId_persona() {
        return id_persona;
    }

    public void setId_persona(String id_persona) {
        this.id_persona = id_persona;
    }

    public String getIdentificacion_ex() {
        return identificacion_ex;
    }

    public void setIdentificacion_ex(String identificacion_ex) {
        this.identificacion_ex = identificacion_ex;
    }

    public String getNombre_ex() {
        return nombre_ex;
    }

    public void setNombre_ex(String nombre_ex) {
        this.nombre_ex = nombre_ex;
    }

    public String getApellido_ex() {
        return apellido_ex;
    }

    public void setApellido_ex(String apellido_ex) {
        this.apellido_ex = apellido_ex;
    }

    public int getCabello_ex() {
        return cabello_ex;
    }

    public void setCabello_ex(int cabello_ex) {
        this.cabello_ex = cabello_ex;
    }

    public int getPiel_ex() {
        return piel_ex;
    }

    public void setPiel_ex(int piel_ex) {
        this.piel_ex = piel_ex;
    }

    public int getOjos_ex() {
        return ojos_ex;
    }

    public void setOjos_ex(int ojos_ex) {
        this.ojos_ex = ojos_ex;
    }

    public Double getMedicion_ex() {
        return medicion_ex;
    }

    public void setMedicion_ex(Double medicion_ex) {
        this.medicion_ex = medicion_ex;
    }

    public int getContextura_ex() {
        return contextura_ex;
    }

    public void setContextura_ex(int contextura_ex) {
        this.contextura_ex = contextura_ex;
    }

    public int getPeso_ex() {
        return peso_ex;
    }

    public void setPeso_ex(int peso_ex) {
        this.peso_ex = peso_ex;
    }

    public String getComentario_ex() {
        return comentario_ex;
    }

    public void setComentario_ex(String comentario_ex) {
        this.comentario_ex = comentario_ex;
    }

    
}
