package com.dataprovider.sensitivedataapi.resource;

import com.dataprovider.sensitivedataapi.model.dto.SensitiveDataDto;
import com.dataprovider.sensitivedataapi.service.SensitiveDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SensitiveDataResource {

  @Autowired
  private SensitiveDataService service;

  @GetMapping
  public void getScoreDataFromCustomer(@PathVariable String cpf) {
      SensitiveDataDto scoreDataDto = service.getScoreDataFromCustomer(cpf);
  }
}
