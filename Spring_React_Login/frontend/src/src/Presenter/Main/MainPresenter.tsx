import * as React from "react";
import { Input, Button, Form } from "antd";
import "./MainPresenter.scss";

const MainPresenter = () => {
  return (
    <div className={"background"}>
      <Form
        className={"main-container"}
        onFinish={() => {
          alert("제출");
        }}
      >
        <div className={"loginForm"}>
          아이디
          <Form.Item
            name="userId"
            rules={[{ required: true, message: "Please input yourname!" }]}
          >
            <Input className={"idInput"} />
          </Form.Item>
          비밀번호
          <Form.Item
            rules={[{ required: true, message: "Please input password!" }]}
            name="password"
          >
            <Input.Password />
          </Form.Item>
          <span className="buttonForm">
            <Button
              type="primary"
              style={{
                marginLeft: "auto",
                marginRight: "10px"
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
        </div>
      </Form>
    </div>
  );
};

export default MainPresenter;
