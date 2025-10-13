package application.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "comment")
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "comment_text")
  private String commentText;

  @ManyToOne
  @JoinColumn(name = "movie_comment_id")
  private Movie movie;

  @ManyToOne
  @JoinColumn(name = "comment_parent_id")
  private Comment parent;

  @OneToMany(mappedBy = "parent")
  private List<Comment> children;

  @ManyToMany
  @JoinTable(
      name = "comment_like",
      joinColumns = @JoinColumn(name = "comment_id"), // FK da entidade atual
      inverseJoinColumns = @JoinColumn(name = "client_id") // FK da outra entidade
  )
  private List<Client> nameOfLikers;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCommentText() {
    return commentText;
  }

  public void setCommentText(String commentText) {
    this.commentText = commentText;
  }

  public Movie getMovie() {
    return movie;
  }

  public void setMovie(Movie movie) {
    this.movie = movie;
  }

  public List<Client> getNameOfLikers() {
    return nameOfLikers;
  }

  public void setNameOfLikers(List<Client> nameOfLikers) {
    this.nameOfLikers = nameOfLikers;
  }

  public Comment getParent() {
    return parent;
  }

  public void setParent(Comment parent) {
    this.parent = parent;
  }

  public List<Comment> getChildren() {
    return children;
  }

  public void setChildren(List<Comment> children) {
    this.children = children;
  }
}
