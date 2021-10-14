package com.dataprovider.sensitivedataapi.model;

import com.dataprovider.sensitivedataapi.model.dto.SensitiveDataDto;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
public class SensitiveDataEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String cpf;
  private String address;
  private String customerName;

  @OneToMany(mappedBy = "sensitiveData", cascade = CascadeType.ALL)
  private Set<DebtEntity> debts;

  private LocalDateTime updatedAt;

  public static SensitiveDataEntity newInstance(SensitiveDataDto dto) {
    Set<DebtEntity> debts = new HashSet<>();
    SensitiveDataEntity sensitiveData = SensitiveDataEntity.builder()
        .cpf(dto.getCpf())
        .address(dto.getAddress())
        .customerName(dto.getCustomerName())
        .build();

    dto.getDebts().forEach(debtDto -> debts.add(DebtEntity.newInstance(debtDto, sensitiveData)));
    sensitiveData.setDebts(debts);
    return sensitiveData;
  }
}
