package com.alan.yx.springInAction.Chapter_01.knight.src.main.java.sia.knights;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Logger;

/**
 * 示例 1.12
 * 示例 1.13
 *
 * @author yinxing
 * @date 2019/4/20
 */

public class JDBCAcessData {

    private DataSource dataSource = new DataSource() {
        @Override
        public Connection getConnection() throws SQLException {
            return null;
        }

        @Override
        public Connection getConnection(String username, String password) throws SQLException {
            return null;
        }

        @Override
        public <T> T unwrap(Class<T> iface) throws SQLException {
            return null;
        }

        @Override
        public boolean isWrapperFor(Class<?> iface) throws SQLException {
            return false;
        }

        @Override
        public PrintWriter getLogWriter() throws SQLException {
            return null;
        }

        @Override
        public void setLogWriter(PrintWriter out) throws SQLException {

        }

        @Override
        public void setLoginTimeout(int seconds) throws SQLException {

        }

        @Override
        public int getLoginTimeout() throws SQLException {
            return 0;
        }

        @Override
        public Logger getParentLogger() throws SQLFeatureNotSupportedException {
            return null;
        }
    };


    /**
     * 示例 1.12
     * @param id
     * @return
     */
    public Employee getEmployeeById(Long id) {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            conn = dataSource.getConnection();
            // 查找员工
            statement = conn.prepareStatement("SELECT id,name,salary FROM  emplyee WHERE id=?");
            statement.setLong(1, id);
            rs = statement.executeQuery();
            Employee employee = null;
            if (rs.next()) {
                // 根据数据创建对象
                employee = new Employee();
                employee.setId(rs.getLong("id"));
                employee.setName(rs.getString("name"));
                employee.setSalary(rs.getDouble("salary"));
            }
            return employee;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * 示例 1.13
     * @param id
     * @return
     */
/*    public Employee getEmployeeById2(Long id) {
        return jbdcTemplate.queryForObject(
                "SELECT id,name,salary FROM  emplyee WHERE id=?",
                new RowMapper<Employee>(){
                    // 将查询结果匹配对象
                    public Employee mapRow(ResultSet rs,int rowNum) throws SQLException {
                        Employee employee = new Employee();
                        employee = new Employee();
                        employee.setId(rs.getLong("id"));
                        employee.setName(rs.getString("name"));
                        employee.setSalary(rs.getDouble("salary"));
                        return employee;
                    }
                },
                // 指定查询参数
                id);
    }*/
}
