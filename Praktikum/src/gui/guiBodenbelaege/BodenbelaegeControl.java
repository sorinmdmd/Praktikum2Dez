package gui.guiBodenbelaege;

import business.TeppichenModel;
import javafx.stage.Stage;
import ownUtil.Observer;

public class BodenbelaegeControl implements Observer {
	private BodenbelaegeView bodenbelaegeView;
	private TeppichenModel teppicheModel;

	public BodenbelaegeControl(Stage primaryStage) {
		this.teppicheModel = teppicheModel.getInstance();
		this.bodenbelaegeView = new BodenbelaegeView(this, primaryStage, teppicheModel);
		teppicheModel.addObserver(this);
	}

	public void update() {
		bodenbelaegeView.zeigeTeppichAn();
	}
}
