package Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import ModelDAO.Model.BudgetPrevisionnel;
import ModelDAO.Model.BudgetPrevisionnelDAO;
import ModelDAO.Model.Classe;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class NouvelleAnneeController implements Initializable{

    @FXML
    private TextField annee2;

    @FXML
    private TextField annee1;

    @FXML
    private CheckBox check_oui;

    @FXML
    private Button commencer;
    
    public static String anneeScolaire;
    
    public static BudgetPrevisionnel budgetPrevisionnel;
    
    public static ArrayList<Classe> listClasses = new ArrayList<Classe>();
    
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		commencer.setDisable(true);
		annee1.setDisable(true);
		annee2.setDisable(true);
	}
	
	public void Check() {
		if (check_oui.isSelected()) {
			commencer.setDisable(false);
			annee1.setDisable(false);
			annee2.setDisable(false);
		}
		else {
			commencer.setDisable(true);
			annee1.setDisable(true);
			annee2.setDisable(true);
		}
	}
	
	public void Commencer() {
		BudgetPrevisionnelDAO budgetPrevisionnelDAO = new BudgetPrevisionnelDAO();
		int max = budgetPrevisionnelDAO.Max();
		budgetPrevisionnelDAO.close();
		
		anneeScolaire = annee1.getText() + "/" + annee2.getText();
		
		budgetPrevisionnel = new BudgetPrevisionnel(max+1, anneeScolaire, 1);
		
		IntroAcceuilController.win.close();
	}


}
