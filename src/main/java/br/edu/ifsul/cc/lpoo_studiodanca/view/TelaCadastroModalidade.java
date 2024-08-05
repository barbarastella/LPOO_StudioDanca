package br.edu.ifsul.cc.lpoo_studiodanca.view;

import br.edu.ifsul.cc.lpoo_studiodanca.dao.PersistenciaJPA;
import br.edu.ifsul.cc.lpoo_studiodanca.model.Modalidade;
import br.edu.ifsul.cc.lpoo_studiodanca.model.Professor;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;

public class TelaCadastroModalidade extends javax.swing.JFrame {

    PersistenciaJPA jpa;
    Modalidade modalidade;

    public TelaCadastroModalidade() {
        initComponents();
        getProfessores();
    }

    public void getProfessores() {
        cmbProfessor.removeAllItems();

        jpa = new PersistenciaJPA();
        jpa.conexaoAberta();

        List<Professor> lista = jpa.getProfessores();

        for (Professor o : lista) {
            cmbProfessor.addItem(o);
        }

        jpa.fecharConexao();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCadastro = new javax.swing.JLabel();
        lblDescricao = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        lblProfessor = new javax.swing.JLabel();
        cmbProfessor = new javax.swing.JComboBox<>();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblCadastro.setText("Cadastro de Modalidade");

        lblDescricao.setText("Descrição");

        txtDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescricaoActionPerformed(evt);
            }
        });

        lblProfessor.setText("Professor");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 200, Short.MAX_VALUE)
                        .addComponent(btnSalvar))
                    .addComponent(lblProfessor, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDescricao, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCadastro, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbProfessor, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblCadastro)
                .addGap(18, 18, 18)
                .addComponent(lblDescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblProfessor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescricaoActionPerformed

    }//GEN-LAST:event_txtDescricaoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

            jpa = new PersistenciaJPA();
            jpa.conexaoAberta();
            
        if (modalidade == null) // situação 1: criar nova modalidade
        {
            modalidade = new Modalidade();
            modalidade.setDescricao(txtDescricao.getText());
            modalidade.setProfessor((Professor) cmbProfessor.getSelectedItem());

            jpa.persist(modalidade);
            jpa.fecharConexao();

            dispose();
        } else { // situação 2: editar modalidade existente
            try {
                Modalidade m = (Modalidade) jpa.find(Modalidade.class, modalidade.getID());
                m.setDescricao(txtDescricao.getText());

                Professor p = (Professor) cmbProfessor.getSelectedItem();
                m.setProfessor(p);

                jpa.persist(m);

                dispose();
            } catch (Exception e) {
                System.err.println("Erro ao editar modalidade: " + e.getMessage());
            } finally {
                jpa.fecharConexao();
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroModalidade().setVisible(true);
            }
        });
    }

    public Modalidade getModalidade() {
        return modalidade;
    }

    public void setModalidade(Modalidade modalidade) {
        this.modalidade = modalidade;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<Professor> cmbProfessor;
    private javax.swing.JLabel lblCadastro;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblProfessor;
    private javax.swing.JTextField txtDescricao;
    // End of variables declaration//GEN-END:variables
}
