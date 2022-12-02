package com.example.dictionary;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class Dictionary extends Application {
    int yLine=10;
    TextField wordTextField;
    Label meaningLabel;
    DictionaryUsngHashMap dictionaryUsngHashMap;
    Trie trie;

    ListView<String> suggestWordList;

    Button searchButton;

    Pane createContent(){
        Pane root=new Pane();
        root.setPrefSize(500,500);
        root.setBackground(Background.fill(Color.LIGHTGRAY ));


         wordTextField=new TextField();
         wordTextField.setPromptText("Please enter a word");
         wordTextField.setTranslateY(yLine);
         wordTextField.setTranslateX(125);
         wordTextField.setOnKeyTyped(new EventHandler<KeyEvent>() {
             @Override
             public void handle(KeyEvent keyEvent) {
                 meaningLabel.setText(wordTextField.getText());
             }
         });



        meaningLabel=new Label("Meaning of the word");
        meaningLabel.setTranslateY(yLine+30);
        meaningLabel.setTranslateX(125);


        dictionaryUsngHashMap=new DictionaryUsngHashMap();
        trie=new Trie();

         // reating
        searchButton=new Button("Search");
        searchButton.setTranslateY(yLine);
        searchButton.setTranslateX(300);
        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //String word=wordTextField.getText();
                String word=wordTextField.getText();
                System.out.println(word);
                if(word.isBlank()){
                   meaningLabel.setText("Please enter a word");
                   meaningLabel.setTextFill(Color.RED);
                }else{
                    String  ans=trie.getWord(word);
                    System.out.println(ans);
                    meaningLabel.setText(dictionaryUsngHashMap.findMeaning(word));
                    root.setPrefSize(500,500);
                    meaningLabel.setTextFill(Color.BLACK);
                }
            }
        });


        suggestWordList=new ListView<>();
        suggestWordList.setTranslateY(yLine+70);
        suggestWordList.setTranslateX(125);
        //suggestWordList.setBorder();

        String[] suggestedList={"Lord","King","Glory","Role"};
        suggestWordList.getItems().addAll(suggestedList);

        root.getChildren().addAll(wordTextField,searchButton,meaningLabel,suggestWordList);
        return root;
    }
    @Override
    public void start(Stage stage) throws IOException {
      //  FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(createContent());
        stage.setTitle("My Dictionary");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}