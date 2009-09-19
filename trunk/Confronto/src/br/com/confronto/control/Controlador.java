package br.com.confronto.control;

import br.com.confronto.dao.DaoException;
import br.com.confronto.dao.DaoFactory;
import br.com.confronto.dao.EnumTipoDao;
import br.com.confronto.model.vo.Cidade;
import br.com.confronto.model.vo.Estado;
import br.com.confronto.model.vo.EstadoCivil;
import br.com.confronto.model.vo.PessoaFisica;
import br.com.confronto.model.vo.Profissao;
import br.com.confronto.model.vo.TipoCliente;
import br.com.confronto.util.LogControl;
import br.com.confronto.view.CadPessoaPanel;
import br.com.confronto.view.ConfrontoFrame;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ivan Queiroz <ivanqueiroz@gmail.com>
 */
public class Controlador {

    private static final Controlador instancia = new Controlador();
    private ConfrontoFrame confrontoFrame;
    private CadPessoaPanel cadPessoaPanel;

    private Controlador() {
        DaoFactory.getInstancia();
    }

    public static Controlador getInstancia() {
        return instancia;
    }

    public CadPessoaPanel getCadPessoaPanel() {
        if (this.cadPessoaPanel == null) {
            cadPessoaPanel = new CadPessoaPanel();
        }
        return this.cadPessoaPanel;
    }

    public ConfrontoFrame getConfrontoFrame() {
        if (this.confrontoFrame == null) {
            confrontoFrame = new ConfrontoFrame();
        }
        return this.confrontoFrame;
    }

    public Vector<TipoCliente> getListaTipoCliente() {
        Vector<TipoCliente> lista = null;
        try {
             lista = (Vector<TipoCliente>) DaoFactory.getInstancia().getDao(EnumTipoDao.TIPOCLIENTE).obterTodos();
        } catch (DaoException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public Vector<Profissao> getListaProfissoes() {
        Vector<Profissao> lista = null;
        try {
            return (Vector<Profissao>) DaoFactory.getInstancia().getDao(EnumTipoDao.PROFISSAO).obterTodos();
        } catch (DaoException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public Vector<EstadoCivil> getListaEstadosCivis() {

        Vector<EstadoCivil> lista = null;
        try {
            return (Vector<EstadoCivil>) DaoFactory.getInstancia().getDao(EnumTipoDao.ESTADOCIVIL).obterTodos();
        } catch (DaoException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public Vector<Estado> getListaEstados() {
        Vector<Estado> lista = null;
        try {
            return (Vector<Estado>) DaoFactory.getInstancia().getDao(EnumTipoDao.ESTADO).obterTodos();
        } catch (DaoException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public Vector<Cidade> getListaCidadesByUf(String siglaUf) {
        Vector<Cidade> lista = null;
        try {
            return (Vector<Cidade>) DaoFactory.getInstancia().getDao(EnumTipoDao.CIDADE).obterTodos();
        } catch (DaoException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public Vector<PessoaFisica> getListaPessoasFisicas() {
        Vector<PessoaFisica> lista = null;
        try {
            lista = (Vector<PessoaFisica>) DaoFactory.getInstancia().getDao(EnumTipoDao.PESSOAFISICA).obterTodos();
        } catch (DaoException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

        /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    //javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    //javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());

                    javax.swing.UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceBusinessLookAndFeel");
                } catch (Exception e) {
                    LogControl.getInstancia().toLog(this.getClass(), "Erro ao inicializar o sistema " + e.getMessage(), Level.SEVERE);
                }
                Controlador.getInstancia().getConfrontoFrame().setVisible(true);
            }
        });
    }
}
