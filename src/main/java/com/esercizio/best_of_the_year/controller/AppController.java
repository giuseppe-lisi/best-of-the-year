package com.esercizio.best_of_the_year.controller;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.esercizio.best_of_the_year.classes.Movies;
import com.esercizio.best_of_the_year.classes.Songs;

@Controller
@RequestMapping("/")
public class AppController {
    
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("name", "Giuseppe");
        return "home";
    }
    
    @GetMapping("/movies")
    public String movies(Model model) {
        // ottiene la lista dei migliori film dalla func getBestMovies
        // che in questo contesto simula un'API praticamente
        ArrayList<Movies> movies = getBestMovies();
        // aggiungo al model che lo passerà alla View
        // l'oggetto verrà poi interpolato tramite dei tag di Thymeleaf
        model.addAttribute("movies", movies);
        
        // restituisco il template di Thymeleaf con i dati dinamici
        // passati dal model
        return "movies";
    }
    
    @GetMapping("/songs")
    public String songs(Model model) {
        ArrayList<Songs> songs = getBestSongs();

        model.addAttribute("songs", songs);
        
        return "songs";
    }

    @GetMapping("/movies/{id}")
    public String pageById(Model model, @PathVariable int id) {
        ArrayList<Movies> movies = getBestMovies();
        String title = movies.get(id).getTitle();

        model.addAttribute("title", title);

        return "pageById";
    }

    // i seguenti metodi simulano una chiamata ad un'api 
    private ArrayList<Songs> getBestSongs() {
        Songs song1 = new Songs(1, "Strawberry Fields");
        Songs song2 = new Songs(2, "Purple Rain");
        Songs song3 = new Songs(3, "Paradise City");
        
        ArrayList<Songs> songs = new ArrayList<>();
        songs.add(song1);
        songs.add(song2);
        songs.add(song3);
        return songs;
    }
    
    private ArrayList<Movies> getBestMovies() {
        Movies movie1 = new Movies(1, "Matrix");
        Movies movie2 = new Movies(2, "Le pagine della nostra vita");
        Movies movie3 = new Movies(3, "Seven");
        
        ArrayList<Movies> movies = new ArrayList<>();
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        return movies;
    }
}
