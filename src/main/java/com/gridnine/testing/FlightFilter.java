package com.gridnine.testing;

import java.util.List;

public interface FlightFilter {
    /**
     * Метод выполняет фильтрацию полётов зи списка
     * @param flights - список полётов
     * @return отфильтрованный список полётов
     */
    List<Flight> filter(List<Flight> flights);
}
