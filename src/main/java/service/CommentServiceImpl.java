package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.Comment;
import reposiory.CommentDAOImpl;
import reposiory.CommentDao;

public class CommentServiceImpl implements CommentService {
	private static final Logger log = LoggerFactory.getLogger(CommentServiceImpl.class);
	private CommentDao cdao;
	
	public CommentServiceImpl() {
		cdao = new CommentDAOImpl();
	}

	@Override
	public int insert(Comment c) {
		// TODO Auto-generated method stub
		return cdao.insert(c);
	}

	@Override
	public List<Comment> getList(int bno) {
		// TODO Auto-generated method stub
		return cdao.getList(bno);
	}
}
