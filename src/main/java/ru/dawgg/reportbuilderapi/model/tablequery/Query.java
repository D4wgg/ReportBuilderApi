package ru.dawgg.reportbuilderapi.model.tablequery;

import lombok.*;

import javax.validation.constraints.AssertTrue;

@Value
@Builder
public class Query {
    Integer id;
    String tableName;
    String query;
}
