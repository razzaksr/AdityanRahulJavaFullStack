package org.inversion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Beneficiary {
    private int beneficiaryId;
    private String beneficiaryName;
    private long beneficiaryAccountNumber;
}
