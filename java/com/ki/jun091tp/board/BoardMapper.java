package com.ki.jun091tp.board;

import java.util.List;

public interface BoardMapper {
	public abstract int writeBoard(Board b);

	public abstract int getAllBoardCount();

	public abstract int getSearchBoardCount(BoardSelector bSel);

	public abstract List<Board> getBoard(BoardSelector bSel);
	public abstract List<Board> count(BoardSelector bSel); // 조회순 정렬
	public abstract Board DetailBoard(Board b);
	public abstract int readCounterBoard(Board b);
	public abstract int UpdateBoard(Board b); // 게시글 수정

	public abstract int DeleteBoard(Board b); // 게시글 삭제

	public abstract List<Board> getMyBoard(Board b); // 마이페이지 내가 쓴 글 보기

	public abstract int writeComment(Comment c); // 댓글쓰기

	public abstract int deleteComment(Comment c); // 댓글삭제

	public abstract int updateComment(Comment c); // 댓글수정
	
	public abstract List<Comment> getComment(Board boards); // 댓글 불러오기
	
	public abstract List<Board> getAllBoard(Board b); // 게시글 전부 불러오기
}
