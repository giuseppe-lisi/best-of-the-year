package com.esercizio.best_of_the_year.classes;

import java.io.Serializable;

public class Movies implements Serializable {
    private int id;
    private String title;

    public Movies() {};

    public Movies(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }
    
    public String getTitle() {
        return title;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
}
