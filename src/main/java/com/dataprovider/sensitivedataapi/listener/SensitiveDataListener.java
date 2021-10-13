package com.dataprovider.sensitivedataapi.listener;

import com.dataprovider.sensitivedataapi.model.dto.SensitiveDataDto;
import com.dataprovider.sensitivedataapi.service.SensitiveDataService;
import com.dataprovider.sensitivedataapi.util.ObjectConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SensitiveDataListener {

  @Autowired
  private SensitiveDataService service;

  @Autowired
  private ObjectConverter converter;

  @RabbitListener(queues = "sensitive-data-queue")
  public void sensitiveDataQueueListener(@Payload String payload){
    log.info("M=SensitiveDataListener.sensitiveDataQueueListener, payload={}", payload);
    SensitiveDataDto dto = converter.toObject(payload, SensitiveDataDto.class);

    service.saveUpdateDataFromCustomer(dto);
  }
}
