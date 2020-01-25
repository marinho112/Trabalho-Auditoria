/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import model.ModelObjeto;
import model.ModelProcessos;
import model.ModelUsuario;
import view.main;
import view.ListaProcesso;
import view.MenuPrincipal;
import view.objeto;

/**
 *
 * @author Racca
 */
public class ControllObjeto {
    
    private ModelObjeto objeto= new ModelObjeto();
    private ModelUsuario usuario;
    private ControllProcessos processo;
    private ArrayList<ModelObjeto> objetos;
    
    public boolean carregarFormulario(objeto obj) throws CloneNotSupportedException{
    int i;
    objetos= processo.getProcesso().getObjetos();
    DefaultListModel cell=new DefaultListModel();
    for(i=0;i<objetos.size();i++){
        cell.addElement(objetos.get(i).getNome());
    }
   
    obj.getjListObjetos().setModel(cell);
    if(i>0){obj.getjListObjetos().setSelectedIndex(0);}
    obj.getjTextFieldNome().setText(objeto.getNome());
    obj.getjTextPaneDescricao().setText(objeto.getDescricao());
    
    if(i>0){obj.getjListObjetos().setSelectedIndex(0);}
    return true;
        
    }

    public ModelObjeto getObjeto() {
        return objeto;
    }
    
    public boolean editarObjeto(objeto view) throws CloneNotSupportedException{
        
        objeto=objetos.get(view.getjListObjetos().getSelectedIndex());
        this.carregarFormulario(view);
        
        view.repaint();
        view.revalidate();
        return true;
    }
    
    public boolean criarObjeto(objeto view) throws CloneNotSupportedException{
        
        objeto=new ModelObjeto();
        objeto.setIdProcesso(processo.getProcesso().getIdProcessos());
        this.carregarFormulario(view);
        
        view.repaint();
        view.revalidate();
        return true;
    }
    
    public boolean salvarFormulario(objeto obj) throws CloneNotSupportedException{
        objeto.setNome(obj.getjTextFieldNome().getText()); 
        objeto.setDescricao(obj.getjTextPaneDescricao().getText());
        if(objeto.setObjeto()){
            this.carregarFormulario(obj);
            obj.repaint();
            obj.revalidate();
            return true;
        }else{
            return false;
        }
    }
   
    
    
    /**
     *
     * @param principal
     * @return
     */
    public boolean voltar(main principal){
       MenuPrincipal prt02 = new MenuPrincipal();
       
       prt02.setPrincipal(principal);
       prt02.setProcesso(processo);
       prt02.getjLabelNomeProcesso().setText(processo.getProcesso().getNome());
       
       
       principal.getCartao01().removeAll();
       principal.getCartao01().add(prt02);
       principal.getCartao01().repaint();
       principal.getCartao01().revalidate();
       
       return true; 
    }
   
    
    public boolean excluirObjeto(objeto view) throws CloneNotSupportedException{
        if(objetos.get(view.getjListObjetos().getSelectedIndex()).excluir()){
            objeto=objetos.get(0);
            this.carregarFormulario(view);
            
            
            view.repaint();
            view.revalidate();
            return true;
        }else{
            return false;
        }
    }
    

    
    
    
    
    public void setObjeto(ModelObjeto objeto) {
        this.objeto = objeto;
    }

    public ModelUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(ModelUsuario usuario) {
        this.usuario = usuario;
    }

    public ControllProcessos getProcesso() {
        return processo;
    }

    public void setProcesso(ControllProcessos processo) {
        this.processo = processo;
    }
    
    
}
