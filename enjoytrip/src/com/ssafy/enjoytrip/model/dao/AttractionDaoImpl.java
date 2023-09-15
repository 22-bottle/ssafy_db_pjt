package com.ssafy.enjoytrip.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.enjoytrip.model.AttractionInfoDto;
import com.ssafy.util.DBUtil;

public class AttractionDaoImpl implements AttractionDao {

	private AttractionDaoImpl() {}
	
	private static AttractionDao attractionDao = new AttractionDaoImpl();

	public static AttractionDao getAttractionDao() {
		return attractionDao;
	}

	private DBUtil dbUtil = DBUtil.getInstance();

	@Override
	public List<AttractionInfoDto> attractionList(AttractionInfoDto attractionInfoDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		AttractionInfoDto a = null;
		List<AttractionInfoDto> list = new ArrayList<AttractionInfoDto>();
		try {
			conn = dbUtil.getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append(" select * from attraction_info \n");
			sb.append("	where sido_code = ? and content_type_id = ?");
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, attractionInfoDto.getSidoCode());
			pstmt.setInt(2, attractionInfoDto.getContentTypeId());
			rs = pstmt.executeQuery();
//			list = new ArrayList();
			while (rs.next()) {
				a = new AttractionInfoDto();
				int contentId = rs.getInt(1);
				int contentTypeId = rs.getInt(2);
				String title = rs.getString(3);
				String addr1 = rs.getString(4);
				String addr2 = rs.getString(5);
				String zipcode = rs.getString(6);
				String tel = rs.getString(7);
				String firstImage = rs.getString(8);
				String firstImage2 = rs.getString(9);
				int readCount = rs.getInt(10);
				int sidoCode = rs.getInt(11);
				int gugunCode = rs.getInt(12);
				double latitude = rs.getDouble(13);
				double longitude = rs.getDouble(14);
				String mlevel = rs.getString(15);

				a.setContentId(contentId);
				a.setContentTypeId(contentTypeId);
				a.setTitle(title);
				a.setAddr1(addr1);
				a.setAddr2(addr2);
				a.setZipcode(zipcode);
				a.setTel(tel);
				a.setFirstImage(firstImage);
				a.setFirstImage2(firstImage2);
				a.setReadcount(readCount);
				a.setSidoCode(sidoCode);
				a.setGugunCode(gugunCode);
				a.setLatitude(latitude);
				a.setLongitude(longitude);
				a.setMlevel(mlevel);
//				System.out.println(a);
//				rs.getString(1),rs.getString(2),rs.getString(3)
				list.add(a);
			}
		} catch (SQLException e) {
			try {
				System.out.println("롤백 실패");
				conn.rollback();
			} catch (SQLException e1) {
				System.out.println("rollback Error");
			}
			// TODO Auto-generated catch block
		} finally {
			dbUtil.close(rs);
			dbUtil.close(pstmt);
			dbUtil.close(conn);
		}
//		END
//		list.sort((o1,o2)->o1.getArticleNo()-o2.getArticleNo());
		return list;
	}

	@Override
	public List<AttractionInfoDto> searchByTitle(String title, int sidoCode) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		AttractionInfoDto a = null;
		List<AttractionInfoDto> list = new ArrayList<AttractionInfoDto>();
		try {
			conn = dbUtil.getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append(" select * from attraction_info \n");
			sb.append("	where title like ? and sido_code = ? limit 10");
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, '%' + title + '%');
			pstmt.setInt(2, sidoCode);
			rs = pstmt.executeQuery();
//			list = new ArrayList();
			while (rs.next()) {
				a = new AttractionInfoDto();
				int contentId = rs.getInt(1);
				int contentTypeId = rs.getInt(2);
				String t_title = rs.getString(3);
				String addr1 = rs.getString(4);
				String addr2 = rs.getString(5);
				String zipcode = rs.getString(6);
				String tel = rs.getString(7);
				String firstImage = rs.getString(8);
				String firstImage2 = rs.getString(9);
				int readCount = rs.getInt(10);
				int s_sidoCode = rs.getInt(11);
				int gugunCode = rs.getInt(12);
				double latitude = rs.getDouble(13);
				double longitude = rs.getDouble(14);
				String mlevel = rs.getString(15);

				a.setContentId(contentId);
				a.setContentTypeId(contentTypeId);
				a.setTitle(t_title);
				a.setAddr1(addr1);
				a.setAddr2(addr2);
				a.setZipcode(zipcode);
				a.setTel(tel);
				a.setFirstImage(firstImage);
				a.setFirstImage2(firstImage2);
				a.setReadcount(readCount);
				a.setSidoCode(s_sidoCode);
				a.setGugunCode(gugunCode);
				a.setLatitude(latitude);
				a.setLongitude(longitude);
				a.setMlevel(mlevel);
//				System.out.println(a);
//				rs.getString(1),rs.getString(2),rs.getString(3)
				list.add(a);
			}
		} catch (SQLException e) {
			try {
				System.out.println("롤백 실패");
				conn.rollback();
			} catch (SQLException e1) {
				System.out.println("rollback Error");
			}
			// TODO Auto-generated catch block
		} finally {
			dbUtil.close(rs);
			dbUtil.close(pstmt);
			dbUtil.close(conn);
		}
//		END
//		list.sort((o1,o2)->o1.getArticleNo()-o2.getArticleNo());
		return list;
	}

}
