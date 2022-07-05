package ru.maxvagan.exercise_2_11.services.impls;

import com.google.common.collect.Lists;
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
    private EBasket myBasket = new EBasket(Lists.newArrayList());

    @Override
    public String getHelpInfo() {
        return "<h1>Справочная информация по работе с электронной корзиной:</h1>" +
                "<h3><p><b>Используйте команду в запросе для добавления списка ID - /add?items=1,2,3,...,N</b></h3>" +
                "<h3><p><b>Используйте команду в запросе для вывода списка ID - /get</b></h3>";
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
        return String.format("<h3>В корзину добавлены следующие позиции:</h3><p>%s", myBasket.getItemsSet());
    }

    @Override
    public String getFromBasket() {
        return myBasket.toString();
    }
}
