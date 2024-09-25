package kz.alsiher.lab.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import kz.alsiher.lab.model.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class NumberController { @GetMapping("")
public List<Integer> getNumbers(@RequestParam(value = "q", defaultValue = "1") int n) {
    if (n < 1) {
        throw new IllegalArgumentException("Value of 'n' must be greater than 0");
    }

    // Возвращаем список чисел от 1 до n
    return IntStream.rangeClosed(1, n)
            .boxed()
            .collect(Collectors.toList());
}

}
