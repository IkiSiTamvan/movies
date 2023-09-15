package com.tamvan.movie.movie;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MovieRepository extends JpaRepository<Movie, Integer>{
    @Query(value = "select * from movies where title like %:title% ", nativeQuery = true)
    List<Movie> getMovieByTitle(@Param("title")String title);

    List<Movie> findByTitleContaining(String title);
}
