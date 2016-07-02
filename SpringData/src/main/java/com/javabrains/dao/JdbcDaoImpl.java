package com.javabrains.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.javabrains.model.Circle;

@Component
public class JdbcDaoImpl {
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private SimplejdbcTemplate simpleJdbcTemplate;
	
	/*public Circle getCircle(int circleId) {
		
		Connection conn = null;
		
		conn = dataSource.getConnection();
		
		return null;
	}*/
	
	public int getCircleCount() {
		String sql = "SELECT COUNT(*) FROM CIRCLE";
//		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.queryForInt(sql);
	}

	public String getCircleName(int circleId) {
		String sql = "SELECT NAME FROM CIRCLE WHERE ID = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {circleId}, String.class);
		
	}
	
	public Circle getCircleforId(int circleId) {
		String sql = "SELECT * FROM CIRCLE WHERE ID = ?";
		return jdbcTemplate.queryForObject(sql,new Object[] {circleId}, new CircleMapper());
	}
	
	public List<Circle> getAllCircle() {
		String sql = "SELECT * FROM CIRCLE";
		return jdbcTemplate.query(sql, new CircleMapper());
	}
	
	/*public void insertCircle(Circle circle) {
		String sql = "INSERT INTO CIRCLE (ID, NAME) VALUE (?,?)";
		jdbcTemplate.update(sql, new Object[] {circle.getId(), circle.getName()});
	}*/
	
	
	public void insertCircle(Circle circle) {
		String sql = "INSERT INTO CIRCLE (ID, NAME) VALUE (:id, :name)";
		SqlParameterSource namedParameters = new MapSqlParameterSource("id", circle.getId())
							.addValue("name", circle.getName());
		namedParameterJdbcTemplate.update(sql, namedParameters);
		
	}
		
		
		
		
	public void createTriangleTable() {
		String sql = "CREATE TABLE TRIANGLE (ID INTEGER< NAME VARCHAR(50))";
		jdbcTemplate.execute(sql);
	}
	
	
	
	
	private static final class CircleMapper implements RowMapper<Circle>{

		public Circle mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Circle circle = new Circle();
			circle.setId(resultSet.getInt("ID"));
			circle.setName(resultSet.getString("NAME"));
			return circle;
		}
		
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
}