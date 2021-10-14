package com.dataprovider.sensitivedataapi.service.impl;

import com.dataprovider.sensitivedataapi.model.DebtEntity;
import com.dataprovider.sensitivedataapi.model.SensitiveDataEntity;
import com.dataprovider.sensitivedataapi.model.dto.SensitiveDataDto;
import com.dataprovider.sensitivedataapi.repository.SensitiveDataRepository;
import com.dataprovider.sensitivedataapi.service.SensitiveDataService;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SensitiveDataServiceImpl implements SensitiveDataService {

  @Autowired
  private SensitiveDataRepository repository;

  @Override
  public SensitiveDataDto getScoreDataFromCustomer(String cpf) {
    log.info("M=ScoreDataService.getScoreDataFromCustomer, cpf={}", cpf);
    Optional<SensitiveDataEntity> sensitiveData = repository.findByCpf(cpf);
    return sensitiveData.map(SensitiveDataDto::newInstance).orElse(null);
  }

  @Override
  public void saveUpdateDataFromCustomer(SensitiveDataDto dto) {
    log.info("M=ScoreDataService.saveUpdateDataFromCustomer, received dto={}", dto);
    Optional<SensitiveDataEntity> entityOptional = repository.findByCpf(dto.getCpf());
    entityOptional.ifPresentOrElse(
        entity -> updateAndSaveEntity(entity, dto),
        () -> repository.save(SensitiveDataEntity.newInstance(dto))
    );
  }

  private void updateAndSaveEntity(SensitiveDataEntity entity, SensitiveDataDto dto) {
    Set<DebtEntity> debts = new HashSet<>();
    dto.getDebts().forEach(
        debtDto -> debts.add(DebtEntity.newInstance(debtDto, entity))
    );

    entity.setAddress(dto.getAddress());
    entity.setCustomerName(dto.getCustomerName());
    entity.setCpf(dto.getCpf());
    entity.setDebts(debts);
    repository.saveAndFlush(entity);
  }
}
