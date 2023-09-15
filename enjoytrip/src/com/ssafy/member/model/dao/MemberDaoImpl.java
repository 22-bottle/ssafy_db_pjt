package com.ssafy.member.model.dao;

import java.sql.Connection;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ssafy.member.model.MemberDto;
import com.ssafy.util.DBUtil;

public class MemberDaoImpl implements MemberDao {
	
	private MemberDaoImpl() {}

    private static MemberDao memberDao = new MemberDaoImpl();

    public static MemberDao getMemberDao() {
        return memberDao;
    }

	@Override
	public void registerMember(MemberDto memberDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getInstance().getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("insert into members(user_id, user_name, user_password)");
			sb.append(" values (?,?,?)");
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, memberDto.getUserId());
			pstmt.setString(2, memberDto.getUserName());
			pstmt.setString(3, memberDto.getUserPass());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.getInstance().close(pstmt);
			DBUtil.getInstance().close(conn);
		}
	}

	@Override
	public MemberDto login(String userId, String userPass) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDto m = null;
		
		try {
			conn = DBUtil.getInstance().getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("select user_name from members");
			sb.append(" where user_id = ? and user_password = ?");
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, userId);
			pstmt.setString(2, userPass);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String userName = rs.getString("user_name");
				m = new MemberDto(userName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.getInstance().close(pstmt);
			DBUtil.getInstance().close(conn);
		}
		return m;
	}

	@Override
	public void modifyMember(MemberDto memberDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBUtil.getInstance().getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append("update members set user_name = ?, user_password = ?\n");
			sb.append("where user_id = ?");
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, memberDto.getUserName());
			pstmt.setString(2, memberDto.getUserPass());
			pstmt.setString(3, memberDto.getUserId());
			pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
//			try {
//				conn.rollback();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
		} finally {
			DBUtil.getInstance().close(pstmt);
			DBUtil.getInstance().close(conn);
		}
	}

	@Override
	public void deleteMember(String userId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getInstance().getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append("delete from members\n");
			sb.append("where user_id = ?");
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, userId);
			pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
//			try {
//				conn.rollback();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
		} finally {
			DBUtil.getInstance().close(pstmt);
			DBUtil.getInstance().close(conn);
		}
	}

}
