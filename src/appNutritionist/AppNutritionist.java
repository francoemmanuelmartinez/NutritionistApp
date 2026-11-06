package appNutritionist;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.SwingUtilities;
import appNutritionist.controller.PatientController;
import appNutritionist.model.Patient;
import appNutritionist.view.PatientView;

public class AppNutritionist {

    public static void main(String[] args) {

        //Con esta linea se activa el tema visual Flatlaf
        FlatLightLaf.setup();
        // Redondeo de esquinas en toda la aplicación (en píxeles):
        javax.swing.UIManager.put("Button.arc", 999);        // Botones bien redondeados (usamos el valor 999 para forma de píldora total)
        javax.swing.UIManager.put("TextComponent.arc", 12); // Cajas de texto (JTextField) redondeadas
        javax.swing.UIManager.put("Component.arc", 12);     // Comboboxes y otros controles redondeados
        
        SwingUtilities.invokeLater (()->{
            PatientView vista = new PatientView();
            new PatientController(new Patient(),vista);
            vista.setVisible(true);
        });
    }
}
