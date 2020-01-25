/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model ;

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
public class ModelRisco implements Cloneable {
    
    private int IdRisco;
    private String nome;
    private String descricao;
    private int IdProcesso;
    
    
    public boolean getRiscoById(int id){
        Statement stmt;
        ResultSet rs;
        try {
            stmt = Conexao.getConexao().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("SELECT * FROM Risco WHERE ID_Risco='"+id+"' AND desativado=0");
            rs.next();
            IdRisco=rs.getInt("ID_risco");
            nome= rs.getString("Nome");
            IdProcesso= rs.getInt("ID_processo");
            descricao=rs.getString("Descricao");
            
            
            
            return true;
        }catch (SQLException ex) {
            Logger.getLogger(ModelUsuario.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRO no consulta de Risco");
            return false;
        }
    
}
    
    
    private boolean verificaRiscoById(int id){
        Statement stmt;
        ResultSet rs;
        try {
            stmt = Conexao.getConexao().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("SELECT * FROM Risco WHERE ID_Risco='"+id+"' AND desativado=0");
            return rs.next();
        }catch (SQLException ex) {
            Logger.getLogger(ModelUsuario.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRO no verifica Risco");
            return false;
        }
    
}
    
    
   // public boolean stringToBoolean(String var){if(var=="0"){return false;}else{return true;}}
    
    public boolean setRisco(){
        PreparedStatement stmt;
        Statement stmt2;
        ResultSet rs;
        String sql;
        boolean verifica=verificaRiscoById(IdRisco);
        if(verifica){
            sql = "UPDATE Risco SET ID_processo=?,Nome=?,Descricao=? where ID_risco="+IdRisco;
        }
        else{
            sql  = "INSERT INTO Risco (ID_processo,Nome,Descricao) VALUES(?,?,?)";
        }

        try {
            stmt = Conexao.getConexao().prepareStatement(sql);
            stmt.setString(1,Integer.toString(IdProcesso));
            stmt.setString(2,nome);
            stmt.setString(3,descricao);
            
            
            
            stmt.execute();
            stmt.close();
            
            stmt2 = Conexao.getConexao().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt2.executeQuery("Select ID_Risco from Risco order by ID_Risco DESC LIMIT 1");
            rs.next();
            if(!verifica){IdRisco=rs.getInt("ID_Risco");}
            
            
            return true;
            }catch (SQLException ex) {
                Logger.getLogger(ModelUsuario.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("ERRO no set de Risco");
                return false;
            }
    }
    
    public ArrayList<ModelEficacia> getEficacias() throws CloneNotSupportedException{
       
        Statement stmt;
        ResultSet rs;
        ModelEficacia objeto=new ModelEficacia();
        ArrayList<ModelEficacia> retorno= new ArrayList<>();
        try {
            stmt = Conexao.getConexao().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("SELECT * FROM Eficacia WHERE ID_Risco='"+IdRisco+"' AND desativado=0");
            while(rs.next()){
            objeto.setIdRisco(rs.getInt("ID_risco"));
            objeto.setIdMitigacao(rs.getInt("ID_mitigacao"));
            objeto.setEficacia(rs.getByte("eficacia"));
            retorno.add(objeto.clone());
            }
            return retorno;
        }catch (SQLException ex) {
            Logger.getLogger(ModelUsuario.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRO no consulta de Usuario");
            return null;
        }         
    }
    
    public ArrayList<ModelRisco> getRiscos() throws CloneNotSupportedException{
       
        Statement stmt;
        ResultSet rs;
        ModelRisco objeto=new ModelRisco();
        ArrayList<ModelRisco> retorno= new ArrayList<>();
        try {
            stmt = Conexao.getConexao().createStatement();
            rs = stmt.executeQuery("SELECT * FROM risco");
            while(rs.next()){
            objeto.setIdRisco(rs.getInt("ID_risco"));
            objeto.setNome(rs.getString("Nome"));
            objeto.setIdProcesso(rs.getInt("ID_objeto")); 
            objeto.setDescricao(rs.getString("Descricao"));
            retorno.add(objeto.clone());
            }
            return retorno;
        }catch (SQLException ex) {
            Logger.getLogger(ModelUsuario.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRO no consulta Riscos");
            return null;
        }         
    }
    
    public ArrayList<ModelObjetoRisco> getRelacoes() throws CloneNotSupportedException{
       
        Statement stmt;
        ResultSet rs;
        ModelObjetoRisco relacao=new ModelObjetoRisco();
        ArrayList<ModelObjetoRisco> retorno= new ArrayList<>();
        ArrayList<Integer> lista=new ArrayList<>();
        int i,pesquisa;     
        try {
            stmt = Conexao.getConexao().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("SELECT * FROM objeto_risco WHERE ID_risco='"+IdRisco+"' AND desativado=0");
            while(rs.next()){
                
                relacao.setIdObjeto(rs.getInt("ID_Objeto"));
                relacao.setIdRisco(rs.getInt("ID_Risco"));
                relacao.setImpacto(rs.getByte("impacto"));
                relacao.setProbabilidade(rs.getByte("probabilidade"));
               
                retorno.add(relacao.clone());
                
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
        
        String sql="UPDATE risco SET `Desativado` = '1' WHERE ID_risco ='"+IdRisco+"'";
          try { 
            stmt = Conexao.getConexao().prepareStatement(sql);
            stmt.execute(sql);
            
            sql="UPDATE objeto_risco SET `Desativado` = '1' WHERE ID_risco ='"+IdRisco+"'";
            stmt = Conexao.getConexao().prepareStatement(sql);
            stmt.execute(sql);
            
            sql="UPDATE eficacia SET `Desativado` = '1' WHERE ID_risco ='"+IdRisco+"'";
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
        System.out.println("Nome: "+nome);
        System.out.println("IdObjeto: "+IdProcesso);
        System.out.println("Descrição: "+descricao);
    }

    public void setIdRisco(int IdRisco) {
        this.IdRisco = IdRisco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

   
    public void setIdProcesso(int IdObjeto) {
        this.IdProcesso = IdObjeto;
    }

    public int getIdRisco() {
        return IdRisco;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    
    public int getIdProceso() {
        return IdProcesso;
    }
    
    
    
     @Override
    public ModelRisco clone() throws CloneNotSupportedException{
        return (ModelRisco) super.clone();
    }
    
}
