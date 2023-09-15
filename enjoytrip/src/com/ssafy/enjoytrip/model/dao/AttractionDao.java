package com.ssafy.enjoytrip.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.enjoytrip.model.AttractionInfoDto;

public interface AttractionDao {

	List<AttractionInfoDto> attractionList(AttractionInfoDto attractionInfoDto);

	List<AttractionInfoDto> searchByTitle(String title, int sidoCode);

}
