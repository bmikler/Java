package pl.javastart.rental.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@ToString(exclude = "borrowedItems")
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
    private long id;
    @Column(name="name")
    private String name;
    @Column(name="document_no")
    private String documentNo;
    @Column(name="pesel")
    private String pesel;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "Items_borrowed_by_customers",
            joinColumns = {@JoinColumn (name = "customer_id")},
            inverseJoinColumns = {@JoinColumn (name = "borrowed_item_id")}
    )
    private List<Item> borrowedItems;


    public Customer(String name, String documentNo, String pesel) {
        this.name = name;
        this.documentNo = documentNo;
        this.pesel = pesel;
    }

    public void borrowItem(Item item) {
        borrowedItems.add(item);

    }
}
