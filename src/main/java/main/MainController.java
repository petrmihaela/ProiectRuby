package main;

import data_layer.models.Movie;
import data_layer.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
public class MainController {

    @Autowired
    MovieService movieService;

    @RequestMapping("/movies")
    @ResponseBody
    public List<String> getAllMovies() {

        List<String> myList = new ArrayList<>();
        List<Movie> movies = movieService.getAllMovies();
        for (Movie m : movies)
            myList.add(m.toString());
        return myList;

    }

    @RequestMapping(value = "/movies/withTitle", method = RequestMethod.GET)
    @ResponseBody
    public List<String> getMoviesWithTitle(@RequestParam(name = "title") String t) {

        List<String> myList = new ArrayList<>();
        List<Movie> movies = movieService.findMoviesWithTitle(t);
        for (Movie m : movies)
            myList.add(m.toString());
        return myList;

    }

    @RequestMapping(value = "/movies/addMovie", method = RequestMethod.POST)
    @ResponseBody
    public void set(@RequestParam("title") String title, @RequestParam("rating") String rating, @RequestParam("year") String year) {

        Movie m = new Movie(title, rating, year);
        movieService.saveMovie(m);
    }

    @RequestMapping(value = "/movies/deleteMovie", method = RequestMethod.DELETE)
    @ResponseBody
    @Transactional
    public void deleteMovieWithId(@RequestParam("id") long id) {
        movieService.deleteMovieById(id);
    }

    @RequestMapping(value = "/movies/updateMovieTitle", method = RequestMethod.PUT)
    @ResponseBody
    @Transactional
    public void updateMovieTitleWithId(@RequestParam("id") long id,@RequestParam("title") String title) {
        movieService.updateMovieTitleWithId(id,title);
    }

    @RequestMapping(value = "/movies/updateMovieRating", method = RequestMethod.PUT)
    @ResponseBody
    @Transactional
    public void updateMovieRatingWithId(@RequestParam("id") long id,@RequestParam("rating") String rating) {
        movieService.updateMovieRatingWithId(id,rating);
    }

}
