package com.yedam.board;

import java.util.List;

public class BoardMain {
	public static void main(String[] args) {
		BoardDAO b = new BoardDAO();
		
//		전체 조회
		List<Board> blist = b.getBoardList();
		for(Board bod : blist) {
			System.out.println(bod);
		}
		
//		한건 조회
//		Board bod = b.getBoardInfo(1);
//		System.out.println(bod);
		
//		추가
//		Board board = new Board();
//		board.setContent("java Test");
//		board.setWriter("user3");
//		b.insertBoard(board);
				
		
	}
	
}

