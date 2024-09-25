package kz.alsiher.lab.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import kz.alsiher.lab.model.*;

import java.util.Random;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("")
@AllArgsConstructor
public class GuessNumberController {

    // Хранилище для текущих игр (можно использовать базу данных, если нужно)
    private final Map<String, Integer> games = new HashMap<>();
    private final Random random = new Random();

    // Начало новой игры
    @GetMapping("/start")
    public String startGame() {
        int randomNumber = random.nextInt(100) + 1; // Генерируем число от 1 до 100
        String gameId = String.valueOf(random.nextInt(1000)); // Генерация gameId игры
        games.put(gameId, randomNumber); // Сохраняем число в хранилище
        return "Игра началась! Используйте gameId: " + gameId + " для угадывания числа.";
    }

    // Метод угадывания числа с одним параметром
    @GetMapping("/guess")
    public String guessNumber(@RequestParam("input") String input) {
        String[] parts = input.split(":"); // Разделяем входной параметр
        String gameId = parts[0]; // Первый элемент - gameId
        int number;

        try {
            number = Integer.parseInt(parts[1]); // Второй элемент - число для угадывания
        } catch (NumberFormatException e) {
            return "Неверный формат. Пожалуйста, используйте формат gameId:number.";
        }

        Integer randomNumber = games.get(gameId); // Получаем загаданное число по идентификатору игры

        if (randomNumber == null) {
            return "Игра с указанным gameId не найдена. Пожалуйста, начните новую игру.";
        }

        // Логика сравнения числа
        if (number > randomNumber) {
            return "Ваше число больше загаданного. Попробуйте снова.";
        } else if (number < randomNumber) {
            return "Ваше число меньше загаданного. Попробуйте снова.";
        } else {
            games.remove(gameId); // Удаляем игру после выигрыша
            return "Поздравляю, вы угадали число!";
        }
    }
}