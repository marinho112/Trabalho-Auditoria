/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import model.ModelEficacia;
import model.ModelMitigacao;
import model.ModelObjeto;
import model.ModelObjetoRisco;
import model.ModelRisco;
import model.ModelUsuario;
import view.CriarRelacao;
import view.MenuPrincipal;
import view.mitigacao;
import view.main;

/**
 *
 * @author Racca
 */
public class ControllMitigacao {
    
    private ModelMitigacao mitigacao=new ModelMitigacao();
    private ModelUsuario usuario=new ModelUsuario();
    private ControllProcessos processo;
    private ArrayList<ModelMitigacao> mitigacoes=new ArrayList<>();
    private ArrayList<ModelEficacia> eficacias=new ArrayList<>();
    private DefaultListModel cell;
    
    
    private String traduzRisco(int i){
        if(i<1){
              return "Muito Baixa";
            }else if(i<3){
              return "Baixa";
            }else if(i<5){
              return "Média";
            }else if(i<7){
              return "Alta";
            }else{
              return "Perfeita";
            }
    }
    
    private void validaTela(mitigacao menu){
        
        menu.getjButtonAdicionarEficacia().setEnabled(false);
        menu.getjButtonCriar().setEnabled(false);
        menu.getjButtonExcluir().setEnabled(false);
        menu.getjButtonExcluirEficacia().setEnabled(false);

                
       
        if(usuario.getP_gestor()){
            menu.getjButtonCriar().setEnabled(true);
            menu.getjButtonExcluir().setEnabled(true);
        }
        if(usuario.getP_auditor()){
            menu.getjButtonAdicionarEficacia().setEnabled(true);
            menu.getjButtonExcluirEficacia().setEnabled(true);
        }
    }
    
    public void carregarFormulario(mitigacao mit) throws CloneNotSupportedException{
        
        int i,x;
        DefaultTableModel tabela=(DefaultTableModel)mit.getjTableEficacias().getModel();
        String[] dados={"0","1","2","3"};
        cell=new DefaultListModel();
        ModelObjetoRisco relacao=new ModelObjetoRisco();
        ModelObjeto objeto=new ModelObjeto();
        ModelRisco risco = new ModelRisco();
        //Carregar variaveis
        main main = mit.getPrincipal();
        ModelUsuario use=mit.getMitigacao().getUsuario();
        //Carregar Campos Principais
        
        mit.getjTextFieldNome().setText(mitigacao.getNome());
        mit.getjTextAreaDescricao().setText(mitigacao.getDescricao());
        
        //Carregar Lista Mitigações
        mitigacoes=processo.getProcesso().getMitigacoes();
        for(i=0;i<mitigacoes.size();i++){
            cell.addElement(mitigacoes.get(i).getNome());
        }
        mit.getjListMitigacoes().setModel(cell);
        
        //Carregar Tabela Eficacias
        eficacias=mitigacao.getEficacias();
        while(tabela.getRowCount()>0){
            tabela.removeRow(0);
        }
        for(i=0;i<eficacias.size();i++){
            risco.getRiscoById(eficacias.get(i).getIdRisco());
            objeto.getObjetoById(eficacias.get(i).getIdObjeto());
            relacao.getObjetoRiscoById(eficacias.get(i).getIdRisco(),eficacias.get(i).getIdObjeto());
            dados[0]=objeto.getNome();
            dados[1]=risco.getNome();
            x=(int)((((int)relacao.getImpacto())+((int)relacao.getProbabilidade()))/2);
            dados[2]=traduzRisco(x);
            dados[3]=traduzRisco(eficacias.get(i).getEficacia());
            tabela.addRow(dados);
        }
        // Verificar se Todos os Objetos já possuem relação com o Risco
        ArrayList<ModelObjetoRisco> relacoes=new ArrayList<>();
        relacoes=processo.getProcesso().getRelacoes();
        /*if(eficacias.size()==relacoes.size()){
        mit.getjButtonAdicionarEficacia().setEnabled(false);
        }*/

        
        
        validaTela(mit);
        mit.getjListMitigacoes().setSelectedIndex(0);
        mit.repaint();
        mit.revalidate();
    }
    
    public boolean criarMitigacao(mitigacao view) throws CloneNotSupportedException{
        
        mitigacao=new ModelMitigacao();
        mitigacao.setIdProcesso(processo.getProcesso().getIdProcessos());
        this.carregarFormulario(view);
        
        view.repaint();
        view.revalidate();
        return true;
    }
    
    public boolean editarMitigacao(mitigacao view) throws CloneNotSupportedException{
        
        mitigacao= mitigacoes.get(view.getjListMitigacoes().getSelectedIndex());
        this.carregarFormulario(view);
        
        
        return true;
    }
    
    public boolean adicionarEficacia(mitigacao tela) throws CloneNotSupportedException{
        
        CriarRelacao relacao=new CriarRelacao();
        relacao.getEficacia().setMitigacao(this);
        relacao.setAnterior(tela);
        
        CardLayout lay = ((CardLayout)relacao.getjPanelCard().getLayout());
        lay.show(relacao.getjPanelCard(),"card3");
        
        relacao.getEficacia().carregarFormulario(relacao);
        relacao.repaint();
        relacao.revalidate();
        relacao.setVisible(true); 
        
        return true;
    }
    
    public boolean salvarFormulario(mitigacao tela) throws CloneNotSupportedException {
        mitigacao.setNome(tela.getjTextFieldNome().getText());
        mitigacao.setDescricao(tela.getjTextAreaDescricao().getText());
        mitigacao.setMitigacao();
        carregarFormulario(tela);
        return true;
        
    }
    
    /*ArrayList<ModelRisco> getRiscosRelacionados() throws CloneNotSupportedException{
    return mitigacao.getRiscos();
    }s*/

    public boolean excluirEficacia (mitigacao tela) throws CloneNotSupportedException{
        eficacias.get(tela.getjTableEficacias().getSelectedRow()).excluir();
        this.carregarFormulario(tela);
        return true ;
        
    
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
    
    public boolean excluirMitigacao (mitigacao tela) throws CloneNotSupportedException{
        mitigacao.excluir();
        carregarFormulario(tela);
        return true;
    
    }
    
    public ModelMitigacao getMitigacao() {
        return mitigacao;
    }

    public ModelUsuario getUsuario() {
        return usuario;
    }

    public void setMitigacao(ModelMitigacao mitigacao) {
        this.mitigacao = mitigacao;
    }

    public void setUsuario(ModelUsuario usuario) {
        this.usuario = usuario;
    }



    public void setProcesso(ControllProcessos processo) {
        this.processo = processo;
    }

    public ControllProcessos getProcesso() {
        return processo;
    }

    public ArrayList<ModelEficacia> getEficacias() {
        return eficacias;
    }

    

    
            
            
    
}
