package data_layer.services;

import data_layer.models.Movie;
import data_layer.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public Movie findMovieWithTitle(String title) {
        return movieRepository.findByTitleEquals(title);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public void saveMovie(Movie m) {
        movieRepository.save(m);
    }

    public void deleteMovieById(Long id) {

            movieRepository.deleteById(id);
    }

    public void updateMovie(long id,String title){
        movieRepository.setMovieTitleById(title,id);
    }

}
