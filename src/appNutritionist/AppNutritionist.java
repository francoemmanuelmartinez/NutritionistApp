package appNutritionist;

import javax.swing.SwingUtilities;
import appNutritionist.controller.PatientController;
import appNutritionist.model.Patient;
import appNutritionist.view.PatientView;

public class AppNutritionist {

    public static void main(String[] args) {

        SwingUtilities.invokeLater (()->{
            PatientView vista = new PatientView();
            new PatientController(new Patient(),vista);
            vista.setVisible(true);
        });
    }
}
