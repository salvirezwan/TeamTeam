package com.example.spellcheck;

import com.swabunga.spell.event.SpellChecker;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.util.Optional;

public class Spellcheck {
    @FXML
    private TextArea textArea;

    @FXML
    private void checkSpelling() {
        SpellChecker spellChecker = new SpellChecker();
        String[] words = textArea.getText().split("\\s+");
        for (String word : words) {
            if (!spellChecker.isCorrect(word)) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Spelling Check");
                alert.setHeaderText("Did you mean \"" + spellChecker.getSuggestions(word, 1).get(0) + "\"?");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    textArea.replaceSelection((String) spellChecker.getSuggestions(word, 1).get(0));
                }
            }
        }
    }
}