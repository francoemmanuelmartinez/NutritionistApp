package appNutritionist.Controller;

import appNutritionist.Models.modelAliment;
import appNutritionist.Models.modelPatient;
import appNutritionist.Views.viewAliment;
import appNutritionist.Views.viewPatient;

public class controllerAliment {
    
    private final modelAliment model;
    private final viewAliment view;
    
    public controllerAliment(modelAliment model, viewAliment view) {
        this.model = model;
        this.view = view;
        
        view.jButton1.addActionListener(e -> {
            // 1. Cierra y libera los recursos de la vista actual
            view.dispose();
            
            // 2. Inicializa la vista y el controlador de destino en el Event Dispatch Thread
            javax.swing.SwingUtilities.invokeLater(() -> {
                viewPatient vistaPatient = new viewPatient();
                new controllerPatient(new modelPatient(), vistaPatient);
                vistaPatient.setVisible(true);
            });
        });
    }
}
