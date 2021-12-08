package com.ktds.brief.domain.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ktds.brief.domain.entity.Data;

public interface DataRepository extends JpaRepository<Data, String>{

}
