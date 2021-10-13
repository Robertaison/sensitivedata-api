package com.dataprovider.sensitivedataapi.service.impl;

import com.dataprovider.sensitivedataapi.model.SensitiveDataEntity;
import com.dataprovider.sensitivedataapi.model.dto.SensitiveDataDto;
import com.dataprovider.sensitivedataapi.repository.SensitiveDataRepository;
import com.dataprovider.sensitivedataapi.service.SensitiveDataService;
import java.time.LocalDateTime;
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
    return null;
  }

  @Override
  public void saveUpdateDataFromCustomer(SensitiveDataDto dto) {
    log.info("M=saveUpdateDataFromCustomer, received dto={}", dto);
    SensitiveDataEntity scoreDataEntity = SensitiveDataEntity.builder()
        .cpf(dto.getCpf())
        .updatedAt(LocalDateTime.parse(dto.getUpdatedAt()))
        .build();

    repository.save(scoreDataEntity);
  }
}
