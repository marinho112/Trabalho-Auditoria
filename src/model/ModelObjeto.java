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
public class ModelObjeto implements Cloneable{
    
    private int IdObjeto;
    private String nome;
    private String descricao;
    private int IdProcesso;
    
    
    public boolean getObjetoById(int id){
        Statement stmt;
        ResultSet rs;
        try {
            stmt = Conexao.getConexao().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("SELECT * FROM objeto WHERE ID_objeto='"+id+"' AND desativado=0");
            rs.next();
            IdObjeto=rs.getInt("ID_objeto");
            nome= rs.getString("Nome");
            IdProcesso= rs.getInt("ID_processo");
            descricao=rs.getString("Descricao");
            
            
            return true;
        }catch (SQLException ex) {
            Logger.getLogger(ModelUsuario.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRO no consulta de Objeto");
            return false;
        }
    
}
    
    private boolean verificaObjetoById(int id){
        Statement stmt;
        ResultSet rs;
        try {
            stmt = Conexao.getConexao().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("SELECT * FROM objeto WHERE ID_objeto='"+id+"' AND desativado=0");
            return rs.next();
        }catch (SQLException ex) {
            Logger.getLogger(ModelUsuario.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRO no verifica Objeto");
            return false;
        }
    
}
    
    public boolean setObjeto(){
        PreparedStatement stmt;
        Statement stmt2;
        ResultSet rs;
        String sql;
         boolean verifica=verificaObjetoById(IdObjeto);
        if(verifica){
            sql = "UPDATE objeto SET ID_processo=?,Nome=?,Descricao=? where ID_objeto ="+IdObjeto;
        }
        else{
            sql  = "INSERT INTO objeto (ID_processo,Nome,Descricao) VALUES(?,?,?)";
        }

        try {
            stmt = Conexao.getConexao().prepareStatement(sql);
            stmt.setString(1,Integer.toString(IdProcesso));
            stmt.setString(2,nome);
            stmt.setString(3,descricao);
           
            stmt.execute();
            stmt.close();
            
            stmt2 = Conexao.getConexao().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt2.executeQuery("Select ID_objeto from objeto order by ID_objeto DESC LIMIT 1");
            rs.next();
            if(!verifica){IdObjeto=rs.getInt("ID_objeto");}
            
            
            return true;
            }catch (SQLException ex) {
                Logger.getLogger(ModelUsuario.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("ERRO no set de Objeto");
                return false;
            }
    }
    
    public ArrayList<ModelRisco> getRiscos() throws CloneNotSupportedException{
       
        Statement stmt;
        ResultSet rs;
        ModelRisco objeto=new ModelRisco();
        ArrayList<ModelRisco> retorno= new ArrayList<>();
        try {
            stmt = Conexao.getConexao().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("SELECT ID_Risco FROM risco WHERE ID_Objeto='"+IdObjeto+"' AND desativado=0");
            while(rs.next()){
                objeto.getRiscoById(rs.getInt("ID_Risco"));
                retorno.add(objeto.clone());
            }
            return retorno;
        }catch (SQLException ex) {
            Logger.getLogger(ModelUsuario.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRO no consulta de Usuario");
            return null;
        }         
    }
    
    public boolean excluir() {
        PreparedStatement stmt;
        
        String sql="UPDATE objeto SET `Desativado` = '1' WHERE ID_Objeto ='"+IdObjeto+"'";
          try { 
            stmt = Conexao.getConexao().prepareStatement(sql);
            stmt.execute(sql);
            
            sql="UPDATE objeto_risco SET `Desativado` = '1' WHERE ID_Objeto ='"+IdObjeto+"'";
            stmt = Conexao.getConexao().prepareStatement(sql);
            stmt.execute(sql);
            
            sql="UPDATE eficacia SET `Desativado` = '1' WHERE ID_Objeto ='"+IdObjeto+"'";
            stmt = Conexao.getConexao().prepareStatement(sql);
            stmt.execute(sql);
            return true;
          }
          catch (SQLException e) { 
              return false;
          }
    }
    
    public void test(){
        System.out.println("Id Objeto: "+IdObjeto);
        System.out.println("Nome: "+nome);
        System.out.println("IdProcesso: "+IdProcesso);
        System.out.println("Descrição: "+descricao);
    }

    public void setIdObjeto(int IdObjeto) {
        this.IdObjeto = IdObjeto;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setIdProcesso(int IdProcesso) {
        this.IdProcesso = IdProcesso;
    }

    public int getIdObjeto() {
        return IdObjeto;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getIdProcesso() {
        return IdProcesso;
    }
    
    
    
     @Override
    public ModelObjeto clone() throws CloneNotSupportedException{
        return (ModelObjeto) super.clone();
    }
    
}
