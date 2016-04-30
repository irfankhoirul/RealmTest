package com.muhlish.apps.realmtest.model;

import io.realm.RealmObject;

/**
 * Created by Irfan Khoirul on 30/04/2016.
 */
public class Mahasiswa extends RealmObject {
    private String nim;
    private String nama;
    private String jurusan;
    private int angkatan;

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public int getAngkatan() {
        return angkatan;
    }

    public void setAngkatan(int angkatan) {
        this.angkatan = angkatan;
    }

    @Override
    public String toString() {
        return "Mahasiswa{" +
                "nim='" + nim + '\'' +
                ", nama='" + nama + '\'' +
                ", jurusan='" + jurusan + '\'' +
                ", angkatan=" + angkatan +
                '}';
    }
}
