package pl.javastart.rental.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="item_id")
    private long id;
    @Column(name="name")
    private String name;
    @Column(name="stock_level")
    private int stockLevel;
    @Column(name="price")
    private double price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Customer> borrower;

    public void borrowToCustomer(Customer customer){
        borrower.add(customer);
    }

}
