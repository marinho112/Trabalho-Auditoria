/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import model.ModelEficacia;
import model.ModelMitigacao;
import model.ModelObjeto;
import model.ModelObjetoRisco;
import model.ModelProcessos;
import model.ModelRisco;
import view.mapaEficacia;
import view.mapaRisco;

/**
 *
 * @author Racca
 */
public class ControllMapa {
    
    private ModelRisco risco = new ModelRisco();
    private ModelMitigacao mitigacao=new ModelMitigacao();
    private ModelObjeto objeto= new ModelObjeto();
    private ModelEficacia eficacia = new ModelEficacia();
    private ModelProcessos processo;
    private static ArrayList<ArrayList<ArrayList<ModelObjetoRisco>>> matrizObjetoRisco = new ArrayList<>();
    private static ArrayList<ArrayList<ArrayList<ModelEficacia>>> matrizEficacia = new ArrayList<>();
    private static ArrayList<ArrayList<DefaultListModel>> cells = new ArrayList<>();

public void calcularMapaDeRisco() throws CloneNotSupportedException{
    //variaveis
    ArrayList<ModelObjetoRisco> relacoes = processo.getRelacoes();
    matrizEficacia=new ArrayList<>();
    matrizObjetoRisco = new ArrayList<>();
    cells=new ArrayList<>();
    ModelObjetoRisco controle;
    byte impacto,probabilidade;
    int i,x,y;
    //inicializar maatrizes NxNx3
    for(i=0;i<3;i++){
       matrizObjetoRisco.add(new ArrayList<>());
       cells.add(new ArrayList<>());
       for(x=0;x<3;x++){
       matrizObjetoRisco.get(i).add(new ArrayList<>());
       cells.get(i).add(new DefaultListModel());
        } 
    }
    
    // preencher matrizes
    for(i=0;i<relacoes.size();i++){
    
        controle=relacoes.get(i);
        impacto=controle.getImpacto();
        probabilidade=controle.getProbabilidade();
        int eixoX=((int)((impacto)/3));
        int eixoY=((int)((probabilidade)/3));
        matrizObjetoRisco.get(eixoX).get(eixoY).add(controle.clone());
        cells.get(eixoX).get(eixoY).addElement(numberDesing(controle.getIdObjeto())+numberDesing(controle.getIdRisco()));
    }
    
   
}

private String numberDesing(int i){
    
    if(i<10){
        return "00"+i;
    }else if(i<100){
        return "0"+i;
    }
    return ""+i;
}

public void desenharMapaDeRisco(mapaRisco mapa) throws CloneNotSupportedException{
    calcularMapaDeRisco();
    mapa.getjList00().setModel(cells.get(0).get(0));
    mapa.getjList01().setModel(cells.get(1).get(0));
    mapa.getjList02().setModel(cells.get(2).get(0));
    mapa.getjList10().setModel(cells.get(0).get(1));
    mapa.getjList11().setModel(cells.get(1).get(1));
    mapa.getjList12().setModel(cells.get(2).get(1));
    mapa.getjList20().setModel(cells.get(0).get(2));
    mapa.getjList21().setModel(cells.get(1).get(2));
    mapa.getjList22().setModel(cells.get(2).get(2));
    
}


void calcularMapaDeEficacia() throws CloneNotSupportedException{

    ArrayList<ModelEficacia> eficaciaInterna = processo.getEficacias();
    ArrayList<ModelObjetoRisco> relacoes = processo.getRelacoes();
    matrizEficacia=new ArrayList<>();
    matrizObjetoRisco = new ArrayList<>();
    cells=new ArrayList<>();
    ModelEficacia controle;
    ModelObjetoRisco relacao = new ModelObjetoRisco();
    byte ixp,efi;
    
    int i,x,y;
    for(i=0;i<5;i++){
       matrizEficacia.add(new ArrayList<>());
       cells.add(new ArrayList<>());
       for(x=0;x<5;x++){
       matrizEficacia.get(i).add(new ArrayList<>());
       cells.get(i).add(new DefaultListModel());
        } 
    }
       
    for(i=0;i<eficaciaInterna.size();i++){
        controle=eficaciaInterna.get(i);
        efi=controle.getEficacia();
        for(x=0;x<relacoes.size();x++){
            if((eficaciaInterna.get(i).getIdObjeto()==relacoes.get(x).getIdObjeto())&&(eficaciaInterna.get(i).getIdRisco()==relacoes.get(x).getIdRisco())){
                relacao=relacoes.get(x);
                break;
            }
        }
        ixp=(byte)((relacao.getImpacto()+relacao.getProbabilidade())/2);
        int eixoX=((int)((efi+1)/2));
        int eixoY=((int)((ixp)/2));
        matrizEficacia.get(eixoX).get(eixoY).add(controle.clone());
        cells.get(eixoX).get(eixoY).addElement(numberDesing(controle.getIdObjeto())+numberDesing(controle.getIdRisco())+numberDesing(controle.getIdMitigacao()));
    }
    
}

public void desenharMapaDeEficacia(mapaEficacia mapa) throws CloneNotSupportedException{
    calcularMapaDeEficacia();
    mapa.getjList00().setModel(cells.get(0).get(0));
    mapa.getjList01().setModel(cells.get(1).get(0));
    mapa.getjList02().setModel(cells.get(2).get(0));
    mapa.getjList03().setModel(cells.get(3).get(0));
    mapa.getjList04().setModel(cells.get(4).get(0));
    mapa.getjList10().setModel(cells.get(0).get(1));
    mapa.getjList11().setModel(cells.get(1).get(1));
    mapa.getjList12().setModel(cells.get(2).get(1));
    mapa.getjList13().setModel(cells.get(3).get(1));
    mapa.getjList14().setModel(cells.get(4).get(1));
    mapa.getjList20().setModel(cells.get(0).get(2));
    mapa.getjList21().setModel(cells.get(1).get(2));
    mapa.getjList22().setModel(cells.get(2).get(2));
    mapa.getjList23().setModel(cells.get(3).get(2));
    mapa.getjList24().setModel(cells.get(4).get(2));
    mapa.getjList30().setModel(cells.get(0).get(3));
    mapa.getjList31().setModel(cells.get(1).get(3));
    mapa.getjList32().setModel(cells.get(2).get(3));
    mapa.getjList33().setModel(cells.get(3).get(3));
    mapa.getjList34().setModel(cells.get(4).get(3));
    mapa.getjList40().setModel(cells.get(0).get(4));
    mapa.getjList41().setModel(cells.get(1).get(4));
    mapa.getjList42().setModel(cells.get(2).get(4));
    mapa.getjList43().setModel(cells.get(3).get(4));
    mapa.getjList44().setModel(cells.get(4).get(4));
    
}

public void dialog(int x,int y,int index){
    String quebraLinha = System.getProperty("line.separator");     
    ModelObjetoRisco relacao=matrizObjetoRisco.get(x).get(y).get(index);
    objeto.getObjetoById(relacao.getIdObjeto());
    risco.getRiscoById(relacao.getIdRisco());
    
    String desc="Objeto: "+objeto.getNome()+quebraLinha+"Risco: "+risco.getNome();
    String titulo = "Relação de Risco " + numberDesing(objeto.getIdObjeto())+numberDesing(risco.getIdRisco());
    JOptionPane.showMessageDialog(null,desc,titulo,JOptionPane.INFORMATION_MESSAGE);
}

public void dialogEficacia(int x,int y,int index){
    String quebraLinha = System.getProperty("line.separator");
    eficacia=matrizEficacia.get(x).get(y).get(index);
    objeto.getObjetoById(eficacia.getIdObjeto());
    risco.getRiscoById(eficacia.getIdRisco());
    mitigacao.getMitigacaoById(eficacia.getIdMitigacao());

    String desc="Objeto: "+objeto.getNome()+quebraLinha+"Risco: "+risco.getNome()+quebraLinha+"Mitigação: "+mitigacao.getNome();
    String titulo = "Eficacia " + numberDesing(objeto.getIdObjeto())
            +numberDesing(risco.getIdRisco())+numberDesing(mitigacao.getIdMitigacao());
    JOptionPane.showMessageDialog(null,desc,titulo,JOptionPane.INFORMATION_MESSAGE);
    
}

    public void setRisco(ModelRisco risco) {
        this.risco = risco;
    }

    public void setMitigacao(ModelMitigacao mitigacao) {
        this.mitigacao = mitigacao;
    }

    public void setObjeto(ModelObjeto objeto) {
        this.objeto = objeto;
    }

    public void setEficacia(ModelEficacia eficacia) {
        this.eficacia = eficacia;
    }

    public void setProcesso(ModelProcessos processo) {
        this.processo = processo;
    }

    public ModelRisco getRisco() {
        return risco;
    }

    public ModelMitigacao getMitigacao() {
        return mitigacao;
    }

    public ModelObjeto getObjeto() {
        return objeto;
    }

    public ModelEficacia getEficacia() {
        return eficacia;
    }

    public ModelProcessos getProcesso() {
        return processo;
    }



}