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
@Table(name="users") 
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 20)
    private String username;
    @Column(length = 20)
    private String password;
    @Column(length = 20)
    private String leveluser;

//    @ManyToOne(cascade= CascadeType.ALL)
//    private Pegawai pegawai;
//    
//    @OneToOne
//    private Customer customer;
    
    public Users(Long id){
        this.id=id;
    }
    
    public Users(String username, String password, String leveluser){
        this.username=username;
        this.password=password;
        this.leveluser=leveluser;
    }
    
    public Users(Long id, String username, String password, String leveluser){
        this.id=id;
        this.username=username;
        this.password=password;
        this.leveluser=leveluser;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLeveluser() {
        return leveluser;
    }

    public void setLeveluser(String leveluser) {
        this.leveluser = leveluser;
    }
//
//    public Pegawai getPegawai() {
//        return pegawai;
//    }
//
//    public void setPegawai(Pegawai pegawai) {
//        this.pegawai = pegawai;
//    }
//
//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }
//    
    
}
