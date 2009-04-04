/*
 * CadPessoaPanel.java
 *
 * Created on 31/03/2009, 01:16:35
 */
package br.com.confronto.view;

import br.com.confronto.dao.factory.DaoFactory;
import br.com.confronto.model.vo.Sexo;
import br.com.confronto.model.vo.Tipo;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Ivan Queiroz <ivanqueiroz@gmail.com>
 */
public class CadPessoaPanel extends javax.swing.JPanel {

    private static final long serialVersionUID = 1L;
    private DefaultComboBoxModel modelSexo;
    private DefaultComboBoxModel modelTipo;

    /** Creates new form CadPessoaPanel */
    public CadPessoaPanel() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        lblNome = new javax.swing.JLabel();
        jtfNome = new javax.swing.JTextField();
        jtfNome.setDocument(new LimitaTextField(60));
        cmbSexo = new javax.swing.JComboBox();
        lblSexo = new javax.swing.JLabel();
        cmbTipoPessoa = new javax.swing.JComboBox();
        lblTipo = new javax.swing.JLabel();

        lblNome.setText("Nome:");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jtfNome, org.jdesktop.beansbinding.ObjectProperty.create(), lblNome, org.jdesktop.beansbinding.BeanProperty.create("labelFor"));
        bindingGroup.addBinding(binding);

        jtfNome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cmbSexo.setModel(getModelSexo());
        cmbSexo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cmbSexo.setMaximumSize(new java.awt.Dimension(28, 20));
        cmbSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSexoActionPerformed(evt);
            }
        });

        lblSexo.setText("Sexo:");

        cmbTipoPessoa.setModel(getModelTipo());
        cmbTipoPessoa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cmbTipoPessoa.setMaximumSize(new java.awt.Dimension(28, 20));

        lblTipo.setText("Tipo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblNome)
                .addGap(18, 18, 18)
                .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSexo)
                    .addComponent(lblTipo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbTipoPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(108, 108, 108))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNome)
                            .addComponent(lblSexo))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTipo)
                            .addComponent(cmbTipoPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(377, 377, 377))
        );

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    public DefaultComboBoxModel getModelSexo() {
        Vector<Sexo> listaCombo = (Vector<Sexo>) DaoFactory.getInstancia().getSexoDao().getLista();
        modelSexo = new DefaultComboBoxModel(listaCombo);
        return modelSexo;
    }

    public DefaultComboBoxModel getModelTipo() {
        Vector<Tipo> listaCombo = (Vector<Tipo>) DaoFactory.getInstancia().getTipoDao().getTipos();
        modelTipo = new DefaultComboBoxModel(listaCombo);
        return modelTipo;
    }

    private void cmbSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSexoActionPerformed
        // TODO add your handling code here:
        Sexo sexo = (Sexo) cmbSexo.getSelectedItem();
        System.out.println(sexo);
    }//GEN-LAST:event_cmbSexoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbSexo;
    private javax.swing.JComboBox cmbTipoPessoa;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTipo;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
