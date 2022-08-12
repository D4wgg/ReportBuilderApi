package ru.dawgg.reportbuilderapi.model.tablequery;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class QueryDto {
    Integer id;
    String query;
}
