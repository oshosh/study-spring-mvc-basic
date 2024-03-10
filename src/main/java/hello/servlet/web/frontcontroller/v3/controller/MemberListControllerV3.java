package hello.servlet.web.frontcontroller.v3.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {

  private MemberRepository memberRepository = MemberRepository.getInstance();
  @Override
  public ModelView process(Map<String, String> paramMap) {
    List<Member> members = memberRepository.findAll();
    ModelView mv = new ModelView("members"); // 현재 view
    mv.getModel().put("members", members); // 현재 모델을 저장함
    // 보여줄 view를 기준으로 모델을 지정하여 반환
    return mv;
  }
}
