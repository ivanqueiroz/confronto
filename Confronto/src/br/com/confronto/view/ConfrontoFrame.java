/*
 * ConfontoFrame.java
 *
 * Created on 28/03/2009, 18:39:52
 */
package br.com.confronto.view;

import java.awt.BorderLayout;

/**
 *
 * @author Ivan Queiroz <ivanqueiroz@gmail.com>
 */
public class ConfrontoFrame extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    private CadPessoaPanel cadPessoaPanel;

    /** Creates new form ConfontoFrame */
    public ConfrontoFrame() {
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

        statusLabel = new javax.swing.JLabel();
        barraMenuPrincipal = new javax.swing.JMenuBar();
        menuCadastro = new javax.swing.JMenu();
        itemCadPessoa = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("confronto"); // NOI18N
        setTitle(bundle.getString("TITULO_CONFRONTO_FRM")); // NOI18N
        setMinimumSize(new java.awt.Dimension(800, 600));
        setName("frmPrincipal"); // NOI18N

        statusLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        statusLabel.setMinimumSize(new java.awt.Dimension(4, 20));
        statusLabel.setPreferredSize(new java.awt.Dimension(4, 20));
        getContentPane().add(statusLabel, java.awt.BorderLayout.PAGE_END);

        menuCadastro.setMnemonic('C');
        menuCadastro.setText("Cadastro");
        menuCadastro.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
                menuCadastroMenuKeyTyped(evt);
            }
        });

        itemCadPessoa.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        itemCadPessoa.setMnemonic('P');
        itemCadPessoa.setText("Pessoas");
        itemCadPessoa.setToolTipText("Cadastro de Pessoas");
        itemCadPessoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemCadPessoaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                itemCadPessoaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                itemCadPessoaMouseExited(evt);
            }
        });
        itemCadPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCadPessoaActionPerformed(evt);
            }
        });
        menuCadastro.add(itemCadPessoa);

        barraMenuPrincipal.add(menuCadastro);

        setJMenuBar(barraMenuPrincipal);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuCadastroMenuKeyTyped(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_menuCadastroMenuKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_menuCadastroMenuKeyTyped

    private void itemCadPessoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemCadPessoaMouseClicked
    }//GEN-LAST:event_itemCadPessoaMouseClicked

    private void itemCadPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCadPessoaActionPerformed
        cadPessoaPanel = new CadPessoaPanel();
        this.getContentPane().add(cadPessoaPanel, BorderLayout.CENTER);
        this.getRootPane().validate();
        
    }//GEN-LAST:event_itemCadPessoaActionPerformed

    private void itemCadPessoaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemCadPessoaMouseEntered
        statusLabel.setText("Controle dos registros de pesssoas físicas.");
    }//GEN-LAST:event_itemCadPessoaMouseEntered

    private void itemCadPessoaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemCadPessoaMouseExited
        statusLabel.setText(null);
    }//GEN-LAST:event_itemCadPessoaMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ConfrontoFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenuPrincipal;
    private javax.swing.JMenuItem itemCadPessoa;
    private javax.swing.JMenu menuCadastro;
    private javax.swing.JLabel statusLabel;
    // End of variables declaration//GEN-END:variables
}
