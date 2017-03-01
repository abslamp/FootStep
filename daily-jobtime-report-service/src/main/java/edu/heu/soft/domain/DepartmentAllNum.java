package edu.heu.soft.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by new on 17-2-27.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentAllNum {

    private String name;
    private String num;
}
