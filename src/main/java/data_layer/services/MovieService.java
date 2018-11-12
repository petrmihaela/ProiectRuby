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
       // if (movieRepository.getOne(id.intValue()) != null)
            movieRepository.deleteById(id);
        //else
          //  System.out.println("Nu exista id-ul specificat!");
    }

    public void updateMovie(Movie m){
        movieRepository.save(m);
    }

}
