/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllObjeto;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

/**
 *
 * @author Racca
 */
public class objeto extends javax.swing.JPanel {
        
    private ControllObjeto objeto = new ControllObjeto();
    private main principal;
    /**
     * Creates new form objeto
     */
    public objeto() {
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

        jTextFieldNome = new javax.swing.JTextField();
        jLabelNome = new javax.swing.JLabel();
        jScrollPaneRiscos = new javax.swing.JScrollPane();
        jListObjetos = new javax.swing.JList<>();
        jScrollPaneDescricao = new javax.swing.JScrollPane();
        jTextPaneDescricao = new javax.swing.JTextPane();
        jLabelObjetos = new javax.swing.JLabel();
        jLabelDescricao = new javax.swing.JLabel();
        jButtonCriarObjeto = new javax.swing.JButton();
        jButtonEditarObjeto = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jButtonExcluirObjeto = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(800, 600));

        jTextFieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeActionPerformed(evt);
            }
        });
        jTextFieldNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldNomeKeyPressed(evt);
            }
        });

        jLabelNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNome.setText("Nome do Objeto");

        jListObjetos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListObjetos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPaneRiscos.setViewportView(jListObjetos);

        jScrollPaneDescricao.setViewportView(jTextPaneDescricao);

        jLabelObjetos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelObjetos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelObjetos.setText("Objetos");

        jLabelDescricao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDescricao.setText("Descrição");

        jButtonCriarObjeto.setText("Criar Objeto");
        jButtonCriarObjeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCriarObjetoActionPerformed(evt);
            }
        });

        jButtonEditarObjeto.setText("Editar Objeto");
        jButtonEditarObjeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarObjetoActionPerformed(evt);
            }
        });

        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonExcluirObjeto.setText("Excluir Objeto");
        jButtonExcluirObjeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirObjetoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelObjetos, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPaneRiscos, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButtonExcluirObjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(jButtonEditarObjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldNome)
                            .addComponent(jScrollPaneDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                            .addComponent(jLabelNome)
                            .addComponent(jLabelDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jButtonCriarObjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                        .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(168, 168, 168))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelObjetos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPaneRiscos, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonExcluirObjeto)
                            .addComponent(jButtonEditarObjeto)
                            .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelNome)
                        .addGap(5, 5, 5)
                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jLabelDescricao)
                        .addGap(7, 7, 7)
                        .addComponent(jScrollPaneDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonCriarObjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(51, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeActionPerformed

    private void jButtonEditarObjetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarObjetoActionPerformed
        try {
            if(objeto.editarObjeto(this)){
            }else{
                JOptionPane.showMessageDialog(null, "Erro ao Selecionar Objeto", "Erro ao Selecionar!", JOptionPane.ERROR_MESSAGE, null);
            }
        } catch (CloneNotSupportedException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Selecionar Objeto", "Erro ao Selecionar!", JOptionPane.ERROR_MESSAGE, null);
        }
    }//GEN-LAST:event_jButtonEditarObjetoActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
       if(objeto.voltar(principal)){
       }else{
            JOptionPane.showMessageDialog(null, "Erro ao voltar pro Processo", "Erro ao Voltar!", JOptionPane.ERROR_MESSAGE, null);
       }
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jButtonCriarObjetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCriarObjetoActionPerformed
        try {
            if(objeto.criarObjeto(this)){
            }else{
                JOptionPane.showMessageDialog(null, "Erro ao Criar Processo", "Erro ao Criar!", JOptionPane.ERROR_MESSAGE, null);
            }
        } catch (CloneNotSupportedException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Criar Processo", "Erro ao Criar!", JOptionPane.ERROR_MESSAGE, null);
        }
    }//GEN-LAST:event_jButtonCriarObjetoActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        if(jTextPaneDescricao.getSelectionEnd()>1000){
            JOptionPane.showMessageDialog(null, "Limite-se a 1000 caracteres para esse campo.", "Descrição Muito Grande", JOptionPane.ERROR_MESSAGE, null);
            return;
        }
        try {
            if(objeto.salvarFormulario(this)){
                JOptionPane.showMessageDialog(null, "Salvo com Sucesso", "Salvo!", JOptionPane.INFORMATION_MESSAGE, null);
            }else{
                JOptionPane.showMessageDialog(null, "Erro ao Salvar Objeto", "Erro ao Salvar!", JOptionPane.ERROR_MESSAGE, null);
            }
        } catch (CloneNotSupportedException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Salvar Objeto", "Erro ao Salvar!", JOptionPane.ERROR_MESSAGE, null);
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jTextFieldNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNomeKeyPressed
        if(jTextFieldNome.getText().getBytes().length>50){
           // JOptionPane.showMessageDialog(null,"Numero excessimo de Caracteres, limite de 35 caracteres","Erro na Senha",JOptionPane.ERROR_MESSAGE,null);
            char[] nome=jTextFieldNome.getText().toCharArray();
            String novoNome="";
            int i;
            for(i=0;i<51;i++){
               novoNome+=nome[i];
            }
            jTextFieldNome.setText(novoNome);
        }
    }//GEN-LAST:event_jTextFieldNomeKeyPressed

    private void jButtonExcluirObjetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirObjetoActionPerformed
        if(JOptionPane.showConfirmDialog(null,"Tem certeza que deseja Excluir?",
                "CUIDADO OPERAÇÂO IRREVERSIVEL!",
                JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION){
            try {
                if(objeto.excluirObjeto(this)){
                    JOptionPane.showMessageDialog(null, "Excluido com Sucesso", "Excluido!", JOptionPane.INFORMATION_MESSAGE, null);
                }else{
                    JOptionPane.showMessageDialog(null, "Erro ao Excluir Objeto", "Erro ao Excluir!", JOptionPane.ERROR_MESSAGE, null);
                }
            } catch (CloneNotSupportedException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao Excluir Objeto", "Erro ao Excluir!", JOptionPane.ERROR_MESSAGE, null);
            }
        }
    }//GEN-LAST:event_jButtonExcluirObjetoActionPerformed

    public ControllObjeto getObjeto() {
        return objeto;
    }

    public main getPrincipal() {
        return principal;
    }

    public JList<String> getjListObjetos() {
        return jListObjetos;
    }

    public JTextField getjTextFieldNome() {
        return jTextFieldNome;
    }

    public JTextPane getjTextPaneDescricao() {
        return jTextPaneDescricao;
    }

    public void setObjeto(ControllObjeto objeto) {
        this.objeto = objeto;
    }

    public void setPrincipal(main principal) {
        this.principal = principal;
    }

    public void setjListObjetos(JList<String> jListObjetos) {
        this.jListObjetos = jListObjetos;
    }

    public void setjTextFieldNome(JTextField jTextFieldNome) {
        this.jTextFieldNome = jTextFieldNome;
    }

    public void setjTextPaneDescricao(JTextPane jTextPaneDescricao) {
        this.jTextPaneDescricao = jTextPaneDescricao;
    }





    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCriarObjeto;
    private javax.swing.JButton jButtonEditarObjeto;
    private javax.swing.JButton jButtonExcluirObjeto;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabelDescricao;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelObjetos;
    private javax.swing.JList<String> jListObjetos;
    private javax.swing.JScrollPane jScrollPaneDescricao;
    private javax.swing.JScrollPane jScrollPaneRiscos;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextPane jTextPaneDescricao;
    // End of variables declaration//GEN-END:variables
}
