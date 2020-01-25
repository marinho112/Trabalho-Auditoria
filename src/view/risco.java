/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllRisco;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Racca
 */
public class risco extends javax.swing.JPanel {
    private ControllRisco risco = new ControllRisco();
    private main principal;
    
    /**
     * Creates new form risco
     */
    public risco() {
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
        jScrollPaneDescricao = new javax.swing.JScrollPane();
        jTextAreaDescricao = new javax.swing.JTextArea();
        jLabelDescricao = new javax.swing.JLabel();
        jLabelObjetos = new javax.swing.JLabel();
        jButtonVoltar = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jScrollPaneRiscos = new javax.swing.JScrollPane();
        jListRiscos = new javax.swing.JList<>();
        jLabelRiscos = new javax.swing.JLabel();
        jLabelProcesso = new javax.swing.JLabel();
        jButtonEditarRisco = new javax.swing.JButton();
        jScrollPaneObjetos = new javax.swing.JScrollPane();
        jTableObjetos = new javax.swing.JTable();
        jButtonExcluirRelacao = new javax.swing.JButton();
        jButtonAdicionarRelacao = new javax.swing.JButton();
        jButtonNovoRisco = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));

        jTextFieldNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldNomeKeyPressed(evt);
            }
        });

        jLabelNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNome.setText("Nome");

        jTextAreaDescricao.setColumns(20);
        jTextAreaDescricao.setRows(5);
        jScrollPaneDescricao.setViewportView(jTextAreaDescricao);

        jLabelDescricao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDescricao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDescricao.setText("Descrição");

        jLabelObjetos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelObjetos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelObjetos.setText("Objetos Relacionados");

        jButtonVoltar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        jButtonSalvar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonSalvar.setText("SALVAR");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonExcluir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonExcluir.setText("Excluir Risco");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jListRiscos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListRiscos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPaneRiscos.setViewportView(jListRiscos);

        jLabelRiscos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelRiscos.setText("Riscos");

        jLabelProcesso.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelProcesso.setText("Processo: Nome do Processo");

        jButtonEditarRisco.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonEditarRisco.setText("Editar Risco");
        jButtonEditarRisco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarRiscoActionPerformed(evt);
            }
        });

        jTableObjetos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Objeto", "Impacto", "Probabilidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPaneObjetos.setViewportView(jTableObjetos);

        jButtonExcluirRelacao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonExcluirRelacao.setText("Excluir Relação");
        jButtonExcluirRelacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirRelacaoActionPerformed(evt);
            }
        });

        jButtonAdicionarRelacao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonAdicionarRelacao.setText("Adicionar Relação");
        jButtonAdicionarRelacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarRelacaoActionPerformed(evt);
            }
        });

        jButtonNovoRisco.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonNovoRisco.setText("Novo Risco");
        jButtonNovoRisco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoRiscoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelProcesso)
                                .addComponent(jLabelRiscos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPaneRiscos, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jButtonEditarRisco, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonNovoRisco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(96, 96, 96)
                        .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabelNome)
                                .addGap(338, 338, 338))
                            .addComponent(jLabelDescricao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButtonExcluirRelacao, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonAdicionarRelacao, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPaneDescricao)
                                .addComponent(jLabelObjetos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPaneObjetos, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNome)
                    .addComponent(jLabelProcesso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelRiscos))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelDescricao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPaneDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelObjetos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPaneObjetos, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPaneRiscos, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonExcluir)
                    .addComponent(jButtonEditarRisco)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonExcluirRelacao)
                        .addComponent(jButtonAdicionarRelacao)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonSalvar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonNovoRisco)
                        .addComponent(jButtonVoltar)))
                .addGap(34, 34, 34))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        
        if(risco.voltar(principal)){
       }else{
           JOptionPane.showMessageDialog(null, "Erro ao voltar pro Objeto", "Erro ao Voltar!", JOptionPane.ERROR_MESSAGE, null);
        
       }
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        if(jTextAreaDescricao.getSelectionEnd()>1000){
            JOptionPane.showMessageDialog(null, "Limite-se a 1000 caracteres para esse campo.", "Descrição Muito Grande", JOptionPane.ERROR_MESSAGE, null);
            return;
        }
        try {
            if(risco.salvarFormulario(this)){
                JOptionPane.showMessageDialog(null, "Salvo com Sucesso", "Salvo!", JOptionPane.INFORMATION_MESSAGE, null);
            }else{
                JOptionPane.showMessageDialog(null, "Erro ao Salvar Risco", "Erro ao Salvar!", JOptionPane.ERROR_MESSAGE, null);
            }
        } catch (CloneNotSupportedException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Salvar Risco", "Erro ao Salvar!", JOptionPane.ERROR_MESSAGE, null);
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        if(JOptionPane.showConfirmDialog(null,"Tem certeza que deseja Excluir?",
                "CUIDADO OPERAÇÂO IRREVERSIVEL!",
                JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION){
            try {
                if(risco.excluirRisco(this)){
                    JOptionPane.showMessageDialog(null, "Excluido com Sucesso", "Excluido!", JOptionPane.INFORMATION_MESSAGE, null);
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao Excluir Risco", "Erro ao Excluir!", JOptionPane.ERROR_MESSAGE, null);
                }
            } catch (CloneNotSupportedException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao Excluir Risco", "Erro ao Excluir!", JOptionPane.ERROR_MESSAGE, null);
            }
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

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

    private void jButtonEditarRiscoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarRiscoActionPerformed
        try {
            risco.editarRisco(this);
        } catch (CloneNotSupportedException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Carregar Risco", "Erro ao Carregar!", JOptionPane.ERROR_MESSAGE, null);
        }
    }//GEN-LAST:event_jButtonEditarRiscoActionPerformed

    private void jButtonNovoRiscoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoRiscoActionPerformed
        try {
            risco.criarRisco(this);
        } catch (CloneNotSupportedException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Carregar Risco", "Erro ao Carregar!", JOptionPane.ERROR_MESSAGE, null);
        }
    }//GEN-LAST:event_jButtonNovoRiscoActionPerformed

    private void jButtonExcluirRelacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirRelacaoActionPerformed
        if(JOptionPane.showConfirmDialog(null,"Tem certeza que deseja Excluir?",
                "CUIDADO OPERAÇÂO IRREVERSIVEL!",
                JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION){    
            try {
                if(risco.excluirRelacao(this)){
                    JOptionPane.showMessageDialog(null, "Excluido com Sucesso", "Excluido!", JOptionPane.INFORMATION_MESSAGE, null);
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao Excluir Risco", "Erro ao Excluir!", JOptionPane.ERROR_MESSAGE, null);
                }
            } catch (CloneNotSupportedException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao Excluir Relação", "Erro ao Excluir!", JOptionPane.ERROR_MESSAGE, null);
            }
        }
    }//GEN-LAST:event_jButtonExcluirRelacaoActionPerformed

    private void jButtonAdicionarRelacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarRelacaoActionPerformed
        try {
            risco.criarRelacao(this);
        } catch (CloneNotSupportedException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Criar Relação", "Erro ao Criar!", JOptionPane.ERROR_MESSAGE, null);
        
        }
    }//GEN-LAST:event_jButtonAdicionarRelacaoActionPerformed

    public ControllRisco getRisco() {
        return risco;
    }

    public main getPrincipal() {
        return principal;
    }

    public JLabel getjLabelProcesso() {
        return jLabelProcesso;
    }

    public JList<String> getjListRiscos() {
        return jListRiscos;
    }

    public JTable getjTableObjetos() {
        return jTableObjetos;
    }

    public JTextArea getjTextAreaDescricao() {
        return jTextAreaDescricao;
    }

    public JTextField getjTextFieldNome() {
        return jTextFieldNome;
    }

    public void setRisco(ControllRisco risco) {
        this.risco = risco;
    }

    public void setPrincipal(main principal) {
        this.principal = principal;
    }

    public void setjLabelProcesso(JLabel jLabelProcesso) {
        this.jLabelProcesso = jLabelProcesso;
    }

    public void setjListRiscos(JList<String> jListRiscos) {
        this.jListRiscos = jListRiscos;
    }

    public void setjTableObjetos(JTable jTableObjetos) {
        this.jTableObjetos = jTableObjetos;
    }

    public void setjTextAreaDescricao(JTextArea jTextAreaDescricao) {
        this.jTextAreaDescricao = jTextAreaDescricao;
    }

    public void setjTextFieldNome(JTextField jTextFieldNome) {
        this.jTextFieldNome = jTextFieldNome;
    }

    public JButton getjButtonAdicionarRelacao() {
        return jButtonAdicionarRelacao;
    }

  


    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionarRelacao;
    private javax.swing.JButton jButtonEditarRisco;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonExcluirRelacao;
    private javax.swing.JButton jButtonNovoRisco;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabelDescricao;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelObjetos;
    private javax.swing.JLabel jLabelProcesso;
    private javax.swing.JLabel jLabelRiscos;
    private javax.swing.JList<String> jListRiscos;
    private javax.swing.JScrollPane jScrollPaneDescricao;
    private javax.swing.JScrollPane jScrollPaneObjetos;
    private javax.swing.JScrollPane jScrollPaneRiscos;
    private javax.swing.JTable jTableObjetos;
    private javax.swing.JTextArea jTextAreaDescricao;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables
}
