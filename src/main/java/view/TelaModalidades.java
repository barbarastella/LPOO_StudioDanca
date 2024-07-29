package view;

import br.edu.ifsul.cc.lpoo_studiodanca.dao.PersistenciaJPA;
import br.edu.ifsul.cc.lpoo_studiodanca.model.Modalidade;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class TelaModalidades extends javax.swing.JFrame {

    private PersistenciaJPA persistencia;
    private DefaultListModel listModelModalidades;
         
    public TelaModalidades() {
        initComponents();
        persistencia = new PersistenciaJPA();
        
        listModelModalidades = new DefaultListModel<>();
        lstModalidades.setModel(listModelModalidades);
        getModalidades();
    }

    private void getModalidades() {
        listModelModalidades.clear();
        List<Modalidade> modalidades = persistencia.getModalidades();
        
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblModalidades.setText("Modalidades");

        btnNovo.setText("Adicionar nova");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        lstModalidades.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lstModalidades);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblModalidades)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(btnNovo))
                    .addComponent(jScrollPane1))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblModalidades)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNovo)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed

        String modalidade = JOptionPane.showInputDialog(this, "Insira o nome da nova modalidade:", "Adicionar nova", JOptionPane.PLAIN_MESSAGE);

        if (modalidade != null && !modalidade.trim().isEmpty()) {
            persistencia.addModalidade(modalidade);
            getModalidades();
        } else {
            JOptionPane.showMessageDialog(this, "ERRO! O nome da modalidade não pode ser vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnNovoActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaModalidades().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNovo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblModalidades;
    private javax.swing.JList<String> lstModalidades;
    // End of variables declaration//GEN-END:variables
}
