package appNutritionist.controller;

import appNutritionist.model.Aliment;
import appNutritionist.model.Patient;
import appNutritionist.view.AlimentView;
import appNutritionist.view.PatientView;

public class AlimentController {
    
    private final Aliment model;
    private final AlimentView view;
    
    public AlimentController(Aliment model, AlimentView view) {
        this.model = model;
        this.view = view;
        
        view.getBtnPatient().addActionListener(e -> {
            // 1. Cierra y libera los recursos de la vista actual
            view.dispose();
            
            // 2. Inicializa la vista y el controlador de destino en el Event Dispatch Thread
            javax.swing.SwingUtilities.invokeLater(() -> {
                PatientView vistaPatient = new PatientView();
                new PatientController(new Patient(), vistaPatient);
                vistaPatient.setVisible(true);
            });
        });
    }
}
