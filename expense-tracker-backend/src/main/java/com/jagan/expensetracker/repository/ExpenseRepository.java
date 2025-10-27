package com.jagan.expensetracker.repository;

import com.jagan.expensetracker.model.Expense;
import com.jagan.expensetracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByUser(User user);
    List<Expense> findByUserAndExpenseDateBetween(User user, LocalDate from, LocalDate to);
}
