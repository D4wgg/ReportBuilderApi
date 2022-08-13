package ru.dawgg.reportbuilderapi.model.query;

import lombok.*;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "query id cannot be null")
    private Integer queryId;

    @Column(name = "query")
    @NotBlank(message = "query cannot be empty")
    @Size(max = 120)
    private String query;
}
