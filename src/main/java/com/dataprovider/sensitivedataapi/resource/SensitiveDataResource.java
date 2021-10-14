package com.dataprovider.sensitivedataapi.resource;

import com.dataprovider.sensitivedataapi.model.dto.SensitiveDataDto;
import com.dataprovider.sensitivedataapi.service.SensitiveDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SensitiveDataResource {

  @Autowired
  private SensitiveDataService service;

  @GetMapping(value = "/sensitive-data")
  public ResponseEntity<SensitiveDataDto> getScoreDataFromCustomer(@RequestParam String cpf) {
    log.info("ScoreDataResource.getScoreDataFromCustomer, cpf={}", cpf);

    SensitiveDataDto scoreDataDto = service.getScoreDataFromCustomer(cpf);
    return ResponseEntity.ok(scoreDataDto);
  }
}
