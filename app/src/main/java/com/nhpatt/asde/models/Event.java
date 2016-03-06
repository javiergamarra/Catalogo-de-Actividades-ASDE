package com.nhpatt.asde.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


public class Event implements Serializable {

    private final String id;
    @SerializedName(value = "titulo")
    private final String name;
    @SerializedName(value = "descripcion")
    private String description;
    @SerializedName(value = "caracteristicas")
    private List<String> characteristics;
    @SerializedName(value = "nivelDeRiesgo")
    private String riskLevel;
    @SerializedName(value = "medidasPreventivas")
    private Measure measure;

    public Event(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Measure getMeasure() {
        return measure;
    }

    public void setMeasure(Measure measure) {
        this.measure = measure;
    }

    public String getDescription() {
        return description;

    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(List<String> characteristics) {
        this.characteristics = characteristics;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

}
