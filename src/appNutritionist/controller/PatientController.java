package appNutritionist.controller;

import appNutritionist.model.Aliment;
import appNutritionist.model.Patient;
import appNutritionist.view.AlimentView;
import appNutritionist.view.PatientView;

public class PatientController {
    
    private final Patient model;
    private final PatientView view;
    
    public PatientController (Patient model, PatientView view)
    {
        this.model=model;
        this.view=view;
        
        view.getBtnAliment().addActionListener(e -> {
            // 1. Cierra y libera los recursos de la vista actual
            view.dispose();
            
            // 2. Inicializa la vista y el controlador de destino en el Event Dispatch Thread
            javax.swing.SwingUtilities.invokeLater(() -> {
                AlimentView vistaAliment = new AlimentView();
                new AlimentController(new Aliment(), vistaAliment);
                vistaAliment.setVisible(true);
            });
        });
    }
}
