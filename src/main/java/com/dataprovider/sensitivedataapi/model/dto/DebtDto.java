package com.dataprovider.sensitivedataapi.model.dto;

import com.dataprovider.sensitivedataapi.model.DebtEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DebtDto {

  private String creditorName;
  private String creditorDocument;
  private String currentDebitAmount;
  private String initialDebitAmount;
  private String initialData;

  public static DebtDto newInstance(DebtEntity debt) {
    return DebtDto.builder()
        .creditorName(debt.getCreditorName())
        .creditorDocument(debt.getCreditorDocument())
        .currentDebitAmount(debt.getCurrentDebitAmount())
        .initialDebitAmount(debt.getInitialDebitAmount())
        .initialData(debt.getInitialData().toString())
        .build();
  }
}
