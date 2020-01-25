/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Racca
 */
public class ModelUsuario implements Cloneable {   
    private int IdUsuario;
    private String nome;
    private boolean P_gestor;
    private boolean P_auditor;
    private boolean logado;
    
            
    
    
    public boolean getUsuarioByLogin(String login){
        
        Statement stmt;
        ResultSet rs;
        try {
            stmt = Conexao.getConexao().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("SELECT * FROM Usuario WHERE login='"+login+"' AND desativado=0");
            rs.next();
            nome= rs.getString("Nome");
            P_gestor= rs.getBoolean("PGestor");
            P_auditor= rs.getBoolean("PAuditor");
            //logado= true;
            IdUsuario= rs.getInt("ID_usuario");
            return true;
        }catch (SQLException ex) {
            Logger.getLogger(ModelUsuario.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRO no consulta de Usuario");
            return false;
        }
        //Conexao.getConexao().prepareStatement(URL);
        
             //   

    }

    public boolean getUsuarioById(int id){
        
        Statement stmt;
        ResultSet rs;
        try {
            stmt = Conexao.getConexao().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("SELECT * FROM Usuario WHERE ID_Usuario='"+id+"' AND desativado=0");
            rs.next();
            nome= rs.getString("Nome");
            P_gestor= rs.getBoolean("PGestor");
            P_auditor= rs.getBoolean("PAuditor");
            //logado= true;
            IdUsuario= rs.getInt("ID_usuario");
            return true;
        }catch (SQLException ex) {
            Logger.getLogger(ModelUsuario.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRO no consulta de Usuario");
            return false;
        }
        //Conexao.getConexao().prepareStatement(URL);
        
             //   

    }
    
    public ArrayList<ModelProcessos> getProcessos() throws CloneNotSupportedException{
       
        Statement stmt;
        ResultSet rs;
        ModelProcessos processo=new ModelProcessos();
        ArrayList<ModelProcessos> retorno= new ArrayList<>();
        try {
            stmt = Conexao.getConexao().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("SELECT ID_Processo FROM processo WHERE ID_usuario='"+IdUsuario+"' AND desativado=0");
            while(rs.next()){
                processo.getProcessoById(rs.getInt("ID_Processo"));
                retorno.add(processo.clone());
            }
            return retorno;
        }catch (SQLException ex) {
            Logger.getLogger(ModelUsuario.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRO no consulta de Usuario");
            return null;
        }         
    }
    
    public ArrayList<ModelProcessos> getProcessosAll() throws CloneNotSupportedException{
       
        Statement stmt;
        ResultSet rs;
        ModelProcessos processo=new ModelProcessos();
        ArrayList<ModelProcessos> retorno= new ArrayList<>();
        try {
            stmt = Conexao.getConexao().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("SELECT ID_Processo FROM processo  WHERE desativado=0");
            while(rs.next()){
                processo.getProcessoById(rs.getInt("ID_Processo"));
                retorno.add(processo.clone());
            }
            return retorno;
        }catch (SQLException ex) {
            Logger.getLogger(ModelUsuario.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRO no consulta de Usuario");
            return null;
        }         
    }
    
    public boolean executaLogin(String login,String senha){
        Statement stmt;
        ResultSet rs;
       
        if(Conexao.conectaDB()){
            try {
                stmt = Conexao.getConexao().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                rs = stmt.executeQuery("SELECT * FROM Usuario WHERE login='"+login+"' AND desativado=0");
                rs.next();
                String log = rs.getString("Login");
                String sen = rs.getString("Senha");
                if((log.equals(login))&&(sen.equals(senha))){
                    if(this.getUsuarioByLogin(login)){
                        this.logado=true;
                        return true;
                    }
                    return false;
                }
                else{
                    return false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(ModelUsuario.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }else{
            return false;
        }
        
    }
    
    public boolean logoff(){
        if(logado){
            nome= null;
            P_gestor= false;
            P_auditor= false;
            IdUsuario= 0;
            logado= false;
            Conexao.setConexao(null);
            return true;
        }
        else{return false;}
    }
    
    public int getIdUsuario() {
        return IdUsuario;
    }

    public String getNome() {
        return nome;
    }

    public boolean getP_gestor() {
        return P_gestor;
    }

    public boolean getP_auditor() {
        return P_auditor;
    }
    
    public void test(){
        System.out.println("Nome: "+nome);
        System.out.println("P_gestor: "+P_gestor);
        System.out.println("P_auditor: "+P_auditor);
        System.out.println("IdUsuario: "+IdUsuario);
        System.out.println("Logado: "+logado);
    }

 

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setP_gestor(boolean P_gestor) {
        this.P_gestor = P_gestor;
    }

    public void setP_auditor(boolean P_auditor) {
        this.P_auditor = P_auditor;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }
    
  
     @Override
    public ModelUsuario clone() throws CloneNotSupportedException{
        return (ModelUsuario) super.clone();
    }
}



