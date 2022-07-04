package ru.maxvagan.exercise_2_11.services.impls;

import com.google.common.collect.Sets;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import ru.maxvagan.exercise_2_11.mainclasses.EBasket;
import ru.maxvagan.exercise_2_11.services.EBasketService;

import java.util.List;

@Service
@SessionScope
public class EBasketServiceImpl implements EBasketService {
    private EBasket myBasket = new EBasket(Sets.newHashSet());

    @Override
    public String getHelpInfo() {
        return "<h1>Справочная информация по работе с электронной корзиной:</h1>";
    }

    @Override
    public String addToBasket(List<Integer> listItems) {
        if (!listItems.isEmpty()) {
            if (myBasket.getItemsSet().size() == 0) {
                myBasket.setItemsList(listItems);
            } else {
                myBasket.addItemsList(listItems);
            }
        }
        return null;
    }

    @Override
    public String getFromBasket() {
        return myBasket.toString();
    }
}
