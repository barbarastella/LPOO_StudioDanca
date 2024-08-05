package br.edu.ifsul.cc.lpoo_studiodanca.view;

import br.edu.ifsul.cc.lpoo_studiodanca.dao.PersistenciaJPA;
import br.edu.ifsul.cc.lpoo_studiodanca.model.Modalidade;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class TelaModalidades extends javax.swing.JFrame {

    private PersistenciaJPA jpa;
    private DefaultListModel listModelModalidades;
    Modalidade modalidade;

    public TelaModalidades() {
        initComponents();
        jpa = new PersistenciaJPA();

        listModelModalidades = new DefaultListModel<>();
        lstModalidades.setModel(listModelModalidades);
        getModalidades();
    }

    private void getModalidades() {
        listModelModalidades.clear();
        List<Modalidade> modalidades = jpa.getModalidades();

        for (Modalidade modalidade : modalidades) {
            listModelModalidades.addElement(modalidade);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblModalidades = new javax.swing.JLabel();
        btnNovo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstModalidades = new javax.swing.JList<>();
        btnRemover = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblModalidades.setText("Modalidades");

        btnNovo.setText("Adicionar nova");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(lstModalidades);

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblModalidades)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRemover)
                        .addGap(52, 52, 52)
                        .addComponent(btnEditar)
                        .addGap(48, 48, 48)
                        .addComponent(btnNovo))
                    .addComponent(jScrollPane1))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblModalidades)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnRemover)
                    .addComponent(btnEditar))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed

        TelaCadastroModalidade telaCadastro = new TelaCadastroModalidade();
        telaCadastro.setVisible(true);

        getModalidades();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        Modalidade modalidadeSelecionada = lstModalidades.getSelectedValue();

        if (modalidadeSelecionada != null) {

            int confirmacaoDel = JOptionPane.showConfirmDialog(rootPane, "Tem certeza que deseja remover a modalidade " + modalidadeSelecionada);

            if (confirmacaoDel == JOptionPane.YES_OPTION) {
                try {

                    jpa = new PersistenciaJPA();
                    jpa.conexaoAberta();

                    jpa.remover(modalidadeSelecionada);
                    getModalidades();

                    jpa.fecharConexao();

                } catch (Exception e) {
                    System.err.println("Erro ao excluir modalidade: " + e.getMessage());
                } finally {
                    jpa.fecharConexao();
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Nenhuma modalidade selecionada!");
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        Modalidade modalidadeSelecionada = lstModalidades.getSelectedValue();

        if (modalidadeSelecionada != null) {
            TelaCadastroModalidade telaCadastro = new TelaCadastroModalidade();

            telaCadastro.setModalidade(modalidade);
            telaCadastro.setVisible(true);

            getModalidades();
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaModalidades().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnRemover;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblModalidades;
    private javax.swing.JList<Modalidade> lstModalidades;
    // End of variables declaration//GEN-END:variables
}
