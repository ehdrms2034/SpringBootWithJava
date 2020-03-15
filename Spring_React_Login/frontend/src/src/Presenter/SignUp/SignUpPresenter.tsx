import * as React from 'react';
import './SignUpPresenter.scss';
import { Button, Input } from 'antd';

const SignUpPresenter = () => {
  return (
    <div className="background">
      <div className="signup-presenter">
        <div className="login-form">
          아이디 <Input required />

          비밀번호 <Input />

          이름 <Input />

          이메일 <Input />

          <Button
            className="submit"
            type='primary'
          >
            회원가입
          </Button>

        </div>
      </div>
    </div>
  )
}

export default SignUpPresenter