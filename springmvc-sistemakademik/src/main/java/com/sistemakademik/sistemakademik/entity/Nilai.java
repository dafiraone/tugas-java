package com.sistemakademik.sistemakademik.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "nilai")
public class Nilai {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rec_no")
    private int recNo;

    @ManyToOne
    @JoinColumn(name = "rec_mhs", nullable = false)
    private Mahasiswa mahasiswa;

    @ManyToOne
    @JoinColumn(name = "rec_dos", nullable = false)
    private Dosen dosen;

    @ManyToOne
    @JoinColumn(name = "rec_mk", nullable = false)
    private MataKuliah mataKuliah;

    @Column(name = "sc1")
    private int sc1;

    @Column(name = "sc2")
    private int sc2;

    @Column(name = "sc3")
    private int sc3;

    public Nilai() {
    }

    public Nilai(Mahasiswa mahasiswa, Dosen dosen, MataKuliah mataKuliah, int sc1, int sc2, int sc3) {
        this.mahasiswa = mahasiswa;
        this.dosen = dosen;
        this.mataKuliah = mataKuliah;
        this.sc1 = sc1;
        this.sc2 = sc2;
        this.sc3 = sc3;
    }

    // Getters and Setters

    public int getRecNo() {
        return recNo;
    }

    public void setRecNo(int recNo) {
        this.recNo = recNo;
    }

    public Mahasiswa getMahasiswa() {
        return mahasiswa;
    }

    public void setMahasiswa(Mahasiswa mahasiswa) {
        this.mahasiswa = mahasiswa;
    }

    public Dosen getDosen() {
        return dosen;
    }

    public void setDosen(Dosen dosen) {
        this.dosen = dosen;
    }

    public MataKuliah getMataKuliah() {
        return mataKuliah;
    }

    public void setMataKuliah(MataKuliah mataKuliah) {
        this.mataKuliah = mataKuliah;
    }

    public int getSc1() {
        return sc1;
    }

    public void setSc1(int sc1) {
        this.sc1 = sc1;
    }

    public int getSc2() {
        return sc2;
    }

    public void setSc2(int sc2) {
        this.sc2 = sc2;
    }

    public int getSc3() {
        return sc3;
    }

    public void setSc3(int sc3) {
        this.sc3 = sc3;
    }
}
