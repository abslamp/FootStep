package timer.domain;

import java.util.List;

/**
 * Created by mjrt on 2/24/2017.
 */
public interface ReminderMessageMapper {
    int insert(ReminderMessage message);
    void delete(Long id);
    List<ReminderMessage> findByName(String name);
}
