package sbb.controler;

public abstract class SubController {

    private final MainController mainController;

    public SubController(MainController controller) {
	this.mainController = controller;
    }

    public MainController getMainController() {
	return this.mainController;
    }

}
