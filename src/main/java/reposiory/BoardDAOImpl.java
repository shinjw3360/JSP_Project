package reposiory;

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
	
	
	
	
	
}
