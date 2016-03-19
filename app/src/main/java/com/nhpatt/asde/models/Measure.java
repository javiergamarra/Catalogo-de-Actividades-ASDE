package com.nhpatt.asde.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * @author Javier Gamarra
 */
public class Measure implements Serializable {

    @SerializedName(value = "debes")
    private String should;
    @SerializedName(value = "noPuedes")
    private String cant;
    @SerializedName(value = "condiciones")
    private String conditions;

    @Override
    public String toString() {
        return "Debes: "
                .concat(should)
                .concat("No puedes: ")
                .concat(cant)
                .concat("Condiciones: ")
                .concat(conditions);
    }
}