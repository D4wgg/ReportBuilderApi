package ru.dawgg.reportbuilderapi.model.query;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Value
@Builder
public class Query {
    @NotNull(message = "query id should be specified")
    Integer id;

    @NotBlank(message = "table name should be specified")
    String tableName;

    @NotBlank(message = "query cant be empty")
    String query;
}
