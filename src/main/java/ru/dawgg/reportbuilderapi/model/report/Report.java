package ru.dawgg.reportbuilderapi.model.report;

import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@javax.persistence.Table(name = "report")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Report {

    @Id
    @Column(name = "report_id")
    private Long id;

    @Column(name = "table_amount")
    private String tableAmount;

    @ElementCollection
    @CollectionTable(name = "report_table_names", joinColumns = @JoinColumn(name = "report_id"))
    @Column(name = "table_names")
    private List<String> tableNames;
}
