package ru.dawgg.reportbuilderapi.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class QueryDto {
    Integer id;
    String query;
}
