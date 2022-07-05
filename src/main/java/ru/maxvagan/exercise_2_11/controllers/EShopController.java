package ru.maxvagan.exercise_2_11.controllers;

import org.springframework.web.bind.annotation.*;
import ru.maxvagan.exercise_2_11.services.EBasketService;

import java.util.List;

/*import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;*/

@RestController
@RequestMapping(path = "/store/order")
public class EShopController {
    private final EBasketService eBasketService;

    public EShopController(EBasketService eBasketService) {
        this.eBasketService = eBasketService;
    }

    @GetMapping
    public String index() {
        return eBasketService.getHelpInfo();
    }

    @GetMapping(path = "/add")
    public String addItemsToBasket(@RequestParam("items") List<Integer> listItems) {
        return eBasketService.addToBasket(listItems);
    }

    @GetMapping(path = "/get")
    public String getItemsFromBasket() {
        return eBasketService.getFromBasket();
    }
}
