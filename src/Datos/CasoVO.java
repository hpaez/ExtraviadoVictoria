package Datos;

import java.util.Date;

/**
 *
 * @author erik
 */
public class CasoVO {
    private int IDCASO;
    private String IDEXTRAVIADO;
    private String IDPERSONA;
    private String ESTADOCASO;
    private Date FECHACASO;

    public CasoVO() {
    }

    public CasoVO(int IDCASO, String IDEXTRAVIADO, String IDPERSONA, String ESTADOCASO, Date FECHACASO) {
        this.IDCASO = IDCASO;
        this.IDEXTRAVIADO = IDEXTRAVIADO;
        this.IDPERSONA = IDPERSONA;
        this.ESTADOCASO = ESTADOCASO;
        this.FECHACASO = FECHACASO;
    }

    public int getIDCASO() {
        return IDCASO;
    }

    public void setIDCASO(int IDCASO) {
        this.IDCASO = IDCASO;
    }

    public String getIDEXTRAVIADO() {
        return IDEXTRAVIADO;
    }

    public void setIDEXTRAVIADO(String IDEXTRAVIADO) {
        this.IDEXTRAVIADO = IDEXTRAVIADO;
    }

    public String getIDPERSONA() {
        return IDPERSONA;
    }

    public void setIDPERSONA(String IDPERSONA) {
        this.IDPERSONA = IDPERSONA;
    }

    public String getESTADOCASO() {
        return ESTADOCASO;
    }

    public void setESTADOCASO(String ESTADOCASO) {
        this.ESTADOCASO = ESTADOCASO;
    }

    public Date getFECHACASO() {
        return FECHACASO;
    }

    public void setFECHACASO(Date FECHACASO) {
        this.FECHACASO = FECHACASO;
    }
    
    
}
