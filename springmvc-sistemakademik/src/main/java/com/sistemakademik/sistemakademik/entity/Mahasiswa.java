package com.sistemakademik.sistemakademik.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "mahasiswa")
public class Mahasiswa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rec_no")
    private int recNo;

    @Column(name = "nrp")
    private String nrp;

    @Column(name = "nama", nullable = false)
    private String nama;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StatusMahasiswa status;

    public Mahasiswa() {
    }

    public Mahasiswa(String nrp, String nama, StatusMahasiswa status) {
        this.nrp = nrp;
        this.nama = nama;
        this.status = status;
    }

    public int getRecNo() {
        return recNo;
    }

    public void setRecNo(int recNo) {
        this.recNo = recNo;
    }

    public String getNrp() {
        return nrp;
    }

    public void setNrp(String nrp) {
        this.nrp = nrp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public StatusMahasiswa getStatus() {
        return status;
    }

    public void setStatus(StatusMahasiswa status) {
        this.status = status;
    }
}
