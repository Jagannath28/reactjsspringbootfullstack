package com.jagan.expensetracker.service;

import com.jagan.expensetracker.dto.ExpenseRequest;
import com.jagan.expensetracker.model.Expense;
import com.jagan.expensetracker.model.User;
import com.jagan.expensetracker.repository.ExpenseRepository;
import com.jagan.expensetracker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;

    public Expense addExpense(String username, ExpenseRequest req) {
        User user = userRepository.findByUsername(username).orElseThrow();
        Expense e = Expense.builder()
                .title(req.getTitle())
                .category(req.getCategory())
                .amount(req.getAmount())
                .expenseDate(req.getExpenseDate() == null ? LocalDate.now() : req.getExpenseDate())
                .user(user)
                .build();
        return expenseRepository.save(e);
    }

    public List<Expense> getAllExpenses(String username) {
        User user = userRepository.findByUsername(username).orElseThrow();
        return expenseRepository.findByUser(user);
    }

    public void deleteExpense(String username, Long expenseId) {
        User user = userRepository.findByUsername(username).orElseThrow();
        Expense e = expenseRepository.findById(expenseId).orElseThrow();
        if (!Objects.equals(e.getUser().getId(), user.getId())) {
            throw new IllegalArgumentException("Not authorized");
        }
        expenseRepository.delete(e);
    }

    public Map<String, Double> monthlyReport(String username, int year, int month) {
        User user = userRepository.findByUsername(username).orElseThrow();
        YearMonth ym = YearMonth.of(year, month);
        LocalDate from = ym.atDay(1);
        LocalDate to = ym.atEndOfMonth();
        List<Expense> list = expenseRepository.findByUserAndExpenseDateBetween(user, from, to);
        return list.stream()
                .collect(Collectors.groupingBy(
                        exp -> exp.getCategory() == null ? "Uncategorized" : exp.getCategory(),
                        Collectors.summingDouble(Expense::getAmount)
                ));
    }
}
