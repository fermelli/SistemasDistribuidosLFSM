package com.fermelli.restweather.service;

import com.fermelli.restweather.dao.entity.ForecastModel;
import com.fermelli.restweather.data.Forecast;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.fermelli.restweather.dao.entity.ForecastRepository;

@Service
public class ForecastService {

    @Autowired
    ForecastRepository forecastRepository;

    public Forecast create(final Forecast forecast) {

        ForecastModel forecastModel = new ForecastModel();
        BeanUtils.copyProperties(forecast, forecastModel);
        forecastModel = forecastRepository.save(forecastModel);

        Forecast forecastData = new Forecast();
        BeanUtils.copyProperties(forecastModel, forecastData);

        return forecastData;
    }

    public List<Forecast> getForecasts() {
        
        List<ForecastModel> forecasts = new ArrayList<>();
        forecastRepository.findAll().forEach(forecasts::add);

        List<Forecast> forecastList = new ArrayList<>();
        for (ForecastModel forecastModel : forecasts) {
            Forecast forecast = new Forecast();
            BeanUtils.copyProperties(forecastModel, forecast);
            forecastList.add(forecast);
        }

        return forecastList;
    }

    public Forecast getForecast(Long id) {

        Optional<ForecastModel> forecast = forecastRepository.findById(id);
        Forecast forecastData = new Forecast();
        BeanUtils.copyProperties(forecast.get(), forecastData);

        return forecastData;
    }

    public void delete(Long id) {
        forecastRepository.deleteById(id);
    }

    public Forecast update(final Forecast forecast, Long id) {

        Optional<ForecastModel> optionalForecast = forecastRepository.findById(id);
        ForecastModel recoveredForecast;
        if (optionalForecast.isPresent()) {
            recoveredForecast = optionalForecast.get(); //obtener directamente la clase pronostico
            BeanUtils.copyProperties(forecast, recoveredForecast);
            recoveredForecast = forecastRepository.save(recoveredForecast);
            return forecast;
        } else {
            // Avisar al usuario de que no se ha encontrado el pronostico
            return null;
        }
    }
    
}
