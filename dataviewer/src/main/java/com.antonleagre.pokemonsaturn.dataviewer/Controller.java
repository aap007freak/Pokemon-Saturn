package com.antonleagre.pokemonsaturn.dataviewer;

import com.antonleagre.pokemonsaturn.model.pokemon.BasePokemon;
import com.antonleagre.pokemonsaturn.model.pokemon.Type;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.PrefixFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.controlsfx.control.textfield.TextFields;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class Controller implements Initializable {


    //search
    @FXML
    private TextField searchPkmnField, searchIDField;

    @FXML
    private ScrollPane mainPane;


    //general info
    @FXML
    private Label nationalDexNumLabel, inGameNameLabel, descriptionLabel;
    @FXML
    private ImageView mainView;
    @FXML
    private ComboBox<Type> type1CBox, type2CBox;
    @FXML
    private Label hpLabel, attLabel, defLabel, spaLabel, spdeLabel, speedLabel;

    //aditional info
    @FXML
    private Label hgFlavourText, ssFlavourText;




    //sprites
    @FXML
    private VBox spriteVBox;

    //non-fxml vars
    private final SelectedPokemonProperty selectedPokemonProperty = new SelectedPokemonProperty();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        TextFields.bindAutoCompletion(searchPkmnField, Arrays.stream(BasePokemon.values()).map(BasePokemon::getIngameName).collect(Collectors.toList()));

        mainPane.visibleProperty().bind(selectedPokemonProperty.isNotNull());

        nationalDexNumLabel.textProperty().bind(selectedPokemonProperty.nationalDexNumProperty.asString("#%d"));
        inGameNameLabel.textProperty().bind(selectedPokemonProperty.ingameNameProperty);
        descriptionLabel.textProperty().bind(selectedPokemonProperty.descriptionProperty);
        type1CBox.valueProperty().bind(selectedPokemonProperty.type1Property);
        type1CBox.setItems(FXCollections.observableArrayList(Type.values()));
        type2CBox.valueProperty().bind(selectedPokemonProperty.type2Property);
        type2CBox.setItems(FXCollections.observableArrayList(Type.values()));
        type2CBox.visibleProperty().bind(selectedPokemonProperty.type1Property.isNotEqualTo(selectedPokemonProperty.type2Property));
        hpLabel.textProperty().bind(selectedPokemonProperty.baseHPProperty.asString("HP: %.0f"));
        attLabel.textProperty().bind(selectedPokemonProperty.baseAttackProperty.asString("ATT: %.0f"));
        defLabel.textProperty().bind(selectedPokemonProperty.baseDefenseProperty.asString("DEF: %.0f"));
        spaLabel.textProperty().bind(selectedPokemonProperty.baseSpecialAttackProperty.asString("SPA: %.0f"));
        spdeLabel.textProperty().bind(selectedPokemonProperty.baseSpecialDefenseProperty.asString("SPDE: %.0f"));
        speedLabel.textProperty().bind(selectedPokemonProperty.baseSpeedProperty.asString("SPEED: %.0f"));
        hgFlavourText.textProperty().bind(selectedPokemonProperty.hgFlavourTextProperty);
        ssFlavourText.textProperty().bind(selectedPokemonProperty.ssFlavourTextProperty);



        //implementing bindings for images is more difficult + we will not want to change them later down the line
        // , so we change them with a Listener instead of the nice properties
        selectedPokemonProperty.addListener((observable, oldValue, newValue) -> {
            // TODO: 2/02/2021 These should be not hardcoded but dynamically found and in the settings
            // find which files we need

            //get pokemon  fronts
            Collection<File> files = FileUtils.listFiles(new File("C:\\Users\\Anton\\Desktop\\Pokemon-Saturn\\art\\battle"), new PrefixFileFilter("pof" + newValue.toString().toLowerCase()), TrueFileFilter.INSTANCE);

            try { //set the mainview one
                File file1 = files.stream().filter(s -> s.getPath().endsWith("1.png")).findFirst().get();
                mainView.setImage(new Image(file1.toURL().toString())); //another example of java IO being a*ds, even with commons IO
                Tooltip tp = new Tooltip(file1.getAbsolutePath());
                Tooltip.install(mainView, tp);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }


            spriteVBox.getChildren().retainAll();
            try { // set the sprites in the sprite vbox

                Set<String> classes = files.stream().map(Controller::getPrefixForBattleSprite).collect(Collectors.toSet());
                for (String clas : classes) {
                    HBox spriteHbox = new HBox();
                    spriteHbox.setAlignment(Pos.CENTER_LEFT);
                    spriteHbox.setPadding(new Insets(0d, 0d, 0d, 20d));
                    spriteHbox.setSpacing(20);
                    Label classLabel = new Label(clas);
                    classLabel.setStyle("-fx-font-size: 24;");
                    spriteHbox.getChildren().add(classLabel);
                    Set<File> setFiles = files.stream().filter(f -> Controller.getPrefixForBattleSprite(f).equals(clas)).collect(Collectors.toSet());
                    for(File file: setFiles){
                        ImageView view = new ImageView(file.toURL().toString());
                        Tooltip tp = new Tooltip(file.getAbsolutePath());
                        Tooltip.install(view, tp);
                        spriteHbox.getChildren().add(view);

                    }
                    spriteVBox.getChildren().add(spriteHbox);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        });


    }

    @FXML
    private void goClicked(){
        if(!searchIDField.getText().equals("")){
            try{
                int nationalDexNum = Integer.parseInt(searchIDField.getText());
                selectedPokemonProperty.set(BasePokemon.values()[nationalDexNum - 1]);
            }catch (NumberFormatException nfe){
                // couldn't format the national dex id, try the other field
                String searchText = searchPkmnField.getText();
                Optional<BasePokemon> pokemon = Arrays.stream(BasePokemon.values())
                        .filter(p -> p.getIngameName().equals(searchText))
                        .findFirst();
                pokemon.ifPresent(selectedPokemonProperty::set);
            }
        }else{
            String searchText = searchPkmnField.getText();
            Optional<BasePokemon> pokemon = Arrays.stream(BasePokemon.values())
                    .filter(p -> p.getIngameName().equals(searchText))
                    .findFirst();
            pokemon.ifPresent(selectedPokemonProperty::set);
        }

    }

    /**
     * Eg. _m _f _fi
     * @param file
     * @return
     */
    private static String getPrefixForBattleSprite(File file){
        String name = file.getName();

        int last_index = name.lastIndexOf("_");
        if(last_index == -1){
            return "";
        }
        String endString = name.substring(name.lastIndexOf("_"));
        return endString.split("\\d+", 2)[0];

    }

}
