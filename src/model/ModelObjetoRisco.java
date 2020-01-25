/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.PreparedStatement;
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
public class ModelObjetoRisco implements Cloneable{
    
    private int IdRisco;
    private int IdObjeto;
    private byte impacto;
    private byte probabilidade;
    
    
    public boolean getObjetoRiscoById(int idR,int idM){
        Statement stmt;
        ResultSet rs;
        String querry="SELECT * FROM objeto_risco WHERE ID_risco='"+idR+"' AND ID_objeto='"+idM+"' AND desativado=0";
       
        try {
            stmt = Conexao.getConexao().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(querry);
            rs.next();
            IdObjeto=rs.getInt("ID_objeto");
            IdRisco=rs.getInt("ID_risco");
            impacto=rs.getByte("impacto");
            probabilidade=rs.getByte("probabilidade");
            
            return true;
        }catch (SQLException ex) {
            Logger.getLogger(ModelUsuario.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRO no consulta de Objeto Risco");
            return false;
        }
    
}
    
    
    public boolean verificaObjetoRiscoById(int idR,int idM){
        Statement stmt;
        ResultSet rs;
        try {
            stmt = Conexao.getConexao().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("SELECT * FROM objeto_risco WHERE ID_Risco='"+idR+"'AND ID_Objeto='"+idM+"'");
            return rs.next();
        }catch (SQLException ex) {
            Logger.getLogger(ModelUsuario.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRO no verifica objeto_risco");
            return false;
        }
    
}
    
    
   // public boolean stringToBoolean(String var){if(var=="0"){return false;}else{return true;}}
    
    public boolean setObjetoRisco(){
        PreparedStatement stmt;
        Statement stmt2;
        ResultSet rs;
        String sql;
        
        if(verificaObjetoRiscoById(IdRisco,IdObjeto)){
            sql = "UPDATE objeto_risco SET impacto=?, probabilidade=?, desativado='0' WHERE ID_risco =? and ID_Objeto=?";
        }
        else{
            sql  = "INSERT INTO objeto_risco (impacto,probabilidade,ID_risco,ID_Objeto,desativado) VALUES(?,?,?,?,'0')";
        }

        try {
            stmt = Conexao.getConexao().prepareStatement(sql);
            stmt.setString(1,Integer.toString(impacto));
            stmt.setString(2,Integer.toString(probabilidade));
            stmt.setString(3,Integer.toString(IdRisco));
            stmt.setString(4,Integer.toString(IdObjeto));
            
            
            
            System.out.println(stmt.toString());
            stmt.execute();
            stmt.close();
            
            
            return true;
            }catch (SQLException ex) {
                Logger.getLogger(ModelUsuario.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("ERRO no set de ObjetoRisco");
                return false;
            }
    }
    
    public ArrayList<ModelObjetoRisco> getRelacoes() throws CloneNotSupportedException{
       
        Statement stmt;
        ResultSet rs;
        ModelObjetoRisco relacao=new ModelObjetoRisco();
        ArrayList<ModelObjetoRisco> retorno= new ArrayList<>();
        try {
            stmt = Conexao.getConexao().createStatement();
            rs = stmt.executeQuery("SELECT * FROM objeto_risco WHERE ID_risco="+IdRisco+" AND desativado=0");
            while(rs.next()){
            relacao.setImpacto(rs.getByte("impacto"));    
            relacao.setProbabilidade(rs.getByte("probabilidade"));
            relacao.setIdObjeto(rs.getInt("ID_Objeto"));
            relacao.setIdRisco(rs.getInt("ID_risco"));
            retorno.add(relacao.clone());
            }
            return retorno;
        }catch (SQLException ex) {
            Logger.getLogger(ModelUsuario.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRO no consulta Objeto Risco");
            return null;
        }         
    }
    
    public boolean excluir() {
        PreparedStatement stmt;
        
        String sql="UPDATE objeto_risco SET `Desativado` = '1' WHERE ID_objeto='"+IdObjeto+"'";
          try { 
            stmt = Conexao.getConexao().prepareStatement(sql);
            stmt.execute(sql);
            return true;
          }
          catch (SQLException e) { 
              return false;
          }
    }
     
    public void test(){
        System.out.println("IdRisco: "+IdRisco);
        System.out.println("IdObjeto: "+IdObjeto);
        System.out.println("Impacto: "+impacto);
        System.out.println("Probabilidade: "+probabilidade);
    }

    public int getIdRisco() {
        return IdRisco;
    }

    public int getIdObjeto() {
        return IdObjeto;
    }

    public byte getImpacto() {
        return impacto;
    }

    public byte getProbabilidade() {
        return probabilidade;
    }

    public void setIdRisco(int IdRisco) {
        this.IdRisco = IdRisco;
    }

    public void setIdObjeto(int IdObjeto) {
        this.IdObjeto = IdObjeto;
    }

    public void setImpacto(byte impacto) {
        this.impacto = impacto;
    }

    public void setProbabilidade(byte probabilidade) {
        this.probabilidade = probabilidade;
    }

   
    
     @Override
    public ModelObjetoRisco clone() throws CloneNotSupportedException{
        return (ModelObjetoRisco) super.clone();
    }
    
}
