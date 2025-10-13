package application.dtos;

import java.util.List;

public class CommentDTO {

  private Long id;

  private String commentText;

  private List<String> nameOfLikers;

  private List<CommentDTO> childresnComments;


  public String getCommentText() {
    return commentText;
  }

  public void setCommentText(String commentText) {
    this.commentText = commentText;
  }

  public List<String> getNameOfLikers() {
    return nameOfLikers;
  }

  public void setNameOfLikers(List<String> nameOfLikers) {
    this.nameOfLikers = nameOfLikers;
  }

  public List<CommentDTO> getChildresnComments() {
    return childresnComments;
  }

  public void setChildresnComments(List<CommentDTO> childresnComments) {
    this.childresnComments = childresnComments;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
