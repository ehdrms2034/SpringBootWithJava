import * as React from "react";
import { Input, Button, Form, Result } from "antd";
import "./MainPresenter.scss";
import NaverLogin from "react-login-by-naver";
import styled from "styled-components";
import naverImg from "./naver_login.png";

type MainPresenterProps = {
  username: string;
  setUsername: Function;
  password: string;
  setPassword: Function;
  doLogin: Function;
  doTest: Function;
  signUpByNaver: Function;
};

const NaverBtn = styled.div`
  margin-top: 10px;
  width: 300px;
  height: 50px;
  background: #11c800;
  color: #ffffff;
  font-weight: bold;
  display: flex;
  justify-content: center;
  align-items: center;
`;

const MainPresenter = ({
  username,
  password,
  setUsername,
  setPassword,
  doLogin,
  doTest,
  signUpByNaver,
}: MainPresenterProps) => {
  return (
    <div className={"background"}>
      <Form
        className={"main-container"}
        onFinish={() => {
          doLogin(username, password);
        }}
      >
        <div className={"loginForm"}>
          아이디
          <Form.Item
            name="userId"
            rules={[{ required: true, message: "Please input yourname!" }]}
          >
            <Input
              className={"idInput"}
              value={username}
              onChange={(e) => setUsername(e.target.value)}
            />
          </Form.Item>
          비밀번호
          <Form.Item
            rules={[{ required: true, message: "Please input password!" }]}
            name="password"
          >
            <Input.Password
              value={password}
              onChange={(e) => setPassword(e.target.value)}
            />
          </Form.Item>
          <span className="buttonForm">
            <Button
              type="primary"
              style={{
                marginLeft: "auto",
                marginRight: "10px",
              }}
              onClick={(e) => {
                doTest();
              }}
            >
              회원가입
            </Button>
            <Form.Item>
              <Button type="primary" htmlType="submit">
                로그인
              </Button>
            </Form.Item>
          </span>
          <span className="socialLoginForm">
            {/* <NaverLogin
              clientId="Rr5h5X4_s0B5nA3TlvQu"
              callbackUrl="http://localhost:3000"
              onSuccess={(result) => {
                console.log(result);
              }}
              onFailure={() => {
                console.error();
              }}
              render={(props) => (
                <NaverBtn onClick={props.onClick}>
                  네이버 아이디로 로그인
                </NaverBtn>
              )}
            ></NaverLogin> */}

            <NaverLogin
              clientId="Rr5h5X4_s0B5nA3TlvQu"
              callbackUrl="http://localhost:3000"
              onSuccess={(result) => {
                signUpByNaver(result.id,result.email,result.name,"naver");
              }}
              onFailure={() => {
                alert("하이");
                console.error();
              }}
              render={(props) => (
                <NaverBtn onClick={props.onClick}>
                  네이버 아이디로 회원가입
                </NaverBtn>
              )}
            />
          </span>
        </div>
      </Form>
    </div>
  );
};

export default MainPresenter;
