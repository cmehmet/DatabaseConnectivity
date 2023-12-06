import java.sql.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException {

        selectData();


    }

    public static void selectData() throws SQLException {
        DBHelper dbHelper = new DBHelper();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<Country> countries = new ArrayList<Country>();
        try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select Code, Name, Continent, Region, Population from country");
            while (resultSet.next()) {
                countries.add(new Country(
                        resultSet.getString("Code"),
                        resultSet.getString("Name"),
                        resultSet.getString("Continent"),
                        resultSet.getString("Region"),
                        resultSet.getInt("Population")));
            }
            System.out.println(countries.size());
            for (Country country : countries){
                System.out.println(country.getName());
            }
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        } finally {
            statement.close();
            connection.close();
        }
    }

    public static void insertData() throws SQLException {
        DBHelper dbHelper = new DBHelper();
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = dbHelper.getConnection();
            //String sql = "insert into city (Name,CountryCode,District,Population) values(?,?,?,?)";
            statement = connection.prepareStatement("insert into city (Name,CountryCode,District,Population) values(?,?,?,?)");
            statement.setString(1,"Amasya 2");
            statement.setString(2,"TUR");
            statement.setString(3,"Amasya 2");
            statement.setInt(4,450000);
            statement.executeUpdate();
            System.out.println("Kayıt eklendi.");
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        } finally {
            statement.close();
            connection.close();
        }
    }

    public static void updateData() throws SQLException {
        DBHelper dbHelper = new DBHelper();
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = dbHelper.getConnection();
            //String sql = "update city set Population = 500000 where id = 4087";
            statement = connection.prepareStatement("update city set Population = 470000,District = 'Tur' where id = ?");
            statement.setInt(1,4087);
            statement.executeUpdate();
            System.out.println("Kayıt güncellendi.");
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        } finally {
            statement.close();
            connection.close();
        }
    }

    public  static void deleteData() throws SQLException {
        DBHelper dbHelper = new DBHelper();
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = dbHelper.getConnection();
            //String sql = ""update city set Population = 500000 where id = 4087"";
            statement = connection.prepareStatement("delete from city where id = ?");
            statement.setInt(1,4087);
            statement.executeUpdate();
            System.out.println("Kayıt silindi.");
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        } finally {
            statement.close();
            connection.close();
        }

    }
}