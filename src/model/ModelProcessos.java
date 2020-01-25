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
public class ModelProcessos implements Cloneable {
    
    private int IdProcessos;
    private String nome;
    private String descricao;
    private int IdUsuario;
    
    
    public boolean getProcessoById(int id){
        Statement stmt;
        ResultSet rs;
        try {
            stmt = Conexao.getConexao().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("SELECT * FROM processo WHERE ID_Processo='"+id+"' AND desativado=0");
            rs.next();
            IdProcessos=rs.getInt("ID_processo");
            nome= rs.getString("Nome");
            IdUsuario= rs.getInt("ID_usuario");
            descricao=rs.getString("Descricao");
            
            return true;
        }catch (SQLException ex) {
            Logger.getLogger(ModelUsuario.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRO no consulta de Processos");
            return false;
        }
    
}
    
    
    private boolean verificaProcessoById(int id){
        Statement stmt;
        ResultSet rs;
        try {
            stmt = Conexao.getConexao().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("SELECT * FROM processo WHERE ID_Processo='"+id+"' AND desativado=0");
            return rs.next();
        }catch (SQLException ex) {
            Logger.getLogger(ModelUsuario.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRO no verifica Processos");
            return false;
        }
    
}

    public boolean setProcessos(){
        PreparedStatement stmt;
        Statement stmt2;
        ResultSet rs;
        String sql;
         boolean verifica=verificaProcessoById(IdProcessos);
        if(verifica){
            sql = "UPDATE processo SET ID_usuario=?, Nome=?, Descricao=? WHERE ID_processo ="+IdProcessos;
        }
        else{
            sql  = "INSERT INTO processo (ID_usuario,Nome,Descricao) VALUES(?,?,?)";
        }

        try {
            stmt = Conexao.getConexao().prepareStatement(sql);
            stmt.setString(1,Integer.toString(IdUsuario));
            stmt.setString(2,nome);
            stmt.setString(3,descricao);
            
            stmt.execute();
            stmt.close();
            
            stmt2 = Conexao.getConexao().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt2.executeQuery("Select ID_Processo from processo order by ID_Processo DESC LIMIT 1");
            rs.next();
            if(!verifica){ IdProcessos=rs.getInt("ID_processo");}
            
            
            return true;
            }catch (SQLException ex) {
                Logger.getLogger(ModelUsuario.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("ERRO no set de Processos");
                return false;
            }
    }
    
    public ArrayList<ModelMitigacao> getMitigacoes() throws CloneNotSupportedException{
       
        Statement stmt;
        ResultSet rs;
        ModelMitigacao objeto=new ModelMitigacao();
        ArrayList<ModelMitigacao> retorno= new ArrayList<>();
        try {
            stmt = Conexao.getConexao().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("SELECT ID_Mitigacao FROM mitigacao WHERE ID_processo='"+IdProcessos+"' AND desativado=0");
            while(rs.next()){
                objeto.getMitigacaoById(rs.getInt("ID_mitigacao"));
                retorno.add(objeto.clone());
            }
            return retorno;
        }catch (SQLException ex) {
            Logger.getLogger(ModelUsuario.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRO no consulta de Usuario");
            return null;
        }         
    }
    
    public ArrayList<ModelEficacia> getEficacias() throws CloneNotSupportedException{
       
        Statement stmt;
        ResultSet rs;
        ModelEficacia objeto=new ModelEficacia();
        ArrayList<ModelEficacia> retorno= new ArrayList<>();
        try {
            stmt = Conexao.getConexao().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("SELECT * FROM eficacia,risco WHERE eficacia.ID_risco = risco.ID_risco AND risco.ID_processo="+IdProcessos+" AND risco.desativado=0 AND eficacia.desativado=0" );
            while(rs.next()){
                objeto.getEficaciaById(rs.getInt("eficacia.ID_risco"),rs.getInt("eficacia.ID_mitigacao"),rs.getInt("eficacia.ID_objeto"));
                retorno.add(objeto.clone());
            }
            return retorno;
        }catch (SQLException ex) {
            Logger.getLogger(ModelUsuario.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRO no consulta de Eficacia");
            return null;
        }         
    }
    
    public ArrayList<ModelObjetoRisco> getRelacoes() throws CloneNotSupportedException{
       
        Statement stmt;
        ResultSet rs;
        ModelObjetoRisco objeto=new ModelObjetoRisco();
        ArrayList<ModelObjetoRisco> retorno= new ArrayList<>();
        try {
            stmt = Conexao.getConexao().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("SELECT * FROM objeto_risco,risco WHERE objeto_risco.ID_risco = risco.ID_risco AND risco.ID_processo="+IdProcessos+" AND risco.desativado=0 AND objeto_risco.desativado=0" );
            while(rs.next()){
                objeto.getObjetoRiscoById(rs.getInt("objeto_risco.ID_risco"),rs.getInt("objeto_risco.ID_objeto"));
                retorno.add(objeto.clone());
                
            }
            return retorno;
        }catch (SQLException ex) {
            Logger.getLogger(ModelUsuario.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRO no consulta de Eficacia");
            return null;
        }         
    }
    
    public ArrayList<ModelRisco> getRiscos() throws CloneNotSupportedException{
       
        Statement stmt;
        ResultSet rs;
        ModelRisco risco=new ModelRisco();
        ArrayList<ModelRisco> retorno= new ArrayList<>();
        try {
            stmt = Conexao.getConexao().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("SELECT ID_Risco FROM Risco WHERE ID_processo='"+IdProcessos+"' AND desativado=0");
            while(rs.next()){
                risco.getRiscoById(rs.getInt("ID_Risco"));
                retorno.add(risco.clone());
            }
            return retorno;
        }catch (SQLException ex) {
            Logger.getLogger(ModelUsuario.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRO no consulta de Usuario");
            return null;
        }         
    }
    
    public ArrayList<ModelObjeto> getObjetos() throws CloneNotSupportedException{
       
        Statement stmt;
        ResultSet rs;
        ModelObjeto objeto=new ModelObjeto();
        ArrayList<ModelObjeto> retorno= new ArrayList<>();
        try {
            stmt = Conexao.getConexao().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("SELECT ID_Objeto FROM objeto WHERE ID_processo='"+IdProcessos+"' AND desativado=0");
            while(rs.next()){
                objeto.getObjetoById(rs.getInt("ID_Objeto"));
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
        
        String sql="UPDATE processo SET `Desativado` = '1' WHERE ID_processo ='"+IdProcessos+"'";
          try { 
            stmt = Conexao.getConexao().prepareStatement(sql);
            stmt.execute(sql);
            sql="UPDATE objeto SET `Desativado` = '1' WHERE ID_processo ='"+IdProcessos+"'";
            stmt = Conexao.getConexao().prepareStatement(sql);
            stmt.execute(sql);
            sql="UPDATE risco SET `Desativado` = '1' WHERE ID_processo ='"+IdProcessos+"'";
            stmt = Conexao.getConexao().prepareStatement(sql);
            stmt.execute(sql);
            sql="UPDATE mitigacao SET `Desativado` = '1' WHERE ID_processo ='"+IdProcessos+"'";
            stmt = Conexao.getConexao().prepareStatement(sql);
            stmt.execute(sql);
            return true;
          }
          catch (SQLException e) { 
              Logger.getLogger(ModelUsuario.class.getName()).log(Level.SEVERE, null, e);
              return false;
          }
    }
    

    public void test(){
        System.out.println("Nome: "+nome);
        System.out.println("IdProcesso: "+IdProcessos);
        System.out.println("IdUsuario: "+IdUsuario);
        System.out.println("Descrição: "+descricao);
    }
    
    
     

    public void setIdProcessos(int IdProcessos) {
        this.IdProcessos = IdProcessos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public int getIdProcessos() {
        return IdProcessos;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }
    
    @Override
    public ModelProcessos clone() throws CloneNotSupportedException{
        return (ModelProcessos) super.clone();
    }
    
    }