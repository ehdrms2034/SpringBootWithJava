import * as React from 'react';
import {useEffect} from 'react';
import styled from 'styled-components';
import qs from 'query-string';

interface SocialLoginingContainerProps{
    location : Location
}

const SocialLoginingContainer = ( {location} : SocialLoginingContainerProps) => {
    const query = qs.parse(location.search);

    useEffect(()=>{
        console.log(query);
    },[]);

    return(
        <div>
        </div>
    )

}

export default SocialLoginingContainer;