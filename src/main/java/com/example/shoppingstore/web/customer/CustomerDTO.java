package com.example.shoppingstore.web.customer;

import com.example.shoppingstore.infraestructure.utils.UtilDate;
import lombok.*;

import java.time.format.DateTimeFormatter;
import java.util.Date;

@Data
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    private Long id;
    private String email;
    private String role;
//  format doj  "02/03/2021",
    private String doj;
    private String createdBy;
    private String modifiedBy;

    public Date convertDojToDate() {
        return
                UtilDate.convertToDate(this.doj, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
    }

}
