package com.dataprovider.sensitivedataapi.repository;

import com.dataprovider.sensitivedataapi.model.DebtEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DebtRepository extends JpaRepository<DebtEntity, Integer> {
}
