package ua.lviv;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CarDAO {

    private final Connection connection;
    private final Logger logger = Logger.getLogger("first");
    private final String SELECT_ALL = "Select * from cars";
    private final String SELECT_BY_ID = "Select * from cars where car_id = ?";
    private final String DELETE_BY_ID = "delete from cars where car_id = ?";
    private final String UPDATE_ALL_FIELDS = "update cars set model = ?, max_speed = ?, is_new = ? where car_id = ?";
    private final String INSERT = "insert into cars (model, max_speed, is_new) values(?, ?, ?)";
    private final String EXISTS_BY_ID = "select count(*) from cars where car_id = ?";


    public CarDAO() {
        this.connection = ConnectionUtil.getConnection();
    }

    public List<Car> selectAll(){
        List<Car> carList = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL)) {
            while (resultSet.next()){
                carList.add(Car.of(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.log( Level.WARNING, "Cannot return data from method \"selectAll\"");
        }
        return carList;
    }

    public Car selectById(int id){
        Car car = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            car = Car.of(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            logger.log( Level.WARNING, "Cannot return data from method \"selectById\"");
        }
        return car;
    }

    public boolean deleteById(int id){
        boolean isSuccess = false;
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID)) {
            preparedStatement.setInt(1, id);
            int i = preparedStatement.executeUpdate();
            if(i == 1)
                isSuccess = true;
        } catch (SQLException e) {
            e.printStackTrace();
            logger.log( Level.WARNING, "Cannot delete data, method \"deleteById\"");
        }
        return isSuccess;
    }

    public boolean updateAllFields(int carId, String model, int maxSpeed, boolean isNew){
        boolean isSuccess = false;
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ALL_FIELDS)) {
            preparedStatement.setString(1, model);
            preparedStatement.setInt(2, maxSpeed);
            preparedStatement.setBoolean(3, isNew);
            preparedStatement.setInt(4, carId);
            int i = preparedStatement.executeUpdate();
            if(i == 1)
                isSuccess = true;
        } catch (SQLException e) {
            e.printStackTrace();
            logger.log( Level.WARNING, "Cannot update data, method \"updateAllFields\"");
        }
        return isSuccess;
    }

    public int insert(String model, int maxSpeed, boolean isNew){
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, model);
            preparedStatement.setInt(2, maxSpeed);
            preparedStatement.setBoolean(3, isNew);
            preparedStatement.executeUpdate();
            ResultSet generatedKey = preparedStatement.getGeneratedKeys();
            generatedKey.next();
            return generatedKey.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
            logger.log( Level.WARNING, "Cannot insert data, method \"insert\"");
            return 0;
        }
    }

    public boolean existsById(int id){
        boolean isExists = false;
        try (PreparedStatement preparedStatement = connection.prepareStatement(EXISTS_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int result = resultSet.getInt(1);
            if (result == 1) {
                isExists = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.log( Level.WARNING, "Cannot check data in method \"existsById\"");
        }
        return isExists;
    }

}
