package com.biz.ajax01.mapper;

// 2015년 이후 mybatis에서 사용가능한 클래스. 실무에서 사용예를 보진 못했다.
import org.apache.ibatis.jdbc.SQL;

public class DeptSQLBuilder {

	public String getSelectAllSQL() {
		
		// C#의 LINQ를 가져온것 같은st
		SQL sql = new SQL()
				.SELECT("*")
				.FROM("tbl_dept")
				.ORDER_BY("d_code");
		
		return sql.toString();
	}
	
	public String getInsertSQL() {
		
		// SQLBuilder(Mybatis 3.x에서 새로 도입된
		// SQL 작성기의 초기버전
		// 1.7이하에서 컴파일 오류가능성
		// 문장을 만드는 과정에서 오류검사를 해주고 있음.
		SQL sql = new SQL()
		.INSERT_INTO("tbl_dept")
		.INTO_COLUMNS("d_code")
		.INTO_VALUES("#{d_code,jdbcType=VARCHAR}")
		
		.VALUES("d_name","#{d_name,jdbcType=VARCHAR}")
		.VALUES("d_ceo", "#{d_ceo,jdbcType=VARCHAR}");
		
		
		return sql.toString();
	}
	
	public String getUpdateSQL() {
		
		SQL sql = new SQL()
				.UPDATE("tbl_dept")
				.SET("d_code = #{d_code,jdbcType=VARCHAR}")
				.SET("d_name = #{d_name,jdbcType=VARCHAR}")
				.SET("d_ceo = #{d_ceo,jdbcType=VARCHAR}")
				.WHERE("d_code = #{d_code,jdbcType=VARCHAR}");
				
		return sql.toString();
	}
	
	public String getDelete() {
		SQL sql = new SQL()
				.DELETE_FROM("tbl_dept")
				.WHERE("d_code = #{d_code}");
		
		return sql.toString();
					
	}
}
