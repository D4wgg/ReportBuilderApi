package ru.dawgg.reportbuilderapi.model.table;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ColumnInfo {
    @NotBlank(message = "column should have a title")
    String title;

    @NotBlank(message = "column should have a type")
    String type;
}
