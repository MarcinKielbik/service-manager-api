package pl.marcinkielbik.service_manager_api.model;

import jakarta.persistence.*;
import org.hibernate.annotations.IdGeneratorType;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;

    @ManyToMany
    @JoinTable(
            name = "customer_service",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id")
    )

    private List<TelecomService> services = new ArrayList<>();
}
