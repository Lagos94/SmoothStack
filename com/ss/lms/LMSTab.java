package com.ss.lms;

import javafx.scene.control.Tab;
import javafx.stage.Stage;

class LMSTab extends Tab {
    LMSTab(Stage stage){
        setText("LMS");
        setClosable(false);
        setContent(new LibManSys(stage));
    }
}
