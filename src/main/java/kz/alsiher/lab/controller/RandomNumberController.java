package kz.alsiher.lab.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import kz.alsiher.lab.model.*;
import java.util.Random;


@RestController
@RequestMapping("/random_number")
@AllArgsConstructor
public class RandomNumberController {
    @GetMapping("")
    public int getRandomNumber() {

        Random random = new Random();
        return random.nextInt(500) + 1;  // возвращаем случайное число от 1 до 500
    }


}
