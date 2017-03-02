package timer.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by mjrt on 2/19/2017.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {

    private Long id;
    private String name;
    @JsonFormat(pattern = "yyyy/MM/dd",timezone = "GMT+8")
    private Date startTime;
    @JsonFormat(pattern = "yyyy/MM/dd",timezone = "GMT+8")
    private Date endTime;

}
