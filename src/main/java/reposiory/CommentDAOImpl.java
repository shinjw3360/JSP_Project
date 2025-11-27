package reposiory;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.Comment;
import orm.DataBasesBuilder;

public class CommentDAOImpl implements CommentDao {

	private static final Logger log = LoggerFactory.getLogger(CommentDAOImpl.class);
	
	private SqlSession sql;
	
	public CommentDAOImpl() {
		new DatabasesBuilder();
		sql = DataBasesBuilder.getFactory().openSession();
	}

	@Override
	public int insert(Comment c) {
		//insert, update, delete => commit 필요
		int isOk = sql.insert("commentMapper.add", c);
		if(isOk > 0) sql.commit();
		return isOk;
	}

	@Override
	public List<Comment> getList(int bno) {
		// TODO Auto-generated method stub
		return sql.selectList("commentMapper.list", bno);
	}
}
