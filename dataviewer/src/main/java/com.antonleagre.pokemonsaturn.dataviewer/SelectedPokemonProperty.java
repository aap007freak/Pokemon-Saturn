package com.antonleagre.pokemonsaturn.dataviewer;

import com.antonleagre.pokemonsaturn.model.pokemon.BasePokemon;
import com.antonleagre.pokemonsaturn.model.pokemon.Type;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class SelectedPokemonProperty extends SimpleObjectProperty<BasePokemon> {

    public SimpleStringProperty ingameNameProperty = new SimpleStringProperty();
    public SimpleIntegerProperty nationalDexNumProperty = new SimpleIntegerProperty();
    public SimpleStringProperty descriptionProperty = new SimpleStringProperty();
    public SimpleObjectProperty<Type> type1Property = new SimpleObjectProperty<>();
    public SimpleObjectProperty<Type> type2Property = new SimpleObjectProperty<>();
    public SimpleFloatProperty baseHPProperty = new SimpleFloatProperty();
    public SimpleFloatProperty baseAttackProperty = new SimpleFloatProperty();
    public SimpleFloatProperty baseDefenseProperty = new SimpleFloatProperty();
    public SimpleFloatProperty baseSpecialAttackProperty = new SimpleFloatProperty();
    public SimpleFloatProperty baseSpecialDefenseProperty = new SimpleFloatProperty();
    public SimpleFloatProperty baseSpeedProperty = new SimpleFloatProperty();
    public SimpleStringProperty hgFlavourTextProperty  = new SimpleStringProperty();
    public SimpleStringProperty ssFlavourTextProperty  = new SimpleStringProperty();




    @Override
    public void set(BasePokemon newValue) {
        super.set(newValue);

        this.ingameNameProperty.set(newValue.getIngameName());
        this.nationalDexNumProperty.set(newValue.getNationalDexNumber());
        this.descriptionProperty.set(newValue.getClassification());
        this.type1Property.set(newValue.getType1());
        this.type2Property.set(newValue.getType2());
        this.baseHPProperty.set(newValue.getBaseHP());
        this.baseAttackProperty.set(newValue.getBaseAttack());
        this.baseDefenseProperty.set(newValue.getBaseDefense());
        this.baseSpecialAttackProperty.set(newValue.getBaseSpAttack());
        this.baseSpecialDefenseProperty.set(newValue.getBaseSpDefense());
        this.baseSpeedProperty.set(newValue.getBaseSpeed());
        this.hgFlavourTextProperty.set(newValue.getHgFlavourText());
        this.ssFlavourTextProperty.set(newValue.getSsFlavourText());


    }


}
