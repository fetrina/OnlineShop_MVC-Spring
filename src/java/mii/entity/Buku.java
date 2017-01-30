package mii.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author user2
 */
@Entity
@Table(name="buku")
public class Buku implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String isbn;
    @Column(length = 40)
    private String judul;
    @Column(length = 40)
    private String penulis;
    @Column(length = 40)
    private String penerbit;
    @Column(length = 4)
    private String tahun_terbit;
    @Column(length = 20)
    private String jenis_cover;
    @Column(length = 4)
    private String jml_hal;
    @Column(length = 15)
    private String bahasa;
    @Column(length = 1000)
    private String deskripsi;
    @Column(length = 200)
    private String gambar;
    private int harga;
    private int stok;
    
    @ManyToOne(cascade= CascadeType.MERGE) // ALL diganti pake MERGE, krn klo ALL pas aku insert produkya, categorynya ikut nambah2 sndri.
    private Category category;
    
    public Buku(){}
    public Buku(Long id){
        this.id=id;
    }
    
    //agar bisa save insert pke constructor
    public Buku(String isbn, String judul, String penulis, String penerbit, String tahun_terbit, String jenis_cover,
        String jml_hal, String bahasa, String deskripsi, String gambar, int harga, int stok, Category category)
        {
        this.isbn=isbn;
        this.judul=judul;
        this.penulis=penulis;
        this.penerbit=penerbit;
        this.tahun_terbit=tahun_terbit;
        this.jenis_cover=jenis_cover;
        this.jml_hal=jml_hal;
        this.bahasa=bahasa;
        this.deskripsi=deskripsi;
        this.gambar=gambar;
        this.harga=harga;
        this.stok=stok;
        this.category=category;
    }
    
    //agar bisa save update pke constructor
    public Buku(Long id, String isbn, String judul, String penulis, String penerbit, String tahun_terbit, String jenis_cover,
        String jml_hal, String bahasa, String deskripsi, String gambar, int harga, int stok, Category category)
        {
        this.id=id;    
        this.isbn=isbn;
        this.judul=judul;
        this.penulis=penulis;
        this.penerbit=penerbit;
        this.tahun_terbit=tahun_terbit;
        this.jenis_cover=jenis_cover;
        this.jml_hal=jml_hal;
        this.bahasa=bahasa;
        this.deskripsi=deskripsi;
        this.gambar=gambar;
        this.harga=harga;
        this.stok=stok;
        this.category=category;
    }
    
    public Buku(int harga){
        this.harga=harga;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public String getTahun_terbit() {
        return tahun_terbit;
    }

    public void setTahun_terbit(String tahun_terbit) {
        this.tahun_terbit = tahun_terbit;
    }

    public String getJenis_cover() {
        return jenis_cover;
    }

    public void setJenis_cover(String jenis_cover) {
        this.jenis_cover = jenis_cover;
    }

    public String getJml_hal() {
        return jml_hal;
    }

    public void setJml_hal(String jml_hal) {
        this.jml_hal = jml_hal;
    }

    public String getBahasa() {
        return bahasa;
    }

    public void setBahasa(String bahasa) {
        this.bahasa = bahasa;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    //====== GET SET Category =======
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
