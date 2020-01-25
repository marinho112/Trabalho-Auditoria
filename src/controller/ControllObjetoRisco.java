/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.ModelObjeto;
import model.ModelObjetoRisco;
import view.CriarRelacao;
import view.mitigacao;
import view.risco;

/**
 *
 * @author Racca
 */
public class ControllObjetoRisco {
    ControllRisco risco=new ControllRisco();
    ArrayList<ModelObjeto> objetos=new ArrayList<>(); 
    
    public boolean carregarFormulario(CriarRelacao criarRelacao) throws CloneNotSupportedException{
        ArrayList<ModelObjeto> objs=(risco.getProcesso().getProcesso().getObjetos());
        criarRelacao.getjLabelNomeRisco().setText("Risco: "+risco.getRisco().getNome());
        int i,x;
        boolean y;
        criarRelacao.getjComboBoxObjeto().removeAllItems();
        for(i=0;i<objs.size();i++){
            y=true;
            for(x=0;x<risco.getRelacoes().size();x++){
                if(objs.get(i).getIdObjeto()==risco.getRelacoes().get(x).getIdObjeto()){
                    y=false;
                    break;
                }else{
                    
                    
                }
            }
            if(y){
                objetos.add(objs.get(i));
                criarRelacao.getjComboBoxObjeto().addItem(objs.get(i).getNome());
            }
        }
        
        
        criarRelacao.repaint();
        criarRelacao.revalidate();
        return true;
    }
    
    public boolean adicionarRelacao(CriarRelacao criarRelacao) throws CloneNotSupportedException{
        ModelObjetoRisco relacao=new ModelObjetoRisco();
        relacao.setIdRisco(risco.getRisco().getIdRisco());
        relacao.setIdObjeto(objetos.get(criarRelacao.getjComboBoxObjeto().getSelectedIndex()).getIdObjeto());
        relacao.setImpacto((byte)((criarRelacao.getjComboBoxImpacto().getSelectedIndex()*3)+1));
        relacao.setProbabilidade((byte)((criarRelacao.getjComboBoxProbabilidade().getSelectedIndex()*3)+1));
        
        relacao.setObjetoRisco();
        
        return this.fechar(criarRelacao);
    }
    
    public boolean fechar(CriarRelacao criarRelacao) throws CloneNotSupportedException{
        criarRelacao.dispose();
        try{
            ((risco)criarRelacao.getAnterior()).getRisco().carregarFormulario((risco)criarRelacao.getAnterior());
        }catch(IllegalArgumentException e){
            ((mitigacao)criarRelacao.getAnterior()).getMitigacao().carregarFormulario((mitigacao)criarRelacao.getAnterior());  
        }
        return true; 
    }

    public void setRisco(ControllRisco risco) {
        this.risco = risco;
    }

    public ControllRisco getRisco() {
        return risco;
    }

   
    
    
    
    
    
}
