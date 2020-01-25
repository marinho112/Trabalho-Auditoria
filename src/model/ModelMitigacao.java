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
public class ModelMitigacao implements Cloneable{
    
    private int IdMitigacao;
    private String nome;
    private String descricao;
    private int IdProcesso;
    
    
    
    
    
    public boolean getMitigacaoById(int id){
        Statement stmt;
        ResultSet rs;
        try {
            stmt = Conexao.getConexao().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("SELECT * FROM mitigacao WHERE ID_mitigacao='"+id+"' AND desativado=0");
            rs.next();
            IdMitigacao=rs.getInt("ID_mitigacao");
            nome= rs.getString("Nome");
            IdProcesso= rs.getInt("ID_processo");
            descricao=rs.getString("Descricao");
            return true;
        }catch (SQLException ex) {
            Logger.getLogger(ModelUsuario.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRO no consulta de Mitigacao");
            return false;
        }
    
}
    
    
    private boolean verificaMitigacaoById(int id){
        Statement stmt;
        ResultSet rs;
        try {
            stmt = Conexao.getConexao().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("SELECT * FROM mitigacao WHERE ID_mitigacao='"+id+"' AND desativado=0");
            return rs.next();
        }catch (SQLException ex) {
            Logger.getLogger(ModelUsuario.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRO no verifica Mitigacao");
            return false;
        }
    
}
    
    public String booleanToString(boolean var){if(var){return "1";}else{return "0";}}
    
   
    
    public boolean setMitigacao(){
        PreparedStatement stmt;
        Statement stmt2;
        ResultSet rs;
        String sql;
        boolean verifica=verificaMitigacaoById(IdMitigacao);
        if(verifica){
            sql = "UPDATE mitigacao SET ID_processo=?,Nome=?,Descricao=? where ID_mitigacao="+IdMitigacao;
        }
        else{
            sql  = "INSERT INTO mitigacao (ID_processo,Nome,descricao) VALUES(?,?,?)";
        }

        try {
            stmt = Conexao.getConexao().prepareStatement(sql);
            stmt.setString(1,Integer.toString(IdProcesso));
            stmt.setString(2,nome);
            stmt.setString(3,descricao);
            System.out.println(stmt.toString());
            System.out.println(sql);
            stmt.execute();
            stmt.close();
            
            stmt2 = Conexao.getConexao().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt2.executeQuery("Select ID_mitigacao from mitigacao order by ID_mitigacao DESC LIMIT 1");
            rs.next();
            if(!verifica){IdMitigacao=rs.getInt("ID_mitigacao");}
            
            
            return true;
            }catch (SQLException ex) {
                Logger.getLogger(ModelUsuario.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("ERRO no set de Mitigacao");
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
            rs = stmt.executeQuery("SELECT * FROM Eficacia WHERE ID_Mitigacao='"+IdMitigacao+"' AND desativado=0");
            while(rs.next()){
            objeto.setIdRisco(rs.getInt("ID_risco"));
            objeto.setIdObjeto(rs.getInt("ID_objeto"));
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
        ArrayList<Integer> lista=new ArrayList<>();
        int i,pesquisa;     
        try {
            stmt = Conexao.getConexao().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("SELECT * FROM eficacia WHERE ID_mitigacao='"+IdMitigacao+"' AND desativado=0");
            while(rs.next()){
                pesquisa =rs.getInt("ID_Risco");
                for(i=0;i<=lista.size();i++){
                    if(lista.get(i)==pesquisa){
                        break;
                    }
                    if(i==lista.size()){
                        lista.add(pesquisa);
                        objeto.getRiscoById(pesquisa);
                        retorno.add(objeto.clone());
                    }
                }
                
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
        
        String sql="UPDATE mitigacao SET `Desativado` = '1' WHERE ID_mitigacao ='"+IdMitigacao+"'";
          try { 
            stmt = Conexao.getConexao().prepareStatement(sql);
            stmt.execute(sql);
            
            sql="UPDATE eficacia SET `Desativado` = '1' WHERE ID_mitigacao ='"+IdMitigacao+"'";
            stmt = Conexao.getConexao().prepareStatement(sql);
            stmt.execute(sql);
            
            return true;
          }
          catch (SQLException e) { 
              return false;
          }
    }

    
    public void test(){
        System.out.println("Idmitigacao: "+IdMitigacao);
        System.out.println("Nome: "+nome);
        System.out.println("IdProcesso: "+IdProcesso);
        System.out.println("Descrição: "+descricao);
    }

    public void setIdMitigacao(int IdMitigacao) {
        this.IdMitigacao = IdMitigacao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public int getIdMitigacao() {
        return IdMitigacao;
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

    public void setIdProcesso(int IdProcesso) {
        this.IdProcesso = IdProcesso;
    }
    
    
    
     @Override
    public ModelMitigacao clone() throws CloneNotSupportedException{
        return (ModelMitigacao) super.clone();
    }
    
}
