package com.jagan.expensetracker.dto;

import lombok.*;
import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ExpenseRequest {
    private String title;
    private String category;
    private Double amount;
    private LocalDate expenseDate;
}
