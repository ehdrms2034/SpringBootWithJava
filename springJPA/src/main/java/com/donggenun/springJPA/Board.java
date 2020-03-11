package com.donggenun.springJPA;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Board {

    @Id
    @GeneratedValue
    private Long seq;
    private String title;
    //    private String writer;
    private String content;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createDate;
    private Long cnt;

    @ManyToOne
    @JoinColumn(name="MEMBER_ID")
    private Member member;

    public Long getSeq() {
        return seq;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getCnt() {
        return cnt;
    }

    public void setCnt(Long cnt) {
        this.cnt = cnt;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "Board{" +
                "seq=" + seq +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createDate=" + createDate +
                ", cnt=" + cnt +
                ", member=" + member +
                '}';
    }
}
