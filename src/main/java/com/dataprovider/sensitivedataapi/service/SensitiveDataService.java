package com.dataprovider.sensitivedataapi.service;

import com.dataprovider.sensitivedataapi.model.dto.SensitiveDataDto;

public interface SensitiveDataService {
  SensitiveDataDto getScoreDataFromCustomer(String cpf);
  void saveUpdateDataFromCustomer(SensitiveDataDto dto);
}
