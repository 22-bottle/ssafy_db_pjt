package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.ssafy.board.model.BoardDto;

public class BoardMain {

	private BufferedReader in;

	public BoardMain() {
		in = new BufferedReader(new InputStreamReader(System.in));
		menu();
	}

	private void menu() {
		while (true) {
			System.out.println("---------- 게시판 메뉴 ----------");
			System.out.println("1. 글등록");
			System.out.println("2. 글목록(전체)");
			System.out.println("3. 글검색(제목)");
			System.out.println("4. 글보기");
			System.out.println("5. 글수정");
			System.out.println("6. 글삭제");
			System.out.println("-------------------------------------");
			System.out.println("0. 프로그램 종료");
			System.out.println("-------------------------------------");
			System.out.print("메뉴 선택 : ");
			try {
				int num = Integer.parseInt(in.readLine());
				switch (num) {
				case 1:
					registerArticle();
					break;
				case 2:
					searchListAll();
					break;
				case 3:
					searchListBySubject();
					break;
				case 4:
					viewArticle();
					break;
				case 5:
					modifyArticle();
					break;
				case 6:
					deleteArticle();
					break;
				default:
					System.out.println("프로그램을 종료합니다!!!");
					System.exit(0);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void registerArticle() throws IOException {
		
	}

	private void searchListAll() {
		
	}

	private void searchListBySubject() throws IOException {
		
	}

	private void viewArticle() throws IOException {
		
	}

	private void modifyArticle() throws NumberFormatException, IOException {
		
	}

	private void deleteArticle() throws IOException {
		
	}

	public static void main(String[] args) {
		new BoardMain();
	}
}
