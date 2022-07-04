package ru.maxvagan.exercise_2_11.mainclasses;

import com.google.common.collect.Sets;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class EBasket {
    private Set<Integer> itemsSet;

    public EBasket(Set<Integer> itemsSet) {
        this.itemsSet = itemsSet;
    }

    public Set<Integer> getItemsSet() {
        return itemsSet;
    }

    public boolean addItemsList(List<Integer> itemsList) {
        return this.itemsSet.addAll(itemsList) ;
    }

    public void setItemsList(List<Integer> itemsList) {
        this.itemsSet = Sets.newHashSet(itemsList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EBasket)) return false;
        EBasket eBasket = (EBasket) o;
        return Objects.equals(getItemsSet(), eBasket.getItemsSet());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getItemsSet());
    }

    @Override
    public String toString() {
        return "\"EBasket\": {" +
                "\"itemsSet\": " + itemsSet +
                '}';
    }
}
