package mii.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author user2
 */
@Entity
@Table(name="customer")
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
     @Column(length = 30)
    private String nama;
    @Column(length = 16)
    private String hp;
    @Column(length = 30)
    private String email;
    @Column(length = 50)
    private String alamat;
    @Column(length = 20)
    private String kota;
    @Column(length = 30)
    private String provinsi;
    
    public Customer(){}
    
    //agar bisa delete pke cunstroctor
    public Customer(Long id){
        this.id=id;
    }
    
    //agar bisa save insert pke constructor
    public Customer(String nama, String hp, String email, String alamat, String kota, String provinsi){
        this.nama=nama;
        this.hp=hp;
        this.email=email;
        this.alamat=alamat;
        this.kota=kota;
        this.provinsi=provinsi;
    }
    
    //agar bisa edit pke constructor
    public Customer(Long id, String nama, String hp, String email, String alamat, String kota, String provinsi){
        this.id=id;
        this.nama=nama;
        this.hp=hp;
        this.email=email;
        this.alamat=alamat;
        this.kota=kota;
        this.provinsi=provinsi;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }
    
}
