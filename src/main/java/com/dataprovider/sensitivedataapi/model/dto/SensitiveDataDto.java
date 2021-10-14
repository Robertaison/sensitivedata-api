package com.dataprovider.sensitivedataapi.model.dto;

import com.dataprovider.sensitivedataapi.model.SensitiveDataEntity;
import java.util.HashSet;
import java.util.Set;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SensitiveDataDto {

  private String cpf;
  private String customerName;
  private String address;
  private Set<DebtDto> debts;
  private String updatedAt;

  public static SensitiveDataDto newInstance(SensitiveDataEntity sensitiveDataEntity) {
    Set<DebtDto> debts = new HashSet<>();
    sensitiveDataEntity.getDebts().forEach(
        debt -> debts.add(DebtDto.newInstance(debt))
    );

    return SensitiveDataDto.builder()
        .cpf(sensitiveDataEntity.getCpf())
        .customerName(sensitiveDataEntity.getCustomerName())
        .address(sensitiveDataEntity.getAddress())
        .debts(debts)
        .build();
  }
}

