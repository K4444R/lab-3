package kz.alsiher.lab.model;
import java.time.LocalDate;

import lombok.*;
@Data
@Builder
public class User {
    private long id;
    private String name;
    private String email;
    private int age;
}
