package reposiory;

import java.util.List;

import domain.Comment;

public interface CommentDao {

	int insert(Comment c);

	List<Comment> getList(int bno);

}
