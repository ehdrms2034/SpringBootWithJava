import * as React from "react";
import { Input, Button, Form, Result } from "antd";
import "./MainPresenter.scss";
import NaverLogin from 'react-login-by-naver';
import styled from 'styled-components';
import naverImg from './naver_login.png';

type MainPresenterProps = {
  username: string,
  setUsername: Function,
  password: string,
  setPassword: Function,
  doLogin: Function,
  doTest: Function
}

const NaverImage = styled.div`
  margin-left : auto;
  margin-right : auto;
  background-image : url(${naverImg});
  background-size : 300px 50px;
  width : 300px;
  height : 50px;
  cursor : pointer;
`;

const MainPresenter = ({
  username, password,
  setUsername, setPassword, doLogin, doTest
}: MainPresenterProps) => {
  return (
    <div className={"background"}>
      <Form
        className={"main-container"}
        onFinish={() => { doLogin(username, password) }}
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
              onChange={e => setPassword(e.target.value)}
            />
          </Form.Item>
          <span className="buttonForm">
            <Button
              type="primary"
              style={{
                marginLeft: "auto",
                marginRight: "10px"
              }}
              onClick={e=>{doTest();}}
            >
              회원가입
            </Button>
            <Form.Item>
              <Button
                type="primary"
                htmlType="submit"
              >
                로그인
              </Button>
            </Form.Item>
          </span>
          <span className="socialLoginForm">
              <NaverLogin
                clientId="Rr5h5X4_s0B5nA3TlvQu"
                callbackUrl="http://localhost:3000"
                onSuccess={(result)=>{alert(result); console.log(result);}}
                onFailure={()=>{alert("하이"); console.error();}}
                render={(props)=> <NaverImage onClick={props.onClick}></NaverImage>}
              >
              </NaverLogin>
          </span>
        </div>
      </Form>
    </div>
  );
};

export default MainPresenter;
