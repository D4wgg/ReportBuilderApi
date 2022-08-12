package ru.dawgg.reportbuilderapi.model.report;

import ru.dawgg.reportbuilderapi.model.table.Table;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class Report {
    @NotNull(message = "report id should be specified")
    private Integer id;

    @NotBlank(message = "report` table amount should be specified")
    private String tableAmount;

    @NotNull(message = "report should have a list of tables")
    private List<Table> tables;
}
