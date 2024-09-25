package kz.alsiher.lab.controller;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import kz.alsiher.lab.model.*;


@RestController
@RequestMapping("/fib")
@AllArgsConstructor
public class FibonacciController {

    @GetMapping("")
    public long getFibonacci(@RequestParam(value = "number") int number) {
        return fibonacci(number);
    }

    // Метод для вычисления n-го числа Фибоначчи
    public long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        long prev1 = 0, prev2 = 1;
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result = prev1 + prev2;
            prev1 = prev2;
            prev2 = result;
        }
        return result;
    }
}
