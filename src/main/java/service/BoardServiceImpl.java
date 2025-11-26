package service;

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
}
