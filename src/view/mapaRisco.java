/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllMapa;
import javax.swing.JList;

/**
 *
 * @author Racca
 */
public class mapaRisco extends javax.swing.JPanel {

    private ControllMapa mapa=new ControllMapa();
    public mapaRisco() {
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

        jScrollPane22 = new javax.swing.JScrollPane();
        jList22 = new javax.swing.JList<>();
        jScrollPane02 = new javax.swing.JScrollPane();
        jList02 = new javax.swing.JList<>();
        jScrollPane01 = new javax.swing.JScrollPane();
        jList01 = new javax.swing.JList<>();
        jScrollPane20 = new javax.swing.JScrollPane();
        jList20 = new javax.swing.JList<>();
        jScrollPane10 = new javax.swing.JScrollPane();
        jList10 = new javax.swing.JList<>();
        jScrollPane00 = new javax.swing.JScrollPane();
        jList00 = new javax.swing.JList<>();
        jScrollPane11 = new javax.swing.JScrollPane();
        jList11 = new javax.swing.JList<>();
        jScrollPane12 = new javax.swing.JScrollPane();
        jList12 = new javax.swing.JList<>();
        jScrollPane21 = new javax.swing.JScrollPane();
        jList21 = new javax.swing.JList<>();
        jLabelImpacto = new javax.swing.JLabel();
        jLabelProbabilidade = new javax.swing.JLabel();
        jLabelProbabilidadeGrande = new javax.swing.JLabel();
        jLabelProbabilidadeMedio = new javax.swing.JLabel();
        jLabelProbabilidadeBaixo = new javax.swing.JLabel();
        jLabelImpactoBaixo = new javax.swing.JLabel();
        jLabelImpactoMedio = new javax.swing.JLabel();
        jLabelImpactoGrande = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));

        jScrollPane22.setMaximumSize(new java.awt.Dimension(266, 200));
        jScrollPane22.setMinimumSize(new java.awt.Dimension(240, 174));
        jScrollPane22.setPreferredSize(new java.awt.Dimension(240, 174));

        jList22.setBackground(new java.awt.Color(255, 0, 0));
        jList22.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList22.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jList22.setDoubleBuffered(true);
        jList22.setLayoutOrientation(javax.swing.JList.VERTICAL_WRAP);
        jList22.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jList22MouseMoved(evt);
            }
        });
        jScrollPane22.setViewportView(jList22);

        jScrollPane02.setMaximumSize(new java.awt.Dimension(266, 200));
        jScrollPane02.setMinimumSize(new java.awt.Dimension(240, 174));
        jScrollPane02.setPreferredSize(new java.awt.Dimension(240, 174));

        jList02.setBackground(new java.awt.Color(255, 153, 0));
        jList02.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList02.setLayoutOrientation(javax.swing.JList.VERTICAL_WRAP);
        jList02.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jList02MouseMoved(evt);
            }
        });
        jScrollPane02.setViewportView(jList02);

        jScrollPane01.setMaximumSize(new java.awt.Dimension(266, 200));
        jScrollPane01.setMinimumSize(new java.awt.Dimension(240, 174));
        jScrollPane01.setPreferredSize(new java.awt.Dimension(240, 174));

        jList01.setBackground(new java.awt.Color(151, 255, 0));
        jList01.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList01.setLayoutOrientation(javax.swing.JList.VERTICAL_WRAP);
        jList01.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jList01MouseMoved(evt);
            }
        });
        jScrollPane01.setViewportView(jList01);

        jScrollPane20.setMaximumSize(new java.awt.Dimension(266, 200));
        jScrollPane20.setMinimumSize(new java.awt.Dimension(240, 174));
        jScrollPane20.setPreferredSize(new java.awt.Dimension(240, 174));

        jList20.setBackground(new java.awt.Color(255, 153, 0));
        jList20.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList20.setLayoutOrientation(javax.swing.JList.VERTICAL_WRAP);
        jList20.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jList20MouseMoved(evt);
            }
        });
        jScrollPane20.setViewportView(jList20);

        jScrollPane10.setMaximumSize(new java.awt.Dimension(266, 200));
        jScrollPane10.setMinimumSize(new java.awt.Dimension(240, 174));
        jScrollPane10.setPreferredSize(new java.awt.Dimension(240, 174));

        jList10.setBackground(new java.awt.Color(151, 255, 0));
        jList10.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList10.setLayoutOrientation(javax.swing.JList.VERTICAL_WRAP);
        jList10.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jList10MouseMoved(evt);
            }
        });
        jScrollPane10.setViewportView(jList10);

        jScrollPane00.setMaximumSize(new java.awt.Dimension(266, 200));
        jScrollPane00.setMinimumSize(new java.awt.Dimension(240, 174));
        jScrollPane00.setPreferredSize(new java.awt.Dimension(240, 174));

        jList00.setBackground(new java.awt.Color(0, 255, 0));
        jList00.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList00.setLayoutOrientation(javax.swing.JList.VERTICAL_WRAP);
        jList00.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jList00MouseMoved(evt);
            }
        });
        jScrollPane00.setViewportView(jList00);

        jScrollPane11.setBorder(null);
        jScrollPane11.setMaximumSize(new java.awt.Dimension(266, 200));
        jScrollPane11.setMinimumSize(new java.awt.Dimension(240, 174));
        jScrollPane11.setPreferredSize(new java.awt.Dimension(240, 174));

        jList11.setBackground(new java.awt.Color(255, 153, 0));
        jList11.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList11.setLayoutOrientation(javax.swing.JList.VERTICAL_WRAP);
        jList11.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jList11MouseMoved(evt);
            }
        });
        jScrollPane11.setViewportView(jList11);

        jScrollPane12.setMaximumSize(new java.awt.Dimension(266, 200));
        jScrollPane12.setMinimumSize(new java.awt.Dimension(240, 174));
        jScrollPane12.setPreferredSize(new java.awt.Dimension(240, 174));

        jList12.setBackground(new java.awt.Color(255, 51, 51));
        jList12.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList12.setLayoutOrientation(javax.swing.JList.VERTICAL_WRAP);
        jList12.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jList12MouseMoved(evt);
            }
        });
        jScrollPane12.setViewportView(jList12);

        jScrollPane21.setMaximumSize(new java.awt.Dimension(266, 200));
        jScrollPane21.setMinimumSize(new java.awt.Dimension(240, 174));
        jScrollPane21.setPreferredSize(new java.awt.Dimension(240, 174));

        jList21.setBackground(new java.awt.Color(255, 51, 51));
        jList21.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList21.setLayoutOrientation(javax.swing.JList.VERTICAL_WRAP);
        jList21.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jList21MouseMoved(evt);
            }
        });
        jScrollPane21.setViewportView(jList21);

        jLabelImpacto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelImpacto.setText("Impacto");

        jLabelProbabilidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelProbabilidade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProbabilidade.setText("Probabilidade");

        jLabelProbabilidadeGrande.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelProbabilidadeGrande.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProbabilidadeGrande.setText("Grande");

        jLabelProbabilidadeMedio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelProbabilidadeMedio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProbabilidadeMedio.setText("Médio");

        jLabelProbabilidadeBaixo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelProbabilidadeBaixo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProbabilidadeBaixo.setText("Baixo");

        jLabelImpactoBaixo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelImpactoBaixo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImpactoBaixo.setText("Baixo");

        jLabelImpactoMedio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelImpactoMedio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImpactoMedio.setText("Médio");

        jLabelImpactoGrande.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelImpactoGrande.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImpactoGrande.setText("Grande");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelProbabilidadeGrande, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelProbabilidadeMedio, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelProbabilidadeBaixo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 9, Short.MAX_VALUE)
                        .addComponent(jLabelImpacto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(4, 4, 4)
                            .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(4, 4, 4)
                            .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(4, 4, 4)
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(4, 4, 4)
                            .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabelImpactoBaixo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane00, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jScrollPane01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelImpactoMedio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jScrollPane02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelImpactoGrande, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))))))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabelProbabilidade)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelProbabilidade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabelProbabilidadeGrande)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(jLabelProbabilidadeMedio)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane00, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelProbabilidadeBaixo)
                                .addGap(81, 81, 81))))
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelImpactoBaixo)
                    .addComponent(jLabelImpactoMedio)
                    .addComponent(jLabelImpactoGrande)
                    .addComponent(jLabelImpacto))
                .addGap(16, 16, 16))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jList20MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList20MouseMoved
       if(jList20.getSelectedIndex()!=-1){
        int indx=jList20.getSelectedIndex();
        mapa.dialog(0,2, indx);
        jList20.clearSelection();
        }
    }//GEN-LAST:event_jList20MouseMoved

    private void jList12MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList12MouseMoved
        if(jList12.getSelectedIndex()!=-1){
        int indx=jList12.getSelectedIndex();
        mapa.dialog(2,1, indx);
        jList12.clearSelection();
        }
    }//GEN-LAST:event_jList12MouseMoved

    private void jList00MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList00MouseMoved
       if(jList00.getSelectedIndex()!=-1){
        int indx=jList00.getSelectedIndex();
        mapa.dialog(0,0, indx);
        jList00.clearSelection();
        }
    }//GEN-LAST:event_jList00MouseMoved

    private void jList01MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList01MouseMoved
        if(jList01.getSelectedIndex()!=-1){
        int indx=jList01.getSelectedIndex();
        mapa.dialog(1,0, indx);
        jList01.clearSelection();
        }
    }//GEN-LAST:event_jList01MouseMoved

    private void jList02MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList02MouseMoved
        if(jList02.getSelectedIndex()!=-1){
        int indx=jList02.getSelectedIndex();
        mapa.dialog(2,0, indx);
        jList02.clearSelection();
        }
    }//GEN-LAST:event_jList02MouseMoved

    private void jList10MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList10MouseMoved
        if(jList10.getSelectedIndex()!=-1){
        int indx=jList10.getSelectedIndex();
        mapa.dialog(0,1, indx);
        jList10.clearSelection();
        }
    }//GEN-LAST:event_jList10MouseMoved

    private void jList11MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList11MouseMoved
        if(jList11.getSelectedIndex()!=-1){
        int indx=jList11.getSelectedIndex();
        mapa.dialog(1,1, indx);
        jList11.clearSelection();
        }
    }//GEN-LAST:event_jList11MouseMoved

    private void jList21MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList21MouseMoved
        if(jList21.getSelectedIndex()!=-1){
        int indx=jList21.getSelectedIndex();
        mapa.dialog(1,2, indx);
        jList21.clearSelection();
        }
    }//GEN-LAST:event_jList21MouseMoved

    private void jList22MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList22MouseMoved
        if(jList22.getSelectedIndex()!=-1){
        int indx=jList22.getSelectedIndex();
        mapa.dialog(2,2, indx);
        jList22.clearSelection();
        }
    }//GEN-LAST:event_jList22MouseMoved
    
 
    public JList<String> getjList00() {
        return jList00;
    }

    public JList<String> getjList01() {
        return jList01;
    }

    public JList<String> getjList02() {
        return jList02;
    }

    public JList<String> getjList10() {
        return jList10;
    }

    public JList<String> getjList11() {
        return jList11;
    }

    public void setMapa(ControllMapa mapa) {
        this.mapa = mapa;
    }

    public ControllMapa getMapa() {
        return mapa;
    }

    public JList<String> getjList12() {
        return jList12;
    }

    public JList<String> getjList20() {
        return jList20;
    }

    public JList<String> getjList21() {
        return jList21;
    }

    public JList<String> getjList22() {
        return jList22;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelImpacto;
    private javax.swing.JLabel jLabelImpactoBaixo;
    private javax.swing.JLabel jLabelImpactoGrande;
    private javax.swing.JLabel jLabelImpactoMedio;
    private javax.swing.JLabel jLabelProbabilidade;
    private javax.swing.JLabel jLabelProbabilidadeBaixo;
    private javax.swing.JLabel jLabelProbabilidadeGrande;
    private javax.swing.JLabel jLabelProbabilidadeMedio;
    private javax.swing.JList<String> jList00;
    private javax.swing.JList<String> jList01;
    private javax.swing.JList<String> jList02;
    private javax.swing.JList<String> jList10;
    private javax.swing.JList<String> jList11;
    private javax.swing.JList<String> jList12;
    private javax.swing.JList<String> jList20;
    private javax.swing.JList<String> jList21;
    private javax.swing.JList<String> jList22;
    private javax.swing.JScrollPane jScrollPane00;
    private javax.swing.JScrollPane jScrollPane01;
    private javax.swing.JScrollPane jScrollPane02;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    // End of variables declaration//GEN-END:variables
}
