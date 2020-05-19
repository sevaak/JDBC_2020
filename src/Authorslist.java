import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Authorslist {
    static ArrayList<Authors> authorlist = new ArrayList<>();

    public static void fillAuthors() throws SQLException {
        ConnectionDB.myConnection();
        Statement statement = ConnectionDB.myConnection().createStatement();
        ResultSet result = statement.executeQuery("Select * from bookstore");

        while (result.next()) {

            Authors author = new Authors();
            author.setAuthorid(result.getInt("Authorid"));
            author.setName(result.getString("LastName"));
            author.setSname(result.getString("FirstName"));
            author.setBookname(result.getString("bookname"));

            authorlist.add(author);

        }

    }

    public static ArrayList<Authors> getauthorList() {
        return authorlist;

    }

    public  static Authors searchbyID(int id) throws SQLException {
        Statement statement = ConnectionDB.myConnection().createStatement();
        ResultSet result = statement.executeQuery("Select * from bookstore where authorid=" + id);

        result.next();
        Authors author = new Authors();
        author.setAuthorid(result.getInt("Authorid"));
        author.setName(result.getString("LastName"));
        author.setSname(result.getString("FirstName"));
        author.setBookname(result.getString("bookname"));

        return author;
    }

    public static ArrayList<Authors> searchbyName(String name) throws SQLException {
        ArrayList<Authors> authorbyName = new ArrayList<>();
        Statement statement = ConnectionDB.myConnection().createStatement();
        ResultSet result = statement.executeQuery("Select * from bookstore where FirstName='" + name + "'");

        while (result.next()) {
            Authors author = new Authors();
            author.setAuthorid(result.getInt("Authorid"));
            author.setName(result.getString("LastName"));
            author.setSname(result.getString("FirstName"));
            author.setBookname(result.getString("bookname"));
            authorbyName.add(author);

        }

        return authorbyName;

    }

    public static ArrayList<Authors> searchbyDate(String date) throws SQLException {
        ArrayList<Authors> authorbyDate = new ArrayList<>();
        Statement statement = ConnectionDB.myConnection().createStatement();
        ResultSet result = statement.executeQuery("Select * from bookstore where date='" + date + "'");

        while (result.next()) {
            Authors author = new Authors();
            author.setAuthorid(result.getInt("Authorid"));
            author.setName(result.getString("LastName"));
            author.setSname(result.getString("FirstName"));
            author.setBookname(result.getString("bookname"));

            authorbyDate.add(author);
        }

        return authorbyDate;

    }

    public void insertAuthors(Authors object) throws SQLException {
        Statement statement = ConnectionDB.myConnection().createStatement();
        statement.executeUpdate("insert into bookstore values(null,'" + object.getName() + "','" + object.getSname() + "','"
                + object.getBookname() + "')");
    }
}
