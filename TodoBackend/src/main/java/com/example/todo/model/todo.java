package com.example.todo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class todo {

    @Id
    @GeneratedValue
    Long id;
    @NotNull
    @NotBlank
    @Schema(title = "title", example = "Spring Boot")
    String title;
//    String description;
    @NotNull
    Boolean iscompleted;

}
