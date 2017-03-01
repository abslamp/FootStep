package demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by mjrt on 2/19/2017.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectAndPrp {

    private Long id;
    private String project;
    private String prpName;
    private String prpAbbreviation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getPrpName() {
        return prpName;
    }

    public void setPrpName(String prpName) {
        this.prpName = prpName;
    }

    public String getPrpAbbreviation() {
        return prpAbbreviation;
    }

    public void setPrpAbbreviation(String prpAbbreviation) {
        this.prpAbbreviation = prpAbbreviation;
    }
}
