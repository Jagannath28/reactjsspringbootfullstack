package com.jagan.expensetracker.controller;

import com.jagan.expensetracker.dto.ExpenseRequest;
import com.jagan.expensetracker.model.Expense;
import com.jagan.expensetracker.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/expenses")
@RequiredArgsConstructor
public class ExpenseController {
    private final ExpenseService expenseService;

    @PostMapping
    public ResponseEntity<Expense> addExpense(@RequestBody ExpenseRequest req, Authentication authentication) {
        String username = authentication.getName();
        Expense e = expenseService.addExpense(username, req);
        return ResponseEntity.ok(e);
    }

    @GetMapping
    public ResponseEntity<List<Expense>> getExpenses(Authentication authentication) {
        String username = authentication.getName();
        return ResponseEntity.ok(expenseService.getAllExpenses(username));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable Long id, Authentication authentication) {
        String username = authentication.getName();
        expenseService.deleteExpense(username, id);
        return ResponseEntity.ok("Deleted");
    }

    @GetMapping("/monthly-report")
    public ResponseEntity<Map<String, Double>> monthlyReport(
            @RequestParam int year, @RequestParam int month, Authentication authentication) {
        String username = authentication.getName();
        return ResponseEntity.ok(expenseService.monthlyReport(username, year, month));
    }
}
