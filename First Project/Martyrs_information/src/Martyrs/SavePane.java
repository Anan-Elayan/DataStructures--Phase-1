package Martyrs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.DirectoryChooser;

public class SavePane extends Pane {
	
	private TextField txtpath = new TextField();
	private Button btnActionSave = new Button("Save");

	public SavePane() {
		txtpath.setPromptText("File Name");
		if (btnActionSave.isVisible() == false || txtpath.isVisible() == false) {
			btnActionSave.setVisible(true);
			txtpath.setVisible(true);
		}

		btnActionSave.setLayoutX(120);
		btnActionSave.setPrefWidth(280);
		btnActionSave.setLayoutY(200);
		btnActionSave.setStyle(
				"-fx-background-color:black;-fx-border-color:white;-fx-text-fill:f2bd12;-fx-border-radius:15;-fx-background-radius:15");
		txtpath.setLayoutX(80);
		txtpath.setLayoutY(150);
		txtpath.setPrefWidth(370);

		
		
		btnActionSave.setOnAction(e -> {
			if (txtpath.getText().trim().isEmpty()) {
				new Warning("Set file name before save it");
				return;
			}
			DirectoryChooser directory = new DirectoryChooser();
			File file2 = directory.showDialog(null);
			File file = new File(file2.getAbsolutePath() + "\\" + txtpath.getText().trim() + ".txt");
			FileWriter write;
			try {
				DateFormat format = new SimpleDateFormat("M/d/yyyy");
				write = new FileWriter(file);
				NodeDoubleLinkedList newDouble = GUI.data.getFirt();
				for (int i = 0; i < GUI.data.size(); i++) {
					NodeSigleLinkedList newSingel = newDouble.getListMartyrs().getFirst();
					for (int j = 0; j < newDouble.getListMartyrs().size(); j++) {
						String d = format.format(newSingel.getObjMartyrs().getDateOfDeath());
						write.append(newSingel.getObjMartyrs().getName() + "," + newSingel.getObjMartyrs().getAge()
								+ "," + newDouble.getLocation() + "," + d + "," + newSingel.getObjMartyrs().getGender()
								+ "," + newSingel.getObjMartyrs().getPersonalStatus() + "\n");
						newSingel = newSingel.getNext();
					}
					newDouble = newDouble.getNext();
				}
				write.close();
				new Warning("Success save");
			} catch (IOException e2) {
				new Warning(e2.getMessage());
			}

		});

		this.getChildren().addAll(txtpath, btnActionSave);
	}

}
