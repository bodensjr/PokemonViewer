package com.it4045.pokemonviewer.enterprise.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

public @Data
class Evolution {

    @SerializedName("num")
    private String evolutionNumber;
    @SerializedName("name")
    private String pokemonEvolutionName;
}
