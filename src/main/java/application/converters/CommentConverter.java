package application.converters;

import application.dtos.CommentDTO;
import application.entities.Client;
import application.entities.Comment;
import application.entities.Movie;
import java.util.List;
import java.util.stream.Collectors;

public class CommentConverter {

  public static List<CommentDTO> toDto(Movie entity) {

    return entity.getComments().stream().filter(comment -> comment.getParent() == null)
        .map(CommentConverter::toDto).collect(Collectors.toList());
  }

  public static CommentDTO toDto(Comment entity) {

    CommentDTO commentDTO = new CommentDTO();
    commentDTO.setId(entity.getId());
    commentDTO.setCommentText(entity.getCommentText());
    commentDTO.setNameOfLikers(
        entity.getNameOfLikers().stream().map(Client::getName).collect(Collectors.toList()));
    commentDTO.setChildresnComments(
        entity.getChildren().stream().map(CommentConverter::toDto).collect(Collectors.toList()));
    String publishedAt =
        entity.getPublishedAt() != null ? entity.getPublishedAt().toString() : null;
    commentDTO.setPublishDate(publishedAt);
    commentDTO.setOwnerName(entity.getClient().getName());
    return commentDTO;
  }
}
