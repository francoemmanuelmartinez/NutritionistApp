package appNutritionist.Controller;

import appNutritionist.Models.modelAliment;
import appNutritionist.Models.modelPatient;
import appNutritionist.Views.viewAliment;
import appNutritionist.Views.viewPatient;

public class controllerPatient {
    
    private final modelPatient model;
    private final viewPatient view;
    
    public controllerPatient (modelPatient model, viewPatient view)
    {
        this.model=model;
        this.view=view;
        
        view.alimentBt.addActionListener(e -> {
            // 1. Cierra y libera los recursos de la vista actual
            view.dispose();
            
            // 2. Inicializa la vista y el controlador de destino en el Event Dispatch Thread
            javax.swing.SwingUtilities.invokeLater(() -> {
                viewAliment vistaAliment = new viewAliment();
                new controllerAliment(new modelAliment(), vistaAliment);
                vistaAliment.setVisible(true);
            });
        });
    }
}
