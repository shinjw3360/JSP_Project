package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.Board;
import reposiory.BoardDAO;
import reposiory.BoardDAOImpl;




public class BoardServiceImpl implements BoardService {
	private static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);
	private BoardDAO bdao;
	
	public BoardServiceImpl() {
		bdao = new BoardDAOImpl();
	}

	@Override
	public int insert(Board b) {
		log.info("boardDAOImpl Test...");

		return bdao.insert(b);
	}

	@Override
	public List<Board> getList() {
		// TODO Auto-generated method stub
		return bdao.getList();
	}
	
	public Board getDetail(int bno) {
		// TODO Auto-generated method stub
		return bdao.getDetails(bno);
	}

	@Override
	public int update(Board b) {
		// TODO Auto-generated method stub
		return bdao.update(b);
	}

	@Override
	public int delete(int bno) {
		// TODO Auto-generated method stub
		return bdao.delete(bno);
	}


	
	
}
