package data_layer.services;

import data_layer.models.Movie;
import data_layer.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void updateMovie(String title,long id) {
        Optional<Movie> movieOptional = movieRepository.findById((int)id);

        if (movieOptional.isPresent()) {
            Movie m=movieOptional.get();
            m.setTitle(title);
            movieRepository.save(m);
        }
    }


}
