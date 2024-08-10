package org.inversion;

// Plain Old Java Object

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Insurance {
    private int insuranceId;
    private String insuranceName;
    private String insuranceType;
    private int insuranceDuration;
    private int insuranceAmount;
}
