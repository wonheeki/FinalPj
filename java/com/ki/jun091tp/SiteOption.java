package com.ki.jun091tp;

public class SiteOption {
		private int boardPerPage;
		
		public SiteOption() {
			// TODO Auto-generated constructor stub
		}

		public SiteOption(int boardPerPage) {
			super();
			this.boardPerPage = boardPerPage;
		}

		public int getBoardPerPage() {
			return boardPerPage;
		}

		public void setBoardPerPage(int boardPerPage) {
			this.boardPerPage = boardPerPage;
		}
}
