package team6.xml_project.web.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class ReviewerListDTO {

    @NotNull
    @NotEmpty(message = "Must choose one or more reviewers")
    public List<Long> reviewerIds;

    public ReviewerListDTO(@NotNull @NotEmpty(message = "Must choose one or more reviewers") List<Long> reviewerIds) {
        this.reviewerIds = reviewerIds;
    }

    public ReviewerListDTO() {
    }


}
