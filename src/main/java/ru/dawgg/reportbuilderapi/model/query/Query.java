package ru.dawgg.reportbuilderapi.model.query;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Value
@Builder
public class Query {
    @NotNull(message = "query id should be specified")
    Integer id;

    @Size(max = 50)
    @NotBlank(message = "table name should be specified")
    String tableName;

    @Size(max = 120)
    @NotBlank(message = "query cant be empty")
    String query;
}
