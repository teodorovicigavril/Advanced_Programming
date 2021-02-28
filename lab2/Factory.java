package com.company;

import java.util.Objects;

public class Factory extends Source {

    /**
     *   Constructor mostenit cu toti parametrii
     * @param supply supply-ul de trimis
     * @param name va fi numele sursei
     * @param type tipul va fi mereu Factory
     * @param index locul din matricea de costuri, pozitia sursei
     */
    public Factory(int supply, String name, String type, int index) {
        super(supply, name, "Factory", index);
    }

    @Override
    void setType(String type) {
        this.type = type;
    }
}
