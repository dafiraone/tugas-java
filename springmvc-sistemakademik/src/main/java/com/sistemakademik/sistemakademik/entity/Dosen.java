package com.sistemakademik.sistemakademik.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "dosen")
public class Dosen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rec_no")
    private int recNo;

    @Column(name = "no_dos", nullable = false)
    private String noDos;

    @Column(name = "nama", nullable = false)
    private String nama;

    public Dosen() {
    }

    public Dosen(String noDos, String nama) {
        this.noDos = noDos;
        this.nama = nama;
    }

    public int getRecNo() {
        return recNo;
    }

    public void setRecNo(int recNo) {
        this.recNo = recNo;
    }

    public String getNoDos() {
        return noDos;
    }

    public void setNoDos(String noDos) {
        this.noDos = noDos;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
