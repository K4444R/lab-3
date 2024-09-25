package kz.alsiher.lab.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import kz.alsiher.lab.model.*;


@RestController
@RequestMapping("/reverse_string")
@AllArgsConstructor
public class ReverseStringController {

    @GetMapping("/{string}")
    public String reverseString(@PathVariable("string") String input) {
        return new StringBuilder(input).reverse().toString();
    }
}
