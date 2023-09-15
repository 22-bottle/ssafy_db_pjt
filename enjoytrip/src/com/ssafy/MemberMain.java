package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.ssafy.board.model.service.BoardService;
import com.ssafy.member.model.MemberDto;

import com.ssafy.member.model.service.MemberService;
import com.ssafy.member.model.service.MemberServiceImpl;

public class MemberMain {
	
	private BufferedReader in;

	static MemberService ms = MemberServiceImpl.getMemberService();
	
	public MemberMain() {
		in = new BufferedReader(new InputStreamReader(System.in));
		menu();
	}

	private void menu() {
		while (true) {
			System.out.println("---------- 회원 메뉴 ----------");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 회원정보수정");
			System.out.println("4. 회원탈퇴");
			System.out.println("-------------------------------------");
			System.out.println("0. 프로그램 종료");
			System.out.println("-------------------------------------");
			System.out.print("메뉴 선택 : ");
			try {
				int num = Integer.parseInt(in.readLine());
				switch (num) {
				case 1:
					registerMember();
					break;
				case 2:
					login();
					break;
				case 3:
					modifyMember();
					break;
				case 4:
					deleteMember();
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

	private void registerMember() throws IOException {
		MemberDto memberDto = new MemberDto();
		System.out.println("=== 로그인 화면 ===");
		System.out.print("아이디 : ");
		memberDto.setUserId(in.readLine());
		System.out.print("이름 : ");
		memberDto.setUserName(in.readLine());
		System.out.print("비밀번호 : ");
		memberDto.setUserPass(in.readLine());
		ms.registerMember(memberDto);
	}

	private void login() throws IOException {
		MemberDto memberDto = new MemberDto();
		System.out.println("=== 로그인 화면 ===");
		System.out.print("아이디 : ");
		String userId = in.readLine();
		System.out.print("비밀번호 : ");
		String userPass= in.readLine();
		if(ms.login(userId, userPass) == null) {
			System.out.println("로그인에 실패하였습니다.");
		} else {
			System.out.println("로그인에 성공하였습니다.");
		}
	}

	private void modifyMember() throws IOException {
		MemberDto memberDto = new MemberDto();
		System.out.println("아이디 : ");
		memberDto.setUserId(in.readLine());
		System.out.println("신규 닉네임 : ");
		memberDto.setUserName(in.readLine());
		System.out.println("신규 비밀번호 : ");
		memberDto.setUserPass(in.readLine());
		MemberServiceImpl.getMemberService().modifyMember(memberDto);
	}

	private void deleteMember() throws IOException {
		System.out.println("삭제 할 아이디 : ");
		MemberServiceImpl.getMemberService().deleteMember(in.readLine());
	}

	public static void main(String[] args) {
		new MemberMain();
	}
}
