package mii.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author user2
 */
@Entity
public class OrderDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int qty;
    private int subtotal;

    @ManyToOne(cascade= CascadeType.MERGE) // ALL diganti pake MERGE, krn klo ALL pas aku insert produkya, categorynya ikut nambah2 sndri.
    private Buku buku;

    @ManyToOne(cascade= CascadeType.MERGE) // ALL diganti pake MERGE, krn klo ALL pas aku insert produkya, categorynya ikut nambah2 sndri.
    private OrderBarang orderBarang;
    
    public OrderDetail(){}
    public OrderDetail(Long id){
        this.id=id;
    }
    
    public OrderDetail(int qty, int subtotal, Buku buku, OrderBarang orderBarang){
        this.qty=qty;
        this.subtotal=subtotal;
        this.buku=buku;
        this.orderBarang=orderBarang;
    }
    
    public OrderDetail(Long id, int qty, int subtotal, Buku buku, OrderBarang orderBarang){
        this.id=id;
        this.qty=qty;
        this.subtotal=subtotal;
        this.buku=buku;
        this.orderBarang=orderBarang;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public Buku getBuku() {
        return buku;
    }

    public void setBuku(Buku buku) {
        this.buku = buku;
    }

    public OrderBarang getOrderBarang() {
        return orderBarang;
    }

    public void setOrderBarang(OrderBarang orderBarang) {
        this.orderBarang = orderBarang;
    }
    
}
