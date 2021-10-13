package com.dataprovider.sensitivedataapi.repository;

import com.dataprovider.sensitivedataapi.model.SensitiveDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensitiveDataRepository extends JpaRepository<SensitiveDataEntity, Integer> {
}
