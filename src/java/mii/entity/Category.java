package mii.entity;

import java.io.Serializable;
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
@Table(name="category") 
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    //skrip tmbhan, agar bisa save insert pke constructor
    public Category(String name){
        this.name=name;  
    }
    
    //skrip tmbhan, agar bisa save delete pke constructor
    public Category(Long id){
        this.id=id;  
    }
    
    //skrip tmbhan, agar bisa update pke constructor
    public Category(Long id, String name){
        this.id=id;
        this.name=name;
    }
        
    public Category(){}
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }    
    
}
