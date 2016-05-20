package Controlador;

import Vista.S0_Principal;
import Vista.S8_IngresarPersona;
import Datos.CasoDAO;
import Datos.CasoVO;
import Datos.ExtraviadoVO;
import Datos.PersonaVO;
import Modelo.Caso;
import Modelo.Conexion;
import Modelo.Extraviado;
import Modelo.Persona;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 *
 * @author erik
 */
public class CtrlPrincipal implements ActionListener {
    S0_Principal ventanaPrincipal;
    
    public CtrlPrincipal(S0_Principal vistaPrincipal) {
        this.ventanaPrincipal = vistaPrincipal;
        this.ventanaPrincipal.btn_ingresarExtraviado.addActionListener(this);
        
        this.ventanaPrincipal.btn_modificar.addActionListener(this);
    }
    
    public void iniciarPrincipal() {
        ventanaPrincipal.setTitle("Principal - Sistema de Búsqueda de Extraviado");
        ventanaPrincipal.pack();
        ventanaPrincipal.setLocationRelativeTo(null);
        ventanaPrincipal.setVisible(true);
        ventanaPrincipal.setResizable(false);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(ventanaPrincipal.btn_ingresarExtraviado == e.getSource()){           
            Persona persona = new Persona();
            S8_IngresarPersona vistaPersona = new S8_IngresarPersona();
            CtrlIngPersona ctrlPersona = new CtrlIngPersona(vistaPersona, persona) {};
            ventanaPrincipal.setVisible(false);
            ventanaPrincipal.dispose();
            ctrlPersona.iniciarPersona();
        }
        if (ventanaPrincipal.btn_modificar == e.getSource()) {
//           Persona persona2 = new Persona();
//           persona2.setRut("9.914.550-1");
//           PersonaVO persona1 = new PersonaVO(persona2);
//            
//           Extraviado extraviado2 = new Extraviado();
//           extraviado2.setIdentificador("No aplica");
//           ExtraviadoVO extraviado1 = new ExtraviadoVO();
//           extraviado1.setIdentificacion_ex(extraviado2.getIdentificador());
//            
//           
//           
//           System.out.println(persona1.getId_persona());
//            CasoDAO casodao = new CasoDAO();
//            java.util.Date fechaActual = new java.util.Date();
//            java.sql.Date sqlDate = new java.sql.Date(fechaActual.getTime());
//            String estado="Desaparecido";
//            Caso _caso = new Caso(estado, sqlDate);
//            
//            CasoVO caso_ = new CasoVO(1,extraviado1.getIdentificacion_ex(),persona1.getId_persona(),_caso.getEstado(),_caso.getFecha());
//            System.out.println("");
//            
//            System.out.println("1");
//            int dato_=0;
//            conexion = new Conexion();
//            System.out.println("***************");
//            try {
//            Connection accesoDB = conexion.getConexion();
//            dato_ = verificarCasoExtraviado(extraviado1.getIdentificacion_ex());
//                System.out.println(dato_);
//                    if (dato_ == 1){
//                        System.out.println("pene");
//                    }else{
//                          
////            PreparedStatement ps = accesoDB.prepareStatement("INSERT INTO caso(IDEXTRAVIADO,IDPERSONA,ESTADOCASO,FECHACASO) VALUES (?,?,?,?)");
//            PreparedStatement ps = accesoDB.prepareStatement("INSERT INTO `caso` (`IDEXTRAVIADO`, `IDPERSONA`, `ESTADOCASO`, `FECHACASO`) VALUES (?,?,?,?)");
//                System.out.println("paso");
//                ps.setInt(1, dato_);
//                ps.setString(2, persona1.getId_persona());
//                ps.setString(3, caso_.getESTADOCASO());
//                ps.setDate(4, (Date) caso_.getFECHACASO());
//                System.out.println(ps);
//                int numFilasAfectadas = ps.executeUpdate();
//                ps.close();
//                conexion.Desconectar();
//                if(numFilasAfectadas>0){
//                    System.out.println("1");
//                }else{
//                    System.out.println("2");
//                }
//                       }
// 
//        }catch(Exception exx) {
//           
//        }
//            
//        
    
    }
 
    }
}