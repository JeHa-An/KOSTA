import {useSelector, useDispatch} from 'react-redux';
import Page2 from './Page2';

const Page1 = () => {
    const data1 = useSelector(state => state.data1);
    const dispatch = useDispatch();

    return (
        <div>
            <h1>{data1}</h1>
            <button onClick={()=> dispatch({type:"STRING", data:"HONG"})}>문자열 변경</button>
            <Page2/>
        </div>
    );
};

export default Page1;