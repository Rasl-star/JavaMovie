package ru.netology.yavaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {
    private MovieManager managerDefault;
    private MovieManager managerCustom;

    @BeforeEach
    void setUp() {
        managerDefault = new MovieManager();
        managerCustom = new MovieManager(3);
    }

    @Test
    void shouldAddMovie() {
        managerDefault.addMovie("Movie 1");
        String[] expected = {"Movie 1"};
        Assertions.assertArrayEquals(expected, managerDefault.findAll());
    }

    @Test
    void shouldReturnAllMoviesInOrder() {
        managerDefault.addMovie("Movie 1");
        managerDefault.addMovie("Movie 2");
        managerDefault.addMovie("Movie 3");

        String[] expected = {"Movie 1", "Movie 2", "Movie 3"};
        Assertions.assertArrayEquals(expected, managerDefault.findAll());
    }

    @Test
    void shouldReturnLastMoviesInReverseOrderWithDefaultLimit() {
        managerDefault.addMovie("Movie 1");
        managerDefault.addMovie("Movie 2");
        managerDefault.addMovie("Movie 3");
        managerDefault.addMovie("Movie 4");
        managerDefault.addMovie("Movie 5");
        managerDefault.addMovie("Movie 6");

        String[] expected = {"Movie 6", "Movie 5", "Movie 4", "Movie 3", "Movie 2"};
        Assertions.assertArrayEquals(expected, managerDefault.findLast());
    }

    @Test
    void shouldReturnLastMoviesInReverseOrderWithCustomLimit() {
        managerCustom.addMovie("Movie 1");
        managerCustom.addMovie("Movie 2");
        managerCustom.addMovie("Movie 3");
        managerCustom.addMovie("Movie 4");

        String[] expected = {"Movie 4", "Movie 3", "Movie 2"};
        Assertions.assertArrayEquals(expected, managerCustom.findLast());
    }

    @Test
    void shouldReturnAllMoviesIfLessThanLimit() {
        managerCustom.addMovie("Movie 1");
        managerCustom.addMovie("Movie 2");

        String[] expected = {"Movie 2", "Movie 1"};
        Assertions.assertArrayEquals(expected, managerCustom.findLast());
    }
}

