/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.joaolucas.projetoestruturadedados;

/**
 *
 * @author joao
 */
public class FrameFila extends javax.swing.JFrame {

    /**
     * Creates new form FrameFila
     */
    public FrameFila() {
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

        PainelMenu = new javax.swing.JPanel();
        btnListaSeq = new javax.swing.JButton();
        btnListaSe = new javax.swing.JButton();
        btnListaDe = new javax.swing.JButton();
        btnPilha = new javax.swing.JButton();
        btnFila = new javax.swing.JButton();
        btnArvore = new javax.swing.JButton();
        frameInterno = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PainelMenu.setBackground(new java.awt.Color(0, 255, 255));

        btnListaSeq.setBackground(new java.awt.Color(0, 255, 255));
        btnListaSeq.setText("Lista Sequencial");
        btnListaSeq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaSeqActionPerformed(evt);
            }
        });

        btnListaSe.setBackground(new java.awt.Color(0, 255, 255));
        btnListaSe.setText("Lista SE");
        btnListaSe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaSeActionPerformed(evt);
            }
        });

        btnListaDe.setBackground(new java.awt.Color(0, 255, 255));
        btnListaDe.setText("Lista DE");
        btnListaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaDeActionPerformed(evt);
            }
        });

        btnPilha.setBackground(new java.awt.Color(0, 255, 255));
        btnPilha.setText("Pilhas");
        btnPilha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPilhaActionPerformed(evt);
            }
        });

        btnFila.setBackground(new java.awt.Color(0, 255, 255));
        btnFila.setText("Filas");
        btnFila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilaActionPerformed(evt);
            }
        });

        btnArvore.setBackground(new java.awt.Color(0, 255, 255));
        btnArvore.setText("Arvore");
        btnArvore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArvoreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PainelMenuLayout = new javax.swing.GroupLayout(PainelMenu);
        PainelMenu.setLayout(PainelMenuLayout);
        PainelMenuLayout.setHorizontalGroup(
            PainelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnListaSeq)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnListaSe, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnListaDe, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPilha, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFila, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnArvore, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        PainelMenuLayout.setVerticalGroup(
            PainelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelMenuLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(PainelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnListaSeq, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(btnListaSe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnListaDe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPilha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFila, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnArvore, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        frameInterno.setVisible(true);

        jLabel1.setText("Filas");

        javax.swing.GroupLayout frameInternoLayout = new javax.swing.GroupLayout(frameInterno.getContentPane());
        frameInterno.getContentPane().setLayout(frameInternoLayout);
        frameInternoLayout.setHorizontalGroup(
            frameInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frameInternoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(329, 329, 329))
        );
        frameInternoLayout.setVerticalGroup(
            frameInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frameInternoLayout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(jLabel1)
                .addContainerGap(213, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(frameInterno)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PainelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(frameInterno))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnListaSeqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaSeqActionPerformed
        FrameListaSeqTamanho frameListaSeqTamanho = new FrameListaSeqTamanho();
        this.dispose();
        frameListaSeqTamanho.setVisible(true);
    }//GEN-LAST:event_btnListaSeqActionPerformed

    private void btnListaSeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaSeActionPerformed
        // TODO add your handling code here:
        FrameListaSe frame = new FrameListaSe();
        this.dispose();
        frame.setVisible(true);
    }//GEN-LAST:event_btnListaSeActionPerformed

    private void btnListaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaDeActionPerformed
        // TODO add your handling code here:
        FrameListaDe frame = new FrameListaDe();
        this.dispose();
        frame.setVisible(true);
        
    }//GEN-LAST:event_btnListaDeActionPerformed

    private void btnPilhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPilhaActionPerformed
        FramePilha frame = new FramePilha();
        this.dispose();
        frame.setVisible(true);
    }//GEN-LAST:event_btnPilhaActionPerformed

    private void btnFilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilaActionPerformed
        FrameFila frame = new FrameFila();
        this.dispose();
        frame.setVisible(true);
    }//GEN-LAST:event_btnFilaActionPerformed

    private void btnArvoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArvoreActionPerformed
        FrameArvore frame = new FrameArvore();
        this.dispose();
        frame.setVisible(true);
    }//GEN-LAST:event_btnArvoreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PainelMenu;
    private javax.swing.JButton btnArvore;
    private javax.swing.JButton btnFila;
    private javax.swing.JButton btnListaDe;
    private javax.swing.JButton btnListaSe;
    private javax.swing.JButton btnListaSeq;
    private javax.swing.JButton btnPilha;
    private javax.swing.JInternalFrame frameInterno;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
