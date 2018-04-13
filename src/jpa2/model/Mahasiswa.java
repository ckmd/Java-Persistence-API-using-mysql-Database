/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa2.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
/**
 *
 * @author Rachmad
 */
@Entity
public class Mahasiswa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private String nama;
    private long nrp;
    
    public Mahasiswa(){
        
    }
    public Mahasiswa(String n, long nrp){
        this.nama = n;
        this.nrp = nrp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public long getNrp() {
        return nrp;
    }

    public void setNrp(long nrp) {
        this.nrp = nrp;
    }
    
}
