package com.ai.ats.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.OffsetDateTime;

@Data
public class PurchaseOrderDTO {

    private long purchaseOrderID;
    private OffsetDateTime placementDate;
    private DocumentationDTO documentation;

}
