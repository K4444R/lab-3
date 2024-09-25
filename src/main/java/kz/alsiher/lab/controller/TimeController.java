package kz.alsiher.lab.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import kz.alsiher.lab.model.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@RestController
@RequestMapping("/current_time")
@AllArgsConstructor
public class TimeController {

    @GetMapping("")
    public String getCurrentTime() {
        // Получаем текущее время
        LocalDateTime now = LocalDateTime.now();

        // Форматируем время в удобный для чтения формат
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedNow = now.format(formatter);

        // Возвращаем строку с текущим временем
        return "Current Time: " + formattedNow;
    }

}
