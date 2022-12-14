package bd.DAO_Classes;

import fc.films.AgeRestriction;
import fc.films.BluRay;
import fc.films.Categories;
import fc.films.Film;
import fc.films.QRCode;
import fc.films.StatesBluRay;
import fc.films.Support;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;
import java.util.ArrayList;

public class FilmsDAO extends DAO<Film>{
    
    public FilmsDAO(Connection conn)
    {
        super(conn);
    }

    @Override
    public Film read(int id) {
        Film film = null;
        try{

            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery("SELECT * FROM Films NATURAL JOIN FilmsCategories WHERE filmID ="+id);
            ResultSet resultActorName = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery("SELECT CONCAT(CONCAT(actorFirstName,''),actorLastName) AS actorName FROM FilmsActors NATURAL JOIN Actors WHERE filmID ="+id);
            ResultSet resultCatName = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery("SELECT catName FROM FilmsCategories NATURAL JOIN Categories WHERE filmID ="+id);
            ResultSet resultSupp = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery("SELECT supportFilmID, typeFilm FROM SupportFilms WHERE filmID="+id);

            if(result.first() && resultActorName.first() && resultCatName.first() && resultSupp.first()){
                String title = result.getString("title");

                String synopsis = result.getString("synopsis");

                ArrayList<String> actors = new ArrayList<String>();
                while(resultActorName.next()){
                    actors.add(resultActorName.getString("actorName"));
                }

                Year year = Year.of(result.getInt("year"));

                String FNDirector = result.getString("directorFirstName");

			    String LNDirector = result.getString("directorLastName");

                AgeRestriction restriction = AgeRestriction.valueOf(result.getString("restrictedAge"));

                ArrayList<Categories> categories = new ArrayList<Categories>();
                while(resultActorName.next()){
                    categories.add(Categories.valueOf(resultCatName.getString("catName")));
                }

                ArrayList<Support >supports = new ArrayList<>();

                if(resultSupp.getString("typeFilm") == "BR"){
                    ResultSet resultSuppID = this.connect.createStatement().executeQuery("SELECT price, state FROM BluRays WHERE supportFilmID="+resultSupp.getString("supportFilmID"));
                    if(resultSuppID.first())
                    supports.add(new BluRay(resultSuppID.getDouble("price"), StatesBluRay.valueOf(resultSuppID.getString("state"))));
                }
                if(resultSupp.getString("typeFilm") == "QR"){
                    ResultSet resultSuppID = this.connect.createStatement().executeQuery("SELECT QRCodeID, link FROM QRCodes WHERE supportFilmID="+resultSupp.getString("supportFilmID"));
                    if(resultSuppID.first())
                    supports.add(new QRCode(resultSuppID.getString("link")));
                }

                film = new Film(title, synopsis, actors, FNDirector, LNDirector, year, categories, restriction, supports);
            }            
            
        }
        catch (SQLException e) { e.printStackTrace(); }
        return film;
        
    }

    @Override
    public boolean create(Film obj) {
        
        return false;
    }

    @Override
    public boolean update(Film obj) {
        
        return false;
    }

    @Override
    public boolean delete(Film obj) {
        
        return false;
    }
}
