package org.example.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Current {
    @JsonProperty("last_updated")
    private String last_updated;
    @JsonProperty("temp_c")
    private float temperatureCelsius;
    @JsonProperty("temp_f")
    private float temperatureFahrenheit;
    @JsonProperty("wind_kph")
    private float windSpeedKph;
    @JsonProperty("pressure_mb")
    private float pressure;
    @JsonProperty("humidity")
    private float humidity;
}
