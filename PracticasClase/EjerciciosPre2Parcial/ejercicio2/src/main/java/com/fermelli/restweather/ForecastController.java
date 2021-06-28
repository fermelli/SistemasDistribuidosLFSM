package com.fermelli.restweather;

import com.fermelli.restweather.data.Forecast;
import com.fermelli.restweather.service.ForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/forecasts")
public class ForecastController {

    @Autowired
    ForecastService forecastService;

    /**
     * Retorna toda la lista de pronosticos
     *
     * @return lista de pronosticos
     */
    @GetMapping
    public ResponseEntity<List<Forecast>> getForecasts() {
        List<Forecast> forecasts = forecastService.getForecasts();
        return new ResponseEntity<>(forecasts, HttpStatus.OK);
    }

    /**
     * Crea un nuevo pronostico en base a un formato json
     *
     * @param forecast
     * @return nuevo pronostico creado
     */
    @PostMapping(value = "/")
    public ResponseEntity<Forecast> createForecast(@RequestBody Forecast forecast) {
        final Forecast forecastData = forecastService.create(forecast);
        return new ResponseEntity<>(forecastData, HttpStatus.CREATED);
    }

    /**
     * Devuelve informacion del pronostico en base a su ID
     *
     * @param id
     * @return detalles del pronostico
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<Forecast> getForecast(@PathVariable Long id) {
        Forecast forecast = forecastService.getForecast(id);
        return new ResponseEntity<>(forecast, HttpStatus.OK);
    }

    /**
     * Remueve un pronostico en base a su ID proporcionado
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteForecast(@PathVariable Long id) {
        forecastService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Actualizar los datos de un pronostico en base a su ID
     *
     * @param id
     * @return detalles del pronostico
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<Forecast> updateForecast(@RequestBody Forecast forecast, @PathVariable Long id) {
        forecast = forecastService.update(forecast, id);
        return new ResponseEntity<>(forecast, HttpStatus.OK);
    }

}
