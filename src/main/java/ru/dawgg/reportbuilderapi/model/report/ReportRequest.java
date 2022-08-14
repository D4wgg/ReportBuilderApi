package ru.dawgg.reportbuilderapi.model.report;

import java.util.List;
import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Value;
import ru.dawgg.reportbuilderapi.model.annotation.ValidId;
import ru.dawgg.reportbuilderapi.model.table.Table;

@Value
@Builder
public class ReportRequest {

    @ValidId
    @NotNull(message = "report id should be specified")
    Long id;

    @NotBlank(message = "report` table amount should be specified")
    @Column(name = "table_amount")
    String tableAmount;

    @NotNull(message = "table list cant be null")
    List<Table> tables;

    @AssertTrue(message = "tableAmount must be equal to table list size")
    private boolean isTableAmountEqualsTableListSize() {
        return Integer.parseInt(tableAmount) == tables.size();
    }
}
