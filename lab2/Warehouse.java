package com.company;

import java.util.Objects;

public class Warehouse extends Source {

    /**
     *   Constructor mostenit cu toti parametrii
     * @param supply supply-ul de trimis
     * @param name va fi numele sursei
     * @param type tipul va fi mereu Warehouse
     * @param index locul din matricea de costuri, pozitia sursei
     */
    public Warehouse(int supply, String name, String type, int index) {
        super(supply, name, "Warehouse", index);
    }

    @Override
    void setType(String type) {
        this.type = type;
    }
}
