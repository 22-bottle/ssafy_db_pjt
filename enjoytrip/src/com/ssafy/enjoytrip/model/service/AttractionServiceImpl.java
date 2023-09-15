package com.ssafy.enjoytrip.model.service;

import java.util.List;

import com.ssafy.enjoytrip.model.AttractionInfoDto;
import com.ssafy.enjoytrip.model.dao.AttractionDaoImpl;

public class AttractionServiceImpl implements AttractionService {

	// 1. 기본 priavte 생성자
	private AttractionServiceImpl() {}
	private static AttractionServiceImpl instance = new AttractionServiceImpl();
	
	public static AttractionServiceImpl getAttractionService() {
		if(instance == null) {
			instance = new AttractionServiceImpl();
		}
		return instance;
	}
	
	@Override
	public List<AttractionInfoDto> attractionList(AttractionInfoDto attractionInfoDto) {
		return AttractionDaoImpl.getAttractionDao().attractionList(attractionInfoDto);
	}

	@Override
	public List<AttractionInfoDto> searchByTitle(String title, int sidoCode) {
		// TODO Auto-generated method stub
		return AttractionDaoImpl.getAttractionDao().searchByTitle(title, sidoCode);
	}

}
