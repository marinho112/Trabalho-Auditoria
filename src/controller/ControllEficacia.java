/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.ModelEficacia;
import model.ModelObjeto;
import model.ModelObjetoRisco;
import model.ModelRisco;
import view.CriarRelacao;
import view.mitigacao;

/**
 *
 * @author Racca
 */
public class ControllEficacia {
    
    ControllMitigacao mitigacao=new ControllMitigacao();
    ArrayList<ModelRisco> riscos=new ArrayList<>(); 
    ArrayList<ModelObjeto> objetos=new ArrayList<>(); 
    
    
    
    public boolean carregarFormulario(CriarRelacao criarRelacao) throws CloneNotSupportedException{
        //variaveis
        ArrayList<ModelObjeto> objs=(mitigacao.getProcesso().getProcesso().getObjetos());
        ArrayList<ModelRisco> ris=(mitigacao.getProcesso().getProcesso().getRiscos());
        int i,x;
        boolean y;
        //valores base
        criarRelacao.getjLabelNomeMitigacao().setText("Mitigacao: "+mitigacao.getMitigacao().getNome());
        criarRelacao.getjComboBoxObjeto2().removeAllItems();
        criarRelacao.getjComboBoxRisco().removeAllItems();
        //listBox Objetos
        for(i=0;i<objs.size();i++){
            y=false;
            for(x=0;x<mitigacao.getEficacias().size();x++){
                y=true;
                if(objs.get(i).getIdObjeto()==mitigacao.getEficacias().get(x).getIdObjeto()){
                    
                    break;
                }else{    
                }
            }
            if(y){
                
                objetos.add(objs.get(i));
                criarRelacao.getjComboBoxObjeto2().addItem(objs.get(i).getNome());
            }
        }
         //listBox Riscos
        for(i=0;i<ris.size();i++){
            y=false;
            for(x=0;x<mitigacao.getEficacias().size();x++){
                y=true;
                if(ris.get(i).getIdRisco()==mitigacao.getEficacias().get(x).getIdRisco()){
                    break;
                }else{    
                }
            }
            if(y){
                
                riscos.add(ris.get(i));
                criarRelacao.getjComboBoxRisco().addItem(ris.get(i).getNome());
            }
        }
        
        criarRelacao.repaint();
        criarRelacao.revalidate();
        return true;
    }
    
    public boolean adicionarEficacia(CriarRelacao criarRelacao) throws CloneNotSupportedException{
        ModelEficacia eficacia = new ModelEficacia();
        eficacia.setIdMitigacao(this.getMitigacao().getMitigacao().getIdMitigacao());
       
        eficacia.setIdObjeto(objetos.get(criarRelacao.getjComboBoxObjeto2().getSelectedIndex()).getIdObjeto());
        eficacia.setIdRisco(riscos.get(criarRelacao.getjComboBoxRisco().getSelectedIndex()).getIdRisco());
        
        eficacia.setEficacia((byte)(criarRelacao.getjComboBoxEficacia().getSelectedIndex()*2));
        eficacia.setAtributosEficacia();
        ModelObjetoRisco relacao=new ModelObjetoRisco();
        if(!(relacao.verificaObjetoRiscoById(eficacia.getIdRisco(), eficacia.getIdObjeto()))){
            relacao.setIdObjeto(eficacia.getIdObjeto());
            relacao.setIdRisco(eficacia.getIdRisco());
            relacao.setImpacto((byte)0);
            relacao.setProbabilidade((byte)0);
            relacao.setObjetoRisco();
        }
            
        return this.fechar(criarRelacao);
    }
    
    public boolean fechar(CriarRelacao criarRelacao) throws CloneNotSupportedException{
        criarRelacao.dispose();
        ((mitigacao)criarRelacao.getAnterior()).getMitigacao().carregarFormulario((mitigacao)criarRelacao.getAnterior());
        return true; 
    }
    


    public void setMitigacao(ControllMitigacao mitigacao) {
        this.mitigacao = mitigacao;
    }

    public ControllMitigacao getMitigacao() {
        return mitigacao;
    }
    
    
}
