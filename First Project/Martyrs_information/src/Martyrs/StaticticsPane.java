package Martyrs;

import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;

public class StaticticsPane extends Pane {

	private TextArea txtArea = new TextArea();
	private Label lblLocatione = new Label("Locatione");
	private Button btnNext = new Button("Next");
	private Button btnPev = new Button("Privious");
	Pane orderPane = new Pane();
	private String btnStyle = "-fx-background-color:black;" + "-fx-border-color:white;"
			+ "-fx-background-radius:10 50 10 50;" + "-fx-border-radius:10 50 10 50;" + "-fx-text-fill:f2bd12";

	public StaticticsPane(NodeDoubleLinkedList nameLocation) {

		this.orderPane.setLayoutY(0);
		this.orderPane.setPrefWidth(600);
		this.orderPane.setPrefHeight(500);

		txtArea.clear();
		lblLocatione.setStyle("-fx-text-fill:cd9b05;-fx-font-size:15");

		lblLocatione.setText("Location: " + nameLocation.getLocation());
		countAges(nameLocation);
		countGender(nameLocation, txtArea, null);
		getAVG(nameLocation, txtArea, null);
		maxDate(nameLocation);

		NodeDoubleLinkedList[] locNode = { nameLocation };

		btnNext.setStyle(btnStyle);
		btnPev.setStyle(btnStyle);

		Font font = Font.font("Arial Black", FontPosture.REGULAR, 10);
		btnNext.setFont(font);
		btnPev.setFont(font);

		btnNext.setOnAction(t -> {
			txtArea.clear();
			locNode[0] = locNode[0].getNext();
			lblLocatione.setText("Location: " + locNode[0].getLocation());
			countAges(locNode[0]);
			countGender(locNode[0], txtArea, null);
			getAVG(locNode[0], txtArea, null);
			maxDate(locNode[0]);
		});

		btnPev.setOnAction(f -> {
			txtArea.clear();
			locNode[0] = locNode[0].getPrevious();
			lblLocatione.setText("Location: " + locNode[0].getLocation());
			countAges(locNode[0]);
			countGender(locNode[0], txtArea, null);
			getAVG(locNode[0], txtArea, null);
			maxDate(locNode[0]);
		});

		lblLocatione.setLayoutX(27);
		lblLocatione.setLayoutY(30);

		btnPev.setPrefHeight(27);
		btnPev.setPrefWidth(102);
		btnPev.setLayoutX(23);
		btnPev.setLayoutY(90);

		btnNext.setPrefHeight(27);
		btnNext.setPrefWidth(102);
		btnNext.setLayoutX(420);
		btnNext.setLayoutY(90);

		txtArea.setPrefHeight(320);
		txtArea.setPrefWidth(490);
		txtArea.setLayoutY(130);
		txtArea.setLayoutX(27);
		txtArea.setEditable(false);

		this.orderPane.getChildren().addAll(txtArea, btnNext, btnPev, lblLocatione);
		this.getChildren().add(this.orderPane);// txtArea, btnNext, btnPev
	}

	public void countAges(NodeDoubleLinkedList nodeDouble) {
		SingelLinkedList tempList = new SingelLinkedList();

		NodeSigleLinkedList nodeSingel = nodeDouble.getListMartyrs().getFirst();
		// O(n)
		while (nodeSingel != null) {
			Martyrs tempMar = new Martyrs(nodeSingel.getObjMartyrs().getName(), nodeSingel.getObjMartyrs().getAge(),
					nodeSingel.getObjMartyrs().getDateOfDeath(), nodeSingel.getObjMartyrs().getGender(),
					nodeSingel.getObjMartyrs().getPersonalStatus());
			tempList.addLast(new NodeSigleLinkedList(tempMar));
			nodeSingel = nodeSingel.getNext();
		}

		nodeSingel = tempList.getFirst();
		// O(n^2)
		for (int i = 0; i < tempList.size(); i++) {
			int countAge = 1;
			if (nodeSingel.getObjMartyrs().getAge() == -1) {
				nodeSingel = nodeSingel.getNext();
				continue;
			}
			NodeSigleLinkedList nodeSinge2 = nodeSingel.getNext();
			for (int j = i + 1; j < tempList.size(); j++) {
				if (nodeSingel.getObjMartyrs().getAge() == nodeSinge2.getObjMartyrs().getAge()) {
					countAge++;
					nodeSinge2.getObjMartyrs().setAge(-1);
				}
				nodeSinge2 = nodeSinge2.getNext();
			}
			txtArea.appendText("Age: " + nodeSingel.getObjMartyrs().getAge() + ", No: " + countAge + "\n");

			nodeSingel = nodeSingel.getNext();
		}
	}

	public static void countGender(NodeDoubleLinkedList nodeDouble, TextArea txtArea, Sammary sammary) {
		NodeSigleLinkedList nodeSingel = nodeDouble.getListMartyrs().getFirst();
		int countF = 0;
		int countM = 0;
		for (int i = 0; i < nodeDouble.getListMartyrs().size(); i++) {
			if (nodeSingel == null) {
				System.out.println(nodeDouble);
				break;
			}
			if (nodeSingel.getObjMartyrs().getGender() == 'F') {
				countF++;
			} else
				countM++;
			nodeSingel = nodeSingel.getNext();
		}
		if (sammary != null) {
			sammary.setNumF(countF);
			sammary.setNumM(countM);
		}
		if (txtArea != null) {
			txtArea.appendText("\n No Femal:" + countF + "  " + "No Male :" + countM);
		}
	}

	public static void getAVG(NodeDoubleLinkedList nodeDouble, TextArea txtArea, Sammary sammary) {
		NodeSigleLinkedList nodeSingel = nodeDouble.getListMartyrs().getFirst();
		int count = 0;
		float AVG = 0;
		for (int i = 0; i < nodeDouble.getListMartyrs().size(); i++) {
			count += nodeSingel.getObjMartyrs().getAge();

			nodeSingel = nodeSingel.getNext();
		}
		AVG = count / nodeDouble.getListMartyrs().size();
		if (sammary != null) {
			sammary.setAvgAge((int) AVG);
		}
		if (txtArea != null) {
			txtArea.appendText("\n The avgerage age is " + AVG);
		}
	}

	public void maxDate(NodeDoubleLinkedList nodeDouble) {
		SingelLinkedList tempList = new SingelLinkedList();

		NodeSigleLinkedList nodeSingel = nodeDouble.getListMartyrs().getFirst();
		// O(n)
		while (nodeSingel != null) {
			Martyrs tempMar = new Martyrs(nodeSingel.getObjMartyrs().getName(), nodeSingel.getObjMartyrs().getAge(),
					nodeSingel.getObjMartyrs().getDateOfDeath(), nodeSingel.getObjMartyrs().getGender(),
					nodeSingel.getObjMartyrs().getPersonalStatus());
			tempList.addLast(new NodeSigleLinkedList(tempMar));
			nodeSingel = nodeSingel.getNext();
		}

		SimpleDateFormat format = new SimpleDateFormat("M/d/yyyy");

		nodeSingel = tempList.getFirst();
		int maxCount = 0;
		Date maxDate = null;
		for (int i = 0; i < tempList.size(); i++) {
			int countDateOfDeath = 1;
			if (nodeSingel.getObjMartyrs().getAge() == -1) {
				nodeSingel = nodeSingel.getNext();
				continue;
			}
			NodeSigleLinkedList nodeSinge2 = nodeSingel.getNext();
			for (int j = i + 1; j < tempList.size(); j++) {
				if (nodeSingel.getObjMartyrs().getDateOfDeath().equals(nodeSinge2.getObjMartyrs().getDateOfDeath())) {
					countDateOfDeath++;
					nodeSingel.getObjMartyrs().setAge(-1);
				}
				nodeSinge2 = nodeSinge2.getNext();
			}
			if (countDateOfDeath > maxCount) {
				maxCount = countDateOfDeath;
				maxDate = nodeSingel.getObjMartyrs().getDateOfDeath();
			}
			nodeSingel = nodeSingel.getNext();
		}
		txtArea.appendText("\n Max Date : " + format.format(maxDate) + " cout = " + maxCount);
	}
}
