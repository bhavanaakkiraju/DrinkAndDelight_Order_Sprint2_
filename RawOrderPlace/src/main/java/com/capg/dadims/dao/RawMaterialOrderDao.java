package com.capg.dadims.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.dadims.entity.RawMaterialOrderDetails;

public interface RawMaterialOrderDao extends JpaRepository<RawMaterialOrderDetails, Integer> {

}
