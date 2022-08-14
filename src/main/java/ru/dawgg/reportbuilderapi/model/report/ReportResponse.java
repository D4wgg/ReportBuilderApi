package ru.dawgg.reportbuilderapi.model.report;

import java.util.List;
import lombok.Builder;
import lombok.Value;
import ru.dawgg.reportbuilderapi.model.table.Table;

@Value
@Builder
public class ReportResponse {

    String reportId;
    String tableAmount;
    List<Table> tables;
}
