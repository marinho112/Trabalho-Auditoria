/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.ModelMitigacao;
import model.ModelObjeto;
import model.ModelProcessos;
import model.ModelRisco;
import model.ModelUsuario;
import view.CriarProcesso;
import view.mapaRisco;
import view.mitigacao;
import view.main;
import view.mapaEficacia;
import view.ListaProcesso;
import view.MenuPrincipal;
import view.objeto;
import view.risco;

/**
 *
 * @author Racca
 */
public class ControllProcessos {
    private ModelProcessos processo;
    private ModelUsuario usuario ;
    

    
    public boolean salvarFormulario(CriarProcesso prt) throws CloneNotSupportedException{
        processo.setNome(prt.getjTextFieldNome().getText());
        processo.setDescricao(prt.getjTextAreaDescricao().getText());
        
        if(processo.setProcessos()){
             prt.getUse().carregaFormulario(prt.getAnterior());
             prt.getAnterior().repaint();
             prt.getAnterior().revalidate();
        return true;
        }else{return false;}
    }
    
    public ArrayList<ModelObjeto> listarObjetos() throws CloneNotSupportedException{
     
        return processo.getObjetos();
    }

    public void validaTela(MenuPrincipal menu){
        
        menu.getjButtonObjeto().setEnabled(false);
        menu.getjButtonRisco().setEnabled(false);
       
        if(usuario.getP_gestor()){
            menu.getjButtonObjeto().setEnabled(true);
        }
        if(usuario.getP_auditor()){
            menu.getjButtonRisco().setEnabled(true);
        }
    
    }
     
    public void abrirObjeto(main main) throws CloneNotSupportedException{
    
        objeto prt03 = new objeto();
    
        prt03.setPrincipal(main);
        prt03.getObjeto().setUsuario(usuario);
        prt03.getObjeto().setObjeto(new ModelObjeto());
        prt03.getObjeto().getObjeto().setIdProcesso(processo.getIdProcessos());
        prt03.getObjeto().setProcesso(this);
        main.getCartao01().removeAll();
        main.getCartao01().add(prt03);
        
        prt03.getObjeto().carregarFormulario(prt03);
        main.getCartao01().repaint();
        main.getCartao01().revalidate();
        
        
    }

    public void abrirMitigacao(main main) throws CloneNotSupportedException{
    
        mitigacao prt03 = new mitigacao();
    
        prt03.setPrincipal(main);
        prt03.getMitigacao().setUsuario(usuario);
        prt03.getMitigacao().setMitigacao(new ModelMitigacao());
        prt03.getMitigacao().getMitigacao().setIdProcesso(processo.getIdProcessos());
        prt03.getMitigacao().setProcesso(this);
        main.getCartao01().removeAll();
        main.getCartao01().add(prt03);
        
        prt03.getMitigacao().carregarFormulario(prt03);
        main.getCartao01().repaint();
        main.getCartao01().revalidate();
        
        
    }
    
    public ArrayList<ModelMitigacao> listarMitigacoes() throws CloneNotSupportedException{
    
        return processo.getMitigacoes();
    }
   
    public ArrayList<ModelRisco> listarRiscos() throws CloneNotSupportedException{
     
        return processo.getRiscos();
    }
    
    public void abrirRisco(main main) throws CloneNotSupportedException{
    
        risco prt03 = new risco();
    
        prt03.setPrincipal(main);
        prt03.getRisco().setUsuario(usuario);
        prt03.getRisco().setRisco(new ModelRisco());
        prt03.getRisco().getRisco().setIdProcesso(processo.getIdProcessos());
        prt03.getRisco().setProcesso(this);
        main.getCartao01().removeAll();
        main.getCartao01().add(prt03);
        
        prt03.getRisco().carregarFormulario(prt03);
        main.getCartao01().repaint();
        main.getCartao01().revalidate();
        
    }
    
    public mapaRisco exibirMapaRisco(){
        mapaRisco map=new mapaRisco();
        System.out.println(processo.getNome());
        map.getMapa().setProcesso(processo);
        try {
            map.getMapa().desenharMapaDeRisco(map);
            return map;
        } catch (CloneNotSupportedException ex) {
            return null;
        }
       
    }
    
    public mapaEficacia exibirMapaEficacia() {
            mapaEficacia map=new mapaEficacia();
            map.getMapa().setProcesso(processo);
        try {
            map.getMapa().desenharMapaDeEficacia(map);
            return map;
        } catch (CloneNotSupportedException ex) {
            return null;
        }
    }
    
    public boolean sair(main principal){
    
       ControllUsuario use=new ControllUsuario();
       ListaProcesso menu = new ListaProcesso();

       use.setUsuario(usuario);
       principal.getCartao01().removeAll();
       principal.getCartao01().add(menu);
       menu.setPrincipal(principal);
       menu.setUse(use);
        try {
            use.carregaFormulario(menu);
        } catch (CloneNotSupportedException ex) {
            return false;
        }
       
       principal.getCartao01().repaint();
       principal.getCartao01().revalidate();
       return true;
    }
    
    public boolean excluir(ListaProcesso menu) throws CloneNotSupportedException{
        if(processo.excluir()){
            
            menu.getUse().carregaFormulario(menu);
            return true;
        }
        return false;
        
    }
    
    public ModelProcessos getProcesso() {
        return processo;
    }

    public void setProcesso(ModelProcessos processo) {
        this.processo = processo;
    }

    public ModelUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(ModelUsuario usuario) {
        this.usuario = usuario;
    }

    

    
    
    
}
