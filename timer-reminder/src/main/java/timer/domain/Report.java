package timer.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by mjrt on 2/24/2017.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Report {

    private Long id;
    private String name;
    private String project;
    private String task;     //length = 4096
    @JsonFormat(pattern = "yyyy/MM/dd",timezone = "GMT+8")
    private Date jmt;
    private double workLoad;
    private double overTime;
    private String state = "UNAUDITED";

}

