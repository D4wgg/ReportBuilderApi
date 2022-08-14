package ru.dawgg.reportbuilderapi.model.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "single_query_table")
public class SingleQuery {

    @Id
    @NotNull(message = "query id cannot be null")
    private Integer queryId;

    @Column(name = "query")
    @NotBlank(message = "query cannot be empty")
    @Size(max = 120)
    private String query;
}
