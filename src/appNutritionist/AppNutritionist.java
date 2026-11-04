package appNutritionist;

import javax.swing.SwingUtilities;
import appNutritionist.Controller.controllerPatient;
import appNutritionist.Models.Patient;
import appNutritionist.Views.viewPatient;

public class AppNutritionist {

    public static void main(String[] args) {

        SwingUtilities.invokeLater (()->{
            viewPatient vista = new viewPatient();
            new controllerPatient(new Patient(),vista);
            vista.setVisible(true);
        });
    }
}
