package Controlador;

import Datos.CasoDAO;
import Datos.CasoVO;
import Modelo.Extraviado;
import Datos.ExtraviadoDAO;
import Datos.ExtraviadoVO;
import Datos.PersonaDAO;
import Datos.PersonaVO;
import Modelo.Caso;
import Modelo.Persona;

import Vista.S0_Principal;
import Vista.S1_IngresarExtraviado;
import Vista.S8_IngresarPersona;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CtrlIngExtraviado implements ActionListener,KeyListener {
    private S1_IngresarExtraviado vistaExtraviado;
    private S8_IngresarPersona vistaPersona;
    private Extraviado modeloExtraviado;
    private CtrlIngExtraviado control_ex;
    private Persona modeloPersona;
    
    PersonaDAO persona_dao = new PersonaDAO();
    ExtraviadoDAO extraviado_dao = new ExtraviadoDAO();
    
    CasoDAO caso_dao = new CasoDAO();
    
    java.util.Date fechaActual = new java.util.Date();
    java.sql.Date sqlDate = new java.sql.Date(fechaActual.getTime());
    
    public CtrlIngExtraviado(S1_IngresarExtraviado vistaExtraviado, Extraviado modeloIngreso,Persona modeloPersona) {
        this.modeloExtraviado   = modeloIngreso;
        this.vistaExtraviado    = vistaExtraviado;
        this.modeloPersona      = modeloPersona;
        
        this.vistaExtraviado.btn_ingresar.addActionListener(this);
        this.vistaExtraviado.btn_limpiar.addActionListener(this);
//        this.vistaExtraviado.btn_volver.addActionListener(this);
        
        // validadores
        this.vistaExtraviado.radio_rut.addActionListener(this);
        this.vistaExtraviado.radio_pasaporte.addActionListener(this);
        this.vistaExtraviado.radio_noAplica.addActionListener(this);
        
        this.vistaExtraviado.txt_nombre.addKeyListener(this);
        this.vistaExtraviado.txt_apellidos.addKeyListener(this);
        this.vistaExtraviado.txt_peso.addKeyListener(this);
        
    }
    CtrlIngPersona contra;
    public void iniciarExtraviado() {
        vistaExtraviado.setTitle("Ingresar Extraviado - Sistema de Búsqueda de Extraviado");
        vistaExtraviado.pack();
        vistaExtraviado.setLocationRelativeTo(null);
        vistaExtraviado.setVisible(true);
        vistaExtraviado.setResizable(false);
        vistaExtraviado.radio_noAplica.setSelected(true);
        habilitarExtraviado(false);
        
    }
    
    public void actionPerformed(ActionEvent e) {
        if(vistaExtraviado.btn_ingresar == e.getSource()) {
            try {
                if(vistaExtraviado.buttonGroup1.getSelection() != null &&
                        !vistaExtraviado.txt_nombre.getText().trim().equals("") &&
                        !vistaExtraviado.txt_apellidos.getText().trim().equals("") &&
                        vistaExtraviado.combo_cOjos.getSelectedIndex() != 0 &&
                        vistaExtraviado.combo_cPelo.getSelectedIndex() != 0 &&
                        vistaExtraviado.combo_cPiel.getSelectedIndex() != 0 &&
                        vistaExtraviado.combo_contextura.getSelectedIndex() != 0){
         
                    if(vistaExtraviado.radio_rut.isSelected()){
                        if(!vistaExtraviado.txt_radioOption.getText().trim().equals("")){
                            if(validarRut(vistaExtraviado.txt_radioOption.getText().trim())){
                                int p = JOptionPane.showConfirmDialog(null, "¿Desea guardar los datos del extraviado?", "Advertencia", JOptionPane.YES_NO_OPTION);
                                if (p == 0) {
                                    //**** RUT SELECCIONADO
                                    if (persona_dao.verificaPersona(modeloPersona.getRut())) {
                                        realizarIngreso(1, (ExtraviadoVO) creaObjectExtraviado(1),modeloPersona,persona_dao,(CasoVO)Caso_());                            
                                    }else{
                                        realizarIngreso(2, (ExtraviadoVO) creaObjectExtraviado(1),modeloPersona,persona_dao,(CasoVO)Caso_());                     
                                    }
                                    //paso a la principal
                                    aLaPrincipal();
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Debe ingresar el rut.","Advertencia",JOptionPane.WARNING_MESSAGE);
                                vistaExtraviado.txt_radioOption.requestFocus();
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "El rut ingresado no es valido.","Advertencia",JOptionPane.WARNING_MESSAGE);
                            vistaExtraviado.txt_radioOption.requestFocus();
                        }
                    } else if(vistaExtraviado.radio_pasaporte.isSelected()) {
                        if(!vistaExtraviado.txt_radioOption.getText().trim().equals("")){
                            int p = JOptionPane.showConfirmDialog(null, "¿Desea guardar los datos del extraviado?", "Advertencia", JOptionPane.YES_NO_OPTION);
                            if (p == 0) {
                            //*************PASAPORTE**********************************
                                if (persona_dao.verificaPersona(modeloPersona.getRut())) {
                                    realizarIngreso(1, (ExtraviadoVO) creaObjectExtraviado(2),modeloPersona,persona_dao,(CasoVO)Caso_());                             
                                }else{
                                    realizarIngreso(2, (ExtraviadoVO) creaObjectExtraviado(2),modeloPersona,persona_dao,(CasoVO)Caso_());                     
                                }
                                //paso a la principal
                                aLaPrincipal();
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Debe ingresar el pasaporte.","Advertencia",JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        int p = JOptionPane.showConfirmDialog(null, "¿Desea guardar los datos del extraviado?", "Advertencia", JOptionPane.YES_NO_OPTION);
                        if (p == 0) {
                            //*************************NO APLICA PASAPORTE O RUT
                            if (persona_dao.verificaPersona(modeloPersona.getRut())) {
                                realizarIngreso(1, (ExtraviadoVO) creaObjectExtraviado(3),modeloPersona,persona_dao,(CasoVO)Caso_());                             
                            }else{
                                realizarIngreso(2, (ExtraviadoVO) creaObjectExtraviado(3),modeloPersona,persona_dao,(CasoVO)Caso_());                       
                            }
                            //paso a la principal
                            aLaPrincipal();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Hay campos que no fueron ingresados.","Advertencia",JOptionPane.WARNING_MESSAGE);
                }
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } else if(vistaExtraviado.btn_limpiar == e.getSource()) {
            try {
                int p = JOptionPane.showConfirmDialog(null, "¿Desea limpiar todos los datos ingresado?", "Advertencia", JOptionPane.YES_NO_OPTION);
                if (p == 0) {
                    limpiarCampos();
                }
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
//        if (vistaExtraviado.btn_volver == e.getSource()) {
//            try {
//                int p = JOptionPane.showConfirmDialog(null, "¿Desea volver a la pantalla principal?", "Advertencia", JOptionPane.YES_NO_OPTION);
//                if (p == 0) {
//                    S8_IngresarPersona ing_persona = new S8_IngresarPersona();            
//                    CtrlIngPersona ctrlPrincipal = new CtrlIngPersona(ing_persona, modeloPersona){ };
//                    ctrlPrincipal.iniciarPersona();
//                    vistaExtraviado.dispose();
//                    vistaPersona.setVisible(false);
//                }
//                } catch(Exception ex) {
//                JOptionPane.showMessageDialog(null, ex);
//            }
//        }

        //**************VALIDADORES DE CAMPOS
        /*habilita campo de texto rut,pasaporte,aplica al momento de seleccionar uno,sino queda desabilitado*/
        if (vistaExtraviado.radio_rut.isSelected()) {
            habilitarExtraviado(true);
            vistaExtraviado.txt_radioOption.requestFocus();
            vistaExtraviado.txt_radioOption.setText("");
        }
        if (vistaExtraviado.radio_pasaporte.isSelected()) {
            habilitarExtraviado(true);
            vistaExtraviado.txt_radioOption.requestFocus();
            vistaExtraviado.txt_radioOption.setText("");
        }
        if (vistaExtraviado.radio_noAplica.isSelected()) {
            habilitarExtraviado(false);
            vistaExtraviado.txt_radioOption.setText("");
        }
    }

    public Object creaObjectExtraviado(int opcion){
            String id_="";
            //noaplica
            if (opcion==3) {
                id_ = "No aplica";
            }
            //rut
            if (opcion==1) {
                 id_ = formatear(vistaExtraviado.txt_radioOption.getText().trim());
            }
            //pasaporte
            if (opcion==2) {
                id_ = vistaExtraviado.txt_radioOption.getText().trim();
            }
            Extraviado extraviado = new Extraviado(id_
            , vistaExtraviado.txt_nombre.getText().trim()
            , vistaExtraviado.txt_apellidos.getText().trim()
            , vistaExtraviado.combo_cOjos.getSelectedIndex()
            , vistaExtraviado.combo_cPelo.getSelectedIndex()
            , vistaExtraviado.combo_cPiel.getSelectedIndex()
            , Double.parseDouble(vistaExtraviado.txt_altura.getText())
            , vistaExtraviado.combo_contextura.getSelectedIndex()
            , Integer.parseInt(vistaExtraviado.txt_peso.getText())
            , vistaExtraviado.textarea_comentario.getText().trim());
            //**************************************************************
            int id_x = 0;
        String idPers__ = modeloPersona.getRut();
        String idExtra_ = extraviado.getIdentificador();
        String nombre_ = extraviado.getNombre();
        String apellido_ = extraviado.getApellido();
        int cabello_ = extraviado.getColorPelo();
        int piel_ = extraviado.getColorPiel();
        int ojos_ = extraviado.getColorOjos();
        Double altura_ = extraviado.getEstatura();
        int contextura_ =  extraviado.getContextura();
        int peso_ = extraviado.getPeso();
        String comentario_ = extraviado.getComentario();
        ExtraviadoVO extraviado_vo = new ExtraviadoVO(id_x,idPers__,idExtra_,nombre_,apellido_,cabello_,piel_,ojos_,altura_,contextura_,peso_,comentario_);                                   
        return extraviado_vo;
    }

    public Object Caso_(){
        String id="";
            if (vistaExtraviado.txt_radioOption.getText().trim().equals("")){
                id="No aplica";
            }else{
                id=vistaExtraviado.txt_radioOption.getText().trim();
            }
        try {
            String estado="Desaparecido";
        
            Caso caso = new Caso(estado,sqlDate);
            
            CasoVO caso_vo = new CasoVO(1, id, modeloPersona.getRut(), caso.getEstado(), caso.getFecha());
            
            return caso_vo;
        }catch (Exception ex){
            return null;
        }
    }
    
    public void aLaPrincipal(){
        S0_Principal ven_principal = new S0_Principal();
        CtrlPrincipal ctrl_principal = new CtrlPrincipal(ven_principal);
        ctrl_principal.iniciarPrincipal();
        vistaExtraviado.dispose();
    }
    
    public void realizarIngreso(int opcion,ExtraviadoVO extraviado_vo,Persona persona,PersonaDAO persona_dao,CasoVO caso_vo){
        PersonaVO persona_vo = new PersonaVO(modeloPersona);
        
        if (opcion == 1) {
            extraviado_dao.insertarExtraviado((ExtraviadoVO) extraviado_vo);
            System.out.println(persona_vo.getId_persona());
            System.out.println(extraviado_vo.getIdentificacion_ex());
            caso_dao.insertarCaso(caso_vo, extraviado_vo, persona_vo);
            
            JOptionPane.showMessageDialog(null, "Ingresado exitosamente");            
        }
        if (opcion == 2){
            persona_dao.insertarPersona(persona_vo);
            extraviado_dao.insertarExtraviado((ExtraviadoVO) extraviado_vo);
            caso_dao.insertarCaso((CasoVO)Caso_(), extraviado_vo, persona_vo);
            JOptionPane.showMessageDialog(null, "Ingresado exitosamente");
            System.out.println(persona_vo.getId_persona());
            System.out.println(extraviado_vo.getIdentificacion_ex());
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        try {
            
        }catch(Exception ex) {
            
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        try {
            
        }catch(Exception ex) {
            
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        try {
            
        }catch(Exception ex) {
            
        }
    }
    
    /*limpia todos los campos del formulario*/
    public void limpiarCampos(){      
        /*datos extraviado*/
        habilitarExtraviado(false);
        
        vistaExtraviado.radio_noAplica.setSelected(true);
        vistaExtraviado.txt_radioOption.setText("");
        vistaExtraviado.txt_nombre.setText("");
        vistaExtraviado.txt_apellidos.setText("");
        
        vistaExtraviado.combo_cOjos.setSelectedIndex(0);
        vistaExtraviado.combo_cPelo.setSelectedIndex(0);
        vistaExtraviado.combo_cPiel.setSelectedIndex(0);
        vistaExtraviado.combo_contextura.setSelectedIndex(0);
        
        vistaExtraviado.txt_altura.setText("");
        vistaExtraviado.txt_peso.setText("");
        vistaExtraviado.textarea_comentario.setText("");
        
        vistaExtraviado.txt_nombre.requestFocus();
        
    }
    
    public void habilitarExtraviado(boolean sw) {
        vistaExtraviado.txt_radioOption.setEnabled(sw);
    }
    
    public static boolean validarRut(String rut) {
        boolean validacion = false;
        try {
            rut = rut.toUpperCase();
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

            char dv = rut.charAt(rut.length() - 1);

            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }
        } catch(Exception e) {
        }
        return validacion;
    }
    
    /**
     * Le da formato a un rut, concatenándole puntos y guión.
     * @param rut Rut a formatear.
     * @return Un nuevo String, con el rut formateado.
     */
    static public String formatear(String rut){
        int cont=0;
        String format;
        if(rut.length() == 0){
            return "";
        }else{
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            format = "-"+rut.substring(rut.length()-1);
            for(int i = rut.length()-2;i>=0;i--){
                format = rut.substring(i, i+1)+format;
                cont++;
                if(cont == 3 && i != 0){
                    format = "."+format;
                    cont = 0;
                }
            }
            return format;
        }
    }
}
