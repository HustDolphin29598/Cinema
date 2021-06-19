package com.onemount.cinema.controller;

import com.onemount.cinema.model.Film;
import com.onemount.cinema.service.FilmService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/film")
public class FilmController {

    @Autowired
    FilmService filmService;

    @GetMapping("")
    public List<Film> getAllFilms(){
        return filmService.getALl();
    }

    @GetMapping(value = "", params = "id")
    public Film getFilmById(@RequestParam int id){
        return filmService.getById(id);
    }

    @GetMapping(value = "", params = "imageUrl", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<Resource> getFilmImage(@RequestParam String imageUrl) throws IOException {
        final ByteArrayResource inputStream = new ByteArrayResource(Files.readAllBytes(Paths.get(imageUrl)));
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentLength(inputStream.contentLength())
                .body(inputStream);
    }
}
