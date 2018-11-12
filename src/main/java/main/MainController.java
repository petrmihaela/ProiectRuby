package main;

import data_layer.dto.MovieDeleteDTO;
import data_layer.models.Movie;
import data_layer.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


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
    public Movie getMovieWithTitle(@RequestParam(name = "title") String t) {


        Movie m = movieService.findMovieWithTitle(t);

        return m;

    }

    @RequestMapping(value = "/movies/addMovie", method = RequestMethod.POST)
    @ResponseBody
    public void set(@RequestBody Movie movie) {
        System.out.println(movie.toString());
        movieService.saveMovie(movie);
    }

    @RequestMapping(value = "/movies/deleteMovie", method = RequestMethod.DELETE)
    @ResponseBody
    @Transactional
    public void deleteMovieWithId(@RequestBody MovieDeleteDTO movieDTO) {
        movieService.deleteMovieById(movieDTO.getId());
    }

    @RequestMapping(value = "/movies/updateMovie", method = RequestMethod.PUT)
    @ResponseBody
    @Transactional
    public void updateMovieTitleWithId(@RequestBody Movie movie) {
        movieService.updateMovie(movie);
    }

    @RequestMapping(value = "/")
    @ResponseBody
    public String index(){
        return "Felicitari, mi-ai descoperit aplicatia!";
    }
}
