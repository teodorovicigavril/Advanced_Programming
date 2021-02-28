package com.company;

import java.util.Objects;

abstract class Source {

     private int supply;
     private String name;
     protected String type;
     private int index;

     /**
      *   Constructor cu toti parametrii
      * @param supply supply-ul de trimis
      * @param name va fi numele sursei
      * @param type ce tip de sursa avem
      * @param index locul din matricea de costuri, pozitia sursei
      */
     public Source(int supply, String name, String type, int index) {
          this.supply = supply;
          this.name = name;
          this.type = type;
          this.index = index;
     }

     public int getIndex() {
          return index;
     }

     public void setIndex(int index) {
          this.index = index;
     }

     abstract void setType(String type);

     String getType() {
          return this.type;
     }

     void setName(String name) {
          this.name = name;
     }

     void setSupply(int supply) {
          this.supply = supply;
     }

     int getSupply() {
          return this.supply;
     }

     String getName() {
          return this.name;
     }



     @Override
     public String toString() {
          return "Source{" +
                  "supply=" + supply +
                  ", name='" + name + '\'' +
                  ", type=" + type +
                  ", index=" + index +
                  '}';
     }

     @Override
     public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;
          Source source = (Source) o;
          return getIndex() == source.getIndex() || Objects.equals(getName(), source.getName());
     }
}

