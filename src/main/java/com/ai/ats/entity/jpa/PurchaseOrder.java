package com.ai.ats.entity.jpa;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
@Entity
@Table(name = "purchase_orders")
@Data
public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "purchase_order_ID")
    long purchaseOrderID;


    @Column(name = "placement_date")
    @CreationTimestamp
    private OffsetDateTime placementDate;

    @Getter(AccessLevel.NONE)
    @ToString.Exclude
    @OneToOne
    private Submission submission;
    @OneToOne(mappedBy = "purchaseOrder", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Documentation documentation;

    public void setDocumentation(Documentation documentation) {
        documentation.setPurchaseOrder(this);
        this.documentation = documentation;
    }


}
