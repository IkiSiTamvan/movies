package com.tamvan.movie.movie;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MovieController {
    @Autowired
    MovieService movieService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/movies")
    public ResponseEntity<List<MovieDto>> getAllMovies(@RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size) {

        List<Movie> movies = movieService.getAllMovies(page, size);
        List<MovieDto> movieDtos = movies.stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(movieDtos, HttpStatus.OK);
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<MovieDto> getMovieById(@PathVariable("id") Integer id) {

        Optional<Movie> movie = movieService.getMovieById(id);
        if (movie.isPresent()) {
            return new ResponseEntity<>(convertToDto(movie.get()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/movies/title/{title}")
    public ResponseEntity<List<MovieDto>> getMovieByTitle(@PathVariable("title") String title) {

        List<Movie> movies = movieService.getMoviesByTitle(title);
        List<MovieDto> movieDtos = movies.stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(movieDtos, HttpStatus.OK);
    }

    @PostMapping("/movies")
    public ResponseEntity<MovieDto> createMovie(@Valid @RequestBody MovieDto movieDto) {
        try {
            Movie movie = movieService.save(new Movie(movieDto.getTitle(), movieDto.getDescription(),
                    movieDto.getRating(), movieDto.getImage(), movieDto.getLastPlaying()));
            return new ResponseEntity<>(convertToDto(movie), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/movies/{id}")
    public ResponseEntity<MovieDto> updateMovie(@PathVariable("id") Integer id, @Valid @RequestBody MovieDto movieDto) {
        Optional<Movie> movieOp = movieService.getMovieById(id);
        if (movieOp.isPresent()) {
            Movie updateMovie = movieOp.get();
            updateMovie.setTitle(movieDto.getTitle());
            updateMovie.setDescription(movieDto.getDescription());
            updateMovie.setImage(movieDto.getImage());
            updateMovie.setRating(movieDto.getRating());
            updateMovie.setLastPlaying(movieDto.getLastPlaying());

            return new ResponseEntity<>(convertToDto(movieService.save(updateMovie)), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/movies/{id}")
    public ResponseEntity<HttpStatus> deleteMovie(@PathVariable("id") Integer id) {
        Optional<Movie> movie = movieService.getMovieById(id);
        if (movie.isPresent()) {
            movieService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    private MovieDto convertToDto(Movie movie) {
        MovieDto dto = modelMapper.map(movie, MovieDto.class);
        return dto;
    }

}
