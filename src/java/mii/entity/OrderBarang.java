package mii.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author user2
 */
@Entity
@Table(name="orderbarang")
public class OrderBarang implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date tanggal;
    @Column(length = 10)
    private String waktu;
    private int total_bayar;
    @Column(length = 15)
    private String status_order;
    
    @ManyToOne(cascade= CascadeType.MERGE) // ALL diganti pake MERGE, krn klo ALL pas aku insert produkya, categorynya ikut nambah2 sndri.
    private OrderDetail orderDetail;
    
    @ManyToOne(cascade= CascadeType.MERGE)
    private Customer customer;
    
    public OrderBarang(){}
    public OrderBarang(Long id){
        this.id=id;
    }
    
     //==== constructor u dgnkn pas insert =====
    public OrderBarang(String waktu, int total_bayar, String status_order){
        this.tanggal=tanggal;
        this.waktu=waktu;
        this.total_bayar=total_bayar;
        this.status_order=status_order;
    }
    
    //==== constructor u dgnkn pas insert =====
    public OrderBarang(String waktu, int total_bayar, String status_order, OrderDetail orderDetail,
    Customer customer){
        
        this.waktu=waktu;
        this.total_bayar=total_bayar;
        this.status_order=status_order;
        this.orderDetail=orderDetail;
        this.customer=customer;
    }
    
    //==== constructor u dgnkn pas update =====
    public OrderBarang(Long id, String waktu, int total_bayar, String status_order, OrderDetail orderDetail,
    Customer customer){
        this.id=id;
     
        this.waktu=waktu;
        this.total_bayar=total_bayar;
        this.status_order=status_order;
        this.orderDetail=orderDetail;
        this.customer=customer;
    }
     
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public int getTotal_bayar() {
        return total_bayar;
    }

    public void setTotal_bayar(int total_bayar) {
        this.total_bayar = total_bayar;
    }

    public String getStatus_order() {
        return status_order;
    }

    public void setStatus_order(String status_order) {
        this.status_order = status_order;
    }

    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
