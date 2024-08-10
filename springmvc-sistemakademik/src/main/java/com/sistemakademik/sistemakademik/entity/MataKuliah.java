package com.sistemakademik.sistemakademik.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "mk")
public class MataKuliah {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rec_no")
    private int recNo;

    @Column(name = "id_mk", nullable = false)
    private String idMk;

    @Column(name = "mk", nullable = false)
    private String mk;

    public MataKuliah() {
    }

    public MataKuliah(String idMk, String mk) {
        this.idMk = idMk;
        this.mk = mk;
    }

    public int getRecNo() {
        return recNo;
    }

    public void setRecNo(int recNo) {
        this.recNo = recNo;
    }

    public String getIdMk() {
        return idMk;
    }

    public void setIdMk(String idMk) {
        this.idMk = idMk;
    }

    public String getMk() {
        return mk;
    }

    public void setMk(String mk) {
        this.mk = mk;
    }
}
