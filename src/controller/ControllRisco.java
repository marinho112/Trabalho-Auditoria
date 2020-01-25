/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import model.ModelObjeto;
import model.ModelObjetoRisco;
import model.ModelRisco;
import model.ModelUsuario;
import view.CriarRelacao;
import view.main;
import view.MenuPrincipal;
import view.risco;

/**
 *
 * @author Racca
 */
public class ControllRisco {
    
    private ModelRisco risco= new ModelRisco();
    private DefaultListModel cell=new DefaultListModel();
    private ArrayList<ModelRisco> riscos;
    private ArrayList<ModelObjetoRisco> relacoes;        
    private ControllProcessos processo;
    
    private ModelUsuario usuario;


    public boolean carregarFormulario(risco ris) throws CloneNotSupportedException{
        //Variaveis
        int i,x;
        riscos= processo.getProcesso().getRiscos();
        relacoes= risco.getRelacoes();
        ModelObjeto objeto=new ModelObjeto();
        DefaultTableModel tabela=(DefaultTableModel)ris.getjTableObjetos().getModel();
        String[] dados={"0","1","2"};
        cell.clear();
        ris.getjButtonAdicionarRelacao().setEnabled(true);
        
        //criar Campos da lista de Riscos
        for(i=0;i<riscos.size();i++){
            cell.addElement(riscos.get(i).getNome());
        }
        ris.getjListRiscos().setModel(cell);
        //Limpar Tabela
        while(tabela.getRowCount()>0){
            tabela.removeRow(0);
        }
        
        risco.test();
        //Criar Linhas Tabela
        for(i=0;i<relacoes.size();i++){
            objeto.getObjetoById(relacoes.get(i).getIdObjeto());
            dados[0]=objeto.getNome();
            //impacto
            if(relacoes.get(i).getImpacto()<3){
              dados[1]="Baixo";
            }else if(relacoes.get(i).getImpacto()<6){
              dados[1]="Médio";
            }else{
              dados[1]="Alto";
            }
            //Probabilidade
            if(relacoes.get(i).getProbabilidade()<3){
              dados[2]="Baixo";
            }else if(relacoes.get(i).getProbabilidade()<6){
              dados[2]="Médio";
            }else{
              dados[2]="Alto";
            }
            // Verificar se Todos os Objetos já possuem relação com o Risco
            ArrayList<ModelObjeto> objetos=new ArrayList<>();
            objetos=processo.getProcesso().getObjetos();
            if(relacoes.size()==objetos.size()){
                ris.getjButtonAdicionarRelacao().setEnabled(false);
            }
            
        tabela.addRow(dados);
    }
    
    //Carregar Valores do Formulário
    
    ris.getjLabelProcesso().setText("Processo: "+processo.getProcesso().getNome());
    if(i>0){ris.getjListRiscos().setSelectedIndex(0);}
    ris.getjTextFieldNome().setText(risco.getNome());
    ris.getjTextAreaDescricao().setText(risco.getDescricao());
    //selecionar primeira linha da lista
    ris.getjListRiscos().setSelectedIndex(0);
    ris.getjTableObjetos().getSelectionModel().setSelectionInterval(0, 0);
    
    return true;
        
    }
    
     public boolean editarRisco(risco view) throws CloneNotSupportedException{
        
        risco=riscos.get(view.getjListRiscos().getSelectedIndex());
        this.carregarFormulario(view);
        
        view.repaint();
        view.revalidate();
        return true;
    }
    
    public boolean criarRisco(risco view) throws CloneNotSupportedException{
        
        risco=new ModelRisco();
        risco.setIdProcesso(processo.getProcesso().getIdProcessos());
        this.carregarFormulario(view);
        
        view.repaint();
        view.revalidate();
        return true;
    }
    
    public boolean criarRelacao(risco view) throws CloneNotSupportedException{
        
        CriarRelacao objetoRisco=new CriarRelacao();
        objetoRisco.getObjetoRisco().setRisco(this);
        objetoRisco.setAnterior(view);
        
        objetoRisco.getObjetoRisco().carregarFormulario(objetoRisco);
        
        objetoRisco.setVisible(true); 
        
        
        
        
        return true;
    }
    
    
    
    public boolean salvarFormulario(risco ris) throws CloneNotSupportedException{
        risco.setNome(ris.getjTextFieldNome().getText());
        risco.setDescricao(ris.getjTextAreaDescricao().getText());
        
        if(risco.setRisco()){
            this.carregarFormulario(ris);
            ris.repaint();
            ris.revalidate();
            return true;
        }else{
            return false;
        }
    }
    
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

    
    public boolean excluirRisco(risco view) throws CloneNotSupportedException{
        if(riscos.get(view.getjListRiscos().getSelectedIndex()).excluir()){
            risco=riscos.get(0);
            this.carregarFormulario(view);
            
            
            view.repaint();
            view.revalidate();
            return true;
        }else{
            return false;
        }
    }
   
    public boolean excluirRelacao(risco view) throws CloneNotSupportedException{
        if(relacoes.get(view.getjTableObjetos().getSelectedRow()).excluir()){
            
            this.carregarFormulario(view);
            
            
            view.repaint();
            view.revalidate();
            return true;
        }else{
            return false;
        }
    }
    
    

    public ModelRisco getRisco() {
        return risco;
    }

    public void setRisco(ModelRisco risco) {
        this.risco = risco;
    }
    
    public void setUsuario(ModelUsuario usuario) {
        this.usuario = usuario;
    }

    public ModelUsuario getUsuario() {
        return usuario;
    }

    public void setProcesso(ControllProcessos processo) {
        this.processo = processo;
    }

    public ControllProcessos getProcesso() {
        return processo;
    }

    public DefaultListModel getCell() {
        return cell;
    }

    public ArrayList<ModelRisco> getRiscos() {
        return riscos;
    }

    public ArrayList<ModelObjetoRisco> getRelacoes() {
        return relacoes;
    }

    
    
}
