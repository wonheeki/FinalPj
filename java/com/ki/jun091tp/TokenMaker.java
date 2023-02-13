package com.ki.jun091tp;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class TokenMaker {

	public static void makeToken(HttpServletRequest req) {
		// 새로고침(f5) : 방금 한 요청을 다시 하는 것
		// 글을 등록할 때 f5를 눌러서 요청을 할 때 마다 같은 글이 중복되어 게시가 됨
		// 요청 할 때 마다 토큰값을 비교해서 중복이 되면 insert가 더 되지 않도록
		
		// 글쓸 때마다 달라질 만한 값을 토큰으로 두어야
		// 날짜, 시간
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("hhmmss");
		String token = sdf.format(d);
		req.setAttribute("token", token);
	}
	public static void makeToken1(HttpServletRequest req) {

		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("hhmmss");
		String token1 = sdf.format(d);
		req.setAttribute("token1", token1);
	}
}
