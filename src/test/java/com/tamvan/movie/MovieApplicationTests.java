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

        String[] passwords = { "PAA6WORD", "Paws5word", "pas4word" };
        String checkString = "1dro5";

        int rightUpper = Integer.valueOf(checkString.substring(0, 1));
        int rightDigit = Integer.valueOf(checkString.substring(checkString.length() - 1, checkString.length()));
        String last3 = checkString.substring(checkString.length() - 4, checkString.length() - 1);

        StringBuilder builder = new StringBuilder(last3);
        last3 = builder.reverse().toString();

        for (String password : passwords) {
            int upperCase = 0;
            int digit = 0;
            String last3pass = password.substring(password.length() - 3, password.length());
            ;
            for (int i = 0; i < password.length(); i++) {
                if (Character.isUpperCase(password.charAt(i))) {
                    upperCase += 1;
                } else if (Character.isDigit(password.charAt(i))) {
                    digit += Integer.valueOf(Character.toString(password.charAt(i)) );
                }
            }

            if (upperCase == rightUpper && digit == rightDigit && last3.equals(last3pass)) {
                rightDigit = digit;
                System.out.println(password);
            }

        }
        MovieDto movieDto = modelMapper.map(movie, MovieDto.class);
        assertEquals(movie.getId(), movieDto.getId());
        assertEquals(movie.getTitle(), movieDto.getTitle());
        assertEquals(movie.getDescription(), movieDto.getDescription());
        assertEquals(movie.getImage(), movieDto.getImage());
        assertEquals(movie.getRating(), movieDto.getRating());
        assertEquals(movie.getLastPlaying(), movieDto.getLastPlaying());

    }
}
