package zy.springbootdemo.database.databasedemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import zy.springbootdemo.database.databasedemo.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User getUser(Long userId) {
        String sql = "select * from user where id=?";
        User user = jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
               User user = new User();
               user.setId(resultSet.getLong("id"));
               user.setName(resultSet.getString("name"));
               user.setDepartmentId(resultSet.getLong("department_id"));
                user.setCreateTime(resultSet.getDate("create_time"));
               return user;
            }
        }, userId);
        return user;
    }
}
