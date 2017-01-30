package mii.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mii.entity.Category;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-06-16T05:29:45")
@StaticMetamodel(Buku.class)
public class Buku_ { 

    public static volatile SingularAttribute<Buku, String> penulis;
    public static volatile SingularAttribute<Buku, String> bahasa;
    public static volatile SingularAttribute<Buku, String> isbn;
    public static volatile SingularAttribute<Buku, String> jenis_cover;
    public static volatile SingularAttribute<Buku, Integer> stok;
    public static volatile SingularAttribute<Buku, String> gambar;
    public static volatile SingularAttribute<Buku, String> jml_hal;
    public static volatile SingularAttribute<Buku, Integer> harga;
    public static volatile SingularAttribute<Buku, String> penerbit;
    public static volatile SingularAttribute<Buku, Long> id;
    public static volatile SingularAttribute<Buku, String> deskripsi;
    public static volatile SingularAttribute<Buku, String> judul;
    public static volatile SingularAttribute<Buku, String> tahun_terbit;
    public static volatile SingularAttribute<Buku, Category> category;

}