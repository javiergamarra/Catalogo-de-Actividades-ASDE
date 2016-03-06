package com.nhpatt.asde.models;

import com.google.gson.annotations.SerializedName;

/**
 * @author Javier Gamarra
 */
public class Measure {

    @SerializedName(value = "debes")
    private String should;
    @SerializedName(value = "noPuedes")
    private String cant;
    @SerializedName(value = "condiciones")
    private String conditions;
}