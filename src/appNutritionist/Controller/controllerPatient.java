package appNutritionist.Controller;

import appNutritionist.Models.Aliment;
import appNutritionist.Models.Patient;
import appNutritionist.Views.viewAliment;
import appNutritionist.Views.viewPatient;

public class controllerPatient {
    
    private final Patient model;
    private final viewPatient view;
    
    public controllerPatient (Patient model, viewPatient view)
    {
        this.model=model;
        this.view=view;
        
        view.getBtnAliment().addActionListener(e -> {
            // 1. Cierra y libera los recursos de la vista actual
            view.dispose();
            
            // 2. Inicializa la vista y el controlador de destino en el Event Dispatch Thread
            javax.swing.SwingUtilities.invokeLater(() -> {
                viewAliment vistaAliment = new viewAliment();
                new controllerAliment(new Aliment(), vistaAliment);
                vistaAliment.setVisible(true);
            });
        });
    }
}
