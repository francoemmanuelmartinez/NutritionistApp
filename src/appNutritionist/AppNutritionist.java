package appNutritionist;

import javax.swing.SwingUtilities;
import appNutritionist.Controller.controllerPatient;
import appNutritionist.Models.modelPatient;
import appNutritionist.Views.viewPatient;

public class AppNutritionist {

    public static void main(String[] args) {

        SwingUtilities.invokeLater (()->{
            viewPatient vista = new viewPatient();
            new controllerPatient(new modelPatient(),vista);
            vista.setVisible(true);
        });
    }
}
