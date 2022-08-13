package ru.dawgg.reportbuilderapi.model.query;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.dawgg.reportbuilderapi.model.annotation.ValidId;

@Entity
@Table(name = "table_query")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TableQuery {

    @ValidId
    @NotNull(message = "query id should be specified")
    @Id
    @Column(name = "id")
    private Integer id;

    @Size(max = 50)
    @NotBlank(message = "table name should be specified")
    @Column(name = "table_name")
    private String tableName;

    @Size(max = 120)
    @NotBlank(message = "query cant be empty")
    @Column(name = "query")
    private String query;
}
