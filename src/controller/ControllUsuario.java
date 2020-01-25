    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import model.ModelProcessos;
import model.ModelUsuario;
import view.CriarProcesso;
import view.main;
import view.ListaProcesso;
import view.MenuPrincipal;

/**
 *
 * @author Racca
 */
public class ControllUsuario {
    
    private ModelUsuario usuario = new ModelUsuario();
    private ArrayList<ModelProcessos> processos;
    
    
    public boolean login(String login,String senha){
        return usuario.executaLogin(login,senha); 
 
    }
    
    public boolean criarProcesso(ListaProcesso menu) throws CloneNotSupportedException {
        CriarProcesso proc = new CriarProcesso();
        proc.getProcesso().getProcesso().setIdUsuario(usuario.getIdUsuario());
        proc.setAnterior(menu);
        proc.setUse(this);
        proc.getProcesso().setUsuario(usuario);
        proc.setVisible(true); 
        
       return true;
    }

    public void editarProcesso(ListaProcesso menu,main main) throws CloneNotSupportedException{
        MenuPrincipal prt02 = new MenuPrincipal();
        prt02.setPrincipal(main);
        processos= usuario.getProcessosAll();
        prt02.getProcesso().setProcesso(processos.get(menu.getjListProcessos().getSelectedIndex()));
        prt02.getProcesso().setUsuario(usuario);
        prt02.getProcesso().validaTela(prt02);
        main.getCartao01().removeAll();
        main.getCartao01().add(prt02);
        prt02.getjLabelNomeProcesso().setText("Processo: "+prt02.getProcesso().getProcesso().getNome());
       //prt02.getProcesso().carregarFormulario(prt02);
        main.getCartao01().repaint();
        main.getCartao01().revalidate();
    }
    
    public ModelUsuario getUsuario() {
        return usuario;
    }
    
    private void validaTela(ListaProcesso menu){
        
        menu.getjButtonCriarProcesso().setEnabled(false);
        menu.getjButtonExcluir().setEnabled(false);
        if(usuario.getP_gestor()){
            menu.getjButtonCriarProcesso().setEnabled(true);
            menu.getjButtonExcluir().setEnabled(true);
        }
    
    }
    
    public boolean carregaFormulario(ListaProcesso menu) throws CloneNotSupportedException{
        JLabel label =menu.getLblNomeUsuario();
        JList list = menu.getjListProcessos();
        int i;
        label.setText("Usuário: "+usuario.getNome());
        processos= usuario.getProcessosAll();
        
           
        DefaultListModel cell=new DefaultListModel();
        for(i=0;i<processos.size();i++){
            cell.addElement(processos.get(i).getNome());
        }
        list.setModel(cell);
        if(i>0){list.setSelectedIndex(0);}
        validaTela(menu);
        return true;
    }
    
     public boolean logoff(){
          return usuario.logoff();
      }  
    
    public ArrayList<ModelProcessos> listarProcessos() throws CloneNotSupportedException{
        return usuario.getProcessos();
    }

    public void setUsuario(ModelUsuario usuario) {
        this.usuario = usuario;
    }

    public ArrayList<ModelProcessos> getProcessos() {
        return processos;
    }
    
    
}
