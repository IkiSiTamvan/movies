package com.tamvan.movie;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import com.tamvan.movie.movie.Movie;
import com.tamvan.movie.movie.MovieDto;

@SpringBootTest
class MovieApplicationTests {
	private ModelMapper modelMapper = new ModelMapper();
	
	@Test
    public void checkMovieDtoToEntityConversion() {
        Movie movie = new Movie();
        movie.setId(1);
        movie.setTitle("title");
        movie.setDescription("Description");
		movie.setImage("image");
		movie.setRating((float) 7.5);
		movie.setLastPlaying(new Date());


        MovieDto movieDto = modelMapper.map(movie, MovieDto.class);
        assertEquals(movie.getId(), movieDto.getId());
        assertEquals(movie.getTitle(), movieDto.getTitle());
        assertEquals(movie.getDescription(), movieDto.getDescription());
		assertEquals(movie.getImage(), movieDto.getImage());
		assertEquals(movie.getRating(), movieDto.getRating());
		assertEquals(movie.getLastPlaying(), movieDto.getLastPlaying());
    }
	

}
