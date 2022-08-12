package ru.dawgg.reportbuilderapi.model.table;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ColumnInfo {
    String title;
    String type;
}
