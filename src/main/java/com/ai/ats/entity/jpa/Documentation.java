package com.ai.ats.entity.jpa;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
@Entity
@Table(name = "Documentations")
@Data
public class Documentation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "documentation_id")
    private long documentationId;

    private String documentationStatus;

    @Getter(AccessLevel.NONE)
    @ToString.Exclude
    @OneToOne
    private PurchaseOrder purchaseOrder;
}
