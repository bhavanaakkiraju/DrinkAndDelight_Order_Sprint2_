package com.capg.dadims.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.dadims.dao.RawMaterialOrderDao;
import com.capg.dadims.entity.RawMaterialOrderDetails;

@Service
@Transactional
public class RawMaterialServiceImpl implements RawMaterialService{

	@Autowired
	RawMaterialOrderDao materialorder;


	@Override
	public RawMaterialOrderDetails addRawMaterialOrder(RawMaterialOrderDetails details) {
		// TODO Auto-generated method stub
		return materialorder.save(details);
	}
}
