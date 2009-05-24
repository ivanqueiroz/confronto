/*
 * CadPessoaPanel.java
 *
 * Created on 31/03/2009, 01:16:35
 */
package br.com.confronto.view;

import br.com.confronto.control.Controlador;
import br.com.confronto.model.vo.Cidade;
import br.com.confronto.model.vo.Estado;
import br.com.confronto.model.vo.EstadoCivil;
import br.com.confronto.model.vo.PessoaFisica;
import br.com.confronto.model.vo.Profissao;
import br.com.confronto.model.vo.Sexo;
import br.com.confronto.model.vo.TipoCliente;
import br.com.confronto.util.CidadeComparator;
import br.com.confronto.util.EstadoComparator;
import java.util.Collections;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ivan Queiroz <ivanqueiroz@gmail.com>
 */
public class CadPessoaPanel extends javax.swing.JPanel {

    private static final long serialVersionUID = 1L;

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
        lblSexo = new javax.swing.JLabel();
        cmbSexo = new javax.swing.JComboBox();
        lblNacionalidade = new javax.swing.JLabel();
        jtfNacionalidade = new javax.swing.JTextField();
        jtfNacionalidade.setDocument(new LimitaTextField(30));
        lblEstadoCivil = new javax.swing.JLabel();
        cmbEstadoCivil = new javax.swing.JComboBox();
        lblProfissao = new javax.swing.JLabel();
        cmbProfissao = new javax.swing.JComboBox();
        lblRg = new javax.swing.JLabel();
        jftfRg = new javax.swing.JFormattedTextField();
        lblCPF = new javax.swing.JLabel();
        jftfCPF = new javax.swing.JFormattedTextField();
        lblCTPS = new javax.swing.JLabel();
        jtfCTPS = new javax.swing.JTextField();
        jtfCTPS.setDocument(new LimitaTextField(7));
        jtfPai = new javax.swing.JTextField();
        jtfPai.setDocument(new LimitaTextField(60));
        jtfMae = new javax.swing.JTextField();
        jtfMae.setDocument(new LimitaTextField(60));
        lblPai = new javax.swing.JLabel();
        lblMae = new javax.swing.JLabel();
        jtfNome = new javax.swing.JTextField();
        jtfNome.setDocument(new LimitaTextField(60));
        lblPIS = new javax.swing.JLabel();
        jtfPIS = new javax.swing.JTextField();
        jtfCTPS.setDocument(new LimitaTextField(7));
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
        jftfCep = new javax.swing.JFormattedTextField();
        lblCep = new javax.swing.JLabel();
        jpContato = new javax.swing.JPanel();
        lblTelResidencial = new javax.swing.JLabel();
        jftfTelFixo = new javax.swing.JFormattedTextField();
        jftfCelular = new javax.swing.JFormattedTextField();
        lblCelular = new javax.swing.JLabel();
        lblFax = new javax.swing.JLabel();
        jftfFax = new javax.swing.JFormattedTextField();
        lblFixoIcon = new javax.swing.JLabel();
        lblCelIcon = new javax.swing.JLabel();
        lblFaxIcon = new javax.swing.JLabel();
        lblOutro = new javax.swing.JLabel();
        jftfOutro = new javax.swing.JFormattedTextField();
        lblOutroIcon = new javax.swing.JLabel();
        lblEmailIcon = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        jtfEmail = new javax.swing.JTextField();
        jtfEmail.setDocument(new LimitaTextField(60));
        jpnListagem = new javax.swing.JPanel();
        jspListagem = new javax.swing.JScrollPane();
        jtblListaPessoas = new javax.swing.JTable();

        jpDadosPessoa.setBorder(javax.swing.BorderFactory.createTitledBorder("Pessoa Física"));

        lblTipo.setLabelFor(cmbTipoPessoa);
        lblTipo.setText("Tipo Cliente:");

        cmbTipoPessoa.setModel(getModelTipo());
        cmbTipoPessoa.setMaximumSize(new java.awt.Dimension(28, 20));

        lblNome.setLabelFor(jtfNome);
        lblNome.setText("Nome:");

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

        cmbEstadoCivil.setModel(getModelTipo());

        lblProfissao.setText("Profissão:");

        cmbProfissao.setModel(getModelProfissao());
        cmbProfissao.setAutoscrolls(true);

        lblRg.setLabelFor(jftfRg);
        lblRg.setText("RG:");

        try {
            jftfRg.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblCPF.setText("CPF:");

        try {
            jftfCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblCTPS.setLabelFor(jtfCTPS);
        lblCTPS.setText("CTPS:");

        jtfPai.setMaximumSize(new java.awt.Dimension(6, 20));

        jtfMae.setMaximumSize(new java.awt.Dimension(6, 20));

        lblPai.setLabelFor(jtfPai);
        lblPai.setText("Pai:");

        lblMae.setText("Mãe:");

        jtfNome.setMaximumSize(new java.awt.Dimension(6, 320));

        lblPIS.setLabelFor(jtfPIS);
        lblPIS.setText("PIS:");

        javax.swing.GroupLayout jpDadosPessoaLayout = new javax.swing.GroupLayout(jpDadosPessoa);
        jpDadosPessoa.setLayout(jpDadosPessoaLayout);
        jpDadosPessoaLayout.setHorizontalGroup(
            jpDadosPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDadosPessoaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpDadosPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTipo)
                    .addComponent(lblPai)
                    .addComponent(lblNome)
                    .addComponent(lblRg)
                    .addComponent(lblCTPS)
                    .addComponent(lblEstadoCivil)
                    .addComponent(lblNacionalidade)
                    .addComponent(lblProfissao)
                    .addComponent(lblMae))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDadosPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfPai, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                    .addComponent(jtfNome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                    .addGroup(jpDadosPessoaLayout.createSequentialGroup()
                        .addGroup(jpDadosPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmbEstadoCivil, javax.swing.GroupLayout.Alignment.LEADING, 0, 129, Short.MAX_VALUE)
                            .addComponent(jftfRg, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                            .addComponent(jtfCTPS, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                            .addComponent(jtfNacionalidade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                            .addComponent(cmbTipoPessoa, javax.swing.GroupLayout.Alignment.LEADING, 0, 129, Short.MAX_VALUE))
                        .addGap(31, 31, 31)
                        .addGroup(jpDadosPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCPF)
                            .addComponent(lblSexo)
                            .addComponent(lblPIS))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpDadosPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtfPIS, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                            .addComponent(jftfCPF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                            .addComponent(cmbSexo, javax.swing.GroupLayout.Alignment.LEADING, 0, 129, Short.MAX_VALUE)))
                    .addComponent(cmbProfissao, 0, 321, Short.MAX_VALUE)
                    .addComponent(jtfMae, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpDadosPessoaLayout.setVerticalGroup(
            jpDadosPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDadosPessoaLayout.createSequentialGroup()
                .addGroup(jpDadosPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jpDadosPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblRg)
                    .addGroup(jpDadosPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jftfRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCPF)
                        .addComponent(jftfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDadosPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfCTPS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCTPS)
                    .addComponent(jtfPIS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPIS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDadosPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEstadoCivil)
                    .addComponent(lblSexo)
                    .addComponent(cmbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDadosPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfNacionalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNacionalidade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDadosPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProfissao)
                    .addComponent(cmbProfissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDadosPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTipoPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTipo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDadosPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPai)
                    .addComponent(jtfPai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDadosPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMae))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jpEndereco.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço"));

        lblEndereco.setText("Rua:");

        jtfEndereco.setMaximumSize(new java.awt.Dimension(6, 20));

        lblBairro.setText("Bairro:");

        lblCidade.setText("Cidade:");

        cmbCidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<CIDADE>" }));
        cmbCidade.setEnabled(false);

        cmbEstado.setModel(getModelEstado());
        cmbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEstadoActionPerformed(evt);
            }
        });

        lblEstado.setText("Estado:");

        try {
            jftfCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblCep.setText("Cep:");

        javax.swing.GroupLayout jpEnderecoLayout = new javax.swing.GroupLayout(jpEndereco);
        jpEndereco.setLayout(jpEnderecoLayout);
        jpEnderecoLayout.setHorizontalGroup(
            jpEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEnderecoLayout.createSequentialGroup()
                .addGroup(jpEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpEnderecoLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jpEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblBairro)
                            .addComponent(lblEndereco))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpEnderecoLayout.createSequentialGroup()
                                .addComponent(jtfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)
                                .addComponent(lblEstado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbEstado, 0, 124, Short.MAX_VALUE))
                            .addComponent(jtfEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)))
                    .addGroup(jpEnderecoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblCidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                        .addComponent(lblCep)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jftfCep, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jpEnderecoLayout.setVerticalGroup(
            jpEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEnderecoLayout.createSequentialGroup()
                .addGroup(jpEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEndereco)
                    .addComponent(jtfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBairro)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCidade)
                    .addComponent(jftfCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCep))
                .addContainerGap())
        );

        jpContato.setBorder(javax.swing.BorderFactory.createTitledBorder("Contato"));

        lblTelResidencial.setLabelFor(jftfTelFixo);
        lblTelResidencial.setText("Tel. Fixo:");

        try {
            jftfTelFixo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jftfCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblCelular.setLabelFor(jftfCelular);
        lblCelular.setText("Tel. Celular:");

        lblFax.setLabelFor(jftfFax);
        lblFax.setText("Fax:");

        try {
            jftfFax.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblFixoIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/confronto/resources/telephone.png"))); // NOI18N
        lblFixoIcon.setLabelFor(jftfTelFixo);

        lblCelIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/confronto/resources/phone.png"))); // NOI18N
        lblCelIcon.setLabelFor(jftfCelular);

        lblFaxIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/confronto/resources/printer.png"))); // NOI18N
        lblFaxIcon.setLabelFor(jftfFax);

        lblOutro.setLabelFor(jftfOutro);
        lblOutro.setText("Outro:");

        try {
            jftfOutro.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblOutroIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/confronto/resources/help.png"))); // NOI18N
        lblOutroIcon.setLabelFor(jftfOutro);

        lblEmailIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/confronto/resources/email.png"))); // NOI18N
        lblEmailIcon.setLabelFor(jtfEmail);

        lblEmail.setText("E-mail:");

        jtfEmail.setInputVerifier(new VerificaEmail());

        javax.swing.GroupLayout jpContatoLayout = new javax.swing.GroupLayout(jpContato);
        jpContato.setLayout(jpContatoLayout);
        jpContatoLayout.setHorizontalGroup(
            jpContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpContatoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTelResidencial)
                    .addComponent(lblCelular)
                    .addComponent(lblFax))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpContatoLayout.createSequentialGroup()
                        .addComponent(jftfFax, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFaxIcon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addComponent(lblOutro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jftfOutro, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblOutroIcon))
                    .addGroup(jpContatoLayout.createSequentialGroup()
                        .addComponent(jftfCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCelIcon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addComponent(lblEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEmailIcon))
                    .addGroup(jpContatoLayout.createSequentialGroup()
                        .addComponent(jftfTelFixo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFixoIcon)))
                .addContainerGap())
        );
        jpContatoLayout.setVerticalGroup(
            jpContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpContatoLayout.createSequentialGroup()
                .addGroup(jpContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpContatoLayout.createSequentialGroup()
                        .addGroup(jpContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jftfTelFixo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTelResidencial)
                            .addComponent(lblFixoIcon))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jftfCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCelular)
                            .addComponent(lblCelIcon))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jftfFax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFax)
                            .addComponent(lblFaxIcon)))
                    .addGroup(jpContatoLayout.createSequentialGroup()
                        .addGroup(jpContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jftfOutro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblOutro)
                            .addComponent(lblOutroIcon))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEmailIcon)
                            .addGroup(jpContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblEmail)))))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jpnListagem.setBorder(javax.swing.BorderFactory.createTitledBorder("Listagem"));

        jtblListaPessoas.setModel(getTableModelPessoas());
        jtblListaPessoas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblListaPessoasMouseClicked(evt);
            }
        });
        jspListagem.setViewportView(jtblListaPessoas);

        javax.swing.GroupLayout jpnListagemLayout = new javax.swing.GroupLayout(jpnListagem);
        jpnListagem.setLayout(jpnListagemLayout);
        jpnListagemLayout.setHorizontalGroup(
            jpnListagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnListagemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jspListagem, javax.swing.GroupLayout.DEFAULT_SIZE, 836, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnListagemLayout.setVerticalGroup(
            jpnListagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnListagemLayout.createSequentialGroup()
                .addComponent(jspListagem, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jpnListagem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jpDadosPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jpEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpDadosPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpContato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(jpnListagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleParent(this);
    }// </editor-fold>//GEN-END:initComponents

    public DefaultComboBoxModel getModelSexo() {
        return new DefaultComboBoxModel(new Sexo[]{null, Sexo.getFeminino(), Sexo.getMasculino()});
    }

    public DefaultComboBoxModel getModelTipo() {
        DefaultComboBoxModel modelTipo = null;
        Vector<TipoCliente> listaCombo = Controlador.getInstancia().getListaTipoCliente();
        if (listaCombo != null) {
            modelTipo = new DefaultComboBoxModel(listaCombo);
        }
        return modelTipo;
    }

    public DefaultComboBoxModel getModelProfissao() {
        DefaultComboBoxModel modelProfissao = null;
        Vector<Profissao> listaCombo = Controlador.getInstancia().getListaProfissoes();
        if (listaCombo != null) {
            modelProfissao = new DefaultComboBoxModel(listaCombo);
        }
        return modelProfissao;
    }

    public DefaultComboBoxModel getModelEstadoCivil() {
        DefaultComboBoxModel modelEstadoCivil = null;
        Vector<EstadoCivil> listaCombo = Controlador.getInstancia().getListaEstadosCivis();
        if (listaCombo != null) {
            modelEstadoCivil = new DefaultComboBoxModel(listaCombo);
        }
        return modelEstadoCivil;
    }

    public DefaultComboBoxModel getModelEstado() {
        DefaultComboBoxModel modelEstado = null;
        Vector<Estado> listaCombo = Controlador.getInstancia().getListaEstados();
        Collections.sort(listaCombo, new EstadoComparator());
        if (listaCombo != null) {
            modelEstado = new DefaultComboBoxModel(listaCombo);
        }
        return modelEstado;
    }

    public DefaultComboBoxModel getModelCidade(String siglaUf) {
        DefaultComboBoxModel modelCidade = null;
        Vector<Cidade> listaCombo = Controlador.getInstancia().getListaCidadesByUf(siglaUf);
        Collections.sort(listaCombo, new CidadeComparator());
        if (listaCombo != null) {
            modelCidade = new DefaultComboBoxModel(listaCombo);
        }
        return modelCidade;
    }

    public DefaultTableModel getTableModelPessoas() {
        Vector<String> titulos = new Vector<String>();
        Vector<Object> linhas = new Vector<Object>();
        Vector<PessoaFisica> aux = Controlador.getInstancia().getListaPessoasFisicas();
        for (PessoaFisica pessoaFisica : aux) {
            Vector<Object> colunas = new Vector<Object>();
            colunas.add(pessoaFisica.getId());
            colunas.add(pessoaFisica.getNome());
            colunas.add(pessoaFisica.getRg());
            colunas.add(pessoaFisica.getCpf());
            colunas.add(pessoaFisica.getTelefoneResidencial());
            colunas.add(pessoaFisica.getCelular());

            linhas.add(colunas);
        }

        titulos.add("ID");
        titulos.add("NOME");
        titulos.add("RG");
        titulos.add("CPF");
        titulos.add("TELEFONE");
        titulos.add("CELULAR");

        return new DefaultTableModel(linhas, titulos);
    }

    private void cmbSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSexoActionPerformed
        Sexo sexo = (Sexo) cmbSexo.getSelectedItem();
    }//GEN-LAST:event_cmbSexoActionPerformed

    private void jtblListaPessoasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblListaPessoasMouseClicked
        Long id = (Long) jtblListaPessoas.getValueAt(jtblListaPessoas.getSelectedRow(), 0);
        System.out.println(id);
    }//GEN-LAST:event_jtblListaPessoasMouseClicked

    private void cmbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstadoActionPerformed
        if (!cmbCidade.isEnabled() && cmbEstado.getSelectedIndex() > 0) {
            cmbCidade.setEnabled(true);
        } else if (cmbEstado.getSelectedIndex() <= 0) {
            cmbCidade.setEnabled(false);
            cmbCidade.setModel(new DefaultComboBoxModel(new String[]{"<CIDADE>"}));
        }
        Estado aux = (Estado) cmbEstado.getSelectedItem();
        if (aux != null) {
            cmbCidade.setModel(getModelCidade(aux.getSiglaUf()));
        }
    }//GEN-LAST:event_cmbEstadoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbCidade;
    private javax.swing.JComboBox cmbEstado;
    private javax.swing.JComboBox cmbEstadoCivil;
    private javax.swing.JComboBox cmbProfissao;
    private javax.swing.JComboBox cmbSexo;
    private javax.swing.JComboBox cmbTipoPessoa;
    private javax.swing.JFormattedTextField jftfCPF;
    private javax.swing.JFormattedTextField jftfCelular;
    private javax.swing.JFormattedTextField jftfCep;
    private javax.swing.JFormattedTextField jftfFax;
    private javax.swing.JFormattedTextField jftfOutro;
    private javax.swing.JFormattedTextField jftfRg;
    private javax.swing.JFormattedTextField jftfTelFixo;
    private javax.swing.JPanel jpContato;
    private javax.swing.JPanel jpDadosPessoa;
    private javax.swing.JPanel jpEndereco;
    private javax.swing.JPanel jpnListagem;
    private javax.swing.JScrollPane jspListagem;
    private javax.swing.JTable jtblListaPessoas;
    private javax.swing.JTextField jtfBairro;
    private javax.swing.JTextField jtfCTPS;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfEndereco;
    private javax.swing.JTextField jtfMae;
    private javax.swing.JTextField jtfNacionalidade;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfPIS;
    private javax.swing.JTextField jtfPai;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblCTPS;
    private javax.swing.JLabel lblCelIcon;
    private javax.swing.JLabel lblCelular;
    private javax.swing.JLabel lblCep;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEmailIcon;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblEstadoCivil;
    private javax.swing.JLabel lblFax;
    private javax.swing.JLabel lblFaxIcon;
    private javax.swing.JLabel lblFixoIcon;
    private javax.swing.JLabel lblMae;
    private javax.swing.JLabel lblNacionalidade;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblOutro;
    private javax.swing.JLabel lblOutroIcon;
    private javax.swing.JLabel lblPIS;
    private javax.swing.JLabel lblPai;
    private javax.swing.JLabel lblProfissao;
    private javax.swing.JLabel lblRg;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTelResidencial;
    private javax.swing.JLabel lblTipo;
    // End of variables declaration//GEN-END:variables
}
