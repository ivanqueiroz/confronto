package br.com.confronto.view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author Ivan Queiroz <ivanqueiroz@gmail.com>
 */
public class VerificaEmail extends InputVerifier {

    public boolean verify(JComponent input) {
        JTextField jtfEmail = (JTextField) input;


        Pattern p = Pattern.compile("([a-zA-Z/\\d_\\\\\\.]+@([a-zA-Z\\d_\\\\\\.]+)" +
                "(\\.[a-zA-Z\\d]{2,4}))|([a-zA-Z/\\d_\\\\\\.]+@)" +
                "[\\d]{1,3}\\.[\\d]{1,3}\\.[\\d]{1,3}\\.[\\d]{1,3}");

        Matcher m = p.matcher(jtfEmail.getText());

        if (m.matches()) {
            return true;
        } else {
            return false;
        }
    }

}
