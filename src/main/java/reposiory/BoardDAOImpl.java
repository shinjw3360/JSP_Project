package reposiory;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.Board;
import orm.DataBasesBuilder;


public class BoardDAOImpl implements BoardDAO {

	private static final Logger log = LoggerFactory.getLogger(BoardDAOImpl.class);
	private SqlSession sql;
	
	public BoardDAOImpl() {
		new DataBasesBuilder();
		sql = DataBasesBuilder.getFactory().openSession();
	}

	@Override
	public int insert(Board b) {
//		Log.info("BoardDAOIMpl Test....");
		int isOk = sql.insert("boardMapper.add", b);
		
		if(isOk > 0) sql.commit();
		return isOk;
	}
	
	public List<Board> getList() {
		List<Board> list = sql.selectList("boardMapper.list");
		return list;
	}

	@Override
	public Board getDetails(int bno) {
		// TODO Auto-generated method stub
		return sql.selectOne("boardMapper.details", bno);
	}

	@Override
	public int update(Board b) {
		// TODO Auto-generated method stub
		int isOk = sql.update("boardMapper.update",b);
		if(isOk > 0) sql.commit();
		return isOk;
	}

	@Override
	public int delete(int bno) {
		int isOk = sql.delete("boardMapper.del", bno);
		if(isOk > 0) sql.commit();
		return isOk;
		
	}
	
	


	
	
}
