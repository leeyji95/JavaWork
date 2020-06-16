package com.lec.beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.D;

public class CategoryDAO extends DefaultDAO{
	
	// 	특정 parant 밑에 있는 child category 의 목록데이터 가져오기
	
	
	// ResultSet --> DTO 배열로 리턴
		public CategoryDTO[] createArray(ResultSet rs) throws SQLException {
			CategoryDTO[] arr = null; // DTO 배열

			ArrayList<CategoryDTO> list = new ArrayList<CategoryDTO>();

			while (rs.next()) {
				int uid = rs.getInt("ca_uid");
				String name = rs.getString("ca_name");
				int depth = rs.getInt("ca_depth");
				int parent = rs.getInt("ca_parent");
				int order = rs.getInt("ca_order");

				CategoryDTO dto = new CategoryDTO(uid, name, depth, parent, order);
				list.add(dto);
			} // end while

			int size = list.size();

			if (size == 0)
				return null;

			arr = new CategoryDTO[size];
			list.toArray(arr); // List -> 배열
			return arr;
		}

		
		
		
		
		// 특정 depth 의 특정 parent 인 카테고리들 읽어오기
		public CategoryDTO[] readBydNp(int depth, int parent) throws SQLException {
			CategoryDTO[] arr = null;

			try {
				pstmt = conn.prepareStatement(D.SQL_CATEGORY_BY_DEPTH_N_PARENT);
				pstmt.setInt(1, depth);
				pstmt.setInt(2, parent);
				rs = pstmt.executeQuery();
				arr = createArray(rs);
			} finally {
				close();
			}
			return arr;
		} // end select()
	
		// 특정 depth 의 특정 parent 인 카테고리들 읽어오기
		public CategoryDTO[] readBydNp(int depth) throws SQLException {
			CategoryDTO[] arr = null;
			
			try {
				pstmt = conn.prepareStatement(D.SQL_CATEGORY_BY_DEPTH);
				pstmt.setInt(1, depth);
				rs = pstmt.executeQuery();
				arr = createArray(rs);
			} finally {
				close();
			}
			return arr;
		} // end select()
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

} // end CategoryDAO
