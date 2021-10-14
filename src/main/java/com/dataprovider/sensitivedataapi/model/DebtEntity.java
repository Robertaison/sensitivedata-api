package com.dataprovider.sensitivedataapi.model;

import com.dataprovider.sensitivedataapi.model.dto.DebtDto;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class DebtEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String creditorName;
  private String creditorDocument;
  private String currentDebitAmount;
  private String initialDebitAmount;
  private LocalDateTime initialData;

  @ManyToOne
  private SensitiveDataEntity sensitiveData;

  public static DebtEntity newInstance(DebtDto debtDto, SensitiveDataEntity entity) {
    return DebtEntity.builder()
        .creditorName(debtDto.getCreditorName())
        .creditorDocument(debtDto.getCreditorDocument())
        .currentDebitAmount(debtDto.getCurrentDebitAmount())
        .initialDebitAmount(debtDto.getInitialDebitAmount())
        .initialData(LocalDateTime.parse(debtDto.getInitialData()))
        .sensitiveData(entity)
        .build();
  }
}
