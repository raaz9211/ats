package com.ai.ats.dto;

import com.ai.ats.entity.jpa.PurchaseOrder;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class DocumentationDTO {


    private long documentationId;

    private String documentationStatus;

}
