package uno.dos.tres.dao.impl;

import uno.dos.tres.bean.AuthInfo;
import uno.dos.tres.bean.RegInfo;
import uno.dos.tres.bean.User;
import uno.dos.tres.bean.UserRoles;
import uno.dos.tres.dao.AuthDao;
import uno.dos.tres.dao.ConnectionPool.ConnectionPool;
import uno.dos.tres.dao.ConnectionPool.ConnectionPoolException;
import uno.dos.tres.dao.DaoException;

import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class SQLAuthDao implements AuthDao {

    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public User checkToken(String token) throws DaoException {
        /*
		try {

		}catch(SQLException e) {
			throw new DaoException(e);
		}
		*/
        return new User("Dany", UserRoles.ADMIN);
    }

    @Override
    public User signIn(AuthInfo authInfo) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String mail = authInfo.getLogin();
        String password = authInfo.getPassword();
        String sql = "SELECT u.idusers, u.username, u.password, u.mail, u.status, r.idroles, r.title " +
                "FROM users u " +
                "JOIN users_has_roles ur ON u.idusers = ur.users_idusers " +
                "JOIN roles r ON ur.roles_idroles = r.idroles " +
                "WHERE u.mail = ? AND u.password = ?";
        try {
            connection = connectionPool.takeConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, mail);
            statement.setString(2, password);
            resultSet = statement.executeQuery();
            try {
                if (resultSet.next()) {
                    String username = resultSet.getString("username");
                    UserRoles role = UserRoles.valueOf(resultSet.getString("title"));
                    return new User(username, role);
                } else {
                    throw new DaoException("No such user");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("BD Error", e);
        } finally {
            connectionPool.closeConnection(resultSet, statement, connection);
        }
    }
        //        if ("user@mail.ru".equals(info.getLogin())) {
//            return new User("Dany", UserRoles.USER);
//        } else if ("admin@mail.ru".equals(info.getLogin())) {
//            return new User("Justin", UserRoles.ADMIN);
//        } else {
//            return null;
//        }


        @Override
        public void signUp (RegInfo regInfo) throws DaoException {
            Connection connection = null;
            try {
                connection = getConnection("jdbc:mysql://localhost:3306/news_db", "root", "111777");
                String sql = "INSERT INTO users (username, password, mail) VALUES (?, ?, ?)";
                String username = regInfo.getUserName();
                String password = regInfo.getPassword();
                String mail = regInfo.getEmail();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                preparedStatement.setString(3, mail);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new DaoException(e);
            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                        System.out.println("Connection closed");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        @Override
        public boolean checkUserMail (RegInfo regInfo) throws DaoException {
            Connection connection = null;
            try {
                connection = getConnection("jdbc:mysql://localhost:3306/news_db", "root", "111777");
                String checkUser = "SELECT COUNT(*) FROM users WHERE mail = ?";
                PreparedStatement checkUserStatement = connection.prepareStatement(checkUser);
                String mail = regInfo.getEmail();
                checkUserStatement.setString(1, mail);
                ResultSet resultSet = checkUserStatement.executeQuery();
                if (resultSet.next()) {
                    return resultSet.getInt(1) > 0;
                }

            } catch (SQLException e) {
                throw new DaoException(e);
            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                        System.out.println("Connection closed");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
            return false;
        }
    }