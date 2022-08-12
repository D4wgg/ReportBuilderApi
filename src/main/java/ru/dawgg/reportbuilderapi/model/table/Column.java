package ru.dawgg.reportbuilderapi.model.table;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor@Builder
public class Column {
    String title;
    ColumnType type;
}
