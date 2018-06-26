package codesquad.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import support.domain.AbstractEntity;

import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

public class Answer extends AbstractEntity {
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_answer_writer"))
    @JsonProperty
    private User writer;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_answer_issue"))
    @JsonProperty
    private Issue issue;

    @Lob
    @JsonProperty
    private String contents;

    public Answer() {}

    public Answer(User writer, Issue issue, String contents) {
        this.writer = writer;
        this.issue = issue;
        this.contents = contents;
    }

    public Answer(long id,User writer, Issue issue, String contents) {
        super(id);
        this.writer = writer;
        this.issue = issue;
        this.contents = contents;
    }

    public boolean isSameWriter(User loginUser) {
        return loginUser.equals(this.writer);
    }

    public User getWriter() {
        return writer;
    }

    public Issue getIssue() {
        return issue;
    }

    public String getContents() {
        return contents;
    }
}
