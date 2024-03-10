package hello.servlet.web.frontcontroller.v3.controller;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3 {

  @Override
  public ModelView process(Map<String, String> paramMap) {
    // 입력이니 따로 보여줄 데이터는 없어도 되서 view만 지정
    return new ModelView("new-form");
  }
}
