package com.fermelli.restweather.dao.entity;

import org.springframework.data.repository.CrudRepository;

public interface ForecastRepository extends CrudRepository<ForecastModel, Long> {
}
