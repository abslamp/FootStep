package timer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by mjrt on 2/24/2017.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReminderMessage {

    private Long id;
    private String message;
    private boolean state;
    private String userName;
    private Date lack;

}