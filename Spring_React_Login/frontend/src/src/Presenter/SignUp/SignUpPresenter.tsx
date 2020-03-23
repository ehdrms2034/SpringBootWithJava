import * as React from "react";
import "./SignUpPresenter.scss";
import { Button, Input, Form } from "antd";
import {RequestSignUp} from '../../Container/SignUpContainer';

type SignUpPresenterProps = {
  username: string,
  setUsername: Function,
  password: string,
  setPassword: Function,
  name: string,
  setName: Function,
  email: string,
  setEmail: Function,
  address : string,
  setAddress : Function,
  handleSignUp: Function,
};

const SignUpPresenter = ({
  username,
  password,
  name,
  email,
  address,
  setUsername,
  setPassword,
  setName,
  setEmail,
  setAddress,
  handleSignUp
}: SignUpPresenterProps) => {
  return (
    <div className="background">
      <div className="signup-presenter">
        <Form
          className="login-form"
          onFinish={() => {
            const requestSignUp : RequestSignUp = {
              username,password,name,email,address
            } 
            handleSignUp(requestSignUp);
          }}
        >
          아이디
          <Form.Item name="username">
            <Input
              value={username}
              onChange={e => setUsername(e.target.value)}
              required
            />
          </Form.Item>
          비밀번호
          <Form.Item name="password">
            <Input.Password
              value={password}
              onChange={e => setPassword(e.target.value)}
            />
          </Form.Item>
          이름
          <Form.Item name="name">
            <Input 
              value={name}
              onChange={e => setName(e.target.value)} />
          </Form.Item>
          이메일
          <Form.Item name="email">
            <Input 
              value={email} 
              onChange={e => setEmail(e.target.value)} />
          </Form.Item>

          주소
          <Form.Item>
            <Input
              value={address}
              onChange = {e=>setAddress(e.target.value)}/>
          </Form.Item>

          <Form.Item>
            <Button htmlType="submit" type="primary">
              회원가입
            </Button>
          </Form.Item>
        </Form>
      </div>
    </div>
  );
};

export default SignUpPresenter;
