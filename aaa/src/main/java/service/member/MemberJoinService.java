package service.member;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import command.MemberCommand;
import controller.MailService;
import controller.SmsSend;
import model.DTO.MemberDTO;
import repository.member.MemberRepository;

@Service
public class MemberJoinService {
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	@Autowired
	MemberRepository memberRepository;	// 디비에 넣는 애
	@Autowired
	MailService mailService;
	
	public void execute(MemberCommand memberCommand) {
		// memberCommand에 데이터 저장
		MemberDTO memberDTO = new MemberDTO();
		Integer result = null;
		memberDTO.setUserAddr(memberCommand.getUserAddr());
		memberDTO.setUserBirth(new Timestamp(memberCommand.getUserBirth().getTime()));
		memberDTO.setUserEmail(memberCommand.getUserEmail());
		memberDTO.setUserGender(memberCommand.getUserGender());
		memberDTO.setUserId(memberCommand.getUserId());
		memberDTO.setUserName(memberCommand.getUserName());
		memberDTO.setUserPh1(memberCommand.getUserPh1());
		memberDTO.setUserPh2(memberCommand.getUserPh2());
		
		// 암호화
		String pw = bcryptPasswordEncoder.encode(memberCommand.getUserPw());
		memberDTO.setUserPw(pw);
		String ins = "";
		for(String str : memberCommand.getInterest()) {
			ins += str + "`";
		}
		memberDTO.setInterest(ins);
		result = memberRepository.insertMember(memberDTO);
		
		// 메일확인
		// 172.30.1.59
		if(result != null) {
			SimpleDateFormat dateForm = new SimpleDateFormat("yyyyMMddHHmmss");
			String num = dateForm.format(new Date());	// 스트링을 날짜로 바꿀 땐 format 반대는 parse
			String subject = "가입환영인사";	// 메일 제목
			String contents = "<html><body>"
					+ "안녕하세요. '" + memberDTO.getUserName()
					+ "'님 가입을 환영합니다.<br />"
					+ "가입을 완료하시려면 <a href='http://172.30.1.59:8080/aaa/register/memberMail?num="+num+"&receiver="+memberDTO.getUserEmail()+"&userId="+memberDTO.getUserId()+"'>여기</a>를 눌러주세요.";
			try {
				mailService.sendMail(memberDTO.getUserEmail(), memberDTO.getUserId(), contents, subject);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	public Integer numUpdate(String num, String receiver, String userId) {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setChkOk(num);
		memberDTO.setUserEmail(receiver);
		memberDTO.setUserId(userId);
		return memberRepository.joinOkUpdate(memberDTO);
	}
}
