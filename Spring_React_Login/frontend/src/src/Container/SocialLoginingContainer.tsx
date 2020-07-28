import * as React from 'react';
import {useEffect} from 'react';
import styled from 'styled-components';
import qs from 'query-string';
import Axios from 'axios';

interface SocialLoginingContainerProps{
    location : Location
}

const SocialLoginingContainer = ( {location} : SocialLoginingContainerProps) => {
    

    useEffect(()=>{
        const query = qs.parse(location.search);

        //https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=Rr5h5X4_s0B5nA3TlvQu&redirect_uri=http://localhost:3000/login/oauth
        const clientId = "Rr5h5X4_s0B5nA3TlvQu";
        const secretKey = "BbIH2OsO0v"
        Axios.get("https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&client_id="+clientId+"&client_secret="+secretKey+"&code="+query.code);
    },[]);

    return(
        <div>
        </div>
    )

}

export default SocialLoginingContainer;