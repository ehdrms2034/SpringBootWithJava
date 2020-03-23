import * as React from "react";
import { Input, Button, Form } from "antd";
import "./MainPresenter.scss";


type MainPresenterProps = {
  username: string,
  setUsername: Function,
  password: string,
  setPassword: Function,
  doLogin: Function,
  doTest: Function
}

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
        </div>
      </Form>
    </div>
  );
};

export default MainPresenter;
