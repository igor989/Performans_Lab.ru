import java.sql.*;

public class DB {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
         {
            Class.forName("org.h2.Driver");
            Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "igor", "host");

            //Statement st = connection.createStatement();
            //st.execute("CREATE TABLE People(id int(20) AUTO_INCREMENT, login VARCHAR(255), password VARCHAR(255), role varchar(255),PRIMARY KEY (id))");
            // Создание таблицы Люди с ключевым параметром id, логино, паролем и ролью

            PreparedStatement at = connection.prepareStatement("insert into PEOPLE (login,password,role) Values (?,?,?)");// Добавление строк в БД people
            at.setString(1,"IGor3");
            at.setString(2,"IGor3");
            at.setString(3,"user");
            at.execute();

             Statement st = connection.createStatement();
             //поскольку нам нужен результат, используем executeQuery
             ResultSet rs = st.executeQuery("SELECT login,password FROM people");// Запрос на вывод из таблицы данных о пользователе

             while (rs.next()) {
             //двигаем указатель набора результатов на 1 строку вниз
             System.out.println("Запись №" + rs.getRow() + "\nlogin: " + rs.getString("login") + "\npassword: " + rs.getString("password"));
         }
    }
}}
