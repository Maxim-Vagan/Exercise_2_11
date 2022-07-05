package ru.maxvagan.exercise_2_11.services;

import java.util.List;

public interface EBasketService {

    String getHelpInfo();

    String addToBasket(List<Integer> listItems);

    String getFromBasket();
}