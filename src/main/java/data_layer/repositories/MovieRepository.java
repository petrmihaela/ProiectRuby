package data_layer.repositories;

import data_layer.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    Movie findByTitleEquals(String title);

    void deleteById(Long id);

    @Modifying
    @Query("update Movie u set u.title = ?1 where u.id = ?2")
    void setMovieTitleById(String title, Long id);

    @Modifying
    @Query("update Movie u set u.rating = ?1 where u.id = ?2")
    void setMovieRatingById(String rating, Long id);
}
