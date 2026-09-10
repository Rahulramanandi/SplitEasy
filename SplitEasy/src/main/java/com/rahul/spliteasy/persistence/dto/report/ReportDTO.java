package com.rahul.spliteasy.persistence.dto.report;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportDTO {

    String groupName;

    String expenseName;

    String expenseOwner;

    List<String> expenseContributors;

    double totalExpenseAmount;

}
