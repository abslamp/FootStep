package timer.domain;

import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by mjrt on 2/24/2017.
 */
public interface ReminderMessageMapper {
    int insert(ReminderMessage message);
    void delete(Long id);
    List<ReminderMessage> findByName(@Param("name") String name);
    ReminderMessage findByPojo(ReminderMessage pojo);
}
