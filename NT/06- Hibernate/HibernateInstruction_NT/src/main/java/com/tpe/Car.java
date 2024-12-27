package com.tpe;

import javax.persistence.PostRemove;
import javax.persistence.PrePersist;

public class Car {

    private Integer id;
    private String renk;
    private String tur;
    private String vites;

    @PrePersist
    public void prePersist(){
        vites="Bu araba 6 vitesli";
    }

}
