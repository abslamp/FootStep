package edu.heu.soft.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by new on 17-2-26.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentUnauditedSelect {



      private String department;
      @JsonIgnore
      private String auditor;
      @JsonIgnore
      private String mailAddress;
      private String name;
      @JsonFormat(pattern = "yyyy/MM/dd")
      private Date jmt;

}
