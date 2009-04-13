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
    DaoFactory factory = null;

    /** Creates new form CadPessoaPanel */
    public CadPessoaPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpDadosPessoa = new javax.swing.JPanel();
        lblTipo = new javax.swing.JLabel();
        cmbTipoPessoa = new javax.swing.JComboBox();
        lblNome = new javax.swing.JLabel();
        jtfNome = new javax.swing.JTextField();
        jtfNome.setDocument(new LimitaTextField(60));
        lblSexo = new javax.swing.JLabel();
        cmbSexo = new javax.swing.JComboBox();
        lblNacionalidade = new javax.swing.JLabel();
        jtfNacionalidade = new javax.swing.JTextField();
        jtfNacionalidade.setDocument(new LimitaTextField(30));
        lblEstadoCivil = new javax.swing.JLabel();
        cmbEstadoCivil = new javax.swing.JComboBox();
        lblProfissao = new javax.swing.JLabel();
        cmbProfissao = new javax.swing.JComboBox();
        jplFiliacao = new javax.swing.JPanel();
        lblPai = new javax.swing.JLabel();
        jtfPai = new javax.swing.JTextField();
        jtfPai.setDocument(new LimitaTextField(60));
        lblMae = new javax.swing.JLabel();
        jtfMae = new javax.swing.JTextField();
        jtfMae.setDocument(new LimitaTextField(60));
        lblTelResidencial = new javax.swing.JLabel();
        jftfTelResidencial = new javax.swing.JFormattedTextField();
        jpEndereco = new javax.swing.JPanel();
        lblEndereco = new javax.swing.JLabel();
        jtfEndereco = new javax.swing.JTextField();
        jtfEndereco.setDocument(new LimitaTextField(300));
        lblBairro = new javax.swing.JLabel();
        jtfBairro = new javax.swing.JTextField();
        jtfBairro.setDocument(new LimitaTextField(20));
        lblCidade = new javax.swing.JLabel();
        cmbCidade = new javax.swing.JComboBox();
        cmbEstado = new javax.swing.JComboBox();
        lblEstado = new javax.swing.JLabel();
        lblCep = new javax.swing.JLabel();
        jtfCep = new javax.swing.JTextField();

        setMaximumSize(new java.awt.Dimension(750, 600));
        setMinimumSize(new java.awt.Dimension(750, 600));
        setPreferredSize(new java.awt.Dimension(750, 600));

        jpDadosPessoa.setBorder(javax.swing.BorderFactory.createTitledBorder("Pessoa Física"));

        lblTipo.setLabelFor(cmbTipoPessoa);
        lblTipo.setText("Tipo:");

        cmbTipoPessoa.setModel(getModelTipo());
        cmbTipoPessoa.setMaximumSize(new java.awt.Dimension(28, 20));

        lblNome.setLabelFor(jtfNome);
        lblNome.setText("Nome:");

        jtfNome.setMaximumSize(new java.awt.Dimension(6, 20));

        lblSexo.setLabelFor(cmbSexo);
        lblSexo.setText("Sexo:");

        cmbSexo.setModel(getModelSexo());
        cmbSexo.setMaximumSize(new java.awt.Dimension(28, 20));
        cmbSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSexoActionPerformed(evt);
            }
        });

        lblNacionalidade.setLabelFor(jtfNacionalidade);
        lblNacionalidade.setText("Nacionalidade:");

        lblEstadoCivil.setText("Estado Civil:");

        cmbEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblProfissao.setText("Profissão:");

        cmbProfissao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jplFiliacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Filiação"));

        lblPai.setLabelFor(jtfPai);
        lblPai.setText("Pai:");

        jtfPai.setMaximumSize(new java.awt.Dimension(6, 20));

        lblMae.setText("Mãe:");

        jtfMae.setMaximumSize(new java.awt.Dimension(6, 20));

        javax.swing.GroupLayout jplFiliacaoLayout = new javax.swing.GroupLayout(jplFiliacao);
        jplFiliacao.setLayout(jplFiliacaoLayout);
        jplFiliacaoLayout.setHorizontalGroup(
            jplFiliacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplFiliacaoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblPai)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtfPai, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblMae)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtfMae, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jplFiliacaoLayout.setVerticalGroup(
            jplFiliacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplFiliacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jplFiliacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfPai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPai)
                    .addComponent(lblMae)
                    .addComponent(jtfMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblTelResidencial.setText("Tel. residencial:");

        try {
            jftfTelResidencial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jpDadosPessoaLayout = new javax.swing.GroupLayout(jpDadosPessoa);
        jpDadosPessoa.setLayout(jpDadosPessoaLayout);
        jpDadosPessoaLayout.setHorizontalGroup(
            jpDadosPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDadosPessoaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpDadosPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDadosPessoaLayout.createSequentialGroup()
                        .addGroup(jpDadosPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpDadosPessoaLayout.createSequentialGroup()
                                .addComponent(lblNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblSexo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(lblTipo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbTipoPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpDadosPessoaLayout.createSequentialGroup()
                                .addComponent(lblNacionalidade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfNacionalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblEstadoCivil)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblProfissao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbProfissao, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(59, 59, 59))
                    .addGroup(jpDadosPessoaLayout.createSequentialGroup()
                        .addComponent(jplFiliacao, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(14, Short.MAX_VALUE))
                    .addGroup(jpDadosPessoaLayout.createSequentialGroup()
                        .addComponent(lblTelResidencial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jftfTelResidencial, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                        .addGap(587, 587, 587))))
        );
        jpDadosPessoaLayout.setVerticalGroup(
            jpDadosPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDadosPessoaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpDadosPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTipoPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSexo)
                    .addComponent(lblTipo)
                    .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpDadosPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfNacionalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNacionalidade)
                    .addComponent(lblEstadoCivil)
                    .addComponent(cmbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProfissao)
                    .addComponent(cmbProfissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpDadosPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelResidencial)
                    .addComponent(jftfTelResidencial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jplFiliacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jpEndereco.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço"));

        lblEndereco.setText("Rua:");

        jtfEndereco.setMaximumSize(new java.awt.Dimension(6, 20));

        lblBairro.setText("Bairro:");

        lblCidade.setText("Cidade:");

        cmbCidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblEstado.setText("Estado:");

        lblCep.setText("Cep:");

        javax.swing.GroupLayout jpEnderecoLayout = new javax.swing.GroupLayout(jpEndereco);
        jpEndereco.setLayout(jpEnderecoLayout);
        jpEnderecoLayout.setHorizontalGroup(
            jpEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEnderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEndereco)
                    .addComponent(lblCep))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpEnderecoLayout.createSequentialGroup()
                        .addComponent(jtfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblBairro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfBairro, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
                    .addGroup(jpEnderecoLayout.createSequentialGroup()
                        .addComponent(jtfCep, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblCidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblEstado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(895, 895, 895))
        );
        jpEnderecoLayout.setVerticalGroup(
            jpEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEnderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpEnderecoLayout.createSequentialGroup()
                        .addGroup(jpEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEndereco))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblCidade)
                                .addComponent(cmbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblEstado)
                                .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtfCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCep)))
                    .addGroup(jpEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblBairro)))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jpEndereco, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpDadosPessoa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 735, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpDadosPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(181, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleParent(this);
    }// </editor-fold>//GEN-END:initComponents

    public DefaultComboBoxModel getModelSexo() {
        
        modelSexo = new DefaultComboBoxModel(new Sexo[]{null, Sexo.getFeminino(), Sexo.getMaculino()});
        return modelSexo;
    }

    public DefaultComboBoxModel getModelTipo() {
        factory = new DaoFactory();
        Vector<Tipo> listaCombo = (Vector<Tipo>) factory.getTipoDao().getTipos();
        if (listaCombo != null) {
            modelTipo = new DefaultComboBoxModel(listaCombo);
        }
        factory.close();
        return modelTipo;
    }

    private void cmbSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSexoActionPerformed
        Sexo sexo = (Sexo) cmbSexo.getSelectedItem();
        System.out.println(sexo);
    }//GEN-LAST:event_cmbSexoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbCidade;
    private javax.swing.JComboBox cmbEstado;
    private javax.swing.JComboBox cmbEstadoCivil;
    private javax.swing.JComboBox cmbProfissao;
    private javax.swing.JComboBox cmbSexo;
    private javax.swing.JComboBox cmbTipoPessoa;
    private javax.swing.JFormattedTextField jftfTelResidencial;
    private javax.swing.JPanel jpDadosPessoa;
    private javax.swing.JPanel jpEndereco;
    private javax.swing.JPanel jplFiliacao;
    private javax.swing.JTextField jtfBairro;
    private javax.swing.JTextField jtfCep;
    private javax.swing.JTextField jtfEndereco;
    private javax.swing.JTextField jtfMae;
    private javax.swing.JTextField jtfNacionalidade;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfPai;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblCep;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblEstadoCivil;
    private javax.swing.JLabel lblMae;
    private javax.swing.JLabel lblNacionalidade;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPai;
    private javax.swing.JLabel lblProfissao;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTelResidencial;
    private javax.swing.JLabel lblTipo;
    // End of variables declaration//GEN-END:variables
}
