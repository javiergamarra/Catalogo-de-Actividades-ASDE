package com.nhpatt.asde.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


public class Event implements Serializable {

    private String id;
    @SerializedName(value = "titulo")
    private String name;
    private String created;
    @SerializedName(value = "descripcion")
    private String description;
    @SerializedName(value = "caracteristicas")
    private List<String> characteristics;
    @SerializedName(value = "nivelDeRiesgo")
    private String riskLevel;
    @SerializedName(value = "medidasPreventivas")
    private Measure measure;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
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

    public String getCharacteristicsAsString() {
        StringBuilder builder = new StringBuilder();
        for (String details : characteristics) {
            builder.append(details + "\n");
        }
        return builder.toString();
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public Measure getMeasure() {
        return measure;
    }

    public void setMeasure(Measure measure) {
        this.measure = measure;
    }
}
