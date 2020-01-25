/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllProcessos;
import controller.ControllUsuario;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import model.ModelProcessos;

/**
 *
 * @author Racca
 */
public class ListaProcesso extends javax.swing.JPanel{
    private ControllUsuario use = new ControllUsuario();
    private main principal;
    public int muda=0;
    public ListaProcesso() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNomeUsuario = new javax.swing.JLabel();
        jScrollPaneProcessos = new javax.swing.JScrollPane();
        jListProcessos = new javax.swing.JList<>();
        lblListaProcessos = new javax.swing.JLabel();
        jButtonCriarProcesso = new javax.swing.JButton();
        jButtonEditarProcesso = new javax.swing.JButton();
        jButtonLogoff = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(800, 600));
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                formPropertyChange(evt);
            }
        });

        lblNomeUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNomeUsuario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNomeUsuario.setText("NomeUsuario");
        lblNomeUsuario.setMinimumSize(new java.awt.Dimension(222, 17));
        lblNomeUsuario.setPreferredSize(new java.awt.Dimension(50, 17));

        jListProcessos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Oi", " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListProcessos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPaneProcessos.setViewportView(jListProcessos);

        lblListaProcessos.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblListaProcessos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblListaProcessos.setText("Lista Processos");

        jButtonCriarProcesso.setText("Criar Processo");
        jButtonCriarProcesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCriarProcessoActionPerformed(evt);
            }
        });

        jButtonEditarProcesso.setText("Selecionar Processo");
        jButtonEditarProcesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarProcessoActionPerformed(evt);
            }
        });

        jButtonLogoff.setText("Sair");
        jButtonLogoff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogoffActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(jButtonEditarProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(jButtonCriarProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(131, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblNomeUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonLogoff, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(215, 215, 215))
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblListaProcessos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPaneProcessos))
                .addGap(100, 100, 100))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonLogoff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(lblListaProcessos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneProcessos, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEditarProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCriarProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButtonLogoffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogoffActionPerformed
           principal.Logoff();
    }//GEN-LAST:event_jButtonLogoffActionPerformed

    private void jButtonCriarProcessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCriarProcessoActionPerformed
        try {
            use.criarProcesso(this);
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(ListaProcesso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonCriarProcessoActionPerformed

    private void jButtonEditarProcessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarProcessoActionPerformed
        try {
            use.editarProcesso(this,principal);
        } catch (CloneNotSupportedException ex) {
            JOptionPane.showMessageDialog(null, "Falha no Processo", "Erro ao Editar Processo!", JOptionPane.ERROR_MESSAGE, null);

        }
    }//GEN-LAST:event_jButtonEditarProcessoActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        if(JOptionPane.showConfirmDialog(null,"Tem certeza que deseja Excluir?",
                "CUIDADO OPERAÇÂO IRREVERSIVEL!",
                JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION){
            ControllProcessos processo=new ControllProcessos();
            processo.setProcesso(use.getProcessos().get(jListProcessos.getSelectedIndex()));
            try {
                if(processo.excluir(this)){
                    JOptionPane.showMessageDialog(null, "Excluido com Sucesso", "Excluido!", JOptionPane.INFORMATION_MESSAGE, null);
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao Excluir Processo", "Erro ao Excluir!", JOptionPane.ERROR_MESSAGE, null);
                }
            } catch (CloneNotSupportedException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao Excluir Processo", "Erro ao Excluir!", JOptionPane.ERROR_MESSAGE, null);
            }
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void formPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_formPropertyChange
        if(muda==1){
            this.repaint();
            this.revalidate();
            muda=0;
        }
    }//GEN-LAST:event_formPropertyChange

    public JButton getjButtonCriarProcesso() {
        return jButtonCriarProcesso;
    }

    public JButton getjButtonEditarProcesso() {
        return jButtonEditarProcesso;
    }

    public JButton getjButtonLogoff() {
        return jButtonLogoff;
    }

    public JList<String> getjListProcessos() {
        return jListProcessos;
    }

    public JLabel getLblNomeUsuario() {
        return lblNomeUsuario;
    }

    public ControllUsuario getUse() {
        return use;
    }

    public void setUse(ControllUsuario use) {
        this.use = use;
    }

    public void setPrincipal(main principal) {
        this.principal = principal;
    }

    public main getPrincipal() {
        return principal;
    }

    public JButton getjButtonExcluir() {
        return jButtonExcluir;
    }
    

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCriarProcesso;
    private javax.swing.JButton jButtonEditarProcesso;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonLogoff;
    private javax.swing.JList<String> jListProcessos;
    private javax.swing.JScrollPane jScrollPaneProcessos;
    private javax.swing.JLabel lblListaProcessos;
    private javax.swing.JLabel lblNomeUsuario;
    // End of variables declaration//GEN-END:variables
}